with Ada.Text_IO;            use Ada.Text_IO;
with SDA_Exceptions;         use SDA_Exceptions;
with Ada.Unchecked_Deallocation;

package body LCA is

	procedure Free is
		new Ada.Unchecked_Deallocation (Object => T_Cellule, Name => T_LCA);

	procedure Initialiser(Sda: out T_LCA) is
	begin
		Sda := null;
	end Initialiser;


	function Est_Vide (Sda : T_LCA) return Boolean is
	begin
		return Sda = null;
	end;


	function Taille (Sda : in T_LCA) return Integer is
	begin
		if Est_Vide(Sda) then
			return 0;
		else
			return 1+Taille(Sda.All.Suivant);
		end if;
	end Taille;


	procedure Enregistrer (Sda : in out T_LCA ; Cle : in T_Cle ; Donnee : in T_Donnee) is
		Aux: T_LCA := Sda;
		Bool: Boolean := False;
	begin
		loop
			if Est_Vide(Aux) then
				Sda := new T_Cellule'(Cle, Donnee, Sda);
				Bool := True;
			elsif Aux.All.Cle = Cle then
				Aux.All.Donnee := Donnee;
				Bool := True;
			else
				Aux := Aux.All.Suivant;
			end if;
		exit when Bool;
		end loop;
	end Enregistrer;


	function Cle_Presente (Sda : in T_LCA ; Cle : in T_Cle) return Boolean is
	begin
		if Est_Vide(Sda) then
			return False;
		elsif Sda.All.Cle = Cle then
			return True;
		else
			return Cle_Presente(Sda.All.Suivant, Cle);
		end if;
	end;


	function La_Donnee (Sda : in T_LCA ; Cle : in T_Cle) return T_Donnee is              -- programmation défensive ???
	begin
		if Est_Vide(Sda) then
			raise Cle_Absente_Exception;
		elsif Sda.All.Cle = Cle then
			return Sda.All.Donnee;
		else
			return La_Donnee(Sda.All.Suivant, Cle);
		end if;
	end La_Donnee;


	procedure Supprimer (Sda : in out T_LCA ; Cle : in T_Cle) is
		Aux: T_LCA := Sda;
	begin
		if Est_Vide(Sda) then
			raise Cle_Absente_Exception;
		elsif Sda.All.Cle = Cle then
			Sda := Sda.All.Suivant;
			Free(Aux);
		else
			Supprimer(Sda.All.Suivant, Cle);
		end if;
	end Supprimer;


	procedure Vider (Sda : in out T_LCA) is
	begin
		if Est_Vide(Sda) then
			Free(Sda);
		else
			Vider(Sda.All.Suivant);
		end if;
		Free(Sda);
	end Vider;


	procedure Pour_Chaque (Sda : in T_LCA) is
		Aux: T_LCA := Sda;
	begin
		while not Est_Vide(Aux) loop
			begin
				Traiter(Aux.All.Cle, Aux.All.Donnee);
			exception
				when others => Put_Line("Erreur de traitement d'une clé et de la donnée associée.");
			end;
			Aux := Aux.All.Suivant;
		end loop;
	end Pour_Chaque;


end LCA;
