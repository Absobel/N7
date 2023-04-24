with Ada.Text_IO;      use Ada.Text_IO;

package adresseIP is

    Type T_AdresseIP is mod 2**32;

    -- But : Afficher une adresse IP dans le terminal sous le format XXX.XXX.XXX.XXX
    --
    -- Paramètres :
    -- adresse : adresse IP à afficher
    procedure AfficherAdresseIP (adresse : in T_AdresseIP);

    -- But : Enregistrer une adresse IP dans un fichier
    --
    -- Paramètres :
    -- adresse : adresse IP à enregistrer
    -- fichier : fichier dans lequel enregistrer l'adresse IP
    procedure EnregistrerAdresse (Fichier : in out File_Type; adresse : in T_AdresseIP);

    -- But : Transformer une adresse IP littérale (XXX.XXX.XXX.XXX) en T_AdresseIP (un entier modulo 2**32)
    --
    -- Paramètres :
    -- adresse : adresse IP littérale à transformer
    --
    -- Remarque : Si l'adresse IP littérale n'est pas valide, la fonction soulève une ErreurFormat.
    function TransformerAdresseIP (Fichier : in out File_Type) return T_AdresseIP;

end adresseIP;
