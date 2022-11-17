with Ada.Text_IO;            use Ada.Text_IO;
with LCA;

package body TH is
    package LCA is new LCA(T_Cle => T_Cle, T_Donnee => T_Donnee);

    procedure Initialiser(Th: out T_TH) is
    begin
        for i in Th'Range loop
            LCA.Initialiser(Th(i));
        end loop;
    end;

    function Est_Vide (Th : T_TH) return Boolean is
        res: Boolean := True;
    begin
        for i in Th'Range loop
            res := res and LCA.Est_Vide(Th(i));
        end loop;
        return res;
    end;

    function Taille (Th : in T_TH) return Integer is
        res: Integer := 0;
    begin
        for i in Th'Range loop
            res := res + LCA.Taille(Th(i));
        end loop;
        return res;
    end;

    procedure Enregistrer (Th : in out T_TH ; Cle : in T_Cle ; Donnee : in T_Donnee) is
    begin
        LCA.Enregistrer(Th(Hashage(Cle)), Cle, Donnee);
    end;

    procedure Supprimer (Th : in out T_TH ; Cle : in T_Cle) is
    begin
        LCA.Supprimer(Th(Hashage(Cle)), Cle);
    end;

    function La_Donnee (Th : in T_TH ; Cle : in T_Cle) return T_Donnee is
    begin
        return LCA.La_Donnee(Th(Hashage(Cle)), Cle);
    end;

    procedure Vider (Th : in out T_TH) is
    begin
        for i in Th'Range loop
            LCA.Vider(Th(i));
        end loop;
    end;

    procedure Pour_Chaque (Th : in T_TH) is
        procedure LCA_Pour_Chaque is new LCA.Pour_Chaque(Traiter => Traiter);
    begin
        for i in Th'Range loop
            Put_Line("Hash : " & Integer'Image(i));
            LCA_Pour_Chaque(Th(i));
        end loop;
    end;
end TH;