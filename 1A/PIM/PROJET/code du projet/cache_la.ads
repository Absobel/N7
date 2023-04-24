with adresseip; use adresseip;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with arbre;

Generic
    Destination_Defaut : unbounded_string;
package cache_la is

    type T_Politique is (LRU, FIFO, LFU);

    type T_Noeud is limited private;

    type T_Cache is limited private;

    -- Initialise le cache avec une taille maximale et une politique
    --
    -- Paramètres :
    --  TailleMax : la taille maximale du cache
    --  Politique : la politique de gestion du cache
    --  Cache : le cache à initialiser
    procedure Initialiser(cache: in out T_Cache ; Taille_Max : in Integer ; Politique : in T_Politique);

    -- Affiche les statistiques du cache (Taille, nombre de consultations, taux de défauts)
    --
    -- Paramètres :
    -- Cache : le cache dont on doit afficher les statistiques
    Procedure Statistiques(cache : in T_Cache ; Ligne : in Integer);

    -- Lit une destination dans le cache et indique si le chemin existe dans l'arbre
    --
    -- Paramètres :
    --  Cache : le cache
    --  Adresse : l'adresse IP à rechercher
    --  Destination : la destination associée à l'adresse IP recherchée ("Erreur" si elle n'existe pas)
    --  A_trouve : indique si l'adresse IP a été trouvée dans le cache
    procedure Lire(cache : in out T_Cache ; Adresse : in T_AdresseIP ; Destination : out Unbounded_String ; A_Trouve : out Boolean);

    -- Ajoute une destination (avec son masque) dans le cache
    --
    -- Paramètres :
    --  Cache : le cache
    --  Adresse : l'adresse IP à ajouter
    --  Masque : le masque associé à l'adresse IP
    --  Destination : la destination associée à l'adresse IP
    procedure Enregistrer(Cache : in out T_Cache ; Adresse : in T_AdresseIP ; Masque : in T_AdresseIP ; Destination : in Unbounded_String);

    -- Affiche le contenu du cache
    --
    -- Paramètres :
    -- Cache : le cache à afficher
    -- Ligne : le numéro de la ligne d'appel dans le fichier de paquetage
    procedure Afficher(Cache : in T_Cache ; Ligne : in Integer);

    -- Vide l'arbre
    --
    -- Paramètres :
    -- Cache : le cache à vider
    procedure Vider(Cache : in out T_Cache);

private


    type T_Noeud is record
        Destination : unbounded_string;
        Masque : T_AdresseIP;
        DerniereConsultation : Integer; -- Indique quand le noeud a été consulté pour la dernière fois
        NombreConsultation : Integer; -- Indique le nombre de fois où le noeud a été consulté
        IndiceCreation : Integer; -- Indique l'indice de création du noeud (le "numéro" du noeud)
    end record;

    package arbre_cache is new arbre (T_Noeud, (Destination_Defaut,0 , 0, 0, 0));
    use arbre_cache;

    type T_Cache is record
        Arbre : T_LA;
        taille : Integer;
        taille_max : Integer;
        Politique : T_Politique;
        Consultation : Integer;     -- Nombre de demande de routage
        IndiceCreation : Integer;   -- Nombre de noeuds créés
        Defauts : Integer;          -- Nombre de défauts de cache
    end record;

end cache_la;
