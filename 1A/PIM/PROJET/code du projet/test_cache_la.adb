with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with Ada.Text_IO;              use Ada.Text_IO;
with Ada.Exceptions;            use Ada.Exceptions;	-- pour Exception_Messagebounded_IO;
with cache_la;
with adresseip; use adresseip;

procedure test_cache_la is

    Erreur_Noeud : constant Unbounded_String := To_Unbounded_String("Erreur");
    package cache_la_test is new cache_la (Erreur_Noeud);
    use cache_la_test;

    CacheLRU : T_Cache;
    CacheLFU : T_Cache;
    cacheFIFO : T_Cache;

    FichierTest : File_Type; -- Table qui donne les adresses à tester dans le programme

    Adresse : T_AdresseIP;
    AdresseASupprimerLRU : T_AdresseIP;
    AdresseASupprimerLFU : T_AdresseIP;
    AdresseASupprimerFIFO : T_AdresseIP;

    Masque : T_AdresseIP;

    Destination : Unbounded_String;
    DestinationLue : Unbounded_String;

    NbConsultations : Integer := 0;
    NbDefauts : Integer := 0;
    TauxDefauts : Float := 0.0;

    A_trouve : Boolean;     -- Indique si l'adresse existe dans l'arbre
    Fini : Boolean;        -- Indique si on a fini le segment (lectures, enregistrements...)

