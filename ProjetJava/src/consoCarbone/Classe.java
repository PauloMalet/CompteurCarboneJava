package consoCarbone;

/** Cette enumeration représente les différentes classes possibles en avion et 
 * leurs emissions correspondantes en tonne de CO2eq .
 */
public enum Classe {
	
	Eco(1), Business(2), Premiere(4);
        
	/**
	 * impactClasse correspond à l'impact en tonne de CO2eq de sa classe dans l'avion
	 */
	public double impactClasse;
	
	private Classe(double impactClasse) {
		this.impactClasse = impactClasse;
	}
	
	/**
	 * 
	 * @return impactClasse l'impact en tonne de CO2eq de sa classe dans l'avion
	 */
	public double getImpactClasse() {
		return impactClasse;
	}
}
