package consoCarbone;


public class Alimentation extends ConsoCarbone{
	private double txBoeuf;
	private double txVege;
	private double impact;
	static double objectif = 1.55;
	// source : https://www.carbone4.com/myco2-empreinte-moyenne-evolution-methodo
	// en faisant -33% car il faut limiter nos emissions de CO2
	
	//Constructeurs
	public Alimentation() {
		this(-1,-1); 
	}
	
	public Alimentation(double txBoeuf, double txVege) {
		this.txBoeuf = txBoeuf;
		this.txVege = txVege;
		calcul();
	}
	
	//Getters et setters
	public double gettxBoeuf() {
		return txBoeuf;
	}
	
	public double gettxVege() {
		return txVege;
	}
	
	public double getimpact() {
		return impact;
	}
	
	public void settxBoeuf(double txBoeuf) {
		this.txBoeuf = txBoeuf;
		calcul();
	}
	
	public void settxVege(double txVege) {
		this.txVege = txVege;
		calcul();
	}

	public double getobjectif() {
		return objectif;
	}
	
	//Suite
	private void calcul(){
		if (txVege != -1 && txBoeuf != -1) {
			this.impact = 8* txBoeuf + 1.6 * (1-txVege-txBoeuf) + 0.9 * txVege;
		}
	}
	
	public static void moyenne() {
		System.out.println("19,5% de l'empreinte carbone des FranÃ§ais provient de l'alimentation, avec 49% pour la viande seule");
	}
	
	@Override
	public String toString() {
		return "Le taux de repas avec du boeuf est " + gettxBoeuf() +", celui de repas vege est " + gettxVege() + " et l'impact est " + getimpact() + " tCO2eq.";
	}
	
	public static void main(String[] args) {
		moyenne();
		Alimentation A1 = new Alimentation(1, 0);
		Alimentation A2 = new Alimentation();
		A2.settxBoeuf(0.1);
		A2.settxVege(0.7);
		System.out.println(A1.impact);
		System.out.println(A2.impact);

	}

}
