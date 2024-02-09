package simcity;

import simcity.Ressource.RessourceType;

public class Succes {

    private RessourceType type;
    private double nbr;

    public Succes(RessourceType type, double nbr){
        this.type = type;
        this.nbr = nbr;
    }

    public String toString(){
        switch (this.type) {
            case EAU:
                if (this.nbr <= 10){
                    return "Bienvenue dans le Sahara";
                } else if (this.nbr >= 80){
                    return "Bienvenue dans l'Atlantide";
                }
            case ELECTRICITE:
                if (this.nbr >= 80){
                    return "Comme un ordi dans l'N7";
                } else if (this.nbr <= 10){
                    return "Retour vers le passé";
                }
            case BONHEUR:
                if (this.nbr >= 80){
                    return "Bienvenue dans le monde des bisounours";
                } else if (this.nbr <= 10){
                    return "Plus fun que Gotham City ";
                }
            case ARGENT:
                if (this.nbr >= 1500){
                    return "Riche comme Balkany (attention à la prison)";
                } else if (this.nbr <= 10){
                    return "Comme en Grèce";
                }
            case HABITANTS:
                if (this.nbr >= 80){
                    return "Ville la plus peuplée du jeu ";
                } else if (this.nbr <= 10){
                    return "Bienvenue à Rochefourchat (ville à 1 hab) ";
                }
            default:
                return "beug";
        }
        
    }    

    
}
