with Ada.Integer_Text_IO;    use Ada.Integer_Text_IO;
with exceptions;           use exceptions;

package body adresseIP is

    procedure AfficherAdresseIP (Adresse : in T_AdresseIP) is
    begin
        for i in 0..2 loop
            -- Afficher l'octet (avec le point)
            Put(Natural (Adresse/256**(3-i) mod 256), 1);
            Put(".");
        end loop;
        -- Afficher l'octet final (sans le point)
        put(Natural (Adresse mod 256), 1);
        Put(" ");
    end AfficherAdresseIP;


    procedure EnregistrerAdresse (Fichier : in out File_Type ; Adresse : in T_AdresseIP) is
    begin
        for i in 0..2 loop
            -- Enregistrer l'octet (avec le point) dans le fichier
            Put(Fichier, Natural (Adresse/256**(3-i) mod 256), 1);
            Put(Fichier, ".");
        end loop;
        -- Enregistrer l'octet final (sans le point) dans le fichier
        put(Fichier, Natural (Adresse mod 256), 1);
        Put(Fichier, " ");
    end EnregistrerAdresse;


    function TransformerAdresseIp(Fichier : in out File_Type) return T_AdresseIP is

        Octet : Integer;    -- Un octet de l'adresse à lire dans le fichier
        Separateur : Character; -- Le caractère qui sépare les octets (ici le point)
        Adresse : T_AdresseIP := 0;

    begin
        for i in 0..3 loop
            Get(Fichier, Octet);    -- Lecture de l'octet
            -- Vérifier que l'octet est bien compris entre 0 et 255
            if Octet < 0 or Octet > 255 then
                raise exceptions.AdresseInvalide;
            end if;
            -- Ajout de l'octet à l'adresse
            Adresse :=  T_AdresseIP(Octet) + Adresse*256;
            -- Enlever le caractère qui sépare les octets
            if i < 3 then
                Get(Fichier, Separateur);
                -- Vérifier que le caractère est bien un point
                if Separateur /= '.' then
                    Put_Line("Erreur de syntaxe dans l'adresse IP");
                    raise ErreurFormat;
                end if;
            end if;
        end loop;
        return Adresse;
    end TransformerAdresseIp;

end adresseIP;
