package utilisateur;

public class Utilisateur {
	private double empreinte;
	private consoCarbone.Alimentation alimentation;
	private consoCarbone.BienConso bienConso;
	private consoCarbone.Logement logement;
	private consoCarbone.Transport transport;
	private consoCarbone.ServicesPublics services;	
	
	public Utilisateur(consoCarbone.Alimentation alimentation, consoCarbone.BienConso bienConso, consoCarbone.Logement logement, consoCarbone.Transport transport, consoCarbone.ServicesPublics services) {
		this.alimentation = alimentation;
		this.bienConso = bienConso;
		this.logement = logement;
		this.transport = transport;
		this.services = services;
	}
	
	private double calculerEmpreinte() {
		empreinte = alimentation.getimpact() + bienConso.getimpact() + logement.getimpact() + transport.getimpact() + services.getimpact();
		return empreinte;
	}
	
	private void detaillerEmpreinte() {
		System.out.println("Il y a " + alimentation.getimpact() + " tCO2 provenant de l'alimentation, " + bienConso.getimpact() + " tCO2 provenant de la consommation " + logement.getimpact() + " tCO2 provenant du logement, " + transport.getimpact() + " tCO2 provenant du transport, et " + services.getimpact() + " tCO2 provenant des services publics");
	}
	
	
	public static void main(String[] args) {
		
	}

}
