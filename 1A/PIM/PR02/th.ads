with LCA;

generic
    CAPACITE: Integer;
    type T_Cle is private;
	type T_Donnee is private;
    with function Hashage (Cle: T_Cle) return Integer;
package TH is

	package Lca_Str_Int is new LCA (T_Cle => T_Cle, T_Donnee => T_Donnee);
	use Lca_Str_Int;

    type T_TH is limited private;

    -- Initialiser une TH.  La TH est vide.
	procedure Initialiser(Th: out T_TH) with
		Post => Est_Vide (Th);


	-- Est-ce qu'une TH est vide ?
	function Est_Vide (Th : T_TH) return Boolean;


	-- Obtenir le nombre d'�l�ments d'une TH. 
	function Taille (Th : in T_TH) return Integer with
		Post => Taille'Result >= 0
			and (Taille'Result = 0) = Est_Vide (Th);


	-- Enregistrer une Donn�e associ�e � une Cl� dans une TH.
	-- Si la cl� est d�j� pr�sente dans la Th, sa donn�e est chang�e.
	procedure Enregistrer (Th : in out T_TH ; Cle : in T_Cle ; Donnee : in T_Donnee) with
		Post => Cle_Presente (Th, Cle) and (La_Donnee (Th, Cle) = Donnee)   -- donn�e ins�r�e
				and (not (Cle_Presente (Th, Cle)'Old) or Taille (Th) = Taille (Th)'Old)
				and (Cle_Presente (Th, Cle)'Old or Taille (Th) = Taille (Th)'Old + 1);

	-- Supprimer la Donn�e associ�e � une Cl� dans une TH.
	-- Exception : Cle_Absente_Exception si Cl� n'est pas utilis�e dans la TH
	procedure Supprimer (Th : in out T_TH ; Cle : in T_Cle) with
		Post =>  Taille (Th) = Taille (Th)'Old - 1 -- un �l�ment de moins
			and not Cle_Presente (Th, Cle);         -- la cl� a �t� supprim�e


	-- Savoir si une Cl� est pr�sente dans une TH.
	function Cle_Presente (Th : in T_TH ; Cle : in T_Cle) return Boolean;


	-- Obtenir la donn�e associ�e � une Cle dans la TH.
	-- Exception : Cle_Absente_Exception si Cl� n'est pas utilis�e dans l'TH
	function La_Donnee (Th : in T_TH ; Cle : in T_Cle) return T_Donnee;


	-- Supprimer tous les �l�ments d'une TH.
	procedure Vider (Th : in out T_TH) with
		Post => Est_Vide (Th);


	-- Appliquer un traitement (Traiter) pour chaque couple d'une TH.
	generic
		with procedure Traiter (Cle : in T_Cle; Donnee: in T_Donnee);
	procedure Pour_Chaque (Th : in T_TH);

	generic
		with function Relation_Ordre(Donnee1: in T_Donnee; Donnee2: in T_Donnee) return Boolean;
	function Extremum(Th: in T_TH) return T_Donnee;

private

    type T_TH is array(1..CAPACITE) of T_LCA;

end TH;