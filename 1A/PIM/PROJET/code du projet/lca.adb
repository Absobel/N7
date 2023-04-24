with Ada.Text_IO;            use Ada.Text_IO;
with exceptions;              use exceptions;
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
		Aux : T_LCA := Sda;
		Compteur : Integer := 0;
	begin
		while Aux /= null loop
			Compteur := Compteur + 1;
			Aux := Aux.All.Suivant;
		end loop;
		return Compteur;
	end Taille;


	procedure Ajouter_Fin (Sda : in out T_LCA ; Cle : in T_Cle ; Donnee : in T_Donnee) is
	begin
		if Sda = null then
			Sda := new T_Cellule'(Cle => Cle, Donnee => Donnee, Suivant => null);
		else
			Ajouter_Fin(Sda.All.Suivant, Cle, Donnee);
		end if;
	end Ajouter_Fin;


	procedure Mise_A_Jour (Sda : in out T_LCA ; Cle : in T_Cle ; Donnee : in T_Donnee) is
	begin
		if Sda = null then
			raise Cle_Absente_Exception;
		elsif Sda.All.Cle = Cle then
			Sda.All.Donnee := Donnee;
		else
			Mise_A_Jour(Sda.All.Suivant, Cle, Donnee);
		end if;
	end Mise_A_Jour;


	function Cle_Presente (Sda : in T_LCA ; Cle : in T_Cle) return Boolean is
	begin
		if Sda = null then
			return False;
		elsif Sda.All.Cle = Cle then
			return True;
		else
			return Cle_Presente(Sda.All.Suivant, Cle);
		end if;
	end;


	function La_Donnee (Sda : in T_LCA ; Cle : in T_Cle) return T_Donnee is
	begin
		if Sda = null then
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
		if Sda = null then
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
		if Sda = null then
			Free(Sda);
		else
			Vider(Sda.All.Suivant);
		end if;
		Free(Sda);
	end Vider;


	procedure Supprimer_Tete (Sda : in out T_LCA) is
		Aux : T_LCA := Sda;
	begin
		if Sda = null then
			raise Liste_Vide_Exception;
		else
			Sda := Sda.All.Suivant;
			Free(Aux);
		end if;
	end Supprimer_Tete;


	procedure Element_Index (Sda : in T_LCA; Index : in Integer; Cle : out T_Cle; Donnee : out T_Donnee) is
		Aux : T_LCA := Sda;
		Compteur : Integer := 0;
	begin
		while Compteur < Index loop
			Aux := Aux.All.Suivant;
			Compteur := Compteur + 1;
		end loop;

		Cle := Aux.All.Cle;
		Donnee := Aux.All.Donnee;
	end Element_Index;


	procedure Pour_Chaque (Sda : in T_LCA) is
		Aux: T_LCA := Sda;
	begin
		while Aux /= null loop
			begin
				Traiter(Aux.All.Cle, Aux.All.Donnee);
			exception
				when others => Put_Line("Erreur de traitement d'une clé et de la donnée associée.");
			end;
			Aux := Aux.All.Suivant;
		end loop;
	end Pour_Chaque;

end LCA;
