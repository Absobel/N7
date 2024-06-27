(*
 * TINY (Tiny Is Not Yasa (Yet Another Static Analyzer)):
 * a simple abstract interpreter for teaching purpose.
 * Copyright (C) 2012  P. Roux
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *)

type base_t = Bot | Itv of InfInt.t * InfInt.t
type t = base_t
(* The module Infint extends 64 bits integers with -oo and +oo
 * with some arithmetic operations. *)

let fprint ff = function
  | Bot -> Format.fprintf ff "⊥"
  | Itv (a, b) -> Format.fprintf ff "%s%s, %s%s"
    (if InfInt.eq a InfInt.minfty then "(" else "[")
    (InfInt.to_string a) (InfInt.to_string b)
    (if InfInt.eq b InfInt.pinfty then ")" else "]")

let order x y = match x, y with
  | Bot, _ -> true
  | _, Bot -> false
  | Itv (a, b), Itv (c, d) -> InfInt.order c a && InfInt.order b d

let top = Itv (InfInt.minfty, InfInt.pinfty)
let bottom = Bot

let join x y = match x, y with
  | Bot, _ -> y
  | _, Bot -> x
  | Itv (a, b), Itv (c, d) -> Itv (InfInt.min a c, InfInt.max b d)

(* [mk_itv i1 i2] returns the interval (Itv (i1, i2)) when i1 <= i2,
   Bot otherwise. *)
let mk_itv i1 i2 = if InfInt.order i1 i2 then Itv (i1, i2) else Bot

let meet x y = match x, y with
  | Bot, _
  | _, Bot -> Bot
  | Itv (a, b), Itv (c, d) -> mk_itv (InfInt.max a c) (InfInt.min b d)

let widening x y = match x, y with
  | Bot, _ -> y
  | _, Bot -> x
  | Itv (a, b), Itv (c, d) ->
    let e = if InfInt.order a c then a else InfInt.minfty in
    let f = if InfInt.order d b then b else InfInt.pinfty in
    Itv (e, f)

let sem_itv n1 n2 = mk_itv (InfInt.fin n1) (InfInt.fin n2)

let sem_plus x y = match x, y with
  | Bot, _ -> Bot
  | _, Bot -> Bot
  | Itv (a, b), Itv (c, d) -> Itv (InfInt.add_lb a c, InfInt.add_ub b d)

let sem_minus x y = match x, y with
  | Bot, _ -> Bot
  | _, Bot -> Bot
  | Itv (a, b), Itv (c, d) -> Itv (InfInt.sub_lb a d, InfInt.sub_ub b c)

let sem_times x y = match x, y with
  | Bot, _ -> Bot
  | _, Bot -> Bot
  | Itv (a, b), Itv (c, d) ->
    let e = InfInt.min
      (InfInt.min (InfInt.mul_lb a c) (InfInt.mul_lb b d))
      (InfInt.min (InfInt.mul_lb b c) (InfInt.mul_lb a d)) in
    let f = InfInt.max
      (InfInt.max (InfInt.mul_ub a c) (InfInt.mul_ub b d))
      (InfInt.max (InfInt.mul_ub b c) (InfInt.mul_ub a d)) in
    Itv (e, f)

let sem_div x y =
  (* precondition: meet y [0, 0] = ⊥ *)
  let sem_div_without_0 x y = match x, y with
    | Bot, _ -> Bot
    | _, Bot -> Bot
    | Itv (a, b), Itv (c, d) ->
      let e = InfInt.min
        (InfInt.min (InfInt.div_lb a c) (InfInt.div_lb b d))
        (InfInt.min (InfInt.div_lb b c) (InfInt.div_lb a d)) in
      let f = InfInt.max
        (InfInt.max (InfInt.div_ub a c) (InfInt.div_ub b d))
        (InfInt.max (InfInt.div_ub b c) (InfInt.div_ub a d)) in
      Itv (e, f) in
  let yneg = meet y (Itv (InfInt.minfty, InfInt.fin (-1))) in
  let ypos = meet y (Itv (InfInt.fin 1, InfInt.pinfty)) in
  join (sem_div_without_0 x yneg) (sem_div_without_0 x ypos)

let sem_guard = meet (Itv (InfInt.fin 1, InfInt.pinfty))

let backsem_plus x y r = meet x (sem_minus r y), meet y (sem_minus r x)

let backsem_minus x y r = meet x (sem_plus y r), meet y (sem_minus x r)

let backsem_times x y r =
  let backsem_times_left x y r =
    (* [contains_0 x] returns true iff the interval x contains 0 *)
    let contains_0 x = meet x (Itv (InfInt.fin 0, InfInt.fin 0)) <> Bot in
    if contains_0 y && contains_0 r then
      x  (* When both y and r can be 0,
            x * y = r doesn't teach us anything about x. *)
    else
      meet x (sem_div r y) in
  backsem_times_left x y r, backsem_times_left y x r

let backsem_div x y r =
    (* The division being an euclidean division x / y = z doesn't implis
       x = z * y, rather x = z * y + r with r \in [-|y|+1, |y|-1]. *)
    let remaining y = match y with
      | Itv (a, b) -> begin match InfInt.to_int a, InfInt.to_int b with
        | Some a, Some b ->
          let c = InfInt.fin (max (abs a) (abs b)) in
          mk_itv (InfInt.sub_lb InfInt.one c) (InfInt.sub_ub c InfInt.one)
        | _ -> top end
      | _ -> top in
    let backsem_div_left x y r =
      meet x (sem_plus (sem_times r y) (remaining y)) in
    let backsem_div_right x y r =
      let x' = sem_plus x (remaining y) in
      meet y (fst (backsem_times y r x')) in
    backsem_div_left x y r, backsem_div_right x y r
