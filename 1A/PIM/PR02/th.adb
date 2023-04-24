with Ada.Text_IO;            use Ada.Text_IO;

package body TH is

    procedure Initialiser(Th: out T_TH) is
    begin
        for i in Th'Range loop
            Lca_Str_Int.Initialiser(Th(i));
        end loop;
    end;

    function Est_Vide (Th : T_TH) return Boolean is
        res: Boolean := True;
    begin
        for i in Th'Range loop
            res := res and Lca_Str_Int.Est_Vide(Th(i));
        end loop;
        return res;
    end;

    function Taille (Th : in T_TH) return Integer is
        res: Integer := 0;
    begin
        for i in Th'Range loop
            res := res + Lca_Str_Int.Taille(Th(i));
        end loop;
        return res;
    end;

    procedure Enregistrer (Th : in out T_TH ; Cle : in T_Cle ; Donnee : in T_Donnee) is
    begin
        Lca_Str_Int.Enregistrer(Th(Hashage(Cle)), Cle, Donnee);
    end;

    procedure Supprimer (Th : in out T_TH ; Cle : in T_Cle) is
    begin
        Lca_Str_Int.Supprimer(Th(Hashage(Cle)), Cle);
    end;

    function Cle_Presente (Th : in T_TH ; Cle : in T_Cle) return Boolean is
    begin
        return Lca_Str_Int.Cle_Presente(Th(Hashage(Cle)), Cle);
    end;

    function La_Donnee (Th : in T_TH ; Cle : in T_Cle) return T_Donnee is
    begin
        return Lca_Str_Int.La_Donnee(Th(Hashage(Cle)), Cle);
    end;

    procedure Vider (Th : in out T_TH) is
    begin
        for i in Th'Range loop
            Lca_Str_Int.Vider(Th(i));
        end loop;
    end;

    procedure Pour_Chaque (Th : in T_TH) is
        procedure Lca_Str_Int_Pour_Chaque is new Lca_Str_Int.Pour_Chaque(Traiter => Traiter);
    begin
        for i in Th'Range loop
            if not Est_Vide(Th(i)) then
                Put_Line("-- Hash : " & Integer'Image(i));
            end if;
            Lca_Str_Int_Pour_Chaque(Th(i));
        end loop;
    end;

    function Extremum(Th: T_TH) return T_Donnee is
        function Lca_Extremum is new Lca_Str_Int.Extremum(Relation_Ordre => Relation_Ordre);
        Extrem: T_Donnee;
        bool : Boolean := False;   -- Est à 0 tant que Extrem 
    begin
        for i in 2..CAPACITE loop
            if not Est_Vide(Th(i)) then 
                if bool and then Relation_Ordre(Extrem, Lca_Extremum(Th(i))) then
                    Extrem := Lca_Extremum(Th(i));
                elsif not bool then
                    Extrem := Lca_Extremum(Th(i));
                    bool := True;
                else
                    null;
                end if;
            end if;
        end loop;
        return Extrem;
    end;
end TH;