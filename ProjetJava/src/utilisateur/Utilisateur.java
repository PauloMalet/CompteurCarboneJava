package utilisateur;
import java.util.ArrayList;
import java.util.List;

import consoCarbone.*;

/**
 * Cette classe correspond aux utilisateurs et elle posséde chaque poste de 
 * consommation(Alimentation, Transport,...) correspondant à chaque utilisateur
 */
public class Utilisateur {
	private double empreinte;
	private Alimentation alimentation;
	private BienConso bienConso;
	private Logement logement;
	private Transport transport;
	private ServicesPublics services;	
	private Avion avion;
	/**
	 * Liste contenant pour chaque utilisateur ses différentes consommations carbones
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
public Utilisateur(Alimentation alimentation, BienConso bienConso, Logement logement, Transport transport, ServicesPublics services, Avion avion) {
	this.alimentation = alimentation;
	this.bienConso = bienConso;
	this.logement = logement;
	this.transport = transport;
	this.services = services;
	this.avion = avion;
	conso.add(alimentation);
	conso.add(bienConso);
	conso.add(logement);
	conso.add(transport);
	conso.add(services);
	conso.add(avion);
	calculerEmpreinte();
	}
	
	private double calculerEmpreinte() {
		empreinte = alimentation.getimpact() + bienConso.getimpact() + logement.getimpact() + transport.getimpact() + services.getimpact();
		return empreinte;
	}
	
	private void detaillerEmpreinte() {
		System.out.println("Il y a " + alimentation.getimpact() + " tCO2 provenant de l'alimentation, " + bienConso.getimpact() + " tCO2 provenant de la consommation " + logement.getimpact() + " tCO2 provenant du logement, " + transport.getimpact() + " tCO2 provenant du transport, et " + services.getimpact() + " tCO2 provenant des services publics");
	}
	
	private void OrdonnerPresenter() {
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
		for (int i=0; i < 6; i++) {
			System.out.println(conso.get(i).getClass().getTypeName().substring(13) + " : " + conso.get(i).getimpact() + " tCO2.");
		}
		for (int i=0; i < 6; i++) {
			if (conso.get(i).getimpact() > conso.get(i).getobjectif()) {
				System.out.println("Il est possible de réduire ses émissions de CO2 en réduisant ses emissions provenant de " + conso.get(i).getClass().getTypeName().substring(13) + " car l'objectif individuel est de " + conso.get(i).getobjectif() + " tCO2 par an.");
			}
		}
	}

	
	
	
	public static void main(String[] args) {
		Alimentation alimentation = new Alimentation(0.1, 0.5);
		BienConso bienConso = new BienConso(1000);
		Logement logement = new Logement(100, CE.B);
		Transport transport = new Transport(true, Taille.P, 5000, 15);
		ServicesPublics services = new ServicesPublics();
		Avion avion = new Avion(5000, Classe.Eco);
		Utilisateur U1 = new Utilisateur(alimentation, bienConso, logement, transport, services, avion);
		U1.OrdonnerPresenter();
	}

}
