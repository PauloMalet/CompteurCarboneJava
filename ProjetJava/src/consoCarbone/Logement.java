package consoCarbone;
/** 
 * Cette classe permet de calculer l'impact d’émissions de GES(Gaz à Effet de Serre) en TCO2eq(tonne de C02)
 *  lié à son logement en fonction de sa superficie et de sa classe.
 */
public class Logement extends ConsoCarbone{
	private int superficie;
	private CE ce;
	private double impact;
	/**
	 * objectif de consommation carbone en terme de logement (en TCO2eq)
	 * permettant de limiter nos emissions de CO2
	 */
	static double objectif = 1.254;
	// source : https://www.carbone4.com/myco2-empreinte-moyenne-evolution-methodo
	// en faisant -33% car il faut limiter nos emissions de CO2
	
	//Suite
	/**
	 * constructeur vide
	 */
	public Logement() {	}
	
	/**
	 * constructeur
	 * 
	 * @param superficie superficie du logement en mètre carré(m^2)
	 * @param ce la classe énergétique du logement
	 */
	public Logement(int superficie, CE ce) {
		this.superficie = superficie;
		this.ce = ce;
		calcul();
	}
	
	//Getters et setters
	/**
	 * 
	 * @param superficie superficie du logement en mètre carré(m^2)
	 */
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
		calcul();
	}
	/**
	 * 
	 * @param ce la classe énergétique du logement
	 */
	public void setce(CE ce) {
		this.ce = ce;
		calcul();
	}
	
	/**
	 * 
	 * @return superficie superficie du logement en mètre carré(m^2)
	 */
	public int getSuperficie() {
		return superficie;
	}
	
	/**
	 * 
	 * @return ce la classe énergétique du logement
	 */
	public CE getCe() {
		return ce;
	}
	
	/**
	 * 
	 * @return impact impact du logement en terme d'émissions de gaz à effet de serre equivalent en tonne de C02
	 */
	public double getimpact() {
		return impact;
	}
	
	
	//Suite
	private void calcul() {
		if (superficie != 0 && ce != null) {
			this.impact = ce.getImpactCE() * superficie;
		}
	}
	
	/**
	 *Methode statique qui affiche l’empreinte carbone moyenne d’un.e français.e vis à vis du logement  
	 */
	public static void moyenne() {
		System.out.println("Le logement reprÃ©sente 22% de l'empreinte carbone des francais, le chauffage seul comptant pour 63%");
	}
	
	@Override
	public String toString() {
		return "La superficie du logement est de " + getSuperficie() + " metres carres, sa categorie energetique est " + getCe() + " et son impact est de " + getimpact() + " tCO2eq.";
	}
	
	
	public static void main(String[] args) {
		Logement l1 = new Logement(100, CE.B);
		Logement l2 = new Logement();
		l2.setSuperficie(100);
		l2.setce(CE.A);
		System.out.println(l1.impact);
		System.out.println(l2.impact);
	}

}
