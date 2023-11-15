import java.util.HashMap;

public class EvaluateurExpression implements VisiteurExpression<Integer> {
    private HashMap<String, Integer> environnement;

    private Integer tempOperandeGauche;
    private Integer tempOperandeDroite;
    private Integer tempOperandeUnique;

    public EvaluateurExpression(HashMap<String, Integer> environnement) {
        this.environnement = environnement;
    }
    
    public Integer visiterAccesVariable(AccesVariable v) {
        return this.environnement.get(v.getNom());
    }

    public Integer visiterConstante(Constante c) {
        return c.getValeur();
    }

    public Integer visiterExpressionBinaire(ExpressionBinaire e) {
        Integer tempGauche = e.getOperandeGauche().accepter(this);
        Integer tempDroite = e.getOperandeDroite().accepter(this);
        this.tempOperandeGauche = tempGauche;
        this.tempOperandeDroite = tempDroite;
        return e.getOperateur().accepter(this);
    }

    public Integer visiterAddition(Addition a) {
        return this.tempOperandeGauche + this.tempOperandeDroite;
    }

    public Integer visiterMultiplication(Multiplication m) {
        return this.tempOperandeGauche * this.tempOperandeDroite;
    }

    public Integer visiterExpressionUnaire(ExpressionUnaire e) {
        Integer tempUnique = e.getOperande().accepter(this);
        this.tempOperandeUnique = tempUnique;
        return e.getOperateur().accepter(this);
    }

    public Integer visiterNegation(Negation n) {
        return -this.tempOperandeUnique;
    }

    public Integer visiterSoustraction(Soustraction s) {
        return this.tempOperandeGauche - this.tempOperandeDroite;
    }

    public Integer visiterLet(Let l) {
        this.environnement.put(l.getNom(), l.getOperandeGauche().accepter(this));
        return l.getOperandeDroite().accepter(this);
    }
}
