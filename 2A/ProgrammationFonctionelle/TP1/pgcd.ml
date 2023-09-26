(* Exercice 4 *)
(* pgcd : int -> int -> int *)
(* Renvoie le plus grand commun diviseur *)
(* a : le premier nombre *)
(* b : le deuxième nombre *)
(* résultat : le pgcd des deux nombres *)
(* precondition : a > 0 && b > 0 *)

let rec pgcd a b = 
    if a = b then
        a
    else if a > b then
        pgcd (a - b) b 
    else
        pgcd a (b - a)

let%test _ = pgcd 4 2 = 2
let%test _ = pgcd 2 4 = 2
let%test _ = pgcd 4 4 = 4
let%test _ = pgcd 18 12 = 6

(* Il est possible de lever ces conditions en utilisant une fonction locale qui
   traiterait les paramètres en leur appliquant la valeur absolue et en traitant
   les cas où un ou deux paramètres sont nuls. *)

(* pgcd : int -> int -> int *)
(* Renvoie le plus grand commun diviseur *)
(* a : le premier nombre *)
(* b : le deuxième nombre *)
(* résultat : le pgcd des deux nombres *)
(* erreur : dans le cas où les deux paramètres sont nuls*)

let rec pgcd_sans_conditions a b =
    let traiter a b = 
        if a = 0 || b = 0 then
            failwith "pgcd incalculable pour un ou plusieurs paramètres nuls"
        else
            (abs a, abs b)
    in
    let (a,b) = traiter a b in
    if a = b then
        a
    else if a > b then
        pgcd_sans_conditions (a - b) b 
    else
        pgcd_sans_conditions a (b - a)

let%test _ = pgcd_sans_conditions 4 2 = 2
let%test _ = pgcd_sans_conditions 2 4 = 2
let%test _ = pgcd_sans_conditions 4 4 = 4
let%test _ = pgcd_sans_conditions 18 12 = 6
let%test _ = pgcd_sans_conditions (-18) 12 = 6
let%test _ = pgcd_sans_conditions 18 (-12) = 6
(* let%test _ = pgcd_sans_conditions 0 4 = 4 *)   (* should fail *)
(* let%test = pgcd_sans_conditions 0 0 *)         (* should fail *)