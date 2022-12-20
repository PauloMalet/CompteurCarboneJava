package consoCarbone;

public class Transport extends ConsoCarbone{
	private boolean possede;
	private Taille taille;
	private int kilomAnnee;
	private int amortissement;
	private double impact;
	static double objectif = 1.34;
	// source : https://www.carbone4.com/myco2-empreinte-moyenne-evolution-methodo
	// en faisant -33% car il faut limiter nos emissions de CO2
	
	//Suite
	public Transport() {
		this.kilomAnnee = -1;
		this.amortissement = -1;
	}
	
	public Transport(boolean possede, Taille taille, int kilomAnnee, int amortissement) {
		this.possede = possede;
		this.taille = taille;
		this.kilomAnnee = kilomAnnee;
		this.amortissement = amortissement;
		calcul();
	}
	
	//Getters et setters
	public void setPossede(boolean possede) {
		this.possede = possede;
		calcul();
	}
	
	public void setTaille(Taille taille) {
		this.taille = taille;
		calcul();
	}
	
	public void setKilomAnnee(int kilomAnnee) {
		this.kilomAnnee = kilomAnnee;
		calcul();
	}
	
	public void setAmortissement(int amortissement) {
		this.amortissement = amortissement;
		calcul();
	}
	
	public boolean getpossede() {
		return possede;
	}
	
	public Taille gettaille() {
		return taille;
	}

	public int getkilomAnnee() {
		return kilomAnnee;
	}
	
	public int getamortissement() {
		return amortissement;
	}
	
	public double getimpact() {
		return impact;
	}
	
	@Override
	public double getobjectif() {
		return objectif;
	}
	
	//Suite
	private void calcul() {
		if (possede == false) 
			impact = 0;
		else {
			if (kilomAnnee != -1 && amortissement != -1 && taille != null) 
				this.impact = kilomAnnee * 1.93 * 0.0001 + (taille.getImpactTaille() / amortissement);
		}
	}
	
	@Override
	public String toString() {
		return "La voiture est de taille " + gettaille() + ", la distance parcourue est " + getkilomAnnee() +  " kilometres et l'amortissement se fait sur " + getamortissement() + " annees. Son impact est de " + getimpact() + " tCO2eq.";
	}
	
	public static void main(String[] args) {
		Transport T1 = new Transport(true, Taille.P, 10000, 10);
		System.out.println(T1.impact);
	}

}
