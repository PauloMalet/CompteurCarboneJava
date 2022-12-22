package testPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import consoCarbone.Alimentation;

class AlimentationTest {
    Alimentation alimentation = new Alimentation(0.5,0.3);
    
    @Test 
    public void testgettxBoeuf() {
		double actual=alimentation.gettxBoeuf();
		if (actual<=1 && actual>=0) {
			System.out.println("txBoeuf est ok");
		}
		double expected=0.5;
		assertEquals(expected, actual);
	}
    
    @Test 
    public void testgettxVege() {
		double actual=alimentation.gettxVege();
		double somme = alimentation.gettxVege()+alimentation.gettxBoeuf();
		if (actual<=1 && actual>=0 && somme<=1) {
			System.out.println("txVege est ok");
		}
		double expected=0.3;
		assertEquals(expected, actual);
	}
    
    @Test 
    public void testCalcul() {
    	//8* txBoeuf + 1.6 * (1-txVege-txBoeuf) + 0.9 * txVege
    	double expected = 4.59;
    	double actual= alimentation.getImpact();
    	assertEquals(expected, actual,0.01);
    }
    
	@Test
	public void testToString() {
		String res_attendu= "Le taux de repas avec du boeuf est 0.5, celui de repas vege est 0.3 et l'impact est 4.59";
		assertEquals(res_attendu, alimentation.toString());
	
		
	}
}
