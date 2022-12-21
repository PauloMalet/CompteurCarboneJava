package consoCarbone;
/** Cette enumeration représente les différentes tailles possibles d’une voiture et 
 * leurs emissions en tonne de CO2eq .
 */

public enum Taille {
	P(4.2), G(19);
	
        /**
	 * impact en TCO2eq de la production de la voiture de l'utilisateur
	 */
	public double impactTaille;
	
	private Taille(double impactTaille) {
		this.impactTaille = impactTaille;
	}
	
	/**
	 * 
	 * @return impactTaille impact de la production en TCO2eq de la voiture de l'utilisateur
	 */
	public double getImpactTaille() {
		return impactTaille;
	}
	
	

}
