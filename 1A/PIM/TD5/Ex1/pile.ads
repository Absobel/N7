generic
    type Type_Element is private;
    Capacite: Integer;
package Pile is
    subtype Pile_Idx is Integer range 1..Capacite;
    type T_Pile is limited private;
    
    procedure Initialiser(Une_Pile : out T_Pile) with
        Post => Est_Vide(Une_Pile);
    
    function Est_Vide(Une_Pile: in T_Pile) return Boolean;

    function Est_Pleine(Une_Pile : in T_Pile) return Boolean;

    function Sommet(Une_Pile : in T_Pile) return Type_Element with
        Pre => not Est_Vide(Une_Pile);

    procedure Empiler(Une_Pile : in out T_Pile ; Un_Element : in Type_Element) with
        Pre => not Est_Pleine(Une_Pile),
        Post => Sommet(Une_Pile) = Un_Element;
    
    procedure Depiler(Une_Pile : in out T_Pile) with
        Pre => not Est_Vide(Une_Pile);

    generic
        with procedure Afficher_Element(Un_Element: in Type_Element);
    procedure Afficher(Une_Pile: in T_Pile);
    
private
    type T_Element is array (Pile_Idx) of Type_Element;
    type T_Pile is record
        Elements : T_Element;
        Taille : Integer;
    end record;
end Pile;