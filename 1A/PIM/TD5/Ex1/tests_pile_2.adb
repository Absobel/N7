with Pile;
with Ada.Text_IO; use Ada.Text_IO;

-- programme de test
procedure Tests_Pile_2 is
    
    package Pile_Char is new Pile(Capacite => 20, Type_Element => Integer);
    use Pile_Char;

    procedure Afficher_Pile is new Afficher(Afficher_Element => Put);

    Une_Pile: T_Pile;
begin
    Initialiser(Une_Pile);
    for i in 1..18 loop
        Empiler(Une_Pile, i);
    end loop;
    Afficher_Pile(Une_Pile);
end Tests_Pile_2;