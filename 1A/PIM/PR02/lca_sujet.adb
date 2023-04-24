with Ada.Text_IO;            use Ada.Text_IO;
with Ada.Strings.Unbounded;     use Ada.Strings.Unbounded;
with LCA;

procedure Lca_Sujet is

    package Lca_Str_Int is
        new LCA(T_Cle => Unbounded_String, T_Donnee => Integer);
    use Lca_Str_Int;

    procedure Afficher(Cle: Unbounded_String; Donnee: Integer) is
    begin
        Put_Line(To_String(Cle) & " : " & Integer'Image(Donnee));
    end;

    procedure Afficher_SDA is new Pour_Chaque(Traiter => Afficher);

    Sda: T_LCA;
begin

    Initialiser(Sda);
    Enregistrer(Sda, To_Unbounded_String("un"), 1);
    Enregistrer(Sda, To_Unbounded_String("deux"), 2);
    Put_Line("Avant supression :");Put_Line("Taille : " & Integer'Image(Taille(Sda)));
    Afficher_SDA(Sda);
    Supprimer(Sda, To_Unbounded_String("un"));
    Put_Line("Après supression :"); Afficher_SDA(Sda);
    Vider(Sda);

end Lca_Sujet;