open Util
open Mem

(* get_assoc: 'a -> ('a*'b) list -> 'b -> 'b 
*)
let rec get_assoc e l def =
    match l with
    | [] -> def
    | (clef,value)::q -> 
        if clef = e then 
            value
        else
            get_assoc e q def

(* Tests unitaires : TODO *)

(* set_assoc : TODO
 *)
let rec set_assoc e l x =
    match l with
    | [] -> [e, x]
    | (clef, value)::q ->
        if clef = e then
            (e,x)::q
        else
            (clef,value)::(set_assoc e q x)

(* Tests unitaires : TODO *)


module AssocMemory : Memory =
struct
    (* Type = liste qui associe des adresses (entiers) à des valeurs (caractères) *)
    type mem_type = (int*char) list

    (* Un type qui contient la mémoire + la taille de son bus d'adressage *)
    type mem = int * mem_type

    (* Nom de l'implémentation *)
    let name = "assoc"

    (* Taille du bus d'adressage *)
    let bussize (bs, _) = bs

    (* Taille maximale de la mémoire *)
    let size (bs, _) = pow2 bs

    (* Taille de la mémoire en mémoire *)
    let allocsize (bs, m) = List.length m * 2

    (* Nombre de cases utilisées *)
    let busyness (bs, m) = 
        List.fold_right (
            fun an init -> 
                if snd an != _0 then 
                    init+2 
                else 
                    init
        ) m 0

    (* Construire une mémoire vide *)
    let clear bs = bs,[]

    (* Lire une valeur *)
    let read (bs, m) addr = failwith "TODO"

    (* Écrire une valeur *)
    let write (bs, m) addr x = failwith "TODO"
end
