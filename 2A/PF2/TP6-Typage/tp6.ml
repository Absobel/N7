type zero = private Dummy1
type _ succ = private Dummy2
type nil = private Dummy3
type 'a list = Nil | Cons of 'a * 'a list

(* Exercice 1 *)

(* 1.1 *)
type ('a, 'n) nlist = 
    | Nil : ('a, zero) nlist
    | Cons : 'a * ('a, 'n) nlist -> ('a, 'n succ) nlist

(* 1.2 *)
let rec map : type n. ('a -> 'b) -> ('a, n) nlist -> ('b, n) nlist =
    fun f l ->
    match l with
    | Nil -> Nil
    | Cons(t, q) -> Cons(f t, map f q)

let%test _ = map (fun x -> x + 1) (Cons(1, Cons(2, Nil))) = Cons(2, Cons(3, Nil))

(* 1.3 *)
let rec snoc : type n. 'a -> ('a, n) nlist -> ('a, n succ) nlist =
    fun e l ->
    match l with
    | Nil -> Cons(e, Nil)
    | Cons(t, q) -> Cons(t, snoc e q)

let%test _ = snoc 3 (Cons(1, Cons(2, Nil))) = Cons(1, Cons(2, Cons(3, Nil)))

(* 1.4 *)

let tail : type n. ('a, n succ) nlist -> ('a, n) nlist =
    fun (Cons(_, q)) -> q

let%test _ = tail (Cons(1, Cons(2, Nil))) = Cons(2, Nil)

(* 1.5 *)

let rec rev : type n. ('a, n) nlist -> ('a, n) nlist =
    function
    | Nil -> Nil
    | Cons(t, q) -> snoc t (rev q)

let%test _ = rev (Cons(1, Cons(2, Nil))) = Cons(2, Cons(1, Nil))

(* Exercice 2 *)

let rec insert : type n. 'a -> ('a, n) nlist -> ('a, n succ) nlist =
    fun x l ->
    match l with
    | Nil -> Cons(x, Nil)
    | Cons(t, q) ->
        if t < x then
            Cons(t, insert x q)
        else
            Cons(x, l)

let rec insertion_sort: type n. ('a, n) nlist -> ('a, n) nlist =
    function
    | Nil -> Nil
    | Cons(t, q) -> insert t (insertion_sort q)

let%test _ = insertion_sort (Cons(2, Cons(1, Cons(3, Nil)))) = Cons(1, Cons(2, Cons(3, Nil)))

(* Exercice 3 *)

type 'p hlist =
    | Nil: nil hlist
    | Cons: 'p * 'q hlist -> ('p * 'q) hlist

let tail : ('p * 'q) hlist -> 'q hlist =
    fun (Cons(_, q)) -> q

let add : (int * (int * 'p)) hlist -> (int * 'p) hlist =
    fun (Cons(x, Cons(y, q))) -> Cons(x+y, q)

(* Exercice 4 *)

type 't expr =
    | Entier : int -> int expr
    | Booleen : bool -> bool expr
    | Plus : int expr * int expr -> int expr
    | Egal : 't expr * 't expr -> bool expr

let rec eval : type t. t expr -> t =
    function
    | Entier(x) -> x
    | Booleen(b) -> b
    | Plus(e1, e2) -> eval e1 + eval e2
    | Egal (e1, e2) -> eval e1 = eval e2

let%test _ = eval (Plus(Entier(1), Entier(2))) = 3
let%test _ = eval (Egal(Entier(1), Entier(2))) = false
let%test _ = eval (Egal(Entier(1), Entier(1))) = true
let%test _ = eval (Entier(1)) = 1
let%test _ = eval (Booleen(true)) = true

(* Exercice 5 *)

type valeur = 
    | Int of int
    | Bool of bool

(* type code =
    | PushI of int
    | PushB of bool
    | Add
    | Equ
    | Seq of code * code

let rec compile : type t. t expr -> code =
    function
    | Entier(x) -> PushI x
    | Booleen(b) -> PushB b
    | Plus(e1, e2) -> Seq(compile e1, Seq(compile e2, Add))
    | Egal(e1, e2) -> Seq(compile e1, Seq(compile e2, Equ))

let%test _ = compile (Plus(Entier(1), Entier(2))) = Seq(PushI 1, Seq(PushI 2, Add))

let rec exec code valeurs =
    match code with
    | PushI(x) -> Int x::valeurs
    | PushB(b) -> Bool b::valeurs
    | Add -> 
        (match valeurs with
        | Int x::Int y::q -> Int (x+y)::q
        | _ -> failwith "Not enough arguments for Add")
    | Equ -> 
        (match valeurs with
        | v1::v2::q -> Bool (v1=v2)::q
        | _ -> failwith "Not enough arguments for Add")
    | Seq(c1, c2) -> exec c2 (exec c1 valeurs) *)

(* Exercice 6 *)

type ('stin, 'stout) code =
    | PushI : int -> ('p, int*'p) code
    | PushB : bool -> ('p, bool*'p) code
    | Add : (int * (int * 'p), int*'p) code
    | Equ : ('a*('a*'p), bool*'p) code
    | Seq : ('a, 'b) code * ('b, 'c) code -> ('a, 'c) code


let rec compile : type t i. t expr -> (i, t*i) code =
    function
    | Entier(x) -> PushI x
    | Booleen(b) -> PushB b
    | Plus(e1, e2) -> Seq(compile e1, Seq(compile e2, Add))
    | Egal(e1, e2) -> Seq(compile e1, Seq(compile e2, Equ))

let eq : ('a * ('a * 'p)) hlist -> (bool * 'p) hlist =
    fun (Cons(x, Cons(y, q))) -> Cons(x=y, q)

let rec exec : type i o. (i, o) code -> i hlist -> o hlist =
    fun c i ->
    match c with
    | PushI(x) -> Cons(x, i)
    | PushB(b) -> Cons(b, i)
    | Add -> add i
    | Equ -> eq i
    | Seq(c1, c2) -> exec c2 (exec c1 i)
