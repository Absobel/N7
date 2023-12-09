type 'a arbre = Noeud of bool * ('a * 'a arbre) list

let rec appartient (Noeud (valeur,branches)) l =
    match l with
    | [] -> valeur
    | t::q -> List.fold_right (
        fun (elem, ss_arbre) acc -> 
            acc || if elem = t then appartient ss_arbre q else false
        ) branches false

(* une correction *)

let rec appartient l (Noeud (valeur, branches)) =
    match l with
    | [] -> valeur
    | t::q -> match branches with
        | [] -> false
        | (cb, ab)::qb -> if t = cb then
            appartient q ab
        else if t < cb then
            false
        else appartient l (Noeud (valeur, qb))

(* autre correction *)

let rec recherche ch lb = 
    match lb with
    | [] -> None
    | (cb, ab)::qb -> 
        if ch = cb
            then Some ab
        else if ch < cb
            then None
        else recherche ch qb

let rec appartient l (Noeud (valeur,br)) =
    match l with
    | [] -> valeur
    | c::qlc -> 
        match (recherche c br) with
        | None -> false
        | Some a -> appartient qlc a

(* ########################################### *)

let rec maj (c, nouveau) lb =
    match lb with
    | [] -> (c, nouveau)::[]
    | (cb, ab)::qb ->
        if c = cb then
            (c, nouveau)::lb
        else if c < cb then
            (c, nouveau)::lb
        else
            (cb, ab)::(maj (c,nouveau) qb)

let rec ajout lc (Noeud(b, lb)) =
    match lc with
    | [] -> Noeud (true, lb)
    | c::qlc ->
        let arbre_c =
            match recherche c lb with
            | None -> Noeud(false, [])
            | Some a -> a
        in
        Noeud(b, maj (c, (ajout qlc arbre_c)) lb)

