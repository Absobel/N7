with adresseIP;                 use adresseIP;
with LCA;
with Ada.Text_IO;               use Ada.Text_IO;
with Ada.Strings.Unbounded;     use Ada.Strings.Unbounded;
with Ada.Strings;               use Ada.Strings;

package TableRoutage is

    Type T_Donnee is record
        Masque : T_AdresseIP;
        Destination : Unbounded_String;
    end record;

    package Liste_Table is new LCA (T_AdresseIP, T_Donnee);
    use Liste_Table;

    -- Initialise la table de routage avec les valeur dans le fichier Fichier_Table.
    --
    -- Paramètres :
    --   Fichier_Table : le nom du fichier contenant les valeurs de la table de routage.
    --   Table : la table de routage à initialiser.
    procedure Initialiser_Table(Table : in out T_LCA ; Fichier_Table : in out File_Type);

    -- Afficher la table de routage dans le terminal avec le numéro de la ligne d'appel de la commande.
    --
    -- Paramètres :
    --  Table : la table de routage à afficher.
    --  Numero_Ligne : le numéro de la ligne d'appel de la commande.
    procedure Afficher_Table (Table : T_LCA ; Numero_Ligne : Integer);

    -- Compare une adresse IP à la table et renvoie l'interface associée (masque le plus grand possible)
    --
    -- Paramètres :
    --   Table : la table de routage à utiliser.
    --   Adresse : l'adresse IP à comparer.
    --   Destination : la destination associée à l'adresse IP.
    --   Masque : le masque associé à l'adresse IP.
    procedure Comparer_table(Table : in T_LCA ; Adresse : in T_AdresseIP ; Destination : out Unbounded_String ; Masque : out T_AdresseIP);

    -- Vide la table de routage et la détruit.
    --
    -- Paramètres :
    --  Table : la table de routage à vider.
    procedure Vider_table(Table : in out T_LCA);

end TableRoutage;
