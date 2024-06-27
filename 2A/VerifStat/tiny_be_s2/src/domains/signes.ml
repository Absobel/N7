(******************************************************************************)
(*                                                                            *)
(* Domaine des signes :                                                       *)
(*                                                                            *)
(*       STop                                                                 *)
(*      / | \                                                                 *)
(*     /  |  \                                                                *)
(*    /  SN0  \                                                               *)
(* SLe0 /   \ SGe0                                                            *)
(*   |\/     \/|                                                              *)
(*   |/\     /\|                                                              *)
(* SLt0 \   / SGt0                                                            *)
(*    \  SE0  /                                                               *)
(*     \  |  /                                                                *)
(*      \ | /                                                                 *)
(*       SBot                                                                 *)
(*                                                                            *)
(* avec pour fonction de concrétisation gamma :                               *)
(* STop |-> Z                      true  true  true                           *)
(* SLe0 |-> { n \in Z | n <= 0 }   true  true  false                          *)
(* SGe0 |-> { n \in Z | n >= 0 }   false true  true                           *)
(* SN0  |-> { n \in Z | n /= 0 }   true  false true                           *)
(* SLt0 |-> { n \in Z | n < 0 }    true  false false                          *)
(* SGt0 |-> { n \in Z | n > 0 }    false false true                           *)
(* SE0  |-> { 0 }                  false true  false                          *)
(* SBot |-> \emptyset              false false false                          *)
(*                                                                            *)
(******************************************************************************)

(* Le treillis est un produit de 3 treillis à deux valeurs, i.e. des booléens *)
(* Chaque booléen représente une direction différente dans ce treillis,       *)
(* en partant de Bot. Tout élément abstrait est défini par un triplet         *)
(* de booléens (tn, t0, tp) qui représentent respectivement:                  *)
(* tn: la présence des nombres négatifs dans la concrétisation                *)
(* t0: la présence du nombre 0 dans la concrétisation                         *)
(* tp: la présence des nombres positifs dans la concrétisation                *)
type t = bool * bool * bool

let debug = true

let fprint ff t = Format.fprintf ff "%s"
  (match t with
    | (false, false, false) -> "⊥"
    | (true, false, false)  -> "< 0"
    | (false, true, false)  -> "= 0"
    | (false, false, true)  -> "> 0"
    | (true, true, false)   -> "≤ 0"
    | (false, true, true)   -> "≥ 0"
    | (true, false, true)   -> "≠ 0"
    | (true, true, true)    -> "⊤")

let order x y = 
  match x, y with
  | (false, false, false), _ -> true
  | _, (true, true, true) -> true
  | (true, true, false), ((true, false, false) | (false, true, false)) -> true
  | (false, true, true), ((false, false, true) | (false, true, false)) -> true
  | (true, false, true), ((true, false, false) | (false, false, true)) -> true
  | _ -> false
  
let top = (true, true, true)
let bottom = (false, false, false)

(* borne supérieure : plus petit des majorants de {x, y} *)
let join (a1, b1, c1) (a2, b2, c2) =
  (a1 || a2, b1 || b2, c1 || c2)

(* borne supérieure : plus grand des minorants de {x, y} *)
let meet (a1, b1, c1) (a2, b2, c2) =
  (a1 && a2, b1 && b2, c1 && c2)

(* Le treillis n'a pas de chaine strictement croissante infinie,
 * donc il suffit d'utiliser l'union comme élargissement. *)
let widening = 
  join

let sem_itv n1 n2 =
  if n1 > n2 then
    bottom
  else if n1 < 0 && n2 < 0 then
    (true, false, false) (* < 0 *)
  else if n1 < 0 && n2 = 0 then
    (true, true, false) (* ≤ 0 *)
  else if n1 = 0 && n2 = 0 then
    (false, true, false) (* = 0 *)
  else if n1 = 0 && n2 > 0 then
    (false, true, true) (* ≥ 0 *)
  else if n1 > 0 && n2 > 0 then
    (false, false, true) (* > 0 *)
  else
    top

