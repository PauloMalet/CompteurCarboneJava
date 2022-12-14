package consoCarbone;

public enum TypeVol {
	C(500), M(3000), L(10000);

	public double impactTypeVol;
	
	private TypeVol(double impactTypeVol) {
		this.impactTypeVol = impactTypeVol;
	}
	
	public double getImpactTypeVol() {
		return impactTypeVol;
	}
	
	

}