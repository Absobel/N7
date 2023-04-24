with Ada.Command_Line; use Ada.Command_Line;
with Ada.Text_IO;      use Ada.Text_IO;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with Ada.Strings;               use Ada.Strings;
with Ada.Text_IO.Unbounded_IO;  use Ada.Text_IO.Unbounded_IO;
with Ada.Exceptions;            use Ada.Exceptions;	-- pour Exception_Messagebounded_IO;
with adresseIP;                 use adresseIP;
with TableRoutage;              use TableRoutage;
with exceptions;               use exceptions;
with ligne_de_commande;



procedure routeur_simple is


    --traiter les commandes du fichier de paquetage

    package ligne_de_commande_P is new ligne_de_commande (Argument_Count);
    use ligne_de_commande_P;

    Tableau_Arguments : T_Tableau_Arguments;    -- tableau qui contient les arguments de la ligne de commande

    Fichier_paquets: File_Type;
    Fichier_resultats:File_Type;
    Fichier_table: File_Type;

    Taille_cache : Integer;                         -- Inutile car aucun cache
    Afficher_Statistiques : Boolean := False;    -- Il n'y a pas de cache, requis pour l'utilisation de Argument_Parsing
    Politique : Unbounded_String;                -- idem
    Nom_Fichier_resultats: Unbounded_string;
    Nom_Fichier_paquets: Unbounded_string;
    Nom_Fichier_Table: Unbounded_string;

    commande: unbounded_String;     -- commande à traiter (table, cache, ou fin)
    Numero_Ligne: Integer;          -- numéro de la ligne de la commande

    Table: Liste_Table.T_LCA;       -- table de routage

    adresse: T_AdresseIP;
    Masque : T_AdresseIP;
    Destination : Unbounded_string;

    A_Fini: Boolean;            -- Indique si la boucle doit se terminer (commande "fin", fin de fichier...)



begin

    -- Initialisation des différentes constantes et ouverture des fichiers.

    for I in 1..Argument_Count loop
        -- On récupère les arguments de la ligne de commande
        Tableau_Arguments(I) := To_Unbounded_String(Argument(I));
    end loop;

        -- On modifie les constantes avec les arguments de la ligne de commande
    Argument_Parsing(Tableau_Arguments, Argument_Count, Taille_Cache, Politique, Afficher_Statistiques, Nom_Fichier_Table, Nom_Fichier_paquets, Nom_Fichier_resultats);

        -- Ouverture des fichiers
    create(Fichier_resultats, Out_File, To_string(Nom_Fichier_resultats));
    Open(Fichier_paquets, In_File, To_string(Nom_Fichier_paquets));

        -- Initialisation de la table de routage
    Open(Fichier_Table, In_File, To_String(Nom_Fichier_Table));
    Initialiser_Table(Table, Fichier_Table);
    close(Fichier_Table);

    -- Traitement des commandes
    A_Fini := False;

    while not End_Of_File(Fichier_paquets) and then not A_Fini loop

        begin

        -- Lecture de la ligne et traitement comme une adresse IP (comparaison à la table, enregistrement dans le fichier résultats).
            Numero_ligne:=Integer(Line(Fichier_paquets));
            Adresse := TransformerAdresseIP(Fichier_paquets);

            Comparer_Table(Table, Adresse, Destination, Masque);

        -- Enregistrer l'adresse et la destination dans le fichier résultats
            EnregistrerAdresse(Fichier_resultats, Adresse);
            Put(Fichier_resultats, Destination);
            New_Line(Fichier_resultats);
            Skip_Line(Fichier_paquets);

        exception
        -- Si on rencontre une erreur de type Data_error, c'est qu'il s'agit d'une commande.
            when DATA_ERROR =>
        -- Lecture et traitement de la commande
            -- Lecture de la commande
                commande:=Get_line(Fichier_paquets);
                trim(commande,both);

            -- Traitement de la commande
                if commande="table" then
                    -- la commande "table" permet d'afficher la table de routage.
                    Afficher_Table(Table,Numero_ligne);

                elsif commande="fin" then
                    -- la commande "fin" permet de terminer le programme.
                    A_Fini := True;

                else
                    -- Si la commande n'est pas reconnue, on affiche un message et on continue.
                    Put_Line("Commande inconnue à la ligne " & Integer'Image(Numero_ligne));
                end if;

                    -- Si l'errur est inconnue, on affiche le message d'erreur et on arrête le programme.
            when E : others =>
                Put_Line("Erreur de syntaxe dans le fichier de paquets à la ligne" & Integer'Image(Numero_Ligne));
                Put_Line("Erreur : " & Exception_Message(E));
                A_Fini := True;

        end;
    end loop;

    -- Fermer les fichiers et vider les caches
    Vider_Table(Table);

    close(Fichier_resultats);
    close(Fichier_paquets);

    put("Fin du programme");

exception

    when CommandeInvalide =>

        -- L'erreur a lieu avant d'initialiser quoi que ce soit (pas besoin de vider le cache ou la table).

        Put_Line("Erreur dans la ligne de commande.");
        Usage;
        raise;

    when E : others =>

        Put_Line("Erreur (placeholder)");
        Put_Line("Erreur : " & Exception_Message(E));
        Vider_Table(Table);
        Put_Line("Fin du programme");

end routeur_simple;
