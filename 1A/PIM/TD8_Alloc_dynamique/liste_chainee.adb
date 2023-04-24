with Ada.Text_IO; use Ada.Text_IO;

package body Liste_Chainee is

    procedure Initialisation(Liste : in T_Liste) is
    begin
        Liste := Null;
    end;

    procedure Ajouter(Liste : in out T_Liste; Element : in T_Element) is
    begin
        Liste := new T_Cellule;
        Liste.All.Element := Element;
        Liste.All.Suivante := Liste;
    end;

    function Premier(Liste : in T_Liste) return T_Element is
    begin
        if Liste = Null then
            raise Liste_Vide_Exception;
        else
            return Liste.All.Element;
        end if;
    end;

    function Taille(Liste: in T_Liste) return Integer is
    begin
        if Liste = Null then
            return 0;
        else
            return Taille(Liste.All.Suivante) + 1;
        end if;

        -- ou :
        -- nb_cellules := 0;
        -- courant := Liste;
        -- while courant /= Null loop
        --     nb_cellules := nb_cellules + 1;
        --     courant := courant.all.Suivante;
    end;

    procedure Afficher(Liste : in T_Liste) is
    begin
        if Liste = null then
            Put("__E");
        else
            Put("-->[");
            Afficher_Element(Liste.All.Element);
            Afficher(Liste.all.Suivante);
        end if;
    end;

    procedure Supprimer(Liste: in out T_Liste; Element: in T_Element) is
        A_Detruire : T_Liste;
    begin
        if Liste = Null then
            raise Element_Absent_Erreur;
        elsif Liste.all.Element = Element then
            A_Detruire := Liste;
            Liste := Liste.All.Suivante;
            Free(A_Detruire);
        else
            Supprimer(Liste.All.Suivante, Element);
        end if;
    end;

    procedure Inserer_Apres(Liste: in out T_Liste; Element_A_Inserer : in T_Element; Element_Apres: in T_Element) is
        Courant : T_Liste;
    begin
        Courant := Liste;

        while Courant /= Null and then Courant.all.Element /= Element_Apres loop
            Courant := Courant.all.Suivante;
        end loop;

        if Courant = Null then
            raise Element_Absent_Erreur;
        else
            Courant.all.Suivante = new T_Cellule(Element_A_Inserer, Courant.all.Suivante);
        end if;
    end;

end Liste_Chainee;