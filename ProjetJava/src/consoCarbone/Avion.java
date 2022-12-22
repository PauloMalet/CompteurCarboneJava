package consoCarbone;

/**
 * 
 * Cette classe permet de calculer l'impact d’émissions de GES en TCO2eq lié aux déplacements en avion
 * en fonction de sa classe et de la distance parcouru
 */
public class Avion extends ConsoCarbone{
	private double impact;
	private int distanceAnnee;
	private Classe classe;
	/**
	 * objectif de consommation carbone en terme de deplacement en avion (en TCO2eq)permettant de limiter nos emissions de CO2
	 */
	static double objectif = 0.28;
	// source : https://www.carbone4.com/myco2-empreinte-moyenne-evolution-methodo
	// en faisant -33% car il faut limiter nos emissions de CO2
	
	/**
         * constructeur vide
         */
	public Avion() {
	}
	
	/**
	 * constructeur
	 * @param distanceAnnee distance parcouru en avion durant un an
	 * @param classe la classe dans l'avion (Eco, Business, Premiere)
	 */
	public Avion(int distanceAnnee, Classe classe) {
		this.distanceAnnee = distanceAnnee;
		this.classe = classe;
		calcul();
	}

	private void calcul() {
		impact = 0.000122 * distanceAnnee * classe.getImpactClasse();
	}
	
	/**
	 * 
	 * @return objectif l'objectif d'impact CO2 pour cette catégorie 
	 */
	public double getobjectif() {
		return objectif;
	}
	
	/**
	 * @return distanceAnnee distance parcouru en avion durant un an
	 */
	public int getDistanceAnnee() {
		return distanceAnnee;
	}

	/**
	 * @param distanceAnnee distance parcouru en avion durant un an
	 * la distance à set
	 */
	public void setDistance(int distanceAnnee) {
		this.distanceAnnee = distanceAnnee;
		calcul();
	}

	/**
	 * @return impact l'impact(en tonnes de gaz à effet de serre CO2) lié aux déplacements en avion
	 */
	public double getimpact() {
		return impact;
	}

	/**
	 * @param impact l'impact(en tonnes de gaz à effet de serre CO2) lié aux déplacements en avion
	 *l'impact à set
	 */
	public void setimpact(double impact) {
		this.impact = impact;
		calcul();
	}

	/**
	 * @return classe la classe dans l'avion (Eco, Business, Premiere)
	 */
	public Classe getclasse() {
		return classe;
	}

	/**
	 * @param classe la classe dans l'avion (Eco, Business, Premiere)
	 *(classe the classe to set)
	 */
	public void setclasse(Classe classe) {
		this.classe = classe;
		calcul();
	}
	
	
	@Override
	public String toString() {
		return "Chaque année, " + distanceAnnee + " kilomètres sont parcourue en classe " + getclasse() + ", et a un impact de " + getimpact() + " tCO2eq.";
	}
	
	public static void main(String[] args) {
		//Tests
		Avion A1 = new Avion(10000, Classe.Business);
		System.out.println(A1.impact);
	}
	
	
}
