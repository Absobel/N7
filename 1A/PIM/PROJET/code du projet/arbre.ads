with adresseip; use adresseip;

generic
    type T_Valeur is private;
    ValeurParDefaut : T_Valeur;
package arbre is

   type T_LA is limited private;


    Procedure Initialiser (arbre : in out T_LA) with
        post => taille(arbre) = 0;

    -- Obtenir la taille de l'arbre
    -- Paramètres :
        -- arbre : l'arbre dont on veut connaître la taille
    function taille (arbre : in T_LA) return integer;

    -- Permet de savoir si l'arbre est un Noeud
    --
    -- paramètres :
    -- arbre : l'arbre dont on veut savoir si c'est un noeud
    function Est_Feuille (arbre : in T_LA) return boolean;

    -- Lire la valeur d'une feuille de l'arbre
    --
    -- paramètres :
    -- arbre : l'arbre dans lequel on veut lire la valeur
    -- Cle : la clé de la feuille dont on veut lire la valeur
    -- Valeur : la valeur de la feuille lue
    -- Cle_Lue : la clé de la feuille lue (pas toujour la même que Cle)
    procedure Lire(Arbre : in T_LA ; Cle : in T_adresseIP ; valeur : out T_Valeur ; Cle_Lue : out T_AdresseIP);

    -- Supprime un élément à partir de sa clé
    --
    -- paramètres :
        -- arbre : l'arbre dans lequel on veut supprimer l'élément
        -- cle : la clé de l'élément à supprimer
    Procedure Supprimer (Cle : in T_AdresseIP ; Arbre : in out T_LA);

    --Enregistrer une cle dans l'arbre.
    --
    --Paramètres :
        -- cle : la clé à enregistrer
        -- valeur : la valeur associée à la clé à enregistrer
        -- arbre : l'arbre dans lequel on veut enregistrer la clé
    Procedure Enregistrer (Cle : in T_AdresseIP ; Valeur : in T_Valeur ; Arbre : in out T_LA);


    -- Vider l'arbre.
    --
    -- Paramètres :
        -- arbre : l'arbre à vider
    procedure Vider (arbre : in out T_LA);

    -- Applique Traiter à chaque noeud de l'arbre.
    -- Paramètres :
        -- arbre : l'arbre à parcourir
        -- Traiter : la procédure à appliquer à chaque noeud
    generic
        with procedure Traiter(Cle: in T_AdresseIP ; Valeur: in T_Valeur; Gauche : out Boolean; Droite : out Boolean);
    procedure PourChaque(Arbre : in T_LA);


private

 type T_Noeud;

 type T_LA is access T_Noeud;

 type T_Noeud is
    record
        Cle : T_AdresseIP ;
        Valeur: T_Valeur;
        Gauche : T_LA ;   -- fils gauche.
        Droite : T_LA ;  -- fils droit
 end record;

end arbre;
