package consoCarbone;
/** 
 * Cette classe permet de calculer l'impact d’émissions de Gaz à Effet de Serre en Tonne de CO2 
 * lié à ses achats en fonction du montant dépensé
 */

public class BienConso extends ConsoCarbone{
	private double montant;
	private double impact;
	/**
	 * objectif de consommation carbone en terme de depenses (en TCO2eq)permettant de limiter nos emissions de CO2
	 */
	static double objectif = 1;
	// source : https://www.carbone4.com/myco2-empreinte-moyenne-evolution-methodo
	// en faisant -33% car il faut limiter nos emissions de CO2
	
	//Constructeurs
	/**
	 * constructeur vide
	 */
	public BienConso() {}
	
	/**
	 * constructeur
	 * @param montant le montant des dépenses par an de l’utilisateur.rice
	 */
	public BienConso(double montant) {
		this.montant = montant;
		calcul();
	}
	
	//Getters et setters
	/**
	 * 
	 * @return montant le montant des dépenses annuelles de l’utilisateur.rice
	 */
	public double getMontant() {
		return montant;
	}
	
	/**
	 * 
	 * @param montant le montant des dépenses annuelles de l’utilisateur.rice
	 */
	public void setMontant(double montant) {
		this.montant = montant;
		calcul();
	}
	
	/**
	 * 
	 * @return impact l'impact des dépenses annuelles de l’utilisateur.rice (en tonne de CO2eq)
	 */
	public double getimpact() {
		return impact;
	}
	
	
	//Suite
	private void calcul() {
		this.impact = montant / 1750 ;
	}
	
	@Override
	public String toString() {
		return "La somme depensee en biens de conso est " + getMontant() + " euros, et son impact est de " + getimpact() + " tCO2eq.";
	}
	
	public static void main(String[] args) {
		BienConso BC1 = new BienConso(1000);
		System.out.println(BC1.impact);
	}

}