let sem_plus x y = 
  match x, y with
  | a, b when a = b -> a (* x + x = x *)
  | (false, false, false) , _ | _, (false, false, false) -> (false, false, false) (* ⊥ + ... = ⊥ *)
  | (true, false, false), (false, true, false) | (false, true, false), (true, false, false) -> (true, true, false) (* < 0 + = 0 = ≤ 0 *)
  | (true, false, false), (true, true, false) | (true, true, false), (true, false, false) -> (true, true, false) (* < 0 + ≤ 0 = ≤ 0 *)
  | (true, false, false), _ | _, (true, false, false) -> (true, true, true) (* < 0 + ... = ⊤ *)
  | (false, false, true), (false, true, false) | (false, true, false), (false, false, true) -> (false, true, true) (* > 0 + = 0 = ≥ 0 *)
  | (false, false, true), (false, true, true) | (false, true, true), (false, false, true) -> (false, true, true) (* > 0 + ≥ 0 = ≥ 0 *)
  | (false, false, true), _ | _, (false, false, true) -> (true, true, true) (* > 0 + ... = ⊤ *)
  | (false, true, false), a | a, (false, true, false) -> a (* = 0 + ... = ... sauf pour les cas déjà traités*)
  | (true, true, false), _ | _, (true, true, false) -> (true, true, true) (* ≤ 0 + ... = ⊤ *)
  | (false, true, true), _ | _, (false, true, true) -> (true, true, true) (* ≥ 0 + ... = ⊤ *)
  | (true, false, true), _ | _, (true, false, true) -> (true, true, true) (* ≠ 0 + ... = ⊤ *)
  | (true, true, true), _ (* | _, (true, true, true) *) -> (true, true, true) (* ⊤ + ... = ⊤ *)

let neg (a, b, c) = (c, b, a)
let sem_minus x y = 
  sem_plus x (neg y)

let sem_times x y = 
  match x, y with
  | (false, false, false), _ | _, (false, false, false) -> (false, false, false) (* ⊥ * ... = ⊥ *)
  | (false, true, false), _ | _, (false, true, false) -> (false, true, false) (* = 0 * ... = 0 *)
  | (true, false, true), (true, false, true) -> (true, false, true) (* ≠ 0 * ≠ 0 = ≠ 0 *)
  | (true, false, true), _ | _, (true, false, true) -> (true, true, true) (* ≠ 0 * ... = ⊤ *)
  | (true, true, false), (true, _, false) | (true, _, false), (true, true, false) -> (false, true, true) (* ≤ 0 * ≤/< 0 = ≥ 0 *)
  | (true, true, false), (false, _, true) | (false, _, true), (true, true, false) -> (true, true, false) (* ≤ 0 * ≥/> 0 = ≤ 0 *)
  | (false, true, true), (true, _, false) | (true, _, false), (false, true, true) -> (true, true, false) (* ≥ 0 * ≤/< 0 = ≤ 0 *)
  | (false, true, true), (false, _, true) | (false, _, true), (false, true, true) -> (false, true, true) (* ≥ 0 * ≥/> 0 = ≥ 0 *)
  | (true, false, false), (true, false, false) -> (false, false, true) (* < 0 * < 0 = > 0 *)
  | (true, false, false), (false, false, true) | (false, false, true), (true, false, false) -> (true, false, false) (* < 0 * > 0 = < 0 *)
  | (false, false, true), (false, false, true) -> (true, false, false) (* > 0 * > 0 = < 0 *)
  | _ -> (true, true, true)

let inv (a, b, c) = 
  if not a && not b && not c then
    (false, false, false) (* bottom *)
  else if a && b && c then
    (true, true, true) (* top *)
  else if b then
    (false, false, false) (* div par 0 *)
  else
    (a, b, c)

let sem_div x y = 
  sem_times x (inv y)

let sem_guard t = 
  match t with
  | (true, false, true) -> (false, false, false)
  | (true, _, false) -> (false, false, false)
  
  | (false, true, true) -> (false, false, false) (* sans ça sa tourne à l'infini je sais pas pourquoi *)

  | t -> t

let backsem_plus x y r = 
  (meet x (sem_minus r y)), (meet y (sem_minus r x))
let backsem_minus x y r = 
  (meet x (sem_plus r y)), (meet y (sem_minus x r))
let backsem_times x y r =
  let backsem_times_left x y r = 
    let contains_0 (_, b, _) = b in
    if contains_0 y && contains_0 r then
      x
    else
      meet x (sem_div r y) in
  backsem_times_left x y r, backsem_times_left y x r
let backsem_div x y r = 
  let x2 = meet x (sem_times r y) in
  let y2 = 
    let contains_0 (_, b, _) = b in
    if contains_0 r then
      y
    else
      meet y (sem_div x r) in
  x2, y2