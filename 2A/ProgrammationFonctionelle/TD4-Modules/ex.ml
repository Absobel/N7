module type Collection =
sig
    type 'a t
    exception CollectionVide
    val vide : 'a t
    val estVide : 'a t -> bool
    val ajouter : 'a t -> 'a -> 'a t
    val enlever : 'a t -> ('a * 'a t)
end

module Pile : Collection =
struct
    type 'a t = 'a list
    exception CollectionVide
    let vide = []
    let estVide p = (p = [])
    let ajouter l e = e::l
    let enlever l =
        match l with
        | [] -> raise CollectionVide
        | e::l -> (e, l)
end

module File : Collection =
struct
    type 'a t = 'a list
    exception CollectionVide
    let vide = []
    let estVide p = (p = [])
    let ajouter l e = l@[e]
    let enlever l =
        match l with
        | [] -> raise CollectionVide
        | e::l -> (e, l)
end

module type Fold =
sig
    type a
    type b
    val cas_de_base: b
    val traite_et_combine: a -> b -> b
end

module Creer_liste : Fold with 
    type a = int 
and type b = int list =
struct
    type a = int
    type b = int list
    let cas_de_base = []
    let traite_et_combine a b = a::b
end

module Trouver_pair: Fold with type a = int and type b = int option =
struct
    type a = int
    type b = int option
    let cas_de_base = None
    let traite_et_combine element q =
        if (element mod 2)  = 0 then
            Some element
        else
            q
end

module FoldList (F: Fold) =
struct
    let rec fold_right l =
        match l with
        | [] -> F.cas_de_base
        | e::l -> F.traite_et_combine e (fold_right l)
end

module FoldCollection (C: Collection) (F: Fold) =
struct
    let rec fold_right c =
        if C.estVide c then
            F.cas_de_base
        else
            let (e, c) = C.enlever c in
            F.traite_et_combine e (fold_right c)
end

module FoldPile = FoldCollection(Pile)
module CreerListePile = FoldPile(Creer_liste)

let%test _ = CreerListePile (Pile.ajouter (Pile.ajouter Pile.vide 1) 2) = [1; 2]