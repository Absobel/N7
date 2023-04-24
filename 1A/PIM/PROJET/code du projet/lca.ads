
-- D�finition de structures de donn�es associatives sous forme d'une liste
-- cha�n�e associative (LCA).
generic
	type T_Cle is private;
	type T_Donnee is private;

package LCA is

	type T_LCA is limited private;


	-- Initialiser une Sda.  La Sda est vide.
	procedure Initialiser(Sda: out T_LCA) with
		Post => Est_Vide (Sda);


	-- Est-ce qu'une Sda est vide ?
	function Est_Vide (Sda : T_LCA) return Boolean;


	-- Obtenir le nombre d'�l�ments d'une Sda.
	function Taille (Sda : in T_LCA) return Integer with
		Post => Taille'Result >= 0
			and (Taille'Result = 0) = Est_Vide (Sda);


	-- Enregistrer une Donn�e associ�e � une Cl� à la fin d'une Sda.
	procedure Ajouter_Fin (Sda : in out T_LCA ; Cle : in T_Cle ; Donnee : in T_Donnee) with
		Post => Taille (Sda) = Taille (Sda)'Old + 1; -- un �l�ment de plus

	-- Mise � jour de la donn�e associ�e � une Cl� dans une Sda.
	-- Exception : Cle_Absente_Exception si Cl� n'est pas utilis�e dans la Sda
	procedure Mise_A_Jour (Sda : in out T_LCA ; Cle : in T_Cle ; Donnee : in T_Donnee) with
		Post => La_Donnee (Sda, Cle) = Donnee
			and Taille (Sda) = Taille (Sda)'Old; -- pas de changement de taille

	-- Supprimer la Donn�e associ�e � une Cl� dans une Sda.
	-- Exception : Cle_Absente_Exception si Cl� n'est pas utilis�e dans la Sda
	procedure Supprimer (Sda : in out T_LCA ; Cle : in T_Cle) with
		Post =>  Taille (Sda) = Taille (Sda)'Old - 1 -- un �l�ment de moins
			and not Cle_Presente (Sda, Cle);         -- la cl� a �t� supprim�e


	-- Savoir si une Cl� est pr�sente dans une Sda.
	function Cle_Presente (Sda : in T_LCA ; Cle : in T_Cle) return Boolean;


	-- Obtenir la donn�e associ�e � une Cle dans la Sda.
	-- Exception : Cle_Absente_Exception si Cl� n'est pas utilis�e dans l'Sda
	function La_Donnee (Sda : in T_LCA ; Cle : in T_Cle) return T_Donnee;


	-- Supprimer tous les �l�ments d'une Sda.
	procedure Vider (Sda : in out T_LCA) with
		Post => Est_Vide (Sda);


	-- Supprimer tête de liste
	procedure Supprimer_Tete (Sda : in out T_LCA) with
		Post =>  Taille (Sda) = Taille (Sda)'Old - 1; -- un �l�ment de moins

	procedure Element_Index (Sda : in T_LCA; Index : in Integer; Cle : out T_Cle; Donnee : out T_Donnee) with
		Post => Cle_Presente (Sda, Cle) and La_Donnee (Sda, Cle) = Donnee;


	-- Appliquer un traitement (Traiter) pour chaque couple d'une Sda.
	generic
		with procedure Traiter (Cle : in T_Cle; Donnee: in T_Donnee);
	procedure Pour_Chaque (Sda : in T_LCA);

private

	type T_Cellule;

	type T_LCA is access T_Cellule;

	type T_Cellule is
		record
			Cle : T_Cle;
			Donnee : T_Donnee;
			Suivant : T_LCA;
		end record;

end LCA;
