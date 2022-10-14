with Ada.Text_IO; use Ada.Text_IO;

package body Pile is

    procedure Initialiser(Une_Pile : out T_Pile) is
    begin
        Une_Pile.Taille := 0;
    end;

    function Est_Vide(Une_Pile : in T_Pile) return Boolean is
    begin
        return (Une_Pile.Taille = 0);
    end;

    function Est_Pleine(Une_Pile : in T_Pile) return Boolean is
    begin
        return (Une_Pile.Taille >= Capacite);
    end;
    
    function Sommet(Une_Pile : in T_Pile) return Type_Element is
    begin
        return Une_Pile.Elements(Une_Pile.Taille);
    end;

    procedure Empiler(Une_Pile : in out T_Pile ; Un_Element : in Type_Element) is
    begin
        Une_Pile.Taille := Une_Pile.Taille + 1;
        Une_Pile.Elements(Une_Pile.Taille) := Un_Element;
    end;

    procedure Depiler(Une_Pile : in out T_Pile) is
    begin
        Une_Pile.Taille := Une_Pile.Taille - 1;
    end;

    procedure Afficher(Une_Pile: in T_Pile) is
    begin
        Put("Your Pile :"); New_Line;
        for i in 1..Une_Pile.Taille loop
            Put("[ "); Afficher_Element(Une_Pile.Elements(i)); Put(" ]"); New_Line;
        end loop;
    end;
end Pile;