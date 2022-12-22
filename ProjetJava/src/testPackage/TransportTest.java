package testPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import consoCarbone.Taille;
import consoCarbone.Transport;


class TransportTest {

	Transport transport = new Transport(true, Taille.P,15000,5);
	
	@Test 
	public void testgetpossede() {
		boolean actual= transport.getpossede();
		if (actual==true || actual==false) {
			System.out.println("possede est ok");
		}
		boolean expected=true;
		assertEquals(expected, actual);
	}
	
	@Test 
	public void testgetTaille() {
		Taille actual= transport.gettaille();
		if (transport.getpossede()==true) {
		if (actual==Taille.P || actual==Taille.G) {
			System.out.println("taille est ok");
		}
		Taille expected=Taille.P;
		assertEquals(expected, actual);}
	}
	
	@Test 
	public void testgetKilomAnnee() {
		double actual= transport.getkilomAnnee();
		if (transport.getpossede()==true && actual>=0) {
		System.out.println("kilomAnne est ok");}
		
		double expected=15000;
		assertEquals(expected, actual,0.1);
	}
	
	@Test 
	public void testgetAmortissement() {
		double actual= transport.getamortissement();
		if (transport.getpossede()==true && actual>=0) {
			
		System.out.println("Amortissement est ok");}
		
		double expected=5;
		assertEquals(expected, actual,0.1);
	}
	
	@Test 
    public void testCalcul() {
    	//(kilomAnnee × 1.93 × 10−4 + fabrication/amortissement)
    	double expected = 3.735;
    	double actual= transport.getimpact();
    	assertEquals(expected, actual, 0.001);
    }
	
	@Test
	public void testToString() {
		String res_attendu= "La voiture est de taille P la distance parcourue est 15000 kilometres et l'amortissement est 5 ans. Son impact est 3.7350000000000003";
		assertEquals(res_attendu, transport.toString());
		
	}
 
}
