package consoCarbone;




public class BienConso extends ConsoCarbone{
	private double montant;
	private double impact;
	
	//Constructeurs
	public BienConso() {}
	
	public BienConso(double montant) {
		this.montant = montant;
		calcul();
	}
	
	//Getters et setters
	public double getMontant() {
		return montant;
	}
	
	public void setMontant(double montant) {
		this.montant = montant;
		calcul();
	}
	
	public double getimpact() {
		return impact;
	}
	
	//Suite
	private void calcul() {
		this.impact = montant / 1750 ;
	}
	
	@Override
	public String toString() {
		return "La somme dÃ©pensÃ©e en biens de conso est " + getMontant() + "et son impact est " + getImpact();
	}
	
	public static void main(String[] args) {
		BienConso BC1 = new BienConso(1000);
		System.out.println(BC1.impact);
	}

}
