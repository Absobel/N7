with Piles;

procedure Parenthesage is

    package Piles_Char is new Piles(Capacite => 20, T_Element => Character); use Piles_Char;
    package Piles_Int is new Piles(Capacite => 20, T_Element => Integer); use Piles_Int;

    -- L'indice dans la chaîne Meule de l'élément Aiguille.
    -- Si l'Aiguille n'est pas dans la Meule, on retroune Meule'Last + 1.
    function Index (Meule : in String; Aiguille: Character) return Integer with
        Post => Meule'First <= Index'Result and then Index'Result <= Meule'Last + 1
            and then (Index'Result > Meule'Last or else Meule (Index'Result) = Aiguille)
    is
        Idx: Integer := 0;
    begin
        while Idx <= Meule'Last and Meule(Idx) /= Aiguille loop
            Idx := Idx + 1;
        end loop;
        return Idx;
    end Index;


    -- Programme de test de Index.
    procedure Tester_Index is
        ABCDEF : constant String := "abcdef";
    begin
        pragma Assert (1 = Index (ABCDEF, 'a'));
        pragma Assert (3 = Index (ABCDEF, 'c'));
        pragma Assert (6 = Index (ABCDEF, 'f'));
        pragma Assert (7 = Index (ABCDEF, 'z'));
        pragma Assert (4 = Index (ABCDEF (1..3), 'z'));
        pragma Assert (3 = Index (ABCDEF (3..5), 'c'));
        pragma Assert (5 = Index (ABCDEF (3..5), 'e'));
        pragma Assert (6 = Index (ABCDEF (3..5), 'a'));
        pragma Assert (6 = Index (ABCDEF (3..5), 'g'));
    end;


    -- Vérifier les bon parenthésage d'une Chaîne (D).  Le sous-programme
    -- indique si le parenthésage est bon ou non (Correct : R) et dans le cas
    -- où il n'est pas correct, l'indice (Indice_Erreur : R) du symbole qui
    -- n'est pas appairé (symbole ouvrant ou fermant).
    --
    -- Exemples
    --   "[({})]"  -> Correct
    --   "]"       -> Non Correct et Indice_Erreur = 1
    --   "((()"    -> Non Correct et Indice_Erreur = 2
    --
    procedure Verifier_Parenthesage (Chaine: in String ; Correct : out Boolean ; Indice_Erreur : out Integer) is
        Ouvrants : Constant String := "([{";
        Fermants : Constant String := ")]}";
        Pile_Ouvrants: Piles_Char.T_Pile;
        Pile_Index: Piles_Int.T_Pile;
    begin
        Initialiser(Pile_Ouvrants);
        Initialiser(Pile_Index);
        for idx_char in Chaine'First..Chaine'Last loop                 -- Ne pas utiliser de boucle for parce qu'on doit quitter au premier caractère faux
            for idx_par in 1..3 loop
                if Chaine(idx_char) = Ouvrants(idx_par) then
                    Empiler(Pile_Ouvrants, Chaine(idx_char));
                    Empiler(Pile_Index, idx_char);
                elsif Chaine(idx_char) = Fermants(idx_par) then
                    if not Est_Vide(Pile_Ouvrants) and then Sommet(Pile_Ouvrants) = Ouvrants(idx_par) then
                        Depiler(Pile_Ouvrants);
                        Depiler(Pile_Index);
                    else
                        Correct := False;
                        if not Est_Vide(Pile_Index) then
                            Indice_Erreur := Sommet(Pile_Index);
                        else
                            Indice_Erreur := idx_par;
                        end if;
                    end if;
                else
                    Null;
                end if;
            end loop;
        end loop;
        if Correct and not Est_Vide(Pile_Ouvrants) then
            Correct := False;
            Indice_Erreur := Sommet(Pile_Index);
        else
            Null;
        end if;
    end Verifier_Parenthesage;


    -- Programme de test de Verifier_Parenthesage
    procedure Tester_Verifier_Parenthesage is
        Exemple1 : constant String(1..2) :=  "{}";
        Exemple2 : constant String(11..18) :=  "]{[(X)]}";

        Indice : Integer;   -- Résultat de ... XXX
        Correct : Boolean;
    begin
        Verifier_Parenthesage ("(a < b)", Correct, Indice);
        pragma Assert (Correct);

        Verifier_Parenthesage ("([{a}])", Correct, Indice);
        pragma Assert (Correct);

        Verifier_Parenthesage ("(][{a}])", Correct, Indice);
        pragma Assert (not Correct);
        pragma Assert (Indice = 2);

        Verifier_Parenthesage ("]([{a}])", Correct, Indice);
        pragma Assert (not Correct);
        pragma Assert (Indice = 1);

        Verifier_Parenthesage ("([{}])}", Correct, Indice);
        pragma Assert (not Correct);
        pragma Assert (Indice = 7);

        Verifier_Parenthesage ("([{", Correct, Indice);
        pragma Assert (not Correct);
        pragma Assert (Indice = 3);

        Verifier_Parenthesage ("([{}]", Correct, Indice);
        pragma Assert (not Correct);
        pragma Assert (Indice = 1);

        Verifier_Parenthesage ("", Correct, Indice);
        pragma Assert (Correct);

        Verifier_Parenthesage (Exemple1, Correct, Indice);
        pragma Assert (Correct);

        Verifier_Parenthesage (Exemple2, Correct, Indice);
        pragma Assert (not Correct);
        pragma Assert (Indice = 11);

        Verifier_Parenthesage (Exemple2(12..18), Correct, Indice);
        pragma Assert (Correct);

        Verifier_Parenthesage (Exemple2(12..15), Correct, Indice);
        pragma Assert (not Correct);
        pragma Assert (Indice = 14);
    end Tester_Verifier_Parenthesage;

begin
    Tester_Index;
    Tester_Verifier_Parenthesage;
end Parenthesage;
