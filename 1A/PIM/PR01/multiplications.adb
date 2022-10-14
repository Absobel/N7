--------------------------------------------------------------------------------
--  Auteur   : Absobel
--  Objectif : Aider l'utilisateur à réviser les tables de multiplication
--------------------------------------------------------------------------------

with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Integer_Text_IO;   use Ada.Integer_Text_IO;
with Ada.Calendar;          use Ada.Calendar;
with Ada.Numerics.Discrete_Random;


procedure Multiplications is


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

	TABLE_MIN: constant Integer := 0;
	TABLE_MAX: constant Integer := 10;
	package Mon_Alea is
			new Alea (TABLE_MIN, TABLE_MAX);  -- générateur de nombre dans l'intervalle [0, 10]
		use Mon_Alea;

-- Variables
	NB_QUESTION: constant Integer := 10;
	A_Reviser: Integer;
	Mult_A_Reviser: Integer;
	Reponse: Integer;
	Nb_Erreur: Integer := 0;
	Caractere: Character;
	Continuer: Boolean;
	Debut: Time;         -- heure de début de l'opération
	Fin: Time;           -- heure de fin de l'opération
	Duree : Duration;    -- durée de l'opération
	Pire_Duree: Float := 0.0;
	Pire_Mult_A_Reviser: Integer;    -- Nombre pour lequelle le temps de réponse a été le plus long
	Duree_Moyenne: Float := 0.0;
	Derniere_Mult: Integer := -1;    -- Variable ayant pour valeur la dernière multiplication donnée
begin
	loop
		-- Demander quelle table de multiplication à réviser
		loop          -- Sert à faire en sorte que A_Reviser soit réellement entre 0 et 10
			Put("Table à réviser (doit être entre 0 et 10) : ");
			Get(A_Reviser);
		exit when A_Reviser <= 10 and A_Reviser >= 0;
		end loop;
		New_Line;

		-- Reviser la table de multiplication
		for Nb_Actuel in 1..NB_QUESTION loop
			loop         -- Empêcher de mettre deux fois de suite la même mutliplication
				Get_Random_Number(Mult_A_Reviser);
			exit when Mult_A_Reviser /= Derniere_Mult;
			end loop;
			Derniere_Mult := Mult_A_Reviser;

			Put("(M");
			Put(Nb_Actuel,1);
			Put(") ");
			Put(A_Reviser,1);
			Put(" x ");
			Put(Mult_A_Reviser,1);
			Put(" ? ");
			New_Line;
			Put(": ");

			Debut := Clock;
			Get(Reponse);
			Fin := Clock;

			-- Calculer la performance temporelle de l'utilisateur
			Duree := Fin - Debut;
			Duree_Moyenne := Duree_Moyenne + Float(Duree);
			if Float(Duree) > Pire_Duree then
				Pire_Duree := Float(Duree);
				Pire_Mult_A_Reviser := Mult_A_Reviser;
			else
				null;
			end if;
			

			-- Valider la réponse
			if Reponse /= A_Reviser*Mult_A_Reviser then
				Put("Mauvaise réponse.");
				Nb_Erreur := Nb_Erreur+1;
			else
				Put("Bravo !");
			end if;
			New_Line;
		end loop;
		Duree_Moyenne := Duree_Moyenne/Float(NB_QUESTION);

		-- Commenter la performance de l'utilisateur
		New_Line;
		case Nb_Erreur is
			when 0 => Put("Aucune erreur. Excellent !");
			when 1..5 => Put(Nb_Erreur,1);
						 Put(" erreurs. Il faut encore travailler la table de ");
						 Put(A_Reviser,1);
						 Put(".");
			when 6..9 => Put("Seulement ");
						 Put(10-Nb_Erreur,1);
						 Put(" bonnes réponses. Il faut apprendre la table de ");
						 Put(A_Reviser);
						 Put(".");
			when 10 => Put("Tout est faux. Volontaire ?");
			when others => null;
		end case;
		New_Line;

		-- Commenter performance temporelle de l'utilisateur
		if Pire_Duree >= Duree_Moyenne+1.0 then
			Put("Des hésitations sur la table de ");
			Put(Pire_Mult_A_Reviser,1);
			Put(" :");
			Put(Float'Image(Pire_Duree));
			Put(" secondes contre");
			Put(Float'Image(Duree_Moyenne));
			Put(" en moyenne. Il faut certainement la réviser.");
			New_Line;
		else
			null;
		end if;

		-- Arrêt de l'utilisateur
		Put("On continue (o/n) ? ");
		Get(Caractere);
		Skip_Line;
		New_Line;
		if Caractere = 'o' then
			Continuer := true;
		else
			Continuer := false;
		end if;

	exit when not Continuer;
	end loop;
end Multiplications;
