with Ada.Text_IO;            use Ada.Text_IO;
with Ada.Strings.Unbounded;     use Ada.Strings.Unbounded;
with TH;

procedure Th_sujet is

    CAPACITE : constant Integer := 11;

    function Hashage(Cle: Unbounded_String) return Integer is
    begin
        return Length(Cle) mod CAPACITE + 1;
    end;
    package TH_Str_Int is 
        new TH (CAPACITE => CAPACITE, 
                T_Cle => Unbounded_String, 
                T_Donnee => Integer, 
                Hashage => Hashage);
    use TH_Str_Int;

    TabH : T_TH;

    procedure Afficher(Cle: Unbounded_String; Donnee: Integer) is
    begin
        Put_Line(To_String(Cle) & " : " & Integer'Image(Donnee));
    end;

    procedure Afficher_Th is new Pour_Chaque(Traiter => Afficher);

begin
    Enregistrer(TabH, To_Unbounded_String("un"), 1);
    Enregistrer(TabH, To_Unbounded_String("deux"), 2);
    Enregistrer(TabH, To_Unbounded_String("trois"), 3);
    Enregistrer(TabH, To_Unbounded_String("quatre"), 4);
    Enregistrer(TabH, To_Unbounded_String("cinq"), 5);
    Enregistrer(TabH, To_Unbounded_String("quatre-vingt-dix-neuf"), 99);
    Enregistrer(TabH, To_Unbounded_String("vingt-et-un"), 21);
    Afficher_Th(TabH);
    Vider(TabH);
end;