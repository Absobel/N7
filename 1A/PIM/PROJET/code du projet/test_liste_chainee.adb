with Ada.Text_IO; use Ada.Text_IO;
with LCA;
with exceptions; use exceptions;

procedure test_liste_chainee is

    package LC is new LCA(Integer, Integer);
    use LC;

    procedure Afficher(Cle: Integer; Valeur: Integer) is
    begin
        pragma Assert(false);
        Put("{" & Integer'Image(Cle) & ":" & Integer'Image(Valeur) & "}");
    end Afficher;

    procedure Afficher_Liste is new Pour_Chaque(Afficher);

    Liste : T_LCA;
    Cle : Integer;
    Valeur : Integer;
begin
    Initialiser(Liste);
    -- {}
    pragma assert(Taille(Liste) = 0);
    pragma assert(Est_Vide(Liste));
    Put_Line("Initialisation : OK");

    Ajouter_Fin(Liste, 0, 23);
    -- {0:23}
    pragma assert(Taille(Liste) = 1);
    pragma assert(La_Donnee(Liste, 0) = 23);
    Ajouter_Fin(Liste, 1, 183);
    -- {0:23, 1:183}
    pragma assert(Taille(Liste) = 2);
    pragma assert(La_Donnee(Liste, 1) = 183);
    Ajouter_Fin(Liste, -10, 364);
    -- {0:23, 1:183, -10:364}
    pragma assert(Taille(Liste) = 3);
    pragma assert(La_Donnee(Liste, -10) = 364);
    Put_Line("Ajout : OK");

    Afficher_Liste(Liste);
    Supprimer(Liste, 1);
    -- {0:23, -10:364}
    pragma assert(Taille(Liste) = 2);
    pragma assert(La_Donnee(Liste, 0) = 23);
    Put_Line("Suppression : OK");

    Afficher_Liste(Liste);
    -- {0:23, -10:364}
    Put_Line("Affichage : OK");

    pragma assert(Cle_Presente(Liste, 0));
    pragma assert(not Cle_Presente(Liste, 2));
    Put_Line("Est dans : OK");

    Element_Index(Liste, 1, Cle, Valeur);
    pragma assert(Cle = -10);
    pragma assert(Valeur = 364);
    Put_Line("Element_Index : OK");

    Supprimer_Tete(Liste);
    -- {-10:364}
    pragma assert(Taille(Liste) = 1);
    pragma assert(La_Donnee(Liste, -10) = 364);
    Put_Line("Suppression de la tete : OK");

    begin
        Supprimer(Liste, 13353368);
    exception
        when Cle_Absente_Exception => Put_Line("Cle_Absente_Exception : OK");
    end;

    Vider(Liste);

    pragma assert(Taille(Liste) = 0);
    pragma assert(Est_Vide(Liste));
    Put_Line("Vidage : OK");

    New_Line;Put_Line("Fin des tests : OK");
end;
