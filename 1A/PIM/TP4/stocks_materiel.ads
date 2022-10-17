
-- Auteur: 
-- Gérer un stock de matériel informatique.

package Stocks_Materiel is


    CAPACITE : constant Integer := 10;      -- nombre maximum de matériels dans un stock

    type T_Nature is (UNITE_CENTRALE, DISQUE, ECRAN, CLAVIER, IMPRIMANTE);
    type T_Etat_Marche is (FONCTIONNE, NE_FONCTIONNE_PAS);

    type T_Materiel is limited private;
    type T_Elements is limited private;
    type T_Stock is limited private;


    -- Créer un stock vide.
    --
    -- paramètres
    --     Stock : le stock à créer
    --
    -- Assure
    --     Nb_Materiels (Stock) = 0
    --
    procedure Creer (Stock : out T_Stock) with
        Post => Nb_Materiels (Stock) = 0;


    -- Obtenir le nombre de matériels dans le stock Stock.
    --
    -- Paramètres
    --    Stock : le stock dont ont veut obtenir la taille
    --
    -- Nécessite
    --     Vrai
    --
    -- Assure
    --     Résultat >= 0 Et Résultat <= CAPACITE
    --
    function Nb_Materiels (Stock: in T_Stock) return Integer with
        Post => Nb_Materiels'Result >= 0 and Nb_Materiels'Result <= CAPACITE;


    -- Enregistrer un nouveau métériel dans le stock.  Il est en
    -- fonctionnement.  Le stock ne doit pas être plein.
    -- 
    -- Paramètres
    --    Stock : le stock à compléter
    --    Numero_Serie : le numéro de série du nouveau matériel
    --    Nature       : la nature du nouveau matériel
    --    Annee_Achat  : l'année d'achat du nouveau matériel
    -- 
    -- Nécessite
    --    Nb_Materiels (Stock) < CAPACITE
    -- 
    -- Assure
    --    Nouveau matériel ajouté
    --    Nb_Materiels (Stock) = Nb_Materiels (Stock)'Avant + 1
    procedure Enregistrer (
            Stock        : in out T_Stock;
            Numero_Serie : in     Integer;
            Nature       : in     T_Nature;
            Annee_Achat  : in     Integer
        ) with
            Pre => Nb_Materiels (Stock) < CAPACITE,
            Post => Nb_Materiels (Stock) = Nb_Materiels (Stock)'Old + 1;


    -- Obtenir le nombre de matériels qui sont hors d’état de fonctionnement.
    --
    -- Paramètres
    --    Stock : le stock dont on veut obtenir le nomnbre de matériels hors d'états de fonctionnement
    --
    -- Nécessite
    --    Vrai
    -- Assure
    --     Résultat >= 0 Et Résultat <= CAPACITE
    --
    function Nb_Materiels_HS(Stock : in T_Stock) return Integer with
        Post => Nb_Materiels_HS'Result >= 0 and Nb_Materiels_HS'Result <= CAPACITE;

    
    -- Mettre à jour l’état d’un matériel enregistrer dans le stock à partir de son numéro de série.
    --
    -- Paramètres
    --    Stock : le Stock contenant le maétriel à modifier
    --    Numero_Serie : numéro de série du matériel à modifier
    --    Nv_Etat_Marche : Nouvel etat de marche du matériel
    --
    -- Nécessite
    --    Vrai
    --
    -- Assure
    --    Vrai
    procedure Materiel_Nv_EdM(Stock : in out T_Stock; Numero_Serie : in Integer; Nv_Etat_Marche : T_Etat_Marche);

    
    -- Supprimer du stock un matériel à partir de son numéro de série.
    --
    -- Paramètres
    --    Stock : le Stock contenant le matériel à supprimer
    --    Numero_Serie : numéro de série du matériel à supprimer
    --
    -- Nécessite
    --    Nb_Materiels(Stock) > 0
    --
    -- Assure
    --    Nb_Materiels (Stock) = Nb_Materiels (Stock)'Avant - 1
    procedure Supprimer_Materiel(Stock : in out T_Stock; Numero_Serie : in Integer) with
        Pre => Nb_Materiels(Stock) > 0,
        Post => Nb_Materiels(Stock) = Nb_Materiels(Stock)'Old -1;
    
    -- Afficher tous les matériels d'un stock.
    -- 
    -- Paramètres
    --    Stock : Stock contenant les matériels à afficher
    --
    -- Nécessite
    --    Vrai
    --
    -- Assure
    --    Vrai
    procedure Afficher_Materiels(Stock: in T_Stock);

    -- Supprimer tous les matériels qui ne sont pas en état de fonctionnement.
    --
    -- Paramètres
    --    Stock : Stock contenant les matériels HS à supprimer
    --
    -- Nécessite
    --    Vrai
    --
    -- Assure
    --    Nb_Materiels(Stock) = Nb_Materiels(Stock)'Avant - Nb_Materiels_HS(Stock)
    procedure Supprimer_HS(Stock: in out T_Stock) with
        Post => Nb_Materiels(Stock) = Nb_Materiels(Stock)'Old - Nb_Materiels_HS(Stock);

private

    type T_Materiel is record
        Num_Serie : Integer;
        Nature : T_Nature;
        Annee_Achat : Integer;
        Etat_Marche : T_Etat_Marche;
    end record;

    type T_Elements is array(1..CAPACITE) of T_Materiel;
    type T_Stock is record
        Elements : T_Elements;
        Taille : Integer;
        -- Invariants
        --    0 <= Taille <= CAPACITE
    end record;

end Stocks_Materiel;
