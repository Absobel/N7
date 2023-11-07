(* Evaluation des expressions simples *)


(* Module abstrayant les expressions *)
module type ExprSimple =
sig
  type t
  val const : int -> t
  val plus : t -> t -> t
  val mult : t-> t -> t
end

(* Module réalisant l'évaluation d'une expression *)
module EvalSimple : ExprSimple with type t = int =
struct
  type t = int
  let const c = c
  let plus e1 e2 = e1 + e2
  let mult e1 e2 = e1 * e2
end


(* Solution 1 pour tester *)
(* A l'aide de foncteur *)

(* Définition des expressions *)
module ExemplesSimples (E:ExprSimple) =
struct
  (* 1+(2*3) *)
  let exemple1  = E.(plus (const 1) (mult (const 2) (const 3)) )
  (* (5+2)*(2*3) *)
  let exemple2 =  E.(mult (plus (const 5) (const 2)) (mult (const 2) (const 3)) )
end

(* Module d'évaluation des exemples *)
module EvalExemples =  ExemplesSimples (EvalSimple)

let%test _ = (EvalExemples.exemple1 = 7)
let%test _ = (EvalExemples.exemple2 = 42)

(* Exercice 1 *)
module PrintSimple : ExprSimple with type t = string =
struct
  type t = string
  let const c = string_of_int c
  let plus e1 e2 = "(" ^ e1 ^ "+" ^ e2 ^ ")"
  let mult e1 e2 = "(" ^ e1 ^ "*" ^ e2 ^ ")"
end

module PrintExemples = ExemplesSimples (PrintSimple)

let%test _ = (PrintExemples.exemple1 = "(1+(2*3))")
let%test _ = (PrintExemples.exemple2 = "((5+2)*(2*3))")

(* Exercice 2 *)
module CompteSimple: ExprSimple with type t = int =
struct
  type t = int
  let const _ = 0
  let plus e1 e2 = e1 + e2 + 1
  let mult e1 e2 = e1 + e2 + 1
end

module CompteExemples = ExemplesSimples (CompteSimple)

let%test _ = (CompteExemples.exemple1 = 2)
let%test _ = (CompteExemples.exemple2 = 3)

(* Exercice 3 *)

module type ExprVar =
sig
  type t
  val def: (string*t) -> t -> t
  val var: string -> t
end

module type Expr =
sig
  include ExprSimple
  include (ExprVar with type t := t)
end

(* Exercice 4 *)

module PrintVar : ExprVar with type t = string =
struct
  type t = string
  let def (name,e1) e2 = "let " ^ name ^ " = " ^ e1 ^ " in " ^ e2
  let var name = name
end

module Print: Expr with type t = string =
struct
  include PrintSimple
  include (PrintVar: ExprVar with type t := t)
end

module Exemples (E: Expr) =
struct
  (* 1+(2*3) *)
  let exemple1  = E.(plus (const 1) (mult (const 2) (const 3)) )
  (* (5+2)*(2*3) *)
  let exemple2 =  E.(mult (plus (const 5) (const 2)) (mult (const 2) (const 3)) )
  (* let x = 1+2 in x*3 *)
  let exemple3 = E.(def ("x",(plus (const 1) (const 2))) (mult (var "x") (const 3)))
  (* let x = 1 in let y = 2 in x+y *)
  let exemple4 = E.(def ("x",(const 1)) (def ("y",(const 2)) (plus (var "x") (var "y"))))
end

module PrintExemplesTotal = Exemples (Print)

let%test _ = (PrintExemplesTotal.exemple1 = "(1+(2*3))")
let%test _ = (PrintExemplesTotal.exemple2 = "((5+2)*(2*3))")
let%test _ = (PrintExemplesTotal.exemple3 = "let x = (1+2) in (x*3)")
let%test _ = (PrintExemplesTotal.exemple4 = "let x = 1 in let y = 2 in (x+y)")

(* Exercice 5 *)

type env = (string*int) list

module EvalVar: ExprVar with type t = env -> int =
struct
  type t = env -> int
  let var name = fun env -> List.assoc name env
  let def (name,e1) e2 = fun env -> e2 ((name,e1 env)::env)
end

module EvalSimpleEnv: ExprSimple with type t = env -> int =
struct
  type t = env -> int
  let const c = fun _ -> c
  let plus e1 e2 = fun env -> e1 env + e2 env
  let mult e1 e2 = fun env -> e1 env * e2 env
end

module Eval : Expr with type t = env -> int =
struct
  include EvalSimpleEnv
  include (EvalVar: ExprVar with type t := t)
end

module EvalExemplesTotal = Exemples (Eval)

let%test _ = (EvalExemplesTotal.exemple1 [] = 7)
let%test _ = (EvalExemplesTotal.exemple2 [] = 42)
let%test _ = (EvalExemplesTotal.exemple3 [] = 9)
let%test _ = (EvalExemplesTotal.exemple4 [] = 3)