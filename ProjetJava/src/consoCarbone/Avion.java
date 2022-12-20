package consoCarbone;


public class Avion extends ConsoCarbone{
	private double impact;
	private int distanceAnnee;
	private Classe classe;
	static double objectif = 0.28;
	// source : https://www.carbone4.com/myco2-empreinte-moyenne-evolution-methodo
	// en faisant -33% car il faut limiter nos emissions de CO2
	
	
	public Avion() {
	}
	
	public Avion(int distanceAnnee, Classe classe) {
		this.distanceAnnee = distanceAnnee;
		this.classe = classe;
		calcul();
	}

	private void calcul() {
		impact = 0.000122 * distanceAnnee * classe.getImpactClasse();
	}
	
	/**
	 * @return the distance
	 */
	public int getDistanceAnnee() {
		return distanceAnnee;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distanceAnnee) {
		this.distanceAnnee = distanceAnnee;
		calcul();
	}

	/**
	 * @return the impact
	 */
	public double getimpact() {
		return impact;
	}

	/**
	 * @param impact the impact to set
	 */
	public void setimpact(double impact) {
		this.impact = impact;
		calcul();
	}

	/**
	 * @return the classe
	 */
	public Classe getclasse() {
		return classe;
	}

	/**
	 * @param classe the classe to set
	 */
	public void setclasse(Classe classe) {
		this.classe = classe;
		calcul();
	}
	
	public double getobjectif() {
		return objectif;
	}
	
	@Override
	public String toString() {
		return "Chaque année, " + distanceAnnee + " kilomètres sont parcourue en classe " + getclasse() + ", et a un impact de " + getimpact() + " tCO2eq.";
	}
	
	public static void main(String[] args) {
		Avion A1 = new Avion(10000, Classe.Business);
		System.out.println(A1.impact);
	}
	
	
}
