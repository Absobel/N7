%{

(* Partie recopiee dans le fichier CaML genere. *)
(* Ouverture de modules exploites dans les actions *)
(* Declarations de types, de constantes, de fonctions, d'exceptions exploites dans les actions *)

%}

/* Declaration des unites lexicales et de leur type si une valeur particuliere leur est associee */

%token UL_PACKAGE UL_INTERFACE UL_EXTENDS
%token UL_INT UL_BOOLEAN UL_VOID
%token UL_LEFT_BRACE UL_RIGHT_BRACE UL_LEFT_BRACKET UL_RIGHT_BRACKET UL_SEMI_COLUMN UL_COMMA UL_DOT

/* Defini le type des donnees associees a l'unite lexicale */

%token <string> UL_IDENT_PACKAGE UL_IDENT_INTERFACE

/* Unite lexicale particuliere qui represente la fin du fichier */

%token UL_FIN

/* Type renvoye pour le nom terminal document */
%type <unit> package

/* Le non terminal document est l'axiome */
%start package

%% /* Regles de productions */

package : internal_package UL_FIN { (print_endline "package : internal_package FIN") }

internal_package : UL_PACKAGE UL_IDENT_PACKAGE UL_LEFT_BRACE package_or_interface packages_or_interfaces UL_RIGHT_BRACE { (print_endline "internal_package : package IDENT_PACKAGE { packages_or_interfaces }") }

packages_or_interfaces : 
    | /* Lambda */ {(print_endline "packages_or_interfaces : ")}
    | package_or_interface packages_or_interfaces {(print_endline "packages_or_interfaces : package_or_interface packages_or_interfaces")}

package_or_interface :
    | internal_package {(print_endline "package_or_interface : internal_package")}
    | interface {(print_endline "package_or_interface : interface")}

interface : UL_INTERFACE UL_IDENT_INTERFACE maybe_extends UL_LEFT_BRACE methodes UL_RIGHT_BRACE {(print_endline "interface : interface IDENT_INTERFACE maybe_extends { methodes }")}

maybe_extends :
    | /* Lambda */ {(print_endline "maybe_extends : /* Lambda */")}
    | UL_EXTENDS nom_qualifie other_nom_qualifies {(print_endline "maybe_extends : extends nom_qualifie other_nom_qualifies")}

nom_qualifie : point_package_idents UL_IDENT_INTERFACE {(print_endline "nom_qualifie: point_package_idents IDENT_INTERFACE")}

point_package_idents :
    | /* Lambda */ {(print_endline "point_package_idents : /* Lambda */")}
    | UL_IDENT_PACKAGE UL_DOT point_package_idents {(print_endline "point_package_idents : IDENT_PACKAGE.point_package_idents")}

other_nom_qualifies :
    | /* Lambda */ {(print_endline "other_nom_qualifies : /* Lambda */")}
    | UL_COMMA other_nom_qualifies {(print_endline "other_nom_qualifies : , other_nom_qualifies")}

methodes :
    | /* Lambda */ {(print_endline "methodes : /* Lambda */")}
    | methode methodes {(print_endline "methodes: methode methodes")}

methode : type_ UL_IDENT_PACKAGE UL_LEFT_BRACKET maybe_types UL_RIGHT_BRACKET UL_SEMI_COLUMN {(print_endline "methode : type IDENT_PACKAGE ( maybe types );")}

maybe_types :
    | /* Lambda */ {(print_endline "maybe_types : /* Lambda */")}
    | types {(print_endline "maybe_types : types")}

types : type_ other_types {(print_endline "types: type other_types")}

other_types :
    | /* Lambda */ {(print_endline "other_types : /* Lambda */")}
    | UL_COMMA types {(print_endline "other_types : , other_types")}

type_ : 
    | UL_BOOLEAN {(print_endline "type : boolean")}
    | UL_INT {(print_endline "type : int")}
    | UL_VOID {(print_endline "type : void")}
    | nom_qualifie {(print_endline "type : nom_qualifie")}
%%

