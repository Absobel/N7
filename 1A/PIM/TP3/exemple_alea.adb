with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Integer_Text_IO;   use Ada.Integer_Text_IO;
with Ada.Numerics.Discrete_Random;

-- Procédure qui illustre l'utilisation du paquetage Alea.
procedure Exemple_Alea is

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

    package Mon_Alea is
        new Alea (5, 15);  -- générateur de nombre dans l'intervalle [5, 15]
    use Mon_Alea;

    Nombre: Integer;
begin
    -- Afficher 10 nombres aléatoires
    Put_Line ("Quelques nombres aléatoires : ");
    for I in 1..10 loop
        Get_Random_Number (Nombre);
        Put (Nombre);
        New_Line;
    end loop;
end Exemple_Alea;
