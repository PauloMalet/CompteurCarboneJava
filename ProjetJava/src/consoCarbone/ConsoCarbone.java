package consoCarbone;
/**
 * Cette classe represente la consommation carbone totale
 */

public abstract class ConsoCarbone implements Comparable<ConsoCarbone>{
	/**
	 * impact total en terme d'émissions equivalent en tonne de C02
	 */
	public double impact;
	private static int id;
	/**
	 * objectif de consommation carbone (en TCO2eq)permettant de limiter nos emissions de CO2
	 */
	static double objectif;
	
	//Constructeurs
	/**
	 * constructeur
	 * permet d'avoir un id différent pour chaque utilisateur correspondant et sa Consommation Carbone
	 */
	public ConsoCarbone() {
		ConsoCarbone.id++;
	} 
	
	//Getters et setters
	/**
	 * 
	 * @return impact impact total en terme d'émissions de gaz à effet de serre equivalent en tonne de C02
	 */
	public double getimpact() {
		return impact;
		
	}
	/**
	 * 
	 * @return ConsoCarbone.id l'id identifiant de l'utilisateur lié à sa Consommation Carbone
	 */
	public int getid() {
		return ConsoCarbone.id;
	}
	
	/**
	 * 
	 * @param id id correspondant à une consommation carbone
	 */
	public void setid(int id) {
		ConsoCarbone.id = id;
	}
	
	//Suite
	/**
	 *
	 * Cette methode permet de comparer deux Consommations Carbones en fonction 
	 * de leurs impacts en termes d’émissions de gaz à effet de serre.  
	 * 
	 */
	@Override
	public int compareTo(ConsoCarbone CC) {
		if (this.getimpact() > CC.getimpact()) {
			return 1;
		}
		if (this.getimpact() < CC.getimpact()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	@Override
	/**
	 * Methode redefinit(pour pouvoir l'utiliser) toString()
	 * Methode qui retourne une chaîne de caractères de l'objet 
	 */
	public abstract String toString();
	
	/**
	 * 
	 * @return objectif objectif de consommation carbone (en TCO2eq)permettant de limiter nos emissions de CO2
	 */
	public double getobjectif() {
		return objectif;
	}
	
	public static void main(String[] args) {
	}

	
}
