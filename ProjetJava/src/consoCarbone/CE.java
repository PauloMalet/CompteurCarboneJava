package consoCarbone;
/** 
 * Cette enumeration représente les différentes classes énergétiques possibles d’un logement.
 */

public enum CE {
	A(0.005), B(0.01), C(0.02), D(0.035), E(0.055), F(0.08), G(0.1);
	
	private double impactCE;
	
	private CE(double impactCE) {
		this.impactCE = impactCE;
	}
	
	/**
	 * 
	 * @return l'impact en termes d’émissions en tonne de GES en TCO2eq de la classe énergétique 
	 */
	public double getImpactCE() {
		return impactCE;
	}
	
	
	
}
