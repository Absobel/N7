with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with Ada.Strings;               use Ada.Strings;

generic

     Taille : Integer;

package ligne_de_commande is

    type T_Tableau_Arguments is array (1 .. Taille) of Unbounded_String;

    -- Affiche comment s'utilise le programme dans le terminal
    procedure Usage;


    -- Initialise les différentes constantes du cache avec la ligne de commande
    --
    -- Paramètres :
    --   Argument : tableau contenant les arguments de la ligne de commande
    --   Argument_Count : nombre d'arguments de la ligne de commande
    --   Cache_Size : taille maximale du cache
    --   Policy : politique de gestion du cache (LRU, LFU ou FIFO)
    --   Stat : Indique si l'on affiche les statistiques du cache en fin de programme
    --   Table_File : nom du fichier contenant la table de routage
    --   Packet_File : nom du fichier contenant les paquets à traiter
    --   Result_File : nom du fichier dans lequel on écrit les résultats
    procedure Argument_Parsing(
        Argument : T_Tableau_Arguments;
        Argument_Count : in Integer;
        Cache_Size :     out Integer;
        Policy :         out Unbounded_String;
        Stat :           out Boolean;
        Table_File :     out Unbounded_String;
        Packet_File :    out Unbounded_String;
        Result_File :    out Unbounded_String);


end ligne_de_commande;
