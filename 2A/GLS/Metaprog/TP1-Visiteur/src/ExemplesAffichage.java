import java.util.HashMap;

/**
  * Exemples d'affichage d'expressions arithmétiques
  *
  * @author	Xavier Crégut
  * @version	$Revision$
  */

public class ExemplesAffichage {

	static final private OperateurBinaire plus = new Addition();
	static final private OperateurBinaire fois = new Multiplication();
	static final private OperateurUnaire negation = new Negation();
	static final private OperateurBinaire moins = new Soustraction();

	static public Expression expression1() {
		return new ExpressionUnaire(negation,
					new ExpressionBinaire(fois,
						new Constante(2),
						new ExpressionBinaire(plus,
							new Constante(1),
							new AccesVariable("x"))));
	}

	static public Expression expression2() {
		return new ExpressionBinaire(plus,
					new Constante(5),
					new ExpressionBinaire(fois,
							new AccesVariable("x"),
							new Constante(4)));
	}

	static public Expression expression3() {
		return new ExpressionBinaire(moins,
					new ExpressionUnaire(negation,
						new ExpressionBinaire(fois,
							new Constante(3),
							new ExpressionBinaire(plus,
								new AccesVariable("y"),
								new Constante(2)))),
					new AccesVariable("z"));
	}	

	static public Expression expression4() {
		return new Let("x",
					new Constante(5),
					new ExpressionBinaire(fois,
							new AccesVariable("x"),
							new Constante(4)));
	}

	static public HashMap<String, Integer> environnement() {
		HashMap<String, Integer> env = new HashMap<String, Integer>();
		env.put("x", 5);
		env.put("y", 7);
		env.put("z", 2);
		return env;
	}

	public static void main(String[] args) {
		// Visiteurs
		AfficheurInfixe infixe = new AfficheurInfixe();
		AfficheurPostfixe postfixe = new AfficheurPostfixe();
		CalculHauteur hauteur = new CalculHauteur();
		EvaluateurExpression eval = new EvaluateurExpression(environnement());
		
		System.out.println("Expression 1 : ");
		System.out.println("  Infixe : " + expression1().accepter(infixe));
		System.out.println("  Postfixe : " + expression1().accepter(postfixe));
		System.out.println("  Hauteur : " + expression1().accepter(hauteur));
		System.out.println("  Evaluation : " + expression1().accepter(eval));

		System.out.println("Expression 2 : ");
		System.out.println("  Infixe : " + expression2().accepter(infixe));
		System.out.println("  Postfixe : " + expression2().accepter(postfixe));
		System.out.println("  Hauteur : " + expression2().accepter(hauteur));
		System.out.println("  Evaluation : " + expression2().accepter(eval));

		System.out.println("Expression 3 : ");
		System.out.println("  Infixe : " + expression3().accepter(infixe));
		System.out.println("  Postfixe : " + expression3().accepter(postfixe));
		System.out.println("  Hauteur : " + expression3().accepter(hauteur));
		System.out.println("  Evaluation : " + expression3().accepter(eval));

		System.out.println("Expression 4 : ");
		System.out.println("  Infixe : " + expression4().accepter(infixe));
		System.out.println("  Postfixe : " + expression4().accepter(postfixe));
		System.out.println("  Hauteur : " + expression4().accepter(hauteur));
		System.out.println("  Evaluation : " + expression4().accepter(eval));
	}
}

