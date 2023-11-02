open Lex

type parseResult =
  | Success of inputStream
  | Failure
;;

(*
  E -> fun ident fleche E
  E -> let ident = E in E
  E -> letrec ident = E in E
  E -> if E then E else E
  E -> ER = E
  E -> ER
  ER -> ER + T
  ER -> ER - T
  ER -> T
  T -> T * F
  T -> T / F
  T -> F
  F -> - F
  F -> ( E )
  F -> ( E ) (E)
  F -> ident
  F -> ident (E)
  F -> true
  F -> false
  F -> number
*)

(*
  LL(1)
  #1  - E -> fun ident -> E
  #2  - E -> let ident = E in E
  #3  - E -> letrec ident = E in E
  #4  - E -> if E then E else E
  #5  - E -> ER EX
  #6  - EX -> = ER EX
  #7  - EX ->
  #8  - ER -> T TX
  #9  - TX -> + T TX
  #10 - TX -> - T TX
  #11 - TX ->
  #12 - T -> F FX
  #13 - FX -> * F FX
  #14 - FX -> / F FX
  #15 - FX ->
  #16 - F -> - F
  #17 - F -> number
  #20 - F -> FF ARG
  #21 - F -> true
  #22 - F -> false
  #23 - FF -> ( E )
  #24 - FF -> ident
  #25 - ARG -> ( E )
  #26 - ARG ->
*)



(* accept : token -> inputStream -> parseResult *)
(* Vérifie que le premier token du flux d'entrée est bien le token attendu *)
(* et avance dans l'analyse si c'est le cas *)
let accept expected stream =
  match (peekAtFirstToken stream) with
    | token when (token = expected) ->
      (print_endline (string_of_token token)); (Success (advanceInStream stream))
    | _ -> Failure
;;

(* acceptIdent : inputStream -> parseResult *)
(* Vérifie que le premier token du flux d'entrée est bien un identifiant *)
(* et avance dans l'analyse si c'est le cas *)
let acceptIdent stream =
  match (peekAtFirstToken stream) with
    | (IdentToken _) -> (Success (advanceInStream stream))
    | _ -> Failure
;;

(* acceptNumber : inputStream -> parseResult *)
(* Vérifie que le premier token du flux d'entrée est bien un nombre *)
(* et avance dans l'analyse si c'est le cas *)
let acceptNumber stream =
  match (peekAtFirstToken stream) with
    | (NumberToken _) -> (Success (advanceInStream stream))
    | _ -> Failure
;;

(* Définition de la monade  qui est composée de : *)
(* - le type de donnée monadique : parseResult  *)
(* - la fonction : inject qui construit ce type à partir d'une liste de terminaux *)
(* - la fonction : bind (opérateur >>=) qui combine les fonctions d'analyse. *)

(* inject inputStream -> parseResult *)
(* Construit le type de la monade à partir d'une liste de terminaux *)
let inject s = Success s;;

(* bind : 'a m -> ('a -> 'b m) -> 'b m *)
(* bind (opérateur >>=) qui combine les fonctions d'analyse. *)
(* ici on utilise une version spécialisée de bind :
   'b  ->  inputStream
   'a  ->  inputStream
    m  ->  parseResult
*)
(* >>= : parseResult -> (inputStream -> parseResult) -> parseResult *)
let (>>=) result f =
  match result with
    | Success next -> f next
    | Failure -> Failure
;;


(* parseE : inputStream -> parseResult *)
(* Analyse du non terminal E *)
let rec parseE stream =
  (*
    (print_endline (string_of_stream stream));
  *)
  (match (peekAtFirstToken stream) with
    (* regle #1 *)
    | FunctionToken ->
        print_endline "E -> function ident -> E";
        inject stream >>=
        accept FunctionToken >>=
        acceptIdent >>=
        accept BodyToken >>=
        parseE
    (* regle #2 *)
    | LetToken ->
        print_endline "E -> let ident = E in E";
        inject stream >>=
        accept LetToken >>=
        acceptIdent >>=
        accept EqualToken >>=
        parseE >>=
        accept InToken >>=
        parseE
    (* regle #3 *)
    | RecToken ->
        print_endline "E -> letrec ident = E in E";
        inject stream >>=
        accept RecToken >>=
        acceptIdent >>=
        accept EqualToken >>=
        parseE >>=
        accept InToken >>=
        parseE
    (* regle #4 *)
    | IfToken ->
        print_endline "E -> if E then E else E";
        inject stream >>=
        accept IfToken >>=
        parseE >>=
        accept ThenToken >>=
        parseE >>=
        accept ElseToken >>=
        parseE
    (* regle #5 *)
    | ((IdentToken _) | (NumberToken _) | TrueToken | FalseToken | MinusToken | LeftParenthesisToken ) ->
        print_endline "E -> ER EX";
        inject stream >>=
        parseER >>=
        parseEX
    | _ -> Failure)

(* parseEX : inputStream -> parseResult *)
(* Analyse du non terminal EX *)
and parseEX stream =
  (match (peekAtFirstToken stream) with
    (* regle #6 *)
    | EqualToken ->
        print_endline "EX -> = ER EX";
        inject stream >>=
        accept EqualToken >>=
        parseER >>=
        parseEX
    (* regle #7 *)
    | (RightParenthesisToken | ThenToken | InToken | ElseToken) -> 
        print_endline "EX -> ";
        inject stream
    | EOSToken -> 
        print_endline "EX -> EOS";
        inject stream
    | _ -> Failure)

(* parseER : inputStream -> parseResult *)
(* Analyse du non terminal ER *)
and parseER stream =
  (match (peekAtFirstToken stream) with
    (* regle #8 *)
    | ((IdentToken _) | (NumberToken _) | TrueToken | FalseToken | MinusToken | LeftParenthesisToken) ->
        print_endline "ER -> T TX";
        inject stream >>=
        parseT >>=
        parseTX
    | _ -> Failure)

(* parseTX : inputStream -> parseResult *)
(* Analyse du non terminal TX *)
and parseTX stream =
  (match (peekAtFirstToken stream) with
    (* regle 9 *)
    | PlusToken ->
        print_endline "TX -> + T TX";
        inject stream >>=
        accept PlusToken >>=
        parseT >>=
        parseTX
    (* regle 10 *)
    | MinusToken ->
        print_endline "TX -> - T TX";
        inject stream >>=
        accept MinusToken >>=
        parseT >>=
        parseTX
    (* regle 11 *)
    | (RightParenthesisToken | EqualToken | ThenToken | InToken | ElseToken) -> 
        print_endline "TX -> ";
        inject stream
    | EOSToken -> 
        print_endline "TX -> EOS";
        inject stream
    | _ -> Failure)

(* parseT : inputStream -> parseResult *)
(* Analyse du non terminal T *)
and parseT stream =
  (match (peekAtFirstToken stream) with
    (* regle 12 *)
    | ((IdentToken _) | (NumberToken _) | TrueToken | FalseToken | MinusToken | LeftParenthesisToken) ->
        print_endline "T -> F FX";
        inject stream >>=
        parseF >>=
        parseFX
    | _ -> Failure)

(* parseFX : inputStream -> parseResult *)
(* Analyse du non terminal FX *)
and parseFX stream =
  (match (peekAtFirstToken stream) with
    (* regle 13 *)
    | TimesToken ->
        print_endline "FX -> * F FX";
        inject stream >>=
        accept TimesToken >>=
        parseF >>=
        parseFX
    (* regle 14 *)
    | DivideToken ->
        print_endline "FX -> / F FX";
        inject stream >>=
        accept DivideToken >>=
        parseF >>=
        parseFX
    (* regle 15 *)
    | (RightParenthesisToken | EqualToken | PlusToken | MinusToken | ThenToken | InToken | ElseToken) ->
        print_endline "FX -> ";
        inject stream
    | EOSToken -> 
        print_endline "FX -> EOS";
        inject stream
    | _ -> Failure)

(* parseF : inputStream -> parseResult *)
(* Analyse du non terminal F *)
and parseF stream =
  (match (peekAtFirstToken stream) with
    (* regle 16 *)
    | MinusToken ->
        print_endline "F -> - F";
        inject stream >>=
        accept MinusToken >>=
        parseF
    (* regle 17 *)
    | (NumberToken _) ->
        print_endline "F -> number";
        inject stream >>=
        acceptNumber
    (* regle 20 *)
    | ((IdentToken _) | LeftParenthesisToken) ->
        print_endline "F -> FF ARG";
        inject stream >>=
        parseFF >>=
        parseARG
    (* regle 21 *)
    | TrueToken ->
        print_endline "F -> true";
        inject stream >>=
        accept TrueToken
    (* regle 22 *)
    | FalseToken ->
        print_endline "F -> false";
        inject stream >>=
        accept FalseToken
    | _ -> Failure)

(* parseFF : inputStream -> parseResult *)
(* Analyse du non terminal FF *)
and parseFF stream =
  (match (peekAtFirstToken stream) with
    (* regle 23 *)
    | LeftParenthesisToken ->
        print_endline "FF -> ( E )";
        inject stream >>=
        accept LeftParenthesisToken >>=
        parseE >>=
        accept RightParenthesisToken
    (* regle 24 *)
    | (IdentToken _) ->
        print_endline "FF -> ident";
        inject stream >>=
        acceptIdent
    | _ -> Failure)

(* parseARG : inputStream -> parseResult *)
(* Analyse du non terminal ARG *)
and parseARG stream =
  (match (peekAtFirstToken stream) with
    (* regle 25 *)
    | LeftParenthesisToken ->
        print_endline "ARG -> ( E )";
        inject stream >>=
        accept LeftParenthesisToken >>=
        parseE >>=
        accept RightParenthesisToken
    (* regle 26 *)
    | (TimesToken | DivideToken | RightParenthesisToken | EqualToken | PlusToken | MinusToken | ThenToken | InToken | ElseToken) ->
        print_endline "ARG -> ";
        inject stream
    | EOSToken -> 
        print_endline "ARG -> EOS";
        inject stream
    | _ -> Failure)
;;
