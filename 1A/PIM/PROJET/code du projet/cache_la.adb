with Ada.Text_IO; Use Ada.Text_IO;
with exceptions; Use exceptions;

package body cache_la is


    procedure Initialiser(Cache : in out T_Cache ; Taille_Max : in Integer ; Politique : in T_Politique) is
    begin
        Initialiser(Cache.Arbre);
        Cache.taille := 0;
        Cache.Taille_Max := Taille_Max;
        Cache.Politique := Politique;
        Cache.Consultation := 0;
        Cache.IndiceCreation := 0;
        Cache.Defauts := 0;
    end Initialiser;



    procedure Statistiques(Cache : in T_Cache ; Ligne : in Integer) is

        Type T_Taux is delta 0.01 range 0.0 .. 100.0;

        package Taux_IO is new Ada.Text_IO.Fixed_IO(T_Taux);
        use Taux_IO;

        Taux_Defauts : T_Taux;


    begin
        Put_Line("Statistiques (ligne " & Integer'Image(Ligne) & ")");
        Put_Line("Taille du cache : " & Integer'Image(Cache.Taille));
        Put_Line("Nombre de demandes de routes : " & Integer'Image(Cache.Consultation));
        Put_Line("Nombre de défauts : " & Integer'Image(Cache.Defauts));
        -- Afficher le taux de défaut du cache
        if Cache.Consultation = 0 then
            Taux_Defauts := 0.0;
        else
            Taux_Defauts := T_Taux(Float(Cache.Defauts)*100.0 / Float(Cache.Consultation));
        end if;
        Put("Taux de défauts de cache : ");
        Put(Taux_Defauts, 1);
        Put_Line(" %");
    end Statistiques;



    procedure Lire(Cache : in out T_Cache ; Adresse : in T_AdresseIP ; Destination : out Unbounded_String ; A_Trouve : out Boolean) is

        NoeudLu : T_Noeud;
        NoeudAEnregistrer : T_Noeud;
        Adresse_A_Actualiser : T_AdresseIP; -- Adresse de noeud, s'il existe, que l'on a consulté

    begin
        -- Lire l'adresse dans l'arbre
        begin
            Lire(Cache.Arbre, Adresse, NoeudLu, Adresse_A_Actualiser);
            A_Trouve := (Adresse and NoeudLu.Masque) = (Adresse_A_Actualiser and NoeudLu.Masque);
        exception
            -- Si l'adresse n'est pas trouvée, on associe à NoeudLu une valeur par défaut
        when Cle_Absente_Exception =>
            A_Trouve := False;
            NoeudLu := T_Noeud'(Destination_Defaut, 0, 0, 0, 0);
        end;
        Destination := NoeudLu.Destination;

        -- On met à jour l'indice de consultation du cache
        Cache.Consultation := Cache.Consultation + 1;
        if not A_Trouve then
            Cache.Defauts := Cache.Defauts + 1;
        else
            -- Actualiser les indices de consultation et le nombre de consultation du noeud
            NoeudAEnregistrer := T_Noeud'(NoeudLu.Destination, NoeudLu.Masque, Cache.Consultation, NoeudLu.NombreConsultation + 1, NoeudLu.IndiceCreation);
            Enregistrer(Adresse_A_Actualiser, NoeudAEnregistrer, Cache.Arbre);
        end if;
    end Lire;

    procedure Enregistrer(Cache : in out T_Cache ; Adresse : in T_AdresseIP ; Masque : T_AdresseIP ; Destination : in Unbounded_String) is

        MinimumConsultation : Integer := Cache.Consultation;    -- Indice de consultation le plus petit de l'arbre (LRU)
        MinimumFrequence : Integer := Cache.Consultation;    -- Nombre de consultation le plus petit de l'arbre (LFU)
        MinimumCreation : Integer := Cache.IndiceCreation;    -- Indice de création le plus petit de l'arbre (FIFO)

        CleASupprimer : T_AdresseIP;
        NoeudAEnregistrer : T_Noeud;

        -- Actualise le minimum de consultation de l'arbre (LRU) pour le noeud ainsi que l'adresse correspondante
        --
        -- Paramètres :
        --  Cle : la clé du noeud
        --  Valeur : la valeur du noeud
        --  Gauche : Booleen qui indique si la recherche se poursuit dans le sous-arbre gauche
        --  Droite : Booleen qui indique si la recherche se poursuit dans le sous-arbre droit
        procedure TraiterMinimumConsultation(Cle : in T_AdresseIP ; Noeud : in T_Noeud ; Gauche : out Boolean ; Droite : out Boolean) is
        begin
            if Noeud.DerniereConsultation < MinimumConsultation and Noeud.Destination /= Destination_Defaut then
                -- le noeud est en fait une feuille
                MinimumConsultation := Noeud.DerniereConsultation;
                CleASupprimer := Cle;
            end if;
            Gauche := True;
            Droite := True;
            end TraiterMinimumConsultation;

        -- Actualise le minimum de fréquence de consultation de l'arbre (LFU) pour le noeud ainsi que l'adresse correspondante
        -- Paramètres :
        --  Cle : la clé du noeud
        --  Valeur : la valeur du noeud
        --  Gauche : Booleen qui indique si la recherche se poursuit dans le sous-arbre gauche
        --  Droite : Booleen qui indique si la recherche se poursuit dans le sous-arbre droit
        procedure TraiterMinimumFrequence(Cle : in T_AdresseIP ; Noeud : in T_Noeud ; Gauche : out Boolean ; Droite : out Boolean) is
        begin
            if Noeud.NombreConsultation < MinimumFrequence and Noeud.Destination /= Destination_Defaut then
                -- le noeud est en fait une feuille
                MinimumFrequence := Noeud.NombreConsultation;
                CleASupprimer := Cle;
            end if;
                Gauche := True;
                Droite := True;
        end TraiterMinimumFrequence;

        -- Actualise le minimum d'indice de création de l'arbre (FIFO) pour le noeud ainsi que l'adresse correspondante
        -- Paramètres :
        --  Cle : la clé du noeud
        --  Valeur : la valeur du noeud
        --  Gauche : Booleen qui indique si la recherche se poursuit dans le sous-arbre gauche
        --  Droite : Booleen qui indique si la recherche se poursuit dans le sous-arbre droit
        procedure TraiterMinimumCreation(Cle : in T_AdresseIP ; Noeud : in T_Noeud ; Gauche : out Boolean ; Droite : out Boolean) is
        begin
            if Noeud.IndiceCreation < MinimumCreation and Noeud.Destination /= Destination_Defaut then
                -- le noeud est en fait une feuille
                MinimumCreation := Noeud.IndiceCreation;
                CleASupprimer := Cle;
            end if;
            Gauche := True;
            Droite := True;
        end TraiterMinimumCreation;

        procedure LRU is new PourChaque(Traiter => TraiterMinimumConsultation);

        procedure LFU is new PourChaque(Traiter => TraiterMinimumFrequence);

        procedure FIFO is new PourChaque(Traiter => TraiterMinimumCreation);

    begin
        if Cache.Taille >= Cache.Taille_Max then
        -- Supprimer un élément selon la politique de gestion du cache
            case Cache.Politique is
                when LRU =>
                    LRU(Cache.Arbre);
                when LFU =>
                    LFU(Cache.Arbre);
                when FIFO =>
                    FIFO(Cache.Arbre);
            end case;
            if Cache.Taille_Max /= 0 Then
                Supprimer(CleASupprimer, Cache.Arbre);
            end if;
        else
            Cache.Taille := Cache.Taille + 1;
        end if;
        -- Enregistrer l'adresse dans le cache avec la destination et le masque associée
        Cache.IndiceCreation := Cache.IndiceCreation + 1;
        NoeudAEnregistrer := T_Noeud'(Destination, Masque, Cache.consultation, 0, Cache.IndiceCreation);
        if Cache.Taille_Max /= 0 then
            Enregistrer(Adresse, NoeudAEnregistrer, Cache.Arbre);
        end if;
    end Enregistrer;

    procedure Afficher(Cache : in T_Cache ; Ligne : in Integer) is

        -- Affiche le noeud
        --
        -- Paramètres :
        --  Cle : la clé du noeud
        --  Valeur : la valeur du noeud
        --  Gauche : Booleen qui indique si la recherche se poursuit dans le sous-arbre gauche
        --  Droite : Booleen qui indique si la recherche se poursuit dans le sous-arbre droit
        procedure AfficherDestination(Cle : in T_AdresseIP ; Noeud : in T_Noeud ; Gauche : out Boolean ; Droite : out Boolean) is
        begin
            if Noeud.Destination /= Destination_Defaut then
            -- Afficher le contenu du noeud
                AfficherAdresseIP(Cle);
                AfficherAdresseIP(Noeud.Masque);
                Put(To_String(Noeud.Destination));
                New_Line;
            end if;
            Droite := True;
            Gauche := True;
        end AfficherDestination;

        procedure AfficherArbre is new PourChaque(Traiter => AfficherDestination);

    begin
        if Cache.Taille = 0 then
            Put_Line("Le cache est vide");
        else
            Put_Line("cache (ligne " & Integer'Image(Ligne) & ")");
            AfficherArbre(Cache.Arbre);
        end if;
    end Afficher;

    procedure Vider(Cache : in out T_Cache) is
    begin
        Vider(Cache.Arbre);
        Cache.taille := 0;
        Cache.Consultation := 0;
        Cache.Defauts := 0;
    end Vider;

end cache_la;
