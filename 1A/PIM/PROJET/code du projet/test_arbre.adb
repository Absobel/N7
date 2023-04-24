with Ada.Text_IO; use Ada.Text_IO;
with adresseip; use adresseip;
with exceptions; use exceptions;
with arbre;


procedure test_arbre is

    package arbreInt is new arbre(Integer, 0);
    use arbreInt;

    ArbreTest : arbreInt.T_LA;
    Adresse : T_AdresseIP;
    valeurLue : Integer;
    AdresseLue : T_AdresseIP;

begin

   Initialiser(ArbreTest);
   pragma Warnings(off, valeurLue);

    Adresse := 127*2**24 + 0*2**16 + 0*2**8 + 0;
    Enregistrer(Adresse, 1, ArbreTest);

    Put_Line("Ajout de 1 à l'adresse 127.0.0.0");
    pragma assert(taille(ArbreTest) = 1);
    Lire(ArbreTest, Adresse, valeurLue, AdresseLue);
    pragma assert(ValeurLue = 1);
    pragma assert(AdresseLue = Adresse);
    Put_Line("OK");
    New_Line;

    Adresse := 127*2**24 + 127*2**16 + 0*2**8 + 0;
    Enregistrer(Adresse, 2, ArbreTest);

    Put_Line("Ajout de 2 à l'adresse 127.127.0.0");
    pragma assert(taille(ArbreTest) = 12);
    Lire(ArbreTest, Adresse, valeurLue, AdresseLue);
    pragma assert(ValeurLue = 2);
    pragma assert(AdresseLue = Adresse);
    Put_Line("OK");
    New_Line;

    Adresse := 255*2**24 + 0*2**16 + 0*2**8 + 0;
    Enregistrer(Adresse, 3, ArbreTest);

    Put_Line("Ajout de 3 à l'adresse 255.0.0.0");
    pragma assert(taille(ArbreTest) = 13);
    Lire(ArbreTest, Adresse, valeurLue, AdresseLue);
    pragma assert(ValeurLue = 3);
    pragma assert(AdresseLue = Adresse);
    Put_Line("OK");
    New_Line;

    begin
    Adresse := 127*2**24 + 127*2**16 + 0*2**8 + 0;
    Put_Line("Suppression de l'adresse 127.127.0.0");
    Supprimer(Adresse, ArbreTest);
    pragma assert(taille(ArbreTest) = 3);
    Lire(ArbreTest, Adresse, valeurLue, AdresseLue);
    exception
        when Cle_Absente_Exception => Put_Line("OK");
    end;
    New_Line;

    begin
    Adresse := 127*2**24 + 0*2**16 + 0*2**8 + 0;
    Put_Line("Suppression de l'adresse 127.0.0.0");
    Supprimer(Adresse, ArbreTest);
    pragma assert(taille(ArbreTest) = 1);
    Lire(ArbreTest, Adresse, valeurLue, AdresseLue);
    exception
        when Cle_Absente_Exception => Put_Line("OK");
    end;
    New_Line;

    begin
    Adresse := 255*2**24 + 0*2**16 + 0*2**8 + 0;
    Put_Line("Suppression de l'adresse 255.0.0.0");
    Supprimer(Adresse, ArbreTest);
    pragma assert(taille(ArbreTest) = 0);
    Lire(ArbreTest, Adresse, valeurLue, AdresseLue);
    exception
        when Cle_Absente_Exception => Put_Line("OK");
    end;
    New_Line;

    Vider(ArbreTest);

    Put_Line("Test réalisé avec succès !");


end test_arbre;
