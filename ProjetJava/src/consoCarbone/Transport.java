package consoCarbone;

/** Cette classe permet de calculer l'impact d’émissions de GES en TCO2eq lié à ses déplacements : voiture  
 * et son utilisation
 */
public class Transport extends ConsoCarbone{
	private boolean possede;
	private Taille taille;
	private int kilomAnnee;
	private int amortissement;
	private double impact;
	/**
         * objectif de consommation carbone lié aux transports (en TCO2eq)permettant 
         * de limiter nos emissions de CO2
         */
	static double objectif = 1.34;
	// source : https://www.carbone4.com/myco2-empreinte-moyenne-evolution-methodo
	// en faisant -33% car il faut limiter nos emissions de CO2
	
	//Suite
	/**
	 * constructeur par défaut
	 */
	public Transport() {
		this.kilomAnnee = -1;
		this.amortissement = -1;
	}
	
	/**
	 * Constructeur
	 * @param possede indique si l’utilisateur.rice possède une voiture
	 * Vrai si l’utilisateur.rice possède une voiture , Faux sinon
	 * 
	 * @param taille la taille du véhicule (grand ou petit)
	 * @param kilomAnnee nombre de kilomètres parcourus par an
	 * @param amortissement durée conservation du véhicule
	 */
	public Transport(boolean possede, Taille taille, int kilomAnnee, int amortissement) {
		this.possede = possede;
		this.taille = taille;
		this.kilomAnnee = kilomAnnee;
		this.amortissement = amortissement;
		calcul();
	}
	
	//Getters et setters
	
	/**
	 * 
	 * @return objectif l'objectif d'impact CO2 pour cette catégorie 
	 */
	public double getobjectif() {
		return objectif;
	}
	
	/**
	 * 
	 * @param possede possede indique si l’utilisateur.rice possède une voiture
	 * true si il possède une voiture
	 */
	public void setPossede(boolean possede) {
		this.possede = possede;
		calcul();
	}
	
	/**
	 * 
	 * @param taille la taille du véhicule (grand ou petit)
	 */
	public void setTaille(Taille taille) {
		this.taille = taille;
		calcul();
	}
	
	/**
	 * 
	 * @param kilomAnnee nombre de kilomètres parcourus par an
	 */
	public void setKilomAnnee(int kilomAnnee) {
		this.kilomAnnee = kilomAnnee;
		calcul();
	}
	
	/**
	 * 
	 * @param amortissement durée conservation du véhicule
	 */
	public void setAmortissement(int amortissement) {
		this.amortissement = amortissement;
		calcul();
	}
	
	/**
	 * 
	 * @return possede possede indique si l’utilisateur.rice possède une voiture
	 */
	public boolean getpossede() {
		return possede;
	}
	
	/**
	 * 
	 * @return taille la taille du véhicule (grand ou petit)
	 */
	public Taille gettaille() {
		return taille;
	}
	
        /**
         * 
         * @return kilomAnnee nombre de kilomètres parcourus par an
         */
	public int getkilomAnnee() {
		return kilomAnnee;
	}
	/**
	 * 
	 * @return amortissement durée conservation du véhicule
	 */
	public int getamortissement() {
		return amortissement;
	}
	
	/**
         * 
         * @return impact impact(en tonnes de gaz à effet de serre CO2) lié aux transports
         */
	public double getimpact() {
		return impact;
	}
	

	//Suite
	private void calcul() {
		if (possede == false) 
			impact = 0;
		else {
			if (kilomAnnee != -1 && amortissement != -1 && taille != null) 
				this.impact = kilomAnnee * 1.93 * 0.0001 + (taille.getImpactTaille() / amortissement);
		}
	}
	
	@Override
	public String toString() {
		return "La voiture est de taille " + gettaille() + ", la distance parcourue est " + getkilomAnnee() +  " kilometres et l'amortissement se fait sur " + getamortissement() + " annees. Son impact est de " + getimpact() + " tCO2eq.";
	}
	
	public static void main(String[] args) {
		//Tests
		Transport T1 = new Transport(true, Taille.P, 10000, 10);
		System.out.println(T1.impact);
	}

}
