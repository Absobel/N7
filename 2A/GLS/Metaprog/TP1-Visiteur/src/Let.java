public class Let implements Expression {
    private String nom;
    private Expression operandegauche;
	private Expression operandedroite;

    public Let(String nom, Expression gauche, Expression droite) {
        this.nom = nom;
        this.operandegauche = gauche;
        this.operandedroite = droite;
    }

    public String getNom() {
        return this.nom;
    }

    public Expression getOperandeGauche() {
        return this.operandegauche;
    }

    public Expression getOperandeDroite() {
        return this.operandedroite;
    }

    public <R> R accepter(VisiteurExpression<R> visiteur) {
        return visiteur.visiterLet(this);
    }
}
