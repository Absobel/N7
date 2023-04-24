with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Integer_Text_IO;   use Ada.Integer_Text_IO;
with Ada.Numerics.Discrete_Random;

procedure Exos_Tableau is

    generic
		Lower_Bound, Upper_Bound : Integer;	-- bounds in which random numbers are generated
		-- { Lower_Bound <= Upper_Bound }
	
	package Alea is
	
		-- Compute a random number in the range Lower_Bound..Upper_Bound.
		--
		-- Notice that Ada advocates the definition of a range type in such a case
		-- to ensure that the type reflects the real possible values.
		procedure Get_Random_Number (Resultat : out Integer);
	
	end Alea;

	
	package body Alea is
	
		subtype Intervalle is Integer range Lower_Bound..Upper_Bound;
	
		package  Generateur_P is
			new Ada.Numerics.Discrete_Random (Intervalle);
		use Generateur_P;
	
		Generateur : Generateur_P.Generator;
	
		procedure Get_Random_Number (Resultat : out Integer) is
		begin
			Resultat := Random (Generateur);
		end Get_Random_Number;
	
	begin
		Reset(Generateur);
	end Alea;

-- Aider l'utilisateur à réviser les tables de multiplication

	package Mon_Alea is
			new Alea (0, 10);  -- générateur de nombre dans l'intervalle [0, 10]
		use Mon_Alea;

    -- TYPES
    MAX_ELEMENTS: constant Integer := 100;
    type T_Elements is array(1..MAX_ELEMENTS) of Integer;
    
    type T_Tableau is record
        Elements: T_Elements;
        Taille: Integer;
    end record;

    -- PROCEDURES

    -- Afficher un tableau
    -- Paramètres :
    --     Tableau - Tableaud d'élements à afficher
    -- Precondition :
    --     La taille du tableau doit être inférieure à la taille maximale d'un tableau
    procedure afficher_tableau(Tableau: in T_Tableau) with
        Pre => Tableau.Taille <= MAX_ELEMENTS
    is
    begin
        Put("[");
        if Tableau.Taille = 0 then
            Put(" ]");
        else
            for index in 1..(Tableau.Taille-1) loop
                Put(Tableau.Elements(index),1);
                Put(", ");
            end loop;
            Put(Tableau.Elements(Tableau.Taille),1);
            Put("]");
        end if;
    end afficher_tableau;

    -- Trier par insertion
    -- Paramètres : 
    --     Tableau : Tableau à modifier
    -- Precondition :
    --     La taille du tableau doit être inférieure à la taille maximale d'un tableau
    procedure tri_insertion(Tableau: in out T_Tableau) with
        Pre => Tableau.Taille <= MAX_ELEMENTS
    is
        index2: Integer;
        aux: Integer;
    begin
        Put("Test");
        for index in 2..Tableau.Taille loop
            index2 := index;
            Put("test");
            while index2 > 1 and Tableau.Elements(index2-1) > Tableau.Elements(index2) loop
                Put(index2);
                aux := Tableau.Elements(index2);
                Tableau.Elements(index2) := Tableau.Elements(index2-1);
                Tableau.Elements(index2-1) := aux;
                index2 := index2 -1;
            end loop;
        end loop;
    end tri_insertion;


    -- VARIABLES
    Element: T_Elements;
    Tableau: T_Tableau;
    TAILLE: constant Integer := 20;
    num2: Integer;
begin
    for num in 1..TAILLE loop
        num2 := TAILLE-num+1;
        Element(num) := num2;
    end loop;
    Tableau.Elements := Element;
    Tableau.Taille := TAILLE;
    afficher_tableau(Tableau);
    New_Line;
    tri_insertion(Tableau);
    afficher_tableau(Tableau);
end Exos_Tableau;
