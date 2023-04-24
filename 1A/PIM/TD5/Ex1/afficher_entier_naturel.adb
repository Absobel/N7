with Pile;
with Ada.Text_IO; use Ada.Text_IO;

procedure Afficher_entier_Naturel is
    
    package Pile_Char is new Pile(Capacite => 20, Type_Element => Character);
    use Pile_Char;
    
    procedure Afficher_Entier(Nb_A_Afficher: in Integer) is
        Nb: Integer := Nb_A_Afficher;
        Unite: Integer;
        Char_Unite: Character;
        P_Chiffres: T_Pile;
    begin
        Initialiser(P_Chiffres);
        
        loop
            Unite := Nb Mod 10;
            Nb := Nb/10;
            Char_Unite := Character'Val(Character'Pos('0') + Unite);
            Empiler(P_Chiffres, Char_Unite);
        exit when Nb = 0;
        end loop;

        loop
            Char_Unite := Sommet(P_Chiffres);
            Depiler(P_Chiffres);
            Put(Char_Unite);
        exit when Est_Vide(P_Chiffres);
        end loop;
    end Afficher_Entier;

begin
    Put("J'affiche 102 : ");
    Afficher_Entier(102);
    New_Line;

    Put("J'affiche 0 : ");
    Afficher_Entier(0);
    New_Line;

    Put("J'affiche le dernier entier : ");
    Afficher_Entier(Integer'Last);
    New_Line;
end Afficher_entier_Naturel;