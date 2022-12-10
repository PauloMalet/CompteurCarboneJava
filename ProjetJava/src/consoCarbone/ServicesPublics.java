package consoCarbone;

public class ServicesPublics  {
	
	private double impact = 1.5;
	
	public ServicesPublics() {
	}
	
	public double getimpact() {
		return impact;
	}
	
	@Override
	public String toString() {
		return "L'empreinte carbone due aux services publics est de " + impact + " tonnes de CO2eq";
	}
	
	public static void main(String[] args) {
	}

}
