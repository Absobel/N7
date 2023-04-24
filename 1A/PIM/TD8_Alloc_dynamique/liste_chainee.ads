generic
    type T_Element is private;
package Liste_Chainee is

    type T_Liste is private;

    type T_Cellule is record
        Element : T_Element;
        Suivante : T_Liste;
    end record;

    Liste_Vide_Exception : exception;
    Element_Absent_Erreur : exception;


    procedure Initialiser(Liste : out T_Liste) with
        Post => Taille(Liste) = 0;

    procedure Ajouter(Liste : in out T_Liste; Element : in T_Element) with
        Post => Taille(Liste) > 0 and Premier(Liste) = Element;

    function Taille(Liste: in T_Liste) return Integer with
        Post => Taille'Result >= 0;

    generic
        with procedure Afficher_Element(Element: in T_Element);
    procedure Afficher(Liste: in T_Liste);
    
    procedure Supprimer(Liste: in out T_Liste; Element: in T_Element);

    procedure Inserer_Apres(Liste: in out T_Liste; Element_A_Inserer : in T_Element; Element_Apres: in T_Element);

private
    type T_Liste is access T_Cellule;
end Liste_Chainee;