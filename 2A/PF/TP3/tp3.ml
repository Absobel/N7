(****** Algorithmes combinatoires et listes ********)


(*** Code binaires de Gray ***)

(*CONTRAT
Fonction qui génère un code de Gray
Paramètre n : la taille du code
Resultat : le code sous forme de int list list
*)

let appbegl2 l e =
    List.map (fun el -> e::el) l

let rec gray_code n =
    if n = 0 then
        [[]]
    else
        let gcnm1 = gray_code (n-1) in
        (appbegl2 gcnm1 0)@(List.rev (appbegl2 gcnm1 1))

(* TESTS *)
let%test _ = gray_code 0 = [[]]
let%test _ = gray_code 1 = [[0]; [1]]
let%test _ = gray_code 2=  [[0; 0]; [0; 1]; [1; 1]; [1; 0]]
let%test _ = gray_code 3 = [[0; 0; 0]; [0; 0; 1]; [0; 1; 1]; [0; 1; 0]; [1; 1; 0]; [1; 1; 1]; [1; 0; 1];
 [1; 0; 0]]
 let%test _ = gray_code 4 = [[0; 0; 0; 0]; [0; 0; 0; 1]; [0; 0; 1; 1]; [0; 0; 1; 0]; [0; 1; 1; 0];
  [0; 1; 1; 1]; [0; 1; 0; 1]; [0; 1; 0; 0]; [1; 1; 0; 0]; [1; 1; 0; 1];
  [1; 1; 1; 1]; [1; 1; 1; 0]; [1; 0; 1; 0]; [1; 0; 1; 1]; [1; 0; 0; 1];
  [1; 0; 0; 0]]


(*** Combinaisons d'une liste ***)

(* CONTRAT 
    combinaisons : int -> ’a list -> ’a list list
    argument: l, une liste quelconque d’éléments supposés différents 
              k, le nombre d’élements distincts à tirer
    résultat: une liste de combinaisons. Chaque combinaison est elle-même une liste d’éléments, dont les éléments sont ceux de l.
*)
let rec combinaison k l =
    if k <= 0 then
        [[]]
    else match l with
    | [] -> []
    | t::q -> (List.map (fun l -> t::l) (combinaison (k-1) q))@(combinaison k q)

(* TESTS *)
let%test _ = combinaison 0 [] = [[]]
let%test _ = combinaison 1 [] = []
let%test _ = combinaison 0 [1;2;3] = [[]]
let%test _ = combinaison 1 [1;2;3] = [[1];[2];[3]]
let%test _ = combinaison 2 [1;2;3] = [[1;2];[1;3];[2;3]]
let%test _ = combinaison 3 [1;2;3] = [[1;2;3]]
let%test _ = combinaison 4 [1;2;3] = []

(*** Permutations d'une liste ***)

(* CONTRAT
Fonction prend en paramètre un élément e et une liste l et qui insére e à toutes les possitions possibles dans l
Pamaètre e : ('a) l'élément à insérer
Paramètre l : ('a list) la liste initiale dans laquelle insérer e
Reesultat : la liste des listes avec toutes les insertions possible de e dans l
*)

let rec insertion e l =
    match l with
    | [] -> [[e]]
    | t::q -> (e::l)::(List.map (fun l -> t::l) (insertion e q)) 

(* TESTS *)
let%test _ = insertion 0 [1;2] = [[0;1;2];[1;0;2];[1;2;0]]
let%test _ = insertion 0 [] = [[0]]
let%test _ = insertion 3 [1;2] = [[3;1;2];[1;3;2];[1;2;3]]
let%test _ = insertion 3 [] = [[3]]
let%test _ = insertion 5 [12;54;0;3;78] =
[[5; 12; 54; 0; 3; 78]; [12; 5; 54; 0; 3; 78]; [12; 54; 5; 0; 3; 78];
 [12; 54; 0; 5; 3; 78]; [12; 54; 0; 3; 5; 78]; [12; 54; 0; 3; 78; 5]]
 let%test _ = insertion 'x' ['a';'b';'c']=
 [['x'; 'a'; 'b'; 'c']; ['a'; 'x'; 'b'; 'c']; ['a'; 'b'; 'x'; 'c'];
  ['a'; 'b'; 'c'; 'x']]


(* CONTRAT
Fonction qui renvoie la liste des permutations d'une liste
Paramètre l : une liste
Résultat : la liste des permutatiions de l (toutes différentes si les élements de l sont différents deux à deux 
*)

let rec permutations l =
    match l with
    | [] -> [[]]
    | t::q -> List.flatten (List.map (insertion t) (permutations q))

(* TESTS *)
let l1 = permutations [1;2;3]
let%test _ = List.length l1 = 6
let%test _ = List.mem [1; 2; 3] l1 
let%test _ = List.mem [2; 1; 3] l1 
let%test _ = List.mem [2; 3; 1] l1 
let%test _ = List.mem [1; 3; 2] l1 
let%test _ = List.mem [3; 1; 2] l1 
let%test _ = List.mem [3; 2; 1] l1 
let%test _ = permutations [] =[[]]
let l2 = permutations ['a';'b']
let%test _ = List.length l2 = 2
let%test _ = List.mem ['a';'b'] l2 
let%test _ = List.mem ['b';'a'] l2 


(*** Partition d'un entier ***)

(* partition int -> int list
Fonction qui calcule toutes les partitions possibles d'un entier n
Paramètre n : un entier dont on veut calculer les partitions
Préconditions : n >0
Retour : les partitions de n
*)

let rec partition n =
    let rec partition_aux n t =
        if t = n then
            [[t]]
        else if t > n then
            []
        else
            (appbegl2 (partition_aux (n-t) t) t)@(partition_aux n (t+1))
    in partition_aux n 1
        

(* TEST *)
let%test _ = partition 1 = [[1]]
let%test _ = partition 2 = [[1;1];[2]]
let%test _ = partition 3 = [[1; 1; 1]; [1; 2]; [3]]
let%test _ = partition 4 = [[1; 1; 1; 1]; [1; 1; 2]; [1; 3]; [2; 2]; [4]]
let%test _ = partition 5 = [[1; 1; 1; 1; 1]; [1; 1; 1; 2]; [1; 1; 3]; [1; 2; 2]; [1; 4]; [2; 3]; [5]]