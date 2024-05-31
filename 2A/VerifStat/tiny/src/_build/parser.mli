type token =
  | INT of (
# 30 "parser.mly"
        int
# 6 "parser.mli"
)
  | VAR of (
# 31 "parser.mly"
        string
# 11 "parser.mli"
)
  | LPAR
  | RPAR
  | SEMICOL
  | COMA
  | RAND_ITV
  | EQUAL
  | IF
  | ELSE
  | WHILE
  | LBRA
  | RBRA
  | PLUS2
  | MINUS2
  | GT
  | LT
  | GE
  | LE
  | PLUS
  | MINUS
  | TIMES
  | DIV
  | UMINUS
  | SEQ
  | EOF

val file :
  (Lexing.lexbuf  -> token) -> Lexing.lexbuf -> Ast.stm
