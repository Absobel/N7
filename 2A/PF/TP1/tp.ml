(* open Graphics *)
(* open Affichage *)

(* Exercice 2 *)
(*  
   coeff_directeur : float*float -> float*float -> float
   calcule le coefficient directeur de la droite représentée par deux points
   Parametre (x1, y1) : float*float, le premier point
   Parametre (x2, y2) : float*float, le second point
   Resultat : float, le coefficient directeur de la droite passant par
   (x1, y1) et (x2, y2)
*)

let coeff_directeur (x1,y1) (x2,y2) = (y2 -. y1)/.(x2 -. x1)

let%test _ = coeff_directeur (0., 0.) (1., 2.) = 2.
let%test _ = coeff_directeur (1., 2.) (0., 0.) = 2.
let%test _ = coeff_directeur (0., 0.) (2., 1.) = 0.5
let%test _ = coeff_directeur (0., 0.) (-2., 1.) = -0.5
let%test _ = coeff_directeur (1., 2.) (2., 1.) = -1.

(* Exercice 3 *)
(* Les contrats et tests des fonctions ne sont pas demandés *)
(* f1 : int * int -> bool *)
(* f2 : int -> bool *)
(* f3 : 'a -> `a *)
(* f4 : `a * `a -> bool *)
(* f5 : `a*`b -> `a*)

let f1 (a,b) = (a = 1) && (b = 2)
let f2 x = x = 1
let f3 x = x
let f4 (a,b) = a = b
let f5 (a,_) = a

(* Exercice 4 *)
(* ieme : 'a*'a*'a -> int -> 'a *)
(* renvoie le ième élément d'un triplet *)
(* t : le triplet *)
(* i : l'indice de l'élèment dans le triplet *)
(* renvoie le ième élément t *)
(* précondition : 1 =< i =< 3 *)

let ieme t i =  
   match t,i with
   | (x,_,_),1 -> x
   | (_,x,_),2 -> x
   | (_,_,x),3 -> x
   | _ -> failwith "Precondition non respectée"

let%test _ = ieme (5,60,7) 1 = 5
let%test _ = ieme (5,60,17) 2 = 60
let%test _ = ieme (5,60,17) 3 = 17
let%test _ = ieme ('r','e','l') 1 = 'r'
let%test _ = ieme ('r','e','l') 2 = 'e'
let%test _ = ieme ('r','e','l') 3 = 'l'

(* Exercice 5 *)
(* PGCD -> pgcd.ml *)

(* Exercice 6 *)
(*  padovan : int -> int
Fonction qui calcule la nième valeur de la suite de Padovan : u(n+3) = u(n+1) + u(n); u(2)=1, u(1)=u(0)=0 
Paramètre n : un entier représentant la nième valeur à calculer
Précondition : n >=0
Résultat : un entier la nième valeur de la suite de Padovan 
*)

let padovan n = 
   (* padovan_aux : int -> int -> int -> int -> int *)
   (* Fonction auxiliaire qui calcule la nième valeur de la suite de Padovan *)
   (* Paramètre p : un compteur descendant représentant le nombre de valeurs restant à calculer *)
   (* Paramètre unm1 : un entier représentant u(n-1) *)
   (* Paramètre unm2 : un entier représentant u(n-2) *)
   (* Paramètre unm3 : un entier représentant u(n-3) *)
   (* Précondition : p > 0 *)
   (* Résultat : la nième valeur de la suite de Padovan *)
   let rec padovan_aux p unm1 unm2 unm3 =
      let un = unm2 + unm3 in
      if p = 1 then
         un
      else
         padovan_aux (p-1) un unm1 unm2
   in
   if n = 0 || n = 1 then
      0
   else if n = 2 then
      1
   else
      padovan_aux (n-2) 1 0 0

let%test _ = padovan 0 = 0
let%test _ = padovan 1 = 0 
let%test _ = padovan 2 = 1
let%test _ = padovan 3 = 0
let%test _ = padovan 4 = 1
let%test _ = padovan 5 = 1
let%test _ = padovan 6 = 1
let%test _ = padovan 7 = 2
let%test _ = padovan 8 = 2
let%test _ = padovan 9 = 3
let%test _ = padovan 10 = 4

(* Exercice 7 *)
(* estPremier : int -> bool
fonction qui indique si un nombre est premier
Paramètre n : un entier naturel dont on doit dire s'il est premier ou pas
Précondition : n >= 0
Résultat : l'information de si n est premier ou pas
*)

let estPremier n =
   (* estPremier_aux : int -> bool *)
   (* Fonction auxiliaire qui indique si un nombre est premier *)
   (* Paramètre p : un compteur descendant par lequel on calcule le modulo de n pour voir si ce dernier est premier *)
   (* Précondition : p > 0 *)
   (* Résultat : l'information de si n est premier ou pas *)
   let rec estPremier_aux p = 
      if p = 1 then
         true
      else if n mod p = 0 then
         false
      else
         estPremier_aux (p-1)
   in
   if n = 0 || n = 1 then
      false
   else
      let limit = int_of_float ( floor ( sqrt ( float_of_int n ) ) ) in 
      estPremier_aux limit


let%test _ = estPremier 2
let%test _ = estPremier 3 
let%test _ = not (estPremier 4)
let%test _ = estPremier 5
let%test _ = not (estPremier 6)
let%test _ = estPremier 7
let%test _ = not (estPremier 8)
let%test _ = not (estPremier 9)
let%test _ = not (estPremier 10)
let%test _ = not (estPremier 0)
let%test _ = not (estPremier 1)


(*****************************)
(****** Bonus "ludique" ******)
(*****************************)


(*  Création de l'écran d'affichage *)
(* let _ = open_graph " 800x600" *)

(* Exercice 8 *)
(*  
   dragon : (int*int) -> (int*int) -> int -> unit
   Dessine la courbe du dragon à partir de deux points et d'une précision.
   Parametre (xa,ya) : (int*int), coordonnées de la première extrémité du dragon
   Paramètre (xb,yb) : (int*int), coordonnées de la seconde extrémité du dragon
   Paramètre n : nombre d'itération (plus n est grand, plus la courbe aura de détails)
   Resultat : unit, affichage de la courbe du dragon sur l'écran
   Précondition : n positif ou nul
*)

let rec dragon (xa,ya) (xb,yb) n = 
   Graphics.open_graph " 800x600";
   let point_C (xa,ya) (xb,yb) = 
      (xa+xb)/2 + (yb-ya)/2, (ya+yb)/2 + (xa-xb)/2
   in
   let rec dragon_aux (xa,ya) (xb,yb) n =
      if n = 0 then (
         Graphics.moveto xa ya;
         Graphics.lineto xb yb;
      ) else
         let pC = point_C (xa, ya) (xb, yb) in (
            dragon_aux (xa, ya) pC (n-1);
            dragon_aux (xb, yb) pC (n-1);
         )
   in
   dragon_aux (xa,ya) (xb,yb) n


let%test_unit _ = dragon (200,350) (600,350) 20

let _ = while true do () done

(*  Fermeture de l'écran d'affichage *)
(* Graphics.close_graph() *)