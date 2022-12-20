package utilisateur;
import java.util.ArrayList;
import java.util.List;

import consoCarbone.Alimentation;
import consoCarbone.Avion;
import consoCarbone.BienConso;
import consoCarbone.CE;
import consoCarbone.Classe;
import consoCarbone.ConsoCarbone;
import consoCarbone.Logement;
import consoCarbone.ServicesPublics;
import consoCarbone.Taille;
import consoCarbone.Transport;


public class Utilisateur {
	private double empreinte;
	private consoCarbone.Alimentation alimentation;
	private consoCarbone.BienConso bienConso;
	private consoCarbone.Logement logement;
	private consoCarbone.Transport transport;
	private consoCarbone.ServicesPublics services;	
	private consoCarbone.Avion avion;
	List<consoCarbone.ConsoCarbone> conso = new ArrayList<consoCarbone.ConsoCarbone>();

	
public Utilisateur(consoCarbone.Alimentation alimentation, consoCarbone.BienConso bienConso, consoCarbone.Logement logement, consoCarbone.Transport transport, consoCarbone.ServicesPublics services, consoCarbone.Avion avion) {
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
	
	private String Ordonner() {
		int taille = conso.size();
		consoCarbone.ConsoCarbone changement;
		for(int i=0; i < taille; i++){
		    for (int j=1; j < taille-1; j++) {
		    	if (conso.get(j-1).getimpact() > conso.get(j).getimpact()) {
		    		changement = conso.get(j-1);
		    		conso.set(j-1, conso.get(j));
		    		conso.set(j, changement);	    		
		    	}
		    }	
		}
		return "L'ordre des postes les plus poluants est le suivant :" + conso;
	}
	
	
	public static void main(String[] args) {
		Alimentation alimentation = new Alimentation(0.1, 0.5);
		BienConso bienConso = new BienConso(1000);
		Logement logement = new Logement(100, CE.B);
		Transport transport = new Transport(true, Taille.P, 10000, 10);
		ServicesPublics services = new ServicesPublics();
		Avion avion = new Avion(5000, Classe.Eco);
		Utilisateur U1 = new Utilisateur(alimentation, bienConso, logement, transport, services, avion);
		System.out.println(U1.conso.get(1));
		System.out.println(U1.alimentation);
		System.out.println(U1.Ordonner());
		System.out.println(U1.conso.get(1));
	}

}
