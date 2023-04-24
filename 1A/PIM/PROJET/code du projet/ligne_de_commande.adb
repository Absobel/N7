with Ada.Text_IO;               use Ada.Text_IO;
with exceptions;                use exceptions;

package body ligne_de_commande is

    procedure Usage is
    begin
        Put_Line("Usage: ./routeur_ll <options> | ./routeur_la <options>");
        Put_Line("Options:");
        Put_Line("  -c <taille> : Définir la taille du cache. La valeur 0 indique qu'il n y a pas de cache. La valeur par défaut est 10.");
        Put_Line("  -p FIFO|LRU|LFU : Définir la politique utilisée par le cache. La valeur par défaut est FIFO.");
        Put_Line("     <fichier> : Définir le nom du fichier contenant les paquets à router. Par défaut, on utilise le fichier paquets.txt.");
        Put_Line("  -s : Afficher les statistiques (nombre de défauts de cache, nombre de demandes de route, taux de défaut de cache). C'est l'option activée par défaut.");
        Put_Line("  -S : Ne pas afficher les statistiques.");
        Put_Line("  -t <fichier> : Définir le nom du fichier contenant les routes de la table de routage. Par défaut, on utilise le fichier table.txt.");
        Put_Line("  -r <fichier> : Définir le nom du fichier contenant les résultats (adresse IP destination du paquet et inter-face utilisée). Par défaut, on utilise le fichier resultats.txt.");
    end;



    procedure Argument_Parsing(Argument : T_Tableau_Arguments; Argument_Count : in Integer; Cache_Size : out Integer;
        Policy : out Unbounded_String ; Stat : out Boolean ; Table_File : out Unbounded_String;
        Packet_File : out Unbounded_String ; Result_File : out Unbounded_String) is

        i : Integer := 1;   -- Index dans le tableau des arguments
        Argument_i : Unbounded_String;  -- Argument courant

        -- Vérifier que le nombre d'arguments est correct après une commande qui prend une valeur (ex : -c 10)
        --
        -- Paramètres :
        --  Argument : Tableau des arguments
        --  Argument_Count : Nombre d'arguments
        --  i : Index dans le tableau des arguments
        procedure Argument_Checking(Argument : in T_Tableau_Arguments ; Argument_Count : in Integer ; i : in Integer) is
        begin
            if i+1 > Argument_Count then
                -- L'argument suivant n'existe pas
                Put_Line("Il manque un argument à " & To_String(Argument(i)) & " à la position " & Integer'Image(i));
                Usage;
                raise CommandeInvalide;
            end if;
        end Argument_Checking;


    begin
        -- Initialiser les valeurs par défaut
        Cache_Size := 10;
        Policy := To_Unbounded_String("FIFO");
        Stat := True;
        Table_File := To_Unbounded_String("table.txt");
        Packet_File := To_Unbounded_String("paquets.txt");
        Result_File := To_Unbounded_String("resultats.txt");

        -- Enregistrer les valeurs des arguments contenus dans le tableau
        while i <= Argument_Count loop
            Argument_i := Argument(i);

            if Argument_i = "-c" then
                -- Enregistrer la taille maximale du cache
                begin
                    -- Enregitrer la valeur
                    Argument_Checking(Argument, Argument_Count, i);
                    Cache_Size := Integer'Value(To_String(Argument(i+1)));
                exception
                    -- Traiter le cas où -c n'est pas suivi d'un entier
                    when others =>
                        Put_Line("-c est suivi d'un entier. Erreur à la position " & Integer'Image(i));
                        Usage;
                        raise CommandeInvalide;
                end;
                i := i + 1;

            elsif Argument_i = "-p" then
                -- Enregistrer la politique de gestion du cache ou le nom du fichier de paquets
                Argument_Checking(Argument, Argument_Count, i);

                if Argument(i+1) = "FIFO" or Argument(i+1) = "LRU" or Argument(i+1) = "LFU" then
                    -- Enregistrer la politique de gestion du cache
                    Policy := Argument(i+1);
                else
                    Packet_File := Argument(i+1);
                end if;
                i := i + 1;

                --Enregistrer si les statistiques du cache devront être affichées en fin de programme
            elsif Argument_i = "-s" then
                    -- On affichera le cache.
                Stat := True;

            elsif Argument_i = "-S" then
                    -- On n'affichera pas le cache.
                Stat := False;

            elsif Argument_i = "-t" or Argument_i = "-r" then
                -- Enregistrer le chemin vers le fichier de la table de routage et vers le fichier de résultats
                Argument_Checking(Argument, Argument_Count, i);

                if Argument_i = "-t" then
                    -- Enregistrer le chemin vers le fichier de la table de routage
                    Table_File := Argument(i+1);
                else
                    -- Enregistrer le chemin vers le fichier de résultats
                    Result_File := Argument(i+1);
                end if;
                i := i + 1;

            else
                -- Traiter le cas où la commande est inconnue.
                Put_Line("Option inconnue : " & To_String(Argument(i)));
                Usage;
                raise CommandeInvalide;
            end if;

            i := i + 1;
        end loop;
    end;




end ligne_de_commande;
