with Ada.Integer_Text_IO;       use Ada.Integer_Text_IO;

package body TableRoutage is


    procedure Afficher_Table (Table : T_LCA ; Numero_Ligne : Integer) is

        -- Affiche une ligne de la table de routage (format XXX.XXX.XXX.XXX XXX.XXX.XXX.XXX Destination)
        --
        -- Paramètres :
        --   Cle : la clé de la ligne
        --   Valeur : la valeur de la ligne
        procedure Afficher_Ligne (Cle : T_AdresseIP  ; Donnee : T_Donnee) is
        begin
            AfficherAdresseIP(Cle);
            AfficherAdresseIP(Donnee.Masque);
            Put(To_String(Donnee.Destination));
            New_Line;
        end Afficher_Ligne;

        procedure Afficher_Table_Ligne is new Pour_Chaque(Traiter => Afficher_Ligne);

    begin
        -- Afficher la ligne de d'appel
        Put("table : (ligne ");
        put(Numero_Ligne, 1);
        Put(")");
        New_Line;
        -- Afficher la table
        Afficher_Table_Ligne(Table);

    end Afficher_Table;


    procedure Comparer_table(Table : in T_LCA ; Adresse : in T_AdresseIP ; Destination : out Unbounded_String ; Masque : out T_AdresseIP) is

        Adresse_Masquee : T_AdresseIP;
        Adresse_xor_Cle_Min : T_AdresseIP := 2**32 - 1; -- = Adressse XOR Cle, qui permet de déduire le premier bit différent entre Cle et Adresse
        Masque_Max : T_AdresseIP := 0;

        -- Fonction qui compare une adresse masquée par la Donnée avec la clé masquée par la donnée
        --
        -- Paramètres :
        --  Cle : la clé de la ligne
        --  Donnée : la donnée de la ligne
        procedure Comparer_Ligne(Cle : T_AdresseIP ; Donnee : T_Donnee) is
        begin
            -- Masquer l'adresse et la clé
            Adresse_Masquee := Adresse and Donnee.Masque;
            -- Comparer les deux adresses masquées
            if Adresse_Masquee = Cle and Donnee.Masque >= Masque then
                -- On garde uniquement l'adresse correspondante au masque le plus grand
                Destination := Donnee.Destination;
                Masque := Donnee.Masque;
            end if;
            if Donnee.Masque > Masque_Max then
                Masque_Max := Donnee.Masque;
            end if;
        end Comparer_Ligne;

        procedure Parcourir_Table is new Pour_Chaque(Traiter => Comparer_Ligne);

        -- Fonction qui compare une adresse avec la clé et prend celle avec la plus petite différence (masque maximal)
        --
        -- Paramètres :
        --  Cle : la clé de la ligne
        --  Donnée : la donnée de la ligne
        procedure Obtenir_Difference_Min(Cle : T_AdresseIP ; Donnee : T_Donnee) is
        begin

            pragma Warnings(Off, Donnee);

            if Adresse_xor_Cle_Min > (Cle xor Adresse) then
                Adresse_xor_Cle_Min := Cle xor Adresse;
            end if;

        end Obtenir_Difference_Min;

        Procedure Difference_Min is new Pour_Chaque(Traiter => Obtenir_Difference_Min);


        I : Integer := 31;  -- Indice du bit à tester
        Est_Discriminant : Boolean := False; -- Indique si le masque (du Ie bit au 31e) est discriminant
        Bit_Difference : T_AdresseIP; -- Ie bit de la différence minimale entre les clés et l'adresse

    begin

        Masque := 0;
        Destination := To_Unbounded_String("Erreur Table");
        Masque := 0;
        Parcourir_Table(Table);

        Difference_Min(Table);
        Masque := 0;
        loop
            Bit_Difference := (Adresse_xor_Cle_Min / 2**I) mod 2;
            Est_Discriminant := Bit_Difference = 1;
            Masque := Masque + 2**I;
            I := I - 1;
            exit when I = -1 or Est_Discriminant;
        end loop;
        Masque := Masque and Masque_max;

    end Comparer_table;


    procedure Initialiser_Table(Table : in out T_LCA ; Fichier_Table : in out File_Type ) is

        Adresse : T_AdresseIP;
        Masque : T_AdresseIP;
        Destination : Unbounded_String;
        Ligne_Table : T_Donnee;

    begin
        Initialiser(Table);
        -- Remplir la table de routage avec les valeur dans le Fichier_Table
        loop
            -- Lire une ligne du fichier
            Adresse := TransformerAdresseIP(Fichier_Table);
            Masque := TransformerAdresseIP(Fichier_Table);
            Destination := To_Unbounded_String(Get_Line(Fichier_Table));

            Trim(Destination, Both);

            Ligne_Table := T_Donnee'(Masque, Destination);
            -- Ajouter la ligne à la table
            Ajouter_Fin(Table, Adresse, Ligne_Table);
            exit when End_Of_File(Fichier_Table);
        end loop;
        -- gestion des exceptions
    exception
        when End_Error =>
            Put ("Blancs en surplus à la fin du fichier.");
            null;
    end Initialiser_Table;

    procedure Vider_Table (Table : in out T_LCA) is
    begin
        Vider(Table);
    end Vider_Table;

end TableRoutage;
