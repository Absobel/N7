import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import java.util.zip.*;
import java.time.LocalDateTime;


/**
 * La classe principale.
 *
 * Tous les traitements demandés sont faits dans la mêthode
 * {@code repondreQuestions}.
 * Il serait plus logique d'écrire des méthodes qui pemettraient d'améliorer
 * la structuration et la réutilisation.  Cependant l'objectif est ici la
 * manipulation de l'API des collections, pas la structuration du code
 * en sous-programmes.
 */

public class Main {

	private static void repondreQuestions(Reader in) {
		Iterable<PointDeVente> iterable = PointDeVenteUtils.fromXML(in);

		// Construire un tableau associatif (pdvs) des points de vente avec un
		// accès par identifiant
		Map<Long, PointDeVente> pdvs = new HashMap<>();
		for (PointDeVente pdv : iterable) {
			pdvs.put(pdv.getIdentifiant(), pdv);
		}


		// Nombre de point de vente
		int nbPdv = pdvs.size();
		System.out.println("Nombre de points de vente : " + nbPdv);


		// Afficher le nombre de services existants
		Set<String> services_set = new HashSet<String>();
		for (PointDeVente pdv : pdvs.values()) {
			for (String service : pdv.getServices()) {
				services_set.add(service);
			}
		}
		System.out.println("Nombre de services : " + services_set.size() + "\n");

		
		// Afficher les services fournis
		Set<String> services = new HashSet<>();
		for (PointDeVente pdv : pdvs.values()) {
			for (String service : pdv.getServices()) {
				services.add(service);
			}
		}
		for (String service : services) {
			System.out.println("Service : " + service);
		}
		System.out.println();


		// Afficher la ville correspondant au point de vente d'identifiant
		// 31075001 et le prix du gazole le 25 janvier 2017 à 10h.
		PointDeVente pdv = pdvs.get(31075001L);
		System.out.println("Ville du point de vente 31075001 : " + pdv.getVille());
		System.out.println("Prix du gazole le 25 janvier 2017 à 10h : " + pdv.getPrix(Carburant.GAZOLE, LocalDateTime.parse("2017-01-25T10:00:00")));
		System.out.println();


		// Afficher le nombre de villes offrant au moins un point de vente
		Set<String> villes = new HashSet<>();
		for (PointDeVente pdvi : pdvs.values()) {
			villes.add(pdvi.getVille());
		}
		System.out.println("Nombre de villes offrant au moins un point de vente : " + villes.size());


		// Afficher le nombre moyen de points de vente par ville
		System.out.println("Nombre moyen de points de vente par ville : " + (double) nbPdv / villes.size());
		System.out.println();


		// le nombre de villes offrants un certain nombre de carburants
		for (int nb_carb_i = 0; nb_carb_i < 6; nb_carb_i++) {
			List<String> villes_i = new ArrayList<>();
			for (PointDeVente pdvi : pdvs.values()) {
				if (pdvi.getPrix().get(Carburant.values()[nb_carb_i]) != null && !villes_i.contains(pdvi.getVille())) {
					villes_i.add(pdvi.getVille());
				}
			}
			System.out.println("Nombre de villes offrant " + nb_carb_i + " carburants : " + villes_i.size());
		}
		System.out.println();


		// Afficher le nombre et les points de vente dont le code postal est 31200
		int nb_pdv_31200 = 0;
		for (PointDeVente pdvi : pdvs.values()) {
			if (pdvi.getCodePostal().equals("31200")) {
				nb_pdv_31200++;
			}
		}
		System.out.println("Nombre de points de vente dont le code postal est 31200 : " + nb_pdv_31200);


		// Nombre de PDV de la ville de Toulouse qui proposent et du Gazole
		// et du GPLc.                 // FONCTIONNE PAS
		int nb_pdv_toulouse = 0;
		for (PointDeVente pdvi : pdvs.values()) {
			if (pdvi.getVille().equals("Toulouse") && pdvi.getPrix().get(Carburant.GAZOLE) != null && pdvi.getPrix().get(Carburant.GPLc) != null) {
				nb_pdv_toulouse++;
			}
		}
		System.out.println("Nombre de PDV de la ville de Toulouse qui proposent et du Gazole et du GPLc : " + nb_pdv_toulouse);
		System.out.println();


		// Afficher le nom et le nombre de points de vente des villes qui ont au
		// moins 20 points de vente
		Map<String, Integer> villes_20 = new HashMap<>();
		for (PointDeVente pdvi : pdvs.values()) {
			if (villes_20.containsKey(pdvi.getVille())) {
				villes_20.put(pdvi.getVille(), villes_20.get(pdvi.getVille()) + 1);
			} else {
				villes_20.put(pdvi.getVille(), 1);
			}
		}
		for (Map.Entry<String,Integer> entry : villes_20.entrySet()) {
			if (entry.getValue() >= 20) {
				System.out.println("Ville : " + entry.getKey() + " | Nombre de points de vente : " + entry.getValue());
			}
		}
	}


	private static Reader ouvrir(String nomFichier)
			throws FileNotFoundException, IOException
	{
		if (nomFichier.endsWith(".zip")) {
			// On suppose que l'archive est bien formée :
			// elle contient fichier XML !
			ZipFile zfile = new ZipFile(nomFichier);
			ZipEntry premiere = zfile.entries().nextElement();
			return new InputStreamReader(zfile.getInputStream(premiere));
		} else {
			return new FileReader(nomFichier);
		}
	}


	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("usage : java Main <fichier.xml ou fichier.zip>");
		} else {
			try (Reader in = ouvrir(args[0])) {
				repondreQuestions(in);
			} catch (FileNotFoundException e) {
				System.out.println("Fichier non trouvé : " + args[0]);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

}
