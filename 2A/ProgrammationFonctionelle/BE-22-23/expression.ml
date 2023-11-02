(* Exercice 3 *)
module type Expression = sig
  (* Type pour représenter les expressions *)
  type exp


  (* eval : exp -> int *)
  (* Evalue une expression *)
  (* Paramètre exp : l'expression que l'on veut évaluer *)
  (* Résultat : l'entier résultant de l'évaluation de l'expression *)
  val eval : exp -> int
end

(* Exercice 4 *)

module ExpressionArbreBinaire = struct
  (* Type pour représenter les expressions binaires *)
  type op = Moins | Plus | Mult | Div
  type exp = Binaire of exp * op * exp | Entier of int

  (* eval *)
  let rec eval =  fun exp -> 
    match exp with
    | Entier(n) -> n
    | Binaire(e1, op, e2) -> 
        let ee1 = eval e1 in
        let ee2 = eval e2 in
        match op with
        | Moins -> ee1 - ee2
        | Plus -> ee1 + ee2
        | Mult -> ee1 * ee2
        | Div -> 
          if ee2 = 0 then
            failwith "Division by zero"
          else
            ee1 / ee2
  (* Tests : TO DO *)
  let%test _ = -5 = 
    eval (
      Binaire(
        Binaire(
          Entier(3), 
          Plus, 
          Entier(4)
        ), 
        Moins, 
        Entier(12)
      )
    )
  let%test _ = 1 = 
    eval (
      Binaire(
        Binaire(
          Entier(3),
          Mult,
          Entier(4)
        ),
        Div,
        Binaire(
          Entier(10),
          Plus,
          Entier(2)
        )
      )
    )
    let%test _ =
      try
        let _ = eval (Binaire(Entier(1), Div, Entier(0))) in
        false
      with Failure _ -> true
end

(* Exercice 5 *)

module ExpAvecArbreNaire = struct
  (* Linéarisation des opérateurs binaire associatif gauche et droit *)
  type op = Moins | Plus | Mult | Div
  type exp = Naire of op * exp list | Valeur of int

  (* bienformee : exp -> bool *)
  (* Vérifie qu'un arbre n-aire représente bien une expression n-aire *)
  (* c'est-à-dire que les opérateurs d'addition et multiplication ont au moins deux opérandes *)
  (* et que les opérateurs de division et soustraction ont exactement deux opérandes.*)
  (* Paramètre : l'arbre n-aire dont ont veut vérifier si il correspond à une expression *)
  let rec bienformee = fun exp ->
    match exp with
    | Valeur _ -> true
    | Naire(op, expl) ->
      match op with
      | Plus | Mult -> if List.length expl < 2 then false else List.for_all bienformee expl
      | Moins | Div -> if List.length expl != 2 then false else List.for_all bienformee expl

  let en1 = Naire (Plus, [ Valeur 3; Valeur 4; Valeur 12 ])
  let en2 = Naire (Moins, [ en1; Valeur 5 ])
  let en3 = Naire (Mult, [ en1; en2; en1 ])
  let en4 = Naire (Div, [ en3; Valeur 2 ])
  let en1err = Naire (Plus, [ Valeur 3 ])
  let en2err = Naire (Moins, [ en1; Valeur 5; Valeur 4 ])
  let en3err = Naire (Mult, [ en1 ])
  let en4err = Naire (Div, [ en3; Valeur 2; Valeur 3 ])

  let%test _ = bienformee en1
  let%test _ = bienformee en2
  let%test _ = bienformee en3
  let%test _ = bienformee en4
  let%test _ = not (bienformee en1err)
  let%test _ = not (bienformee en2err)
  let%test _ = not (bienformee en3err)
  let%test _ = not (bienformee en4err)

  (* eval : exp-> int *)
  (* Calcule la valeur d'une expression n-aire *)
  (* Paramètre : l'expression dont on veut calculer la valeur *)
  (* Précondition : l'expression est bien formée *)
  (* Résultat : la valeur de l'expression *)
  let rec eval_bienformee =  fun exp ->
    match exp with
    | Valeur n -> n
    | Naire(op, e1::e2::q) -> (
      match op with
      | Plus -> List.fold_right (fun an init -> (eval_bienformee an) + init) (e1::e2::q) 0
      | Mult -> List.fold_right (fun an init -> (eval_bienformee an) * init) (e1::e2::q) 1
      | Moins -> (eval_bienformee e1) - (eval_bienformee e2)
      | Div -> (eval_bienformee e1) / (eval_bienformee e2)
    )
    | _ -> failwith "precondition non respectée"

  let%test _ = eval_bienformee en1 = 19
  let%test _ = eval_bienformee en2 = 14
  let%test _ = eval_bienformee en3 = 5054
  let%test _ = eval_bienformee en4 = 2527

  (* Définition de l'exception Malformee *)
  exception Malformee

  (* eval : exp-> int *)
  (* Calcule la valeur d'une expression n-aire *)
  (* Paramètre : l'expression dont on veut calculer la valeur *)
  (* Résultat : la valeur de l'expression *)
  (* Exception  Malformee si le paramètre est mal formé *)
  let eval  = fun exp -> 
    if bienformee exp then
      eval_bienformee exp
    else
      raise Malformee
      
  let%test _ = eval en1 = 19
  let%test _ = eval en2 = 14
  let%test _ = eval en3 = 5054
  let%test _ = eval en4 = 2527

  let%test _ =
    try
      let _ = eval en1err in
      false
    with Malformee -> true

  let%test _ =
    try
      let _ = eval en2err in
      false
    with Malformee -> true

  let%test _ =
    try
      let _ = eval en3err in
      false
    with Malformee -> true

  let%test _ =
    try
      let _ = eval en4err in
      false
    with Malformee -> true

end