begin

    -- Initialisation des caches et du fichier test

    Open(FichierTest, In_File, "test_cache_la_table.txt");

    Initialiser (CacheLRU, 5, LRU);
    Initialiser (CacheLFU, 5, LFU);
    Initialiser (CacheFIFO, 5, FIFO);

    -- Ajout de 5 adresse IP dans chaque cache

    Put_Line(Get_Line(FichierTest));

    for I in 1..5 loop

        begin

        -- Lecture de l'adresse IP, du masque et de la destination
        Adresse := TransformerAdresseIp(FichierTest);
        Masque := TransformerAdresseIp(FichierTest);
        Destination := To_Unbounded_String(Get_line(FichierTest));

        -- Ajout de l'adresse IP dans les caches
        Enregistrer (CacheLRU, Adresse, Masque, Destination);
        Enregistrer (CacheLFU, Adresse, Masque, Destination);
        Enregistrer (CacheFIFO, Adresse, Masque, Destination);

        -- vérification de l'ajout dans le cache LRU
        Lire(CacheLRU, Adresse, DestinationLue, A_Trouve);
        Pragma Assert (A_Trouve);
        Pragma Assert (DestinationLue = Destination);

        -- vérification de l'ajout dans le cache LFU
        Lire(CacheLFU, Adresse, DestinationLue, A_Trouve);
        Pragma Assert (A_Trouve);
        Pragma Assert (DestinationLue = Destination);

        -- vérification de l'ajout dans le cache FIFO
        Lire(CacheFIFO, Adresse, DestinationLue, A_Trouve);
        Pragma Assert (A_Trouve);
        Pragma Assert (DestinationLue = Destination);

        -- Fin de l'étape
        Put_Line("Etape " & Integer'Image(I) & " : OK");
        NbConsultations := NbConsultations + 1;

    exception
        when E : others =>
            -- anormal
            PUT_Line(Exception_Message(E));

    end;
    end loop;

    -- Affichage des caches

    New_Line;
    Put_Line("--------------------");
    New_Line;
    Put_Line("Affichage des caches :");
    Put_Line("Cache LRU :");
    Afficher(CacheLRU, 1);
    New_Line;
    Put_Line("Cache LFU :");
    Afficher(CacheLFU, 1);
    New_Line;
    Put_Line("Cache FIFO :");
    Afficher(CacheFIFO, 1);
    New_Line;
    put_Line("--------------------");
    new_line;

    -- Lecture dans les caches

    Put_Line(Get_Line(FichierTest));
    Fini := False;
    while not Fini loop

        begin

            -- Lecture de l'adresse IP et de la destination
            Adresse := TransformerAdresseIp(FichierTest);
            Destination := To_Unbounded_String(Get_line(FichierTest));

            -- Lecture dans le cache LRU et vérification
            Lire(CacheLRU, Adresse, DestinationLue, A_trouve);
            pragma assert(A_Trouve);
            pragma assert(DestinationLue = Destination);

            -- Lecture dans le cache LFU et vérification
            Lire(CacheLFU, Adresse, DestinationLue, A_trouve);
            pragma assert(A_Trouve);
            pragma assert(DestinationLue = Destination);

            -- Lecture dans le cache FIFO et vérification
            Lire(CacheFIFO, Adresse, DestinationLue, A_trouve);
            pragma assert(A_Trouve);
            pragma assert(DestinationLue = Destination);

            -- Fin de l'étape
            put_Line("Etape " & Integer'Image(NbConsultations) & " : OK");
            NbConsultations := NbConsultations + 1;

        exception
            when DATA_ERROR =>
                -- On a atteint la fin du segment : on passe à la suite
                put_line(Get_line(FichierTest));
                Fini := True;

            when E : others =>
                -- anormal
                Put_Line("Erreur : " & Exception_Message(E));
                Fini := True;
        end;
    end loop;



    -- Lecture de chemins qui n'existent pas dans le cache

    New_Line;
    Put_Line("--------------------");
    New_Line;
    Put_Line(Get_Line(FichierTest));
    Fini := False;

    while not Fini loop
        begin

            -- Lecture de l'adresse IP
            Adresse := TransformerAdresseIp(FichierTest);

            -- Lecture dans le cache LRU et vérification
            Lire(CacheLRU, Adresse, DestinationLue, A_trouve);
            pragma assert(not A_Trouve);
            pragma assert(DestinationLue = To_Unbounded_String("Erreur"));

            -- Lecture dans le cache LFU et vérification
            Lire(CacheLFU, Adresse, DestinationLue, A_trouve);
            pragma assert(not A_Trouve);
            pragma assert(DestinationLue = To_Unbounded_String("Erreur"));

            -- Lecture dans le cache FIFO et vérification
            Lire(CacheFIFO, Adresse, DestinationLue, A_trouve);
            pragma assert(not A_Trouve);
            pragma assert(DestinationLue = To_Unbounded_String("Erreur"));

            -- Fin de l'étape
            put_Line("Etape " & Integer'Image(NbConsultations) & " : OK");
            NbConsultations := NbConsultations + 1;
            NbDefauts := NbDefauts + 1;

        exception
            when DATA_ERROR =>
                -- On a atteint la fin du segment : on passe à la suite
                Fini := True;
                Put_Line(Get_Line(FichierTest));

            when E : others =>
                -- anormal
                Put_Line("Erreur : " & Exception_Message(E));
                Fini := True;
        end;
    end loop;

    -- Ajout dans le cache déjà plein

    New_Line;
    Put_Line("--------------------");
    New_Line;
    Put_Line(Get_Line(FichierTest));
    Fini := False;

    while not Fini loop
        begin

        -- Lecture de l'adresse IP et du masque
        Adresse := TransformerAdresseIp(FichierTest);
        Masque := TransformerAdresseIp(FichierTest);

        -- Lecture de l'Adresse IP qui devrait être supprimée pour chaque cache
        AdresseASupprimerLRU := TransformerAdresseIp(FichierTest);
        AdresseASupprimerLFU := TransformerAdresseIp(FichierTest);
        AdresseASupprimerFIFO := TransformerAdresseIp(FichierTest);

        -- Lecture de la destination
        Destination := To_Unbounded_String(Get_line(FichierTest));

        -- Ajout dans les caches
        Enregistrer (CacheLRU, Adresse, Masque, Destination);
        Enregistrer (CacheLFU, Adresse, Masque, Destination);
        Enregistrer (CacheFIFO, Adresse, Masque, Destination);

        -- Vérification de l'ajout dans le cache LRU
        Lire(CacheLRU, Adresse, DestinationLue, A_Trouve);
        Pragma Assert (A_Trouve);
        Pragma Assert (DestinationLue = Destination);
        -- Vérification de la suppression de la bonne adresse IP
        Lire(CacheLRU, AdresseASupprimerLRU, DestinationLue, A_Trouve);
        Pragma Assert (not A_Trouve);
        Pragma Assert (DestinationLue = To_Unbounded_String("Erreur"));

        -- Vérification de l'ajout dans le cache LFU
        Lire(CacheLFU, Adresse, DestinationLue, A_Trouve);
        Pragma Assert (A_Trouve);
        Pragma Assert (DestinationLue = Destination);
        -- Vérification de la suppression de la bonne adresse IP
        Lire(CacheLFU, AdresseASupprimerLFU, DestinationLue, A_Trouve);
        Pragma Assert (not A_Trouve);
        Pragma Assert (DestinationLue = To_Unbounded_String("Erreur"));

        -- Vérification de l'ajout dans le cache FIFO
        Lire(CacheFIFO, Adresse, DestinationLue, A_Trouve);
        Pragma Assert (A_Trouve);
        Pragma Assert (DestinationLue = Destination);
        -- Vérification de la suppression de la bonne adresse IP
        Lire(CacheFIFO, AdresseASupprimerFIFO, DestinationLue, A_Trouve);
        Pragma Assert (not A_Trouve);
        Pragma Assert (DestinationLue = To_Unbounded_String("Erreur"));

        -- Fin de l'étape
        put_Line("Etape " & Integer'Image(NbConsultations) & " : OK");
        NbConsultations := NbConsultations + 2;
        NbDefauts := NbDefauts + 1;

        exception
            when DATA_ERROR =>
                -- On a atteint la fin du segment : on passe à la suite
                Fini := True;
                Put_Line(Get_Line(FichierTest));

            when E : others =>
                -- anormal
                Put_Line("Erreur : " & Exception_Message(E));
                Fini := True;
        end;
    end loop;

    -- Affichage des caches

    New_Line;
    Put_Line("--------------------");
    New_Line;
    Put_Line("Cache LRU :");
    Afficher(CacheLRU, 1);
    New_Line;
    Put_Line("Cache LFU :");
    Afficher(CacheLFU, 1);
    New_Line;
    Put_Line("Cache FIFO :");
    Afficher(CacheFIFO, 1);
    new_line;


    -- Affichage des statistiques

    Put_Line("--------------------");
    New_Line;

    Put_Line("Statistiques :");
    New_Line;
    Put_Line("Attendues :");
    Put_Line("Nombre de consultations : " & Integer'Image(NbConsultations));
    TauxDefauts := Float(NbDefauts) / Float(NbConsultations);
    Put_Line("Taux de défauts : " & Float'Image(TauxDefauts));
    New_Line;
    Put_Line("Cache LRU :");
    Statistiques(CacheLRU);
    New_Line;
    Put_Line("Cache LFU :");
    Statistiques(CacheLFU);
    New_Line;
    Put_Line("Cache FIFO :");
    Statistiques(CacheFIFO);
    New_line;
    Put_Line("--------------------------------------------------");
    New_Line;

    -- Fin du test
    Put_Line("Test effectué avec succès !");

    -- Fermeture des fichier et vidage des caches
    Vider(CacheLRU);
    Vider(CacheLFU);
    Vider(CacheFIFO);

    close(FichierTest);

end test_cache_la;
