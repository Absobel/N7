with Text_IO;
use Text_IO;
with Ada.Integer_Text_IO;
use Ada.Integer_Text_IO;

-- Afficher le plus petit et le plus grand Ã©lÃ©ment d'une sÃ©rie d'entiers
-- naturels lus au clavier.  La saisie de la sÃ©rie se termine par 0
-- (qui n'appartient pas Ã  la sÃ©rie).
-- Exemple : 2, 9, 3, 6, 3, 0 -> min = 2 et max = 9
procedure Min_Max_Serie is
	Entier: Integer;	-- un entier lu au clavier
	Min, Max: Integer;	-- le plus petit et le plus grand Ã©lÃ©ment de la sÃ©rie

begin
	-- Afficher la consigne
	Put("Saisir les valeurs de la sÃ©rie (0 pour terminer) : ");

	-- Saisir un premier entier
	Get(Entier);

	if Entier = 0 then --{ entier n'est pas une valeur de la sÃ©rie }
		Put_Line("Pas de valeurs dans la sÃ©rie");
	else   --{ Entier est le premier Ã©lÃ©ment de la sÃ©rie }
		-- initialiser Min et Max avec le premier entier
		Min := Entier;
		Max := Entier;

		-- traiter les autres Ã©lÃ©ments de la sÃ©rie
		Get(Entier);   -- saisir un nouvel entier
		while Entier /= 0 loop      -- Entier est une valeur de la sÃ©rie
			-- mettre Ã  jour le Min et le Max
			if Entier > Max then   -- nouveau max
				-- mettre Ã  jour le max avec Entier
				Max := Entier;
			elsif Entier < Min then  -- nouveau Min
				-- mettre Ã  jour le min avec Entier
				Min := Entier;
			else
				null;
			end if;

			-- saisir un nouvel entier
			Get(Entier);
		end loop;

		-- afficher le min et le max de la sÃ©rie
		Put("Min = ");
		Put(Min, 1);
		New_Line;

		Put("Max = ");
		Put(Max, 1);
		New_Line;
	end if;
end Min_Max_Serie;

