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