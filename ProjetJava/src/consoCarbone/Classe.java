package consoCarbone;

public enum Classe {
	
	Eco(1), Business(2), Premiere(4);

	public double impactClasse;
	
	private Classe(double impactClasse) {
		this.impactClasse = impactClasse;
	}
	
	public double getImpactClasse() {
		return impactClasse;
	}
}
