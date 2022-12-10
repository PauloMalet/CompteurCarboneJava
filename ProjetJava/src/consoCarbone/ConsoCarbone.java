package consoCarbone;

public abstract class ConsoCarbone implements Comparable{
	public double impact;
	private static int id;
	
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
		
	public String compareTo(ConsoCarbone CC) {
		if (this.getimpact() > CC.getimpact()) {
			return (this + " a un impact supÃ©rieur Ã  " + CC);
		}
		if (this.getimpact() < CC.getimpact()) {
			return (CC + " a un impact supÃ©rieur Ã  " + this);
		}
		else {
			return (this + " et " + CC + " ont le mÃªme impact");
		}
	}
	
	@Override
	public abstract String toString();
	
	public static void main(String[] args) {
	}

	
}
