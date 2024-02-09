/** Tester le polymorphisme (principe de substitution) et la liaison
 * dynamique.
 * @author	Xavier Crégut
 * @version	1.5
 */
public class TestPolymorphisme {

	/** Méthode principale */
	public static void main(String[] args) {
		// Créer et afficher un point p1
		Point p1 = new Point(3, 4);	// Est-ce autorisé ? Pourquoi ? oui , il y a aucune ambiguïté
		p1.translater(10,10);		// Quel est le translater exécuté ? Celui de la classe Point
		System.out.print("p1 = "); p1.afficher (); System.out.println ();
										// Qu'est ce qui est affiché ? (13, 14)

		// Créer et afficher un point nommé pn1
		PointNomme pn1 = new PointNomme (30, 40, "PN1");
										// Est-ce autorisé ? Pourquoi ? Oui, pas d'ambiguïté
		pn1.translater (10,10);		// Quel est le translater exécuté ? Celui de la classe point
		System.out.print ("pn1 = "); pn1.afficher(); System.out.println ();
										// Qu'est ce qui est affiché ? "PN1 :\n(30, 40)"

		// Définir une poignée sur un point
		Point q;

		// Attacher un point à q et l'afficher
		q = p1;				// Est-ce autorisé ? Pourquoi ? oui comportement normal
		System.out.println ("> q = p1;");
		System.out.print ("q = "); q.afficher(); System.out.println ();
										// Qu'est ce qui est affiché ? (13, 14)

		// Attacher un point nommé à q et l'afficher
		q = pn1;			// Est-ce autorisé ? Pourquoi ? PointNomme sous classe de Point
		System.out.println ("> q = pn1;");
		System.out.print ("q = "); q.afficher(); System.out.println ();
										// Qu'est ce qui est affiché ? Pareil que pn1

		// Définir une poignée sur un point nommé
		PointNomme qn;

/* 		// Attacher un point à q et l'afficher
		qn = p1;			// Est-ce autorisé ? Pourquoi ? Parce que p1 n'est pas un PointNomme ou une sous classe de PointNomme
		System.out.println ("> qn = p1;");
		System.out.print ("qn = "); qn.afficher(); System.out.println ();
										// Qu'est ce qui est affiché ? X */

		// Attacher un point nommé à qn et l'afficher
		qn = pn1;			// Est-ce autorisé ? Pourquoi ?  comportement normal
		System.out.println ("> qn = pn1;");
		System.out.print ("qn = "); qn.afficher(); System.out.println ();
										// Qu'est ce qui est affiché ? pareil que pn1

		double d1 = p1.distance (pn1);	// Est-ce autorisé ? Pourquoi ? p1 et pn1 sont des points
		System.out.println ("distance = " + d1);

		double d2 = pn1.distance (p1);	// Est-ce autorisé ? Pourquoi ? idem
		System.out.println ("distance = " + d2);

		double d3 = pn1.distance (pn1);	// Est-ce autorisé ? Pourquoi ? idem
		System.out.println ("distance = " + d3);

/* 		System.out.println ("> qn = q;");
		qn = q;				// Est-ce autorisé ? Pourquoi ? q n'est pas un PointNomme
		System.out.print ("qn = "); qn.afficher(); System.out.println ();
										// Qu'est ce qui est affiché ? X */

		System.out.println ("> qn = (PointNomme) q;");
		qn = (PointNomme) q;		// Est-ce autorisé ? Pourquoi ? parce que cast de classe et q est PointNomme
		System.out.print ("qn = "); qn.afficher(); System.out.println ();

/* 		System.out.println ("> qn = (PointNomme) p1;");
		qn = (PointNomme) p1;		// Est-ce autorisé ? Pourquoi ? pas autorisé parce que p1 pas un PointNomme
		System.out.print ("qn = "); qn.afficher(); System.out.println (); */
	}

}
