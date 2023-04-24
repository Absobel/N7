with Ada.Unchecked_Deallocation;
with exceptions; use exceptions;

package body arbre is

    procedure Free is
        new Ada.Unchecked_Deallocation(Object => T_Noeud, Name => T_LA);

    procedure Initialiser(Arbre : in out T_LA) is
    begin
        arbre := null;
    end Initialiser;

    function Taille(Arbre : in T_LA) return Integer is
    begin
        if Arbre = null then
            -- L'arbre est vide
            return 0;
        else
            -- l'arbre a au moins un enfant
            return 1 + Taille(Arbre.All.Gauche) + Taille(Arbre.All.Droite);
        end if;
    end Taille;

    function Est_Feuille(Arbre : in T_LA) return Boolean is
    begin
        return Arbre /= null and then Arbre.All.Gauche = null and then Arbre.All.Droite = null;
    end Est_Feuille;

    procedure Lire(Arbre : in T_LA ; Cle : in T_AdresseIP ; Valeur : out T_Valeur ; Cle_Lue : out T_AdresseIP) is

        procedure LireRecursif(Arbre : in T_LA ; Cle : in T_AdresseIP ; Profondeur : in Integer ; Valeur : out T_Valeur ; Cle_Lue : out T_AdresseIP) is
            Bit : T_AdresseIP;
        begin
            Bit := (Cle / 2**(31-Profondeur)) mod 2;
        if Arbre = null then
            -- L'arbre est vide
            raise Cle_Absente_Exception;
        elsif Est_Feuille(Arbre) then
            -- La clé est trouvée
            Valeur := Arbre.All.Valeur;
            Cle_Lue := Arbre.All.Cle;
        else
            if Bit = 0 then
                LireRecursif(Arbre.All.Gauche, Cle, Profondeur+1, Valeur, Cle_Lue);
            else
                LireRecursif(Arbre.All.Droite, Cle, Profondeur+1, Valeur, Cle_Lue);
            end if;
        end if;
    end LireRecursif;
    begin
        LireRecursif(Arbre, Cle, 0, Valeur, Cle_Lue);
    end Lire;

    procedure Supprimer(Cle : in T_AdresseIP ; Arbre : in out T_LA) is

        Reequilibrage_Fini : Boolean := False;

        -- Supprime un noeud de l'arbre de manière récursive
        --
        -- Paramètres :
            -- Cle : la clé du noeud à supprimer
            -- Profondeur : la profondeur courante dans l'arbre (ex : à la troisième itération, Profondeur = 3)
            -- Arbre : l'arbre dans lequel on supprime le noeud
        procedure SupprimerRecursif(Cle : in T_AdresseIP; Profondeur : in Integer ; Arbre : in out T_LA) is

            Bit : T_AdresseIP;  -- Bit de poids fort de la clé

        begin

            if Arbre = Null then
                -- Supprimer un noeud dans un arbre vide résulte en une erreur
                raise StructureVideErreur;

            elsif Est_Feuille(Arbre) then
                -- Supprimer la feuille ou soulèver une erreur
                if Arbre.All.Cle = Cle then
                    Free(Arbre);
                else
                    raise Cle_Absente_Exception;
                end if;

            else
            -- Traiter les différents cas
                -- Supprimer le noeud dans un sous-arbre
                Bit := (Cle / 2**(31-Profondeur)) mod 2;
                if Bit = 1 then
                    -- Si le bit de poids fort vaut 1, on va à droite
                    SupprimerRecursif(Cle, Profondeur + 1, Arbre.All.Droite);
                else
                    -- Si le bit de poids fort vaut 0, on va à gauche
                    SupprimerRecursif(Cle, Profondeur + 1, Arbre.All.Gauche);
                end if;

                if not Reequilibrage_Fini Then
                    -- Réajuster l'arbre pour qu'il ait la profondeur la plus petite possible
                    if Arbre.All.Gauche = Null and Arbre.All.Droite = Null then
                        -- Si le noeud n'a pas d'enfants, on le supprime
                        Free(Arbre);
                    elsif Arbre.All.Gauche /= Null and Arbre.All.Droite = Null and Est_Feuille(Arbre.All.Gauche) then
                        -- Si le noeud n'a qu'un enfant, on le remplace par son enfant (gauche)
                        Arbre.All.Valeur := Arbre.All.Gauche.All.Valeur;
                        Arbre.All.Cle := Arbre.All.Gauche.All.Cle;
                        Free(Arbre.All.Gauche);
                    elsif Arbre.All.Gauche = Null and Arbre.All.Droite /= Null and Est_Feuille(Arbre.All.Droite) then
                        -- Si le noeud n'a qu'un enfant, on le remplace par son enfant (droite)
                        Arbre.All.Valeur := Arbre.All.Droite.All.Valeur;
                        Arbre.All.Cle := Arbre.All.Droite.All.Cle;
                        Free(Arbre.All.Droite);
                    else
                        -- Si le noeud a deux enfants, l'arbre est déjà équilibré
                       Reequilibrage_Fini := True;
                    end if;
                else
                    Null;
                end if;
            end if;
        end SupprimerRecursif;

    begin

        SupprimerRecursif(Cle, 0, Arbre);   --la profondeur initiale est nulle

    end Supprimer;

    procedure Enregistrer(Cle : in T_AdresseIP; Valeur : in T_Valeur ; Arbre : in out T_LA) is

        -- Enregistre un noeud dans l'arbre de manière récursive
        --
        -- Paramètres :
            -- Cle : la clé du noeud à enregistrer
            -- Valeur : la valeur du noeud à enregistrer
            -- Profondeur : la profondeur courante dans l'arbre (ex : à la troisième itération, Profondeur = 3)
            -- Arbre : l'arbre dans lequel on enregistre le noeud
        procedure EnregistrerRecursif(Cle : in T_AdresseIP ; Valeur : in T_Valeur ; Profondeur : in Integer ; Arbre : in out T_LA) is

            Bit_Noeud : T_AdresseIP;    -- Bit de poids fort du noeud
            BiT_AdresseIP : T_AdresseIP;    -- Bit de poids fort de l'adresse IP
            ADetruire : T_LA;   -- Noeud à détruire

        begin

            if Arbre = Null then
            -- Si l'arbre est vide, on crée un nouveau noeud
                Arbre := new T_Noeud'(Cle, Valeur, null, null);

            elsif Est_Feuille(Arbre) then
            -- Ajouter la feuille à l'arbre (en le laissant discriminant)
                if Cle = Arbre.All.Cle Then
                    -- Si la clé du noeud à enregistrer est déjà dans l'arbre, on remplace la valeur
                    Arbre.All.Valeur := Valeur;

                else
                    Bit_Noeud := (Arbre.All.Cle / 2**(31-profondeur)) mod 2;

                -- Transformer la feuille en noeud
                    ADetruire := Arbre;
                    Arbre := new T_Noeud'(0, ValeurParDefaut, null, null);

                -- Ajouter une copie de la feuille à gauche ou à droite
                    if Bit_Noeud = 1 then
                        -- Si le bit de poids fort du noeud vaut 1, on ajoute la copie à droite

                        Arbre.All.Droite := New T_Noeud'(ADetruire.All.Cle, ADetruire.All.Valeur, null, null);
                    else
                        -- Si le bit de poids fort du noeud vaut 0, on ajoute la copie à gauche
                        Arbre.All.Gauche := New T_Noeud'(ADetruire.All.Cle, ADetruire.All.Valeur, null, null);
                    end if;

                    Free(ADetruire);
                    EnregistrerRecursif(Cle , Valeur, Profondeur, Arbre);
                end if;

            else
            -- Naviguer dans l'arbre
                BiT_AdresseIP := (Cle / 2**(31-profondeur)) mod 2;
                if BiT_AdresseIP = 1 then
                    -- Si le bit de poids fort vaut 1, on va à droite
                    EnregistrerRecursif(Cle, Valeur, Profondeur + 1, Arbre.All.Droite);
                else
                    -- Si le bit de poids fort vaut 0, on va à gauche
                    EnregistrerRecursif(Cle, Valeur, Profondeur + 1, Arbre.All.Gauche);
                end if;
            end if;

        end EnregistrerRecursif;

    begin

        EnregistrerRecursif(Cle, Valeur, 0, Arbre);

    end Enregistrer;


    procedure Vider(Arbre : in out T_LA) is
    begin
    if Arbre = Null then
            Null;
        else
            Vider(Arbre.All.Gauche);    -- On vide à gauche
            Vider(Arbre.All.Droite);    -- On vide à droite
            Free(Arbre);
        end if;
    end Vider;

    procedure PourChaque(Arbre : in T_LA) is

        Gauche : Boolean := True;   -- Booléen indiquant si l'on va poursuivre le parcours de l'arbre à gauche
        Droite : Boolean := True;   -- Booléen indiquant si l'on va poursuivre le parcours de l'arbre à droite

    begin
        if Arbre = Null Then
            -- Si l'arbre est vide, on ne fait rien
            Null;
        else

            Traiter(Arbre.All.Cle, Arbre.All.Valeur, Gauche, Droite);

            -- Poursuivre à gauche ou à droite selon Gauche et Droite
            If Gauche then
                -- Si Gauche est vrai, on continue le parcours à gauche
                PourChaque(Arbre.All.Gauche);
            end if;
            if Droite then
                -- Si Droite est vrai, on continue le parcours à droite
                PourChaque(Arbre.All.Droite);
            end if;
        end if;

    exception
        when others =>
            -- Si une exception est levée, on continue dans les deux sous-arbres
            PourChaque(Arbre.All.Droite);
            PourChaque(Arbre.All.Gauche);
    end PourChaque;


end arbre;
