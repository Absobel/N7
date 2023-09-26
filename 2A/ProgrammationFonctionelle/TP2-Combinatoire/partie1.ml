(*
    2^0 -> { {} }   (ensemble qui contient l'ensemble vide)
    2^n -> 2^n + 2^n -> 2^n+1
    parties déjà construites + parties ajoutées
*)

(*
    ajout: ajoute un element à chaque ensemble en entrée
    paramètres :
        liste_ensembles : liste des ensembles auxquels on veut ajouter l'élélement e
        e : élement à ajouter
    résultat :
        liste d'ensembles auxuqels l'élement e a été ajouté
*)
let ajout liste_ensembles e =
    liste_ensembles@(List.map (fun set -> set@[e]) liste_ensembles)
    
let%test _ = (ajout [[1]; [4; 5]; [3]] 2) = [[1]; [4;5]; [3]; [1;2]; [4;5;2]; [3;2]]

let parties e =
    let rec parties_aux le elem = 
        match elem with
        | [] -> le
        | t::q -> parties_aux (ajout le t) q
    in 
    parties_aux [[]] e

let%test _ = parties [] = [[]]
let%test _ = parties [1] = [[]; [1]]
let%test _ = parties [1;2] = [[]; [1]; [2]; [1;2]]
    
(* correction *)
let rec parties e =
    match e with
    | [] -> [[]]
    | t::q -> ajout (parties q) t

(* autre methode *)
let ajout e l = l@(List.map (fun set -> set@[e]) l)
let parties e =
    List.fold_right ajout e [[]]