with Ada.Text_IO;          use Ada.Text_IO;
with Ada.Integer_Text_IO;  use Ada.Integer_Text_IO;

-- Objectif : Comprendre le comportement de Get et Skip_Line.

-- Saisir une longueur (valeur et unitÃ©) et l'afficher.
procedure Comprendre_Get_Skip_Line is
	Valeur: Integer;	-- la valeur du longeur
	Unite: Character;	-- l'unitÃ© de la longueur : (c)entimÃ¨tre, (m)Ã¨tre...
begin
	-- saisir la longueur
	Put("Longueur = ");
	Get(Valeur);
	Skip_Line;
	Get(Unite);
	Skip_Line;

	-- afficher la longueur
	Put("Valeur = ");
	Put(Valeur, 1);
	New_Line;
	Put_Line("UnitÃ© = >" & Unite & "<");

	-- afficher les caractÃ¨res en attente sur l'entrÃ©e standard (fin de ligne)
	-- Put_Line("Reste de la derniÃ¨re ligne saisie : " & '"' & Get_Line & '"');
end Comprendre_Get_Skip_Line;

