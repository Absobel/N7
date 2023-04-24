WITH Ada.Text_IO; use Ada.Text_IO;
with adresseip; use adresseip;
with Ada.Strings;               use Ada.Strings;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with Ada.Text_IO.Unbounded_IO;  use Ada.Text_IO.Unbounded_IO;
with exceptions; use exceptions;

procedure test_adresseip is

    Adresse : T_AdresseIP;
    Chaine : Unbounded_String;  -- chaine de caractère pour tester que "0.0.0.0 test" soit bien restitué

    FichierEntree : File_Type;
    FichierSortie : File_Type;

begin

    -- Ouvrir les fichiers

    Open(FichierEntree, In_File, "test_adresseip_table.txt");
    Create(FichierSortie, Out_File, "test_adresseip_resultat.txt");

    Put_Line("Test du module adresseip");

    -- tester avec 125.125.125.125

        -- Lecture dans le fichier et afficher le résultat
    Adresse := TransformerAdresseIP(FichierEntree);
    AfficherAdresseIP(Adresse);
        -- Ecriture dans l'autre fichier
    EnregistrerAdresse(FichierSortie, Adresse);
    New_Line;
        -- vérifier que l'adresse obtenue est correcte
    pragma assert (Adresse = 125*2**24 + 125*2**16 + 125*2**8 + 125);

    -- tester avec 0.0.0.0 "test"

        -- Lecture dans le fichier et afficher le résultat
    Adresse := TransformerAdresseIP(FichierEntree);
    AfficherAdresseIP(Adresse);
        -- Ecriture dans l'autre fichier
    EnregistrerAdresse(FichierSortie, Adresse);
    New_Line;
        -- vérifier que l'adresse obtenue est correcte
    pragma assert (Adresse = 0);

        -- lecture de la chaine de test dans le fichier
    Chaine := Get_Line(FichierEntree);
    trim(Chaine, both);
        -- vérifier que la chaine de test est correcte
    pragma assert (To_String(Chaine) = "test");


    -- tester avec 255.255.255.255

        -- Lecture dans le fichier et afficher le résultat
    Adresse := TransformerAdresseIP(FichierEntree);
    AfficherAdresseIP(Adresse);
        -- Ecriture dans l'autre fichier
    EnregistrerAdresse(FichierSortie, Adresse);
    New_Line;
        -- vérifier que l'adresse obtenue est correcte
    pragma assert (Adresse = 2**32 - 1);

    -- tester avec 256.255.255.255 : on obtiendra l'erreur AdresseInvalide

    begin
        -- Essayer de lire une adresse invalide
    Adresse := TransformerAdresseIP(FichierEntree);
    Put_Line("On aurait dû obtenir l'erreur AdresseInvalide");

    exception
        -- traiter l'erreur
        when AdresseInvalide =>
            Put_Line("Adresse invalide");
        when others =>
            Put_Line("Erreur inconnue");
    end;

    -- tester avec -1.0.0.0 : on obtiendra l'erreur AdresseInvalide

    begin
        -- Essayer de lire une adresse invalide
    Adresse := TransformerAdresseIP(FichierEntree);
    Put_Line("On aurait dû obtenir l'erreur AdresseInvalide");

    exception
            -- traiter l'erreur
        when AdresseInvalide =>
            Put_Line("Adresse invalide");
        when DATA_ERROR =>
            Put_Line("Erreur de donnée");
        when others =>
            Put_Line("Erreur inconnue");
    end;

    -- Fermer les fichiers

    Close(FichierEntree);
    Close(FichierSortie);

    -- Vérifier le contenu de FichierSortie

    Open(FichierSortie, In_File, "test_adresseip_resultat.txt");

        -- Vérifier que la première adresse est correcte
    Adresse := TransformerAdresseIP(FichierSortie);
    pragma assert (Adresse = 125*2**24 + 125*2**16 + 125*2**8 + 125);

        -- Vérifier que la deuxième adresse est correcte
    Adresse := TransformerAdresseIP(FichierSortie);
    pragma assert (Adresse = 0);

            -- Vérifier que la troisième adresse est correcte
    Adresse := TransformerAdresseIP(FichierSortie);
    pragma assert (Adresse = 2**32 - 1);

    -- Fermer le fichier

    Put_Line("Test terminé");
    close(FichierSortie);



end test_adresseip;
