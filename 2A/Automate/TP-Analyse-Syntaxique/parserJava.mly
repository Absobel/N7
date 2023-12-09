%{

(* Partie recopiee dans le fichier CaML genere. *)
(* Ouverture de modules exploites dans les actions *)
(* Declarations de types, de constantes, de fonctions, d'exceptions exploites dans les actions *)

let nbrVariables = ref 0;;
let nbrMethodes = ref 0;;

%}

/* Declaration des unites lexicales et de leur typeStruct si une valeur particuliere leur est associee */

%token IMPORT 
%token CLASS EXTENDS PUBLIC PRIVATE STATIC MAIN
%token <string> IDENT TYPEIDENT
%token INT FLOAT BOOL CHAR VOID STRING
%token ACCOUV ACCFER PAROUV PARFER CROOUV CROFER
%token PTVIRG VIRG
%token SI SINON TANTQUE RETOUR
/* Defini le typeStruct des donnees associees a l'unite lexicale */
%token <int> ENTIER
%token <float> FLOTTANT
%token <bool> BOOLEEN
%token <char> CARACTERE
%token <string> CHAINE
%token VIDE
%token NOUVEAU
%token ASSIGN
%token OPINF OPSUP OPINFEG OPSUPEG OPEG OPNONEG
%token OPPLUS OPMOINS OPOU
%token OPMULT OPMOD OPDIV OPET
%token OPNON
%token OPPT
/* Unite lexicale particuliere qui represente la fin du fichier */
%token FIN

/* Declarations des regles d'associative et de priorite pour les operateurs */
/* La priorite est croissante de haut en bas */
/* Associatif a droite */
%right ASSIGN /* Priorite la plus faible */
/* Non associatif */
%nonassoc OPINF OPSUP OPINFEG OPSUPEG OPEG OPNONEG
/* Associatif a gauche */
%left OPPLUS OPMOINS OPOU
%left OPMULT OPMOD OPDIV OPET
%right OPNON
%left OPPT PAROUV CROOUV /* Priorite la plus forte */

/* typeStruct renvoye pour le nom terminal fichier */
%type <unit> fichier
%type <int> variables

/* Le non terminal fichier est l'axiome */
%start fichier

%% /* Regles de productions */

fichier : programme FIN 
{ 
	(print_endline "fichier : programme FIN");
	(print_string "Nombre de methodes : ");(print_int !nbrMethodes);(print_newline());
	(print_string "Nombre de variables : ");(print_int !nbrVariables);(print_newline())
}

programme : principale { (print_endline "programme : principale") }
		  | classes principale { (print_endline "programme : classe principale") }

classes : /* Lambda, mot vide */ { (print_endline "classes : /* Lambda, mot vide */") }
		| classe classes { (print_endline "classes : classe classes") }

classe : CLASS IDENT maybe_heritage ACCOUV definitions ACCFER { (print_endline "classe : CLASS IDENT maybe_heritage ACCOUV definitions ACCFER") }

maybe_heritage : /* Lambda */ { (print_endline "maybe_heritage : /* Lambda */") }
			   | EXTENDS IDENT { (print_endline "maybe_heritage : EXTENDS IDENT") }

definitions : /* Lambda, mot vide */ { (print_endline "definitions : /* Lambda, mot vide */") }
			| definition definitions { (print_endline "definitions : definition definitions") }

definition : privacy attribut_ou_methode { (print_endline "definition : privacy attribut_ou_methode") }

privacy : PUBLIC { (print_endline "privacy : PUBLIC") }
		| PRIVATE { (print_endline "privacy : PRIVATE") }

attribut_ou_methode : attribut { (print_endline "attribut_ou_methode : attribut") }
					 | methode { (print_endline "attribut_ou_methode : methode") }

attribut : typeStruct IDENT PTVIRG { (print_endline "attribut : typeStruct IDENT PTVIRG") }

methode : entete corps { (print_endline "methode : entete corps"); nbrMethodes := !nbrMethodes + 1 }

typeStruct : typeBase declTab { (print_endline "typeStruct : typeBase declTab") }

typeBase : INT { (print_endline "typeBase : INT") }
         | FLOAT { (print_endline "typeBase : FLOAT") }
         | BOOL { (print_endline "typeBase : BOOL") }
         | CHAR { (print_endline "typeBase : CHAR") }
         | STRING { (print_endline "typeBase : STRING") }
         | TYPEIDENT { (print_endline "typeBase : TYPEIDENT") }

declTab : /* Lambda, mot vide */ { (print_endline "declTab : /* Lambda, mot vide */") }
        | CROOUV CROFER { (print_endline "declTab : CROOUV CROFER") }

entete : typeStruct IDENT PAROUV parsFormels PARFER { (print_endline "entete : typeStruct IDENT PAROUV parsFormels PARFER") }
       | VOID IDENT PAROUV parsFormels PARFER { (print_endline "entete : VOID IDENT PAROUV parsFormels PARFER") }

parsFormels : /* Lambda, mot vide */ { (print_endline "parsFormels : /* Lambda, mot vide */") }
            | typeStruct IDENT suiteParsFormels { (print_endline "parsFormels : typeStruct IDENT suiteParsFormels") }

suiteParsFormels : /* Lambda, mot vide */ { (print_endline "suiteParsFormels : /* Lambda, mot vide */") }
                 | VIRG typeStruct IDENT suiteParsFormels { (print_endline "suiteParsFormels : VIRG typeStruct IDENT suiteParsFormels") }

principale : PUBLIC CLASS IDENT ACCOUV principal ACCFER { (print_endline "principale : PUBLIC CLASS IDENT CROOUV principal CROFER") }

principal : PUBLIC STATIC VOID MAIN PAROUV STRING CROOUV CROFER IDENT PARFER corps { (print_endline "principal : PUBLIC STATIC VOID MAIN PAROUV STRING CROOUV CROFER IDENT PARFER corps") }

corps : ACCOUV /* $1 */ variables /* $2 */ instructions /* $3 */ ACCFER /* $4 */
     {
	(print_endline "corps : ACCOUV variables instructions ACCFER");
	(print_string "Nombre de variables = ");
	(print_int $2);
	(print_newline ())
	}

variables : /* Lambda, mot vide */
	  {
		(print_endline "variables : /* Lambda, mot vide */");
		0
		}
          | variable /* $1 */ variables /* $2 */
	  {
		(print_endline "variables : variable variables");
		($2 + 1)
		}

variable : typeStruct IDENT other_idents PTVIRG { (print_endline "variable : typeStruct IDENT other_idents PTVIRG") }

other_idents : /* Lambda, mot vide */ { (print_endline "other_idents : /* Lambda, mot vide */") }
			 | VIRG IDENT other_idents { (print_endline "other_idents : VIRG IDENT other_idents") }

instructions : /* Lambda, mot vide */ { (print_endline "instructions : /* Lambda, mot vide */") }
			 | instruction instructions { (print_endline "instructions :	 instruction instructions") }

instruction : expression PTVIRG { (print_endline "instruction : expression PTVIRG") }
			| SI PAROUV expression PARFER corps maybe_else { (print_endline "instruction : SI PAROUV expression PARFER corps maybe_else") }
			| TANTQUE PAROUV expression PARFER corps { (print_endline "instruction : TANTQUE PAROUV expression PARFER corps") }
			| RETOUR expression PTVIRG { (print_endline "instruction : RETOUR expression PTVIRG") }

maybe_else : /* Lambda, mot vide */ { (print_endline "maybe_else : /* Lambda, mot vide */") }
		   | SINON corps { (print_endline "maybe_else : SINON corps") }

expression : binaire { (print_endline "expression : binaire") }
		   | unaires expression_suite { (print_endline "expression : unaires expression_suite") }

unaires : /* Lambda, mot vide */ { (print_endline "unaires : /* Lambda, mot vide */") }
		| unaire unaires { (print_endline "unaires : unaire unaires") }

unaire : PAROUV typeStruct PARFER { (print_endline "unaire : PAROUV typeStruct PARFER") }
	   | OPPLUS { (print_endline "unaire : OPPLUS") }
	   | OPMOINS { (print_endline "unaire : OPMOINS") }
	   | OPNON { (print_endline "unaire : OPNON") }

expression_suite : ENTIER { (print_endline "expression_suite : ENTIER") }
				 | FLOTTANT { (print_endline "expression_suite : FLOTTANT") }
				 | CARACTERE { (print_endline "expression_suite : CARACTERE") }
				 | BOOLEEN { (print_endline "expression_suite : BOOLEEN") }
				 | VIDE { (print_endline "expression_suite : VIDE") }
				 | NOUVEAU IDENT PAROUV PARFER { (print_endline "expression_suite : NOUVEAU IDENT PAROUV PARFER") }
				 | NOUVEAU IDENT CROOUV expression CROFER
				 | ident_or_expr suffixes { (print_endline "expression_suite : ident_or_expr suffixes") }

ident_or_expr : IDENT { (print_endline "ident_or_expr : IDENT") }
			  | PAROUV expression PARFER { (print_endline "ident_or_expr : PAROUV expression PARFER") }

suffixes : /* Lambda, mot vide */ { (print_endline "suffixes : /* Lambda, mot vide */") }
		 | suffixe suffixes { (print_endline "suffixes : suffixe suffixes") }

suffixe : CROOUV expression CROFER { (print_endline "suffixe : CROOUV expression CROFER") }
		| PAROUV args PARFER { (print_endline "suffixe : PAROUV args PARFER") }

args : /* Lambda, mot vide */ { (print_endline "args : /* Lambda, mot vide */") }
	 | expression suite_args { (print_endline "args : expression suite_args") }

suite_args : /* Lambda, mot vide */ { (print_endline "suite_args : /* Lambda, mot vide */") }
		   | VIRG expression suite_args { (print_endline "suite_args : VIRG expression suite_args") }

binaire : ASSIGN { (print_endline "binaire : ASSIGN") }
		| OPPT { (print_endline "binaire : OPPT") }
		| OPPLUS { (print_endline "binaire : OPPLUS") }
		| OPMOINS { (print_endline "binaire : OPMOINS") }
		| OPMULT { (print_endline "binaire : OPMULT") }
		| OPDIV { (print_endline "binaire : OPDIV") }
		| OPMOD { (print_endline "binaire : OPMOD") }
		| OPOU { (print_endline "binaire : OPOU") }
		| OPET { (print_endline "binaire : OPET") }
		| OPEG { (print_endline "binaire : OPEG") }
		| OPNONEG { (print_endline "binaire : OPNONEG") }
		| OPINF { (print_endline "binaire : OPINF") }
		| OPSUP { (print_endline "binaire : OPSUP") }
		| OPINFEG { (print_endline "binaire : OPINFEG") }
		| OPSUPEG { (print_endline "binaire : OPSUPEG") }
%%
