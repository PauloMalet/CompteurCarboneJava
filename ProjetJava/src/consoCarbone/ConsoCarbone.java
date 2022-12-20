package consoCarbone;

public abstract class ConsoCarbone implements Comparable<ConsoCarbone>{
	public double impact;
	private static int id;
	static double objectif;
	
	//Constructeurs
	public ConsoCarbone() {
		ConsoCarbone.id++;
	} 
	
	//Getters et setters
	public double getimpact() {
		return impact;
		
	}
	
	public int getid() {
		return ConsoCarbone.id;
	}
	
	public void setid(int id) {
		ConsoCarbone.id = id;
	}
	
	//Suite
	@Override
	public int compareTo(ConsoCarbone CC) {
		if (this.getimpact() > CC.getimpact()) {
			return 1;
		}
		if (this.getimpact() < CC.getimpact()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	@Override
	public abstract String toString();
	
	public double getobjectif() {
		return objectif;
	}
	
	public static void main(String[] args) {
	}

	
}
