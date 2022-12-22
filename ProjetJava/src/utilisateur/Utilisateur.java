package utilisateur;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import consoCarbone.*;

/**
 * Cette classe correspond aux utilisateurs et elle posséde chaque poste de 
 * consommation(Alimentation, Transport,...) correspondant à chaque utilisateur
 */
public class Utilisateur {
	private double empreinte;
	private Alimentation alimentation;
	private BienConso bienConso;
	private List<Logement> logement = new ArrayList<Logement>();
	private List<Transport> transport = new ArrayList<Transport>();
	private ServicesPublics services;	
	private Avion avion;
	/**
	 * Liste contenant pour chaque utilisateur ses différentes consommations carbone
	 */
	List<ConsoCarbone> conso = new ArrayList<ConsoCarbone>();

	/**
	 * constructeur
	 * @param alimentation le poste de consommation carbone de l’utilisateur.rice lié à son alimentation.
	 * @param bienConso le poste de consommation carbone de l’utilisateur.rice concernant ses dépenses en biens de consommation
	 * @param logement le poste de consommation carbone de l’utilisateur.rice concernant son logement
	 * @param transport le poste de consommation carbone de l’utilisateur.rice concernant ses déplacements
	 * @param services le poste de consommation carbone de l’utilisateur.rice concernant son utilisation des services publics
	 * ces différents postes de consommation sont ajoutés à la liste conso
	 */
public Utilisateur(Alimentation alimentation, BienConso bienConso, List<Logement> logement, List<Transport> transport, ServicesPublics services, Avion avion) {
	this.alimentation = alimentation;
	this.bienConso = bienConso;
	this.logement = logement;
	this.transport = transport;
	this.services = services;
	this.avion = avion;
	conso.add(alimentation);
	conso.add(bienConso);
	for (Logement e: logement) conso.add(e);
	for (Transport e: transport) conso.add(e);
	conso.add(services);
	conso.add(avion);
	calculerEmpreinte();
	}
	
	private double calculerEmpreinte() {
		empreinte = alimentation.getimpact() + bienConso.getimpact() + services.getimpact() + avion.getimpact();
		for (Logement e: logement) empreinte += + e.getimpact();
		for (Transport e: transport) empreinte += + e.getimpact();		
		return empreinte;
	}
	
	private void detaillerEmpreinte() {
		double impactLogement = 0;
		double impactTransport = 0;
		for (Logement e: logement) {
			impactLogement += e.getimpact();
		}
		for (Transport e: transport) {
			impactLogement += e.getimpact();
		}
		System.out.println("Il y a " + alimentation.getimpact() + " tCO2 provenant de l'alimentation, " + bienConso.getimpact() + " tCO2 provenant de la consommation, " + impactLogement + " tCO2 provenant du logement, " + impactTransport + " tCO2 provenant du transport, et " + services.getimpact() + " tCO2 provenant des services publics");
	}
	
	private void OrdonnerPresenter() {
		System.out.println("Votre emission totale de CO2 est de " + empreinte + " tonnes");
		int taille = conso.size();
		ConsoCarbone changement;
		for(int i=0; i < taille; i++){
		    for (int j=1; j < taille; j++) {
		    	if (conso.get(j-1).getimpact() > conso.get(j).getimpact()) {
		    		changement = conso.get(j-1);
		    		conso.set(j-1, conso.get(j));
		    		conso.set(j, changement);	    		
		    	}
		    }	
		}
		System.out.println("Voici les postes d'emission de CO2 en ordre croissant et en tCO2: ");
		for (int i=0; i < conso.size(); i++) {
			System.out.println(conso.get(i).getClass().getTypeName().substring(13) + " : " + conso.get(i).getimpact() + " tCO2.");
		}
		for (int i=0; i < conso.size(); i++) {
			if (conso.get(i).getimpact() > conso.get(i).getobjectif()) {
				System.out.println("Il serait sage de réduire ses émissions de CO2 en réduisant ses emissions provenant de " + conso.get(i).getClass().getTypeName().substring(13) + " car l'objectif individuel est de " + conso.get(i).getobjectif() + " tCO2 par an.");
			}
		}
	}

	
	
	
	public static void main(String[] args) {
		
		ServicesPublics services = new ServicesPublics();		
		
		//Crer scanner
		Scanner scan = new Scanner(System.in);
		
		//Alimentation
		System.out.println("Entrer le taux de repas contenant du boeuf : ");
		Double txboeuf = scan.nextDouble();
		System.out.println("Entrer le taux de repas vegetarien : ");
		Double txvege = scan.nextDouble();
		
		Alimentation alimentation = new Alimentation(txboeuf, txvege);
		
		//BienConso
		System.out.println("Entrer la somme dépensée en biens de consommation : ");
		Double montant = scan.nextDouble();
		
		BienConso bienConso = new BienConso(montant);
		
		//Logement
		System.out.println("Entrer le nombre de logements que vous avez : ");
		int nombre = scan.nextInt();
		
		List<Logement> logement = new ArrayList<Logement>();
		for (int i = 0; i < nombre; i++) {
			System.out.println("Entrer la surface du logement : ");
			int surface = scan.nextInt();
			System.out.println("Entrer la categorie energetique du logement : ");
			String a = scan.next();
			CE ce = CE.valueOf(a);
			Logement logement1 = new Logement(surface, ce);
			logement.add(logement1);
		}
		
		//Transport
		System.out.println("Entrer le nombre de voitures que vous avez : ");
		int nombre2 = scan.nextInt();
		
		List<Transport> transport = new ArrayList<Transport>();
		for (int i = 0; i < nombre2; i++) {
			System.out.println("Entrer la taille de la voiture (P ou G) : ");
			String b = scan.next();
			Taille taille = Taille.valueOf(b);
			System.out.println("Entrer la distance parcourue chaque annee : ");
			int kilomAnnee = scan.nextInt();
			System.out.println("Entrer le temps d'amortissement du véhicule en annees : ");
			int amortissement = scan.nextInt();
			Transport transport1 = new Transport(true, taille, kilomAnnee, amortissement);
			transport.add(transport1);
		}
		
		//Avion
		Avion avion = new Avion();
		System.out.println("Entrer la distance parcourue en avion : ");
		int distance = scan.nextInt();

		if (distance > 0) {
			System.out.println("Entrer la classe (Eco, Business ou Premiere) : ");
			String c = scan.next();
			Classe classe = Classe.valueOf(c);
			avion.setDistance(distance);
			avion.setclasse(classe);
		}
		
		
		else {
			avion.setDistance(distance);
			avion.setclasse(Classe.Eco);
		}
		
		//Calculs finaux
		
		Utilisateur U1 = new Utilisateur(alimentation, bienConso, logement, transport, services, avion);
		U1.OrdonnerPresenter();
		
		
		//Ne marche pas
		/*
		char[] array = new char[100];
		try {
			FileReader input = new FileReader("C:\\Users\\Paul\\git\\ProjetJava\\ProjetJava\\src\\utilisateur.txt");
			input.read(array);
		    System.out.println("Data in the file: ");
		    System.out.println(array);
			input.close();
		}
		
		catch(Exception e) {
			System.out.println("cela ne marche pas");
			e.getStackTrace();
		}
		*/
	}

}
