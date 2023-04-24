with Ada.Text_IO;          use Ada.Text_IO;
with Ada.Integer_Text_IO;  use Ada.Integer_Text_IO;

-- Auteur: 
-- Gérer un stock de matériel informatique.
--
package body Stocks_Materiel is

    procedure Creer (Stock : out T_Stock) is
        Elements_Init : T_Elements;
    begin
        Stock.Elements := Elements_Init;
        Stock.Taille := 0;
    end Creer;


    function Nb_Materiels (Stock: in T_Stock) return Integer is
    begin
        return Stock.Taille;
    end;


    procedure Enregistrer (
            Stock        : in out T_Stock;
            Numero_Serie : in     Integer;
            Nature       : in     T_Nature;
            Annee_Achat  : in     Integer) is
        Materiel : constant T_Materiel := (Numero_Serie,Nature,Annee_Achat, FONCTIONNE);
    begin
        Stock.Taille := Stock.Taille+1;
        Stock.Elements(Stock.Taille) := Materiel;
    end;


    function Nb_Materiels_HS(Stock : in T_Stock) return Integer is
        Result : Integer := 0;
    begin
        for i in 1..Stock.Taille loop
            if Stock.Elements(i).Etat_Marche = NE_FONCTIONNE_PAS then
                Result := Result+1;
            else
                null;
            end if;
        end loop;

        return Result;
    end;


    procedure Materiel_Nv_EdM(Stock : in out T_Stock; Numero_Serie : in Integer; Nv_Etat_Marche : T_Etat_Marche) is
    begin
        for i in 1..Stock.Taille loop
            if Stock.Elements(i).Num_Serie = Numero_Serie then
                Stock.Elements(i).Etat_Marche := Nv_Etat_Marche;
            else
                null;
            end if;
        end loop;
    end;

    procedure Supprimer_Materiel(Stock : in out T_Stock; Numero_Serie : in Integer) is
        Idx_Suppr : Integer := CAPACITE+1;
    begin
        for i in 1..Stock.Taille loop
            -- Recherchde de l'indice du matériel supprimé
            if Stock.Elements(i).Num_Serie = Numero_Serie then
                Idx_Suppr := i;
            else
                null;
            end if;

            -- Décale tous les matériaux un cran avant dans le tableau du Stock
            if i >= Idx_Suppr then
                Stock.Elements(i) := Stock.Elements(i+1);
            else
                null;
            end if;
        end loop;
        Stock.Taille := Stock.Taille - 1;
    end;


    procedure Afficher_Materiels(Stock: in T_Stock) is
    begin
        Put("Stock :"); New_Line;
        New_Line;
        for i in 1..Stock.Taille loop
            Put("Matériel "); Put(i); Put(" :"); New_Line;
            Put("   Numéro de série : "); Put(Stock.Elements(i).Num_Serie); New_Line;
            Put("   Nature : "); Put(T_Nature'Image(Stock.Elements(i).Nature)); New_Line;
            Put("   Année d'achat : "); Put(Stock.Elements(i).Annee_Achat);
            Put("   État de marche : "); Put(T_Etat_Marche'Image(Stock.Elements(i).Etat_Marche)); New_Line;
            New_Line;
        end loop;
    end;

    procedure Supprimer_HS(Stock: in out T_Stock) is
        Nb_Suppr : Integer := 0;
    begin
        for i in 1..Stock.Taille loop
            if i <= i - Nb_Suppr then
                if Stock.Elements(i).Etat_Marche = NE_FONCTIONNE_PAS then
                    Nb_Suppr := Nb_Suppr + 1;
                else
                    null;
                end if;
                -- Déplace les Materiels pour remplir la place de ceux supprimés
                for j in 1..Nb_Suppr loop
                    Stock.Elements(i+1) := Stock.Elements(i+1+Nb_Suppr);
                end loop;
            else
                null;
            end if;
        end loop;
        Stock.Taille := Stock.Taille - Nb_Suppr;
    end;

end Stocks_Materiel;
