(****** Algorithmes combinatoires et monades ********)

module type FONCTEUR =
  sig
    type 'a t
    val map : ('a -> 'b) -> ('a t -> 'b t)
  end

module type MONADE =
  sig
    include FONCTEUR
    val return : 'a -> 'a t
    val (>>=)  : 'a t -> ('a -> 'b t) -> 'b t
  end

module type MONADE_PLUS =
  sig
    include MONADE
    val zero : 'a t
    val (++) : 'a t -> 'a t -> 'a t
  end

(* interface incluant l'affichage des éléments calculés *)
(* pour les listes d'entiers uniquement                 *)
module type MONADE_PLUS_PRINT =
  sig
    include MONADE_PLUS
    val print : Format.formatter -> int list t -> unit
  end

(* fonction auxiliaire pour compter le nombre maximum d'octets alloués en mémoire *)
let max_bytes () =
  let stat = Gc.stat () in
  8. *. (stat.minor_words +. stat.major_words -. stat.promoted_words)

(* fonction auxiliaire pour afficher une liste d'entiers *)
let print_int_list fmt l =
  begin
    Format.fprintf fmt "[";
    List.iter (Format.fprintf fmt "%d; ") l;
    Format.fprintf fmt "]"
  end


(* implantation de la monade ND avec des listes *)
(* ne fonctionne qu'en l'absence de doublons    *)
module NDList : MONADE_PLUS_PRINT =
  struct
    type 'a t = 'a list
    let map = List.map
    let return v = [v]
    let (>>=) s f = List.flatten (List.map f s)
    let zero = []
    let (++) = (@)

    (* fonction d'affichage pour les tests *)
    let print fmt =
      List.iter (Format.fprintf fmt "%a@." print_int_list) 
  end


(*** Combinaisons d'une liste ***)

module Exo1 (ND : MONADE_PLUS) =
  struct
    (* CONTRAT 
       Fonction qui renvoie toutes les combinaisons possible de k éléments d'une liste l
       Paramètre k : le nombre d'éléments dans la liste retournée
       Precondition : k>= taille de l
       Paramètre l : la liste dans laquelle on prend les éléments
       Resultat : les combinaisons de k éléments choisis dans l
     *)
    open ND
    let rec combinaisons k l =
      if k <= 0 then 
        ND.return []
      else match l with
      | [] -> ND.zero
      | t::q -> 
        ((combinaisons (k-1) q) >>= (fun c -> ND.return (t::c)))
        ++ (combinaisons k q)
  end

(* TESTS *)
let test1 (module ND : MONADE_PLUS_PRINT) =
  let module M = Exo1 (ND) in
  let old_bytes = max_bytes () in
  let result = M.combinaisons 4 [1;2;3;4;5;6;7;8;9;10] in
  begin
    Format.printf "@.TEST combinaisons@.memory used: %f@.result:@. %a@." (max_bytes () -. old_bytes) ND.print result
  end

(* let _ = test1 (module NDList) *)


(*** Permutations d'une liste ***)

module Exo2 (ND : MONADE_PLUS) =
  struct
    (* CONTRAT
       Fonction prend en paramètre un élément e et une liste l et qui insére e à toutes les possitions possibles dans l
       Pamaètre e : ('a) l'élément à insérer
       Paramètre l : ('a l  ist) la liste initiale dans laquelle insérer e
       Résultat : toutes les insertions possible de e dans l
     *)
    open ND
    let rec insertion e l =
      match l with
      | [] -> ND.return [e]
      | t::q -> ((insertion e q) >>= (fun i -> ND.return (t::i))) ++ ND.return (e::l)

    (* CONTRAT
       Fonction qui renvoie la liste des permutations d'une liste
       Paramètre l : une liste
       Résultat : les permutations de l (toutes différentes si les élements de l sont différents deux à deux)
     *)
    let rec permutations l =
      match l with
      | [] -> ND.return []
      | e::q -> (permutations q) >>= (insertion e)
end

(* TESTS *)
let test2 (module ND : MONADE_PLUS_PRINT) =
  let module M = Exo2 (ND) in
  let old_bytes = max_bytes () in
  let result = M.permutations [1;2;3;4;5] in
  begin
    Format.printf "@.TEST permutations@.memory used: %f@.result:@. %a@." (max_bytes () -. old_bytes) ND.print result
  end

(* let _ = test2 (module NDList) *)


(*** Partition d'un entier ***)

module Exo3 (ND : MONADE_PLUS) =
  struct
    (* CONTRAT
       partition int -> int list
       Fonction qui calcule toutes les partitions possibles d'un entier n
       Paramètre n : un entier dont on veut calculer les partitions
       Préconditions : n >0
       Résultat : les partitions de n
     *)
    open ND
    let partitions n =
      let rec partitions_aux n t =
        if t = n then
          ND.return [t]
        else if t > n then
          ND.zero
        else
          ((partitions_aux (n-t) t) >>= (fun p -> ND.return (t::p))) ++ (partitions_aux n (t+1))
      in partitions_aux n 1
  end

(* TESTS *)
let test3 (module ND : MONADE_PLUS_PRINT) =
  let module M = Exo3 (ND) in
  let old_bytes = max_bytes () in
  let result = M.partitions 5 in
  begin
    Format.printf "@.TEST partitions@.memory used: %f@.result: %a@." (max_bytes () -. old_bytes) ND.print result
  end

(* let _ = test3 (module NDList) *)


(* fonction auxiliaire pour réaliser tous les tests des fonctions combinatoires *)
let test_combinatoire (module ND : MONADE_PLUS_PRINT) =
  begin
    test1 (module ND);
    test2 (module ND);
    test3 (module ND)
  end

(*** Autre implantation de ND par itérateurs ***)
    
module NDIter : MONADE_PLUS_PRINT =
  struct
    type 'a t = Tick of ('a * 'a t) option Lazy.t

    let uncons (Tick flux) = Lazy.force flux
    let rec ( ++ ) l1 l2 =
      Tick(lazy 
        (match (uncons l1) with
        | None -> uncons l2
        | Some(t,q) -> Some(t, q++l2))
      )
    let zero = Tick (lazy None)
    let rec ( >>= ) a f =
      Tick(lazy 
        (match (uncons a) with
        | None -> None
        | Some(t,q) -> uncons ( (f t) ++ (q >>= f) ))
      )
    let return e = Tick(lazy (Some(e,zero)))
    let rec map f a =
      Tick(lazy 
        (match (uncons a) with
        | None -> None
        | Some(t,q) -> Some (f t, map f q))
      )
    (* fonction d'affichage pour les tests *)
    let rec print fmt it =
      match uncons it with
      | None          -> Format.fprintf fmt "@."
      | Some (a, it') -> Format.fprintf fmt "%a@.%a" print_int_list a print it'
  end

(* TESTS *)
let test_iter () =
  begin
    Format.printf "@.TEST itérateur@.";
    test_combinatoire (module NDIter)
  end

(* let _ = test_iter () *)

(*** Autre implantation de ND par tirage aléatoire ***)

module NDRandom : MONADE_PLUS_PRINT =
  struct
    type 'a t = unit -> 'a option

    (* à compléter *)
    let zero = fun () -> None
    let ( ++ ) a b = 
      let ra = a () in
      let rb = b () in
      fun () ->
        if ra = None then rb else if rb = None then ra
        else if Random.bool () then ra else rb
    let ( >>= ) a f =
      match a () with
      | None -> zero
      | Some(e) -> f e
    let return a =  fun () -> Some(a)
    let map f a = fun () ->
      match a () with 
      | None -> None 
      | Some(e) -> Some(f e)

    (* fonction d'affichage pour les tests *)
    let print fmt it =
      match it () with
      | None   -> Format.fprintf fmt "@."
      | Some v -> Format.fprintf fmt "%a@." print_int_list v
  end

(* TESTS *)
let test_random (module ND : MONADE_PLUS_PRINT) =
  begin
    Format.printf "@.TEST aléatoire@."; test_combinatoire (module ND)
  end

let _ = test_random (module NDRandom)


(*** Autre implantation de ND par tirage aléatoire équitable ***)

module NDFairRandom : MONADE_PLUS_PRINT =
  struct
    type 'a t = int * (unit -> 'a)

    (* à compléter *)
    let zero = (0, fun () -> None)
    let ( ++ ) (n1, a) (n2, b) = 
      let ra = a () in
      let rb = b () in
      if ra = None then (n2, b) else if rb = None then (n1, a)
      else if Random.int (n1 + n2) < n1 then (n1 + n2, a) else (n1 + n2, b)
    let ( >>= ) (n, a) f =
      match a () with
      | None -> zero
      | Some(e) -> (n, fun () -> f e)
    let return a =  (1, fun () -> Some(a))
    let map : ('a -> 'b) -> ('a t -> 'b t) = 
    fun f (n, a) -> (n, fun () ->
      match a () with 
      | None -> None 
      | Some(e) -> Some(f e))

    (* fonction d'affichage pour les tests *)
    let print fmt (n, it) =
      match n with
      | 0 -> Format.fprintf fmt "@."
      | _ -> Format.fprintf fmt "%a@." print_int_list (it ())
  end

(* TESTS *)
let _ = test_random (module NDFairRandom)
