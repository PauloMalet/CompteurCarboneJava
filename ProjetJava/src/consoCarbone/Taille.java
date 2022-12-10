package consoCarbone;

public enum Taille {
	P(4.2), G(19);

	public double impactTaille;
	
	private Taille(double impactTaille) {
		this.impactTaille = impactTaille;
	}
	
	public double getImpactTaille() {
		return impactTaille;
	}
	
	

}