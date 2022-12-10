package consoCarbone;

public class Logement extends ConsoCarbone{
	private int superficie;
	private CE ce;
	private double impact;
	
	//Suite
	public Logement() {	}
	
	public Logement(int superficie, CE ce) {
		this.superficie = superficie;
		this.ce = ce;
		calcul();
	}
	
	//Getters et setters
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
		calcul();
	}
	
	public void setce(CE ce) {
		this.ce = ce;
		calcul();
	}
	
	public int getSuperficie() {
		return superficie;
	}
	
	public CE getCe() {
		return ce;
	}
	
	public double getimpact() {
		return impact;
	}
	
	//Suite
	private void calcul() {
		if (superficie != 0 && ce != null) {
			this.impact = ce.getImpactCE() * superficie;
		}
	}
	
	public static void moyenne() {
		System.out.println("Le logement reprÃ©sente 22% de l'empreinte carbone des franÃ§ais, le chauffage seul comptant pour 63%");
	}
	
	@Override
	public String toString() {
		return "La superficie du logement est " + getSuperficie() + ", sa catÃ©gorie Ã©nergÃ©tique est " + getCe() + " et son impact est " + getImpact();
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
