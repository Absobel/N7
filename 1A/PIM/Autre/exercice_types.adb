with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Integer_Text_IO;   use Ada.Integer_Text_IO;

procedure Exercice_Types is

    type T_Couleur is (COEUR, CARREAU, TREFLE, PIQUE);
    type T_Valeur is (AS, DEUX, TROIS, QUATRE, CINQ, SIX, SEPT, HUIT, NEUF, DIX, VALET, DAME, ROI);

    type Carte is record
        Couleur : T_Couleur;
        Valeur : T_Valeur;
    end record;

    function Init_Carte(Couleur_in : in T_Couleur; Valeur_in : in T_Valeur) return Carte is
        Carte_Res : Carte := (Couleur_in, Valeur_in);
    begin
        return Carte_Res;
    end Init_Carte;

    procedure Afficher_Carte(Carte_in : in Carte) is
    begin
        if Carte_in.Valeur = AS then
            Put("AS ");
            Put(T_Couleur'Image(Carte_in.Couleur)(1..3));
        else
            Put(T_Valeur'Pos(Carte_in.Valeur));
            Put(" ");
            Put(T_Couleur'Image(Carte_in.Couleur)(1..3));
        end if;
    end Afficher_Carte;
    
begin

    null;


end Exercice_Types;
