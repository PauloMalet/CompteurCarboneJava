package consoCarbone;


public class BienConso extends ConsoCarbone{
	private double montant;
	private double impact;
	static double objectif = 1;
	// source : https://www.carbone4.com/myco2-empreinte-moyenne-evolution-methodo
	// en faisant -33% car il faut limiter nos emissions de CO2
	
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
	
	public double getobjectif() {
		return objectif;
	}
	
	//Suite
	private void calcul() {
		this.impact = montant / 1750 ;
	}
	
	@Override
	public String toString() {
		return "La somme depensee en biens de conso est " + getMontant() + " euros, et son impact est de " + getimpact() + " tCO2eq.";
	}
	
	public static void main(String[] args) {
		BienConso BC1 = new BienConso(1000);
		System.out.println(BC1.impact);
	}

}
