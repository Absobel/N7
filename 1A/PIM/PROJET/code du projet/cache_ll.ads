with Ada.Strings;                 use Ada.Strings;
with LCA;
with adresseIP;                   use adresseIP;
with Ada.Strings.Unbounded;       use Ada.Strings.Unbounded;

package Cache_LL is

    type T_Cache is limited private;
    type T_Cellule is limited private;
    type T_Politique is (FIFO, LRU, LFU);

    -- nom : Initialiser
    -- sémentique : Initialise le cache
    -- paramètres :
    --      - Cache : in out - le cache à initialiser
    --      - Taille_Max : in - la taille maximale du cache
    procedure Initialiser (Cache : in out T_Cache; Taille_Max : Integer);

    -- nom : Afficher_Stat
    -- sémentique : Affiche les statistiques du cache
    -- paramètres :
    --      - Cache : in - le cache à afficher
    procedure Afficher_Stat (Cache : in T_Cache);

    -- nom : Afficher
    -- sémentique : Affiche le cache
    -- paramètres :
    --      - Cache : in - le cache à afficher
    --      - Politique : in - la politique de remplacement utilisée
    procedure Afficher (Cache : in T_Cache; Numero_Ligne : Integer);

    -- nom : Lire
    -- sémentique : Cherche une destination dans le cache
    -- paramètres :
    --      - Cache : in out - le cache à utiliser
    --      - Destination : in - la destination à chercher
    --      - Politique : in - la politique de remplacement utilisée
    --      - DestInterface : out - l'interface de destination
    --      - A_Trouve : out - vrai si la destination a été trouvée
    procedure Lire (Cache : in out T_Cache; Destination : in T_AdresseIP; Politique : in T_Politique ; DestInterface : out Unbounded_String; A_Trouve : out Boolean);

    -- nom : Enregistrer
    -- sémentique : Enregistre une destination dans le cache
    -- paramètres :
    --      - Cache : in out - le cache à utiliser
    --      - Destination : in - la destination à enregistrer
    --      - Masque : in - le masque de la destination
    --      - DestInterface : in - l'interface de destination
    --      - Politique : in - la politique de remplacement utilisée
    procedure Enregistrer (Cache : in out T_Cache; Destination : in T_AdresseIP; Masque: in T_AdresseIP; DestInterface : in Unbounded_String; Politique : in T_Politique);
    
    -- nom : Incrementer_Defauts
    -- sémentique : Incrémente le nombre de défauts du cache
    -- paramètres :
    --      - Cache : in out - le cache à utiliser
    procedure Incrementer_Defauts (Cache : in out T_Cache);

    -- nom : Vider
    -- sémentique : Vide le cache
    -- paramètres :
    --      - Cache : in out - le cache à vider
    procedure Vider(Cache : in out T_Cache);

    -- Tests

    -- nom : Taille
    -- sémentique : Retourne la taille du cache
    -- paramètres :
    --      - Cache : in - le cache à utiliser
    function Taille (Cache : in T_Cache) return Integer;

    -- nom : Est_Vide
    -- sémentique : Retourne vrai si le cache est vide
    -- paramètres :
    --      - Cache : in - le cache à utiliser
    function Est_Vide (Cache : in T_Cache) return Boolean;

    -- nom : b_Appels_Destination
    -- sémentique : Retourne le nombre d'appels pour une destination
    -- paramètres :
    --      - Cache : in - le cache à utiliser
    --      - Destination : in - la destination à chercher
    function Nb_Appels_Destination (Cache : in T_Cache; Destination : in T_AdresseIP) return Integer;

private

    type T_Cellule is record
        DestInterface : Unbounded_String;
        Masque : T_AdresseIP;
        Nb_Appels_Adresse : Integer;
    end record;

    package Liste_Adresse_Cellule is new LCA (T_Cle => T_AdresseIP, T_Donnee => T_Cellule);
    use Liste_Adresse_Cellule;

    type T_Cache is record
        Liste : T_LCA;
        Taille_Max : Integer;
        Nb_Appels : Integer;
        Nb_Defauts : Integer;
    end record;

end Cache_LL;