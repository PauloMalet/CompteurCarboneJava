package consoCarbone;

/** Cette classe permet de calculer l'impact d’émissions de GES en TCO2eq lié à son alimentation 
 * en fonction de sa superficie et de sa classe
 */

public class Alimentation extends ConsoCarbone{
	private double txBoeuf;
	private double txVege;
	private double impact;
	/**
	 * objectif de consommation carbone en terme d'alimentation (en TCO2eq)permettant de limiter nos emissions de CO2
	 */
	static double objectif = 1.55;
	// source : https://www.carbone4.com/myco2-empreinte-moyenne-evolution-methodo
	// en faisant -33% car il faut limiter nos emissions de CO2
	
	//Constructeurs
	/**
        * constructeur par défaut
        */
	public Alimentation() {
		this(-1,-1); 
	}
	
	/**
	 * constructeur
	 * @param txBoeuf
	 * @param txVege
	 */
	public Alimentation(double txBoeuf, double txVege) {
		this.txBoeuf = txBoeuf;
		this.txVege = txVege;
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
	 * @return txBoeuf le taux de repas à base de boeuf 
	 */
	public double gettxBoeuf() {
		return txBoeuf;
	}
	
	/**
	 * 
	 * @return txVege le taux de repas végétariens
	 */
	public double gettxVege() {
		return txVege;
	}
	
	/**
	 * 
	 * @return impact l'impact(en tonne d'emission de CO2) de son alimentation
	 */
	public double getimpact() {
		return impact;
	}
	
	/**
	 * 
	 * @param txBoeuf  txBoeuf le taux de repas à base de boeuf
	 * txBoeuf doit être compris entre 0 et 1
	 */
	public void settxBoeuf(double txBoeuf) {
		this.txBoeuf = txBoeuf;
		calcul();
	}
	
	/**
	 * 
	 * @param txVege le taux de repas végétariens
	 *txVege doit être compris entre 0 et 1
	 */
	public void settxVege(double txVege) {
		this.txVege = txVege;
		calcul();
	}


	//Suite
	private void calcul(){
		if (txVege != -1 && txBoeuf != -1) {
			this.impact = 8* txBoeuf + 1.6 * (1-txVege-txBoeuf) + 0.9 * txVege;
		}
	}
	
	/**
	 * Methode statique qui affiche l’empreinte carbone moyenne d’un.e français.e vis à vis de l'alimentation
	 */
	public static void moyenne() {
		System.out.println("19,5% de l'empreinte carbone des Francais provient de l'alimentation, avec 49% pour la viande seule");
	}
	
	@Override
	public String toString() {
		return "Le taux de repas avec du boeuf est " + gettxBoeuf() +", celui de repas vege est " + gettxVege() + " et l'impact est " + getimpact() + " tCO2eq.";
	}
	
	public static void main(String[] args) {
		moyenne();
		Alimentation A1 = new Alimentation(1, 0);
		Alimentation A2 = new Alimentation();
		A2.settxBoeuf(0.1);
		A2.settxVege(0.7);
		System.out.println(A1.impact);
		System.out.println(A2.impact);

	}

}
