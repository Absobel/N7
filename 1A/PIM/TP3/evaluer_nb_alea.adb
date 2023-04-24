with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Integer_Text_IO;   use Ada.Integer_Text_IO;
with Ada.Numerics.Discrete_Random;

procedure Evaluer_Nb_Alea is

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






    INTERVALLE_MIN: constant Integer := 1;
    INTERVALLE_MAX: constant Integer := 6;
    package Mon_Alea is
        new Alea (INTERVALLE_MIN, INTERVALLE_MAX);  -- générateur de nombre dans l'intervalle [5, 15]
    use Mon_Alea;

    type Element is record
        Valeur: Integer;
        Occurences: Integer := 1;
    end record;

    Capacite: constant Integer := INTERVALLE_MAX - INTERVALLE_MIN +1;   -- Cette taille est arbitraire
    type T_TableauElements is array (1..Capacite) of Element;

    type T_Tableau is
        record
            Elements: T_TableauElements;
            Taille: Integer;
            -- Invariant: 0 <= Taille and Taille <= Capacite;
        end record;

    -- Objectif : Afficher frequence absolue min et max ainsi que celle théroque
    -- Paramètres : rien
    -- Resultat : afficher fréquence absolue min max et théorique
    procedure evaluer_alea is
        Tab_Nb_Alea: T_Tableau;
        Nombre: Integer;
        TAILLE_ECHANTILLON: constant Integer := 10000;
        Frequence_Theorique: constant Float := Float(TAILLE_ECHANTILLON)/Float(Capacite);
        Taille_Temp: Integer := 0;
        Element_Temp: Element;
        Frequence_Min: Integer;
        Frequence_Max: Integer;
        A_Trouve: Boolean := False;
    begin
        -- Generer et compter tous les nombres aléatoires
        for idx in 1..TAILLE_ECHANTILLON loop
            Get_Random_Number(Nombre);
            -- Si Nombre aléatoire dans Tab_Nb_Alea, incrementer le nombre de fois qu'il est apparu, sinon, l'ajouter dans le tableau
            if Taille_Temp = 0 then
                Taille_Temp := Taille_Temp+1;
                Element_Temp.Valeur := Nombre;
                Tab_Nb_Alea.Elements(Taille_Temp) := Element_Temp;
            else
                for idx2 in 1..Taille_Temp loop
                    if Tab_Nb_Alea.Elements(idx2).Valeur = Nombre then
                        Tab_Nb_Alea.Elements(idx2).Occurences := Tab_Nb_Alea.Elements(idx2).Occurences+1;
                        A_Trouve := True;
                    end if;
                end loop;
                if not A_Trouve then
                    Taille_Temp := Taille_Temp+1;
                    Element_Temp.Valeur := Nombre;
                    Tab_Nb_Alea.Elements(Taille_Temp) := Element_Temp;
                end if;
                A_Trouve := False;
            end if;
        end loop;

        -- Calculer les fréquences absolues
        Frequence_Min := Tab_Nb_Alea.Elements(1).Occurences;
        Frequence_Max := Tab_Nb_Alea.Elements(1).Occurences;
        for idx in 2..Capacite loop
            if Tab_Nb_Alea.Elements(idx).Occurences > Frequence_Max then
                Frequence_Max := Tab_Nb_Alea.Elements(idx).Occurences;
            elsif Tab_Nb_Alea.Elements(idx).Occurences < Frequence_Min then
                Frequence_Min := Tab_Nb_Alea.Elements(idx).Occurences;
            else
                null;
            end if;
        end loop;

        -- Afficher les fréquences
        Put("Intervalle alea : "); Put(INTERVALLE_MIN,1); Put(","); Put(INTERVALLE_MAX,1); New_Line;
        Put("Taille de l'échantillon : "); Put(TAILLE_ECHANTILLON,1); New_Line; New_Line;
        Put("Fréquence minimale : "); Put(Frequence_Min,1); New_Line;
        Put("Fréquence maximale : "); Put(Frequence_Max,1); New_Line;
        Put("Fréquence théorique :"); Put(Float'Image(Frequence_Theorique)); New_Line;
    end evaluer_alea;
begin
    evaluer_alea;
end Evaluer_Nb_Alea;