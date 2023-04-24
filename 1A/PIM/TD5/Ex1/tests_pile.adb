with Pile;
with Ada.Text_IO; use Ada.Text_IO;

-- programme de test
procedure Tests_Pile is
    
    package Pile_Char is new Pile(Capacite => 20, Type_Element => Character);
    use Pile_Char;

    procedure Afficher_Pile is new Afficher(Afficher_Element => Put);

    Une_Pile: T_Pile;
begin
    -- Initialiser pile
    Initialiser(Une_Pile);

    -- Test empiler
    Empiler(Une_Pile, 'o');
    Empiler(Une_Pile, 'k');
    Empiler(Une_Pile, '?');

    -- Verifier sommet
    pragma Assert(Sommet(Une_Pile) = '?');

    Afficher_Pile(Une_Pile);

    -- Depiler jusqu'à ce que ce la pile soit vide
    for i in 1..3 loop
        Depiler(Une_Pile);
    end loop;

    -- Vérifier que la pile est vide
    pragma Assert(Est_Vide(Une_Pile));

end Tests_Pile;