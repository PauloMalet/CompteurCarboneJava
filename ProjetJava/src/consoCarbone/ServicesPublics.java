package consoCarbone;
/**
 * Cette classe permet de calculer l'impact d’émissions de GES en TCO2eq 
 * lié aux services publics (justice, police, éducation, santé, ...)
 * Tout les francais ont le même impact lié aux services publics (1.5TCO2eq)
 *
 */

public class ServicesPublics  extends ConsoCarbone{
	private double impact = 1.5;
	/**
         * objectif de consommation carbone lié aux services publiques (en TCO2eq)permettant 
         * de limiter nos emissions de CO2
         */
	static double objectif = 1;
	
	/**
	 * constructeur vide 
	 */
	public ServicesPublics() {
	}
	
	/**
	 * 
	 * @return impact impact(en tonnes de gaz à effet de serre CO2) lié aux services publics 
	 */
	public double getimpact() {
		return impact;
	}
	
	
	@Override
	public String toString() {
		return "L'empreinte carbone due aux services publics est de " + impact + " tonnes de CO2eq.";
	}
	
	public static void main(String[] args) {
		ServicesPublics SP = new ServicesPublics();
		System.out.println(SP.getimpact());
	}

}
