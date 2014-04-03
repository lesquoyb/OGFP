package tests;

import static org.junit.Assert.*;
import modele.Brut;
import modele.exception.ExceptionChampVide;
import modele.exception.brut.ExceptionBrutNegatif;
import modele.exception.brut.ExceptionBrutString;

import org.junit.Test;

public class TestBrut {

	@Test
	public void testBrutValide() throws ExceptionBrutNegatif {

			assertTrue(Brut.isValid(12));
	}
	
	@Test (expected = ExceptionChampVide.class)
	public void testBrutVide() throws ExceptionBrutNegatif, ExceptionBrutString, ExceptionChampVide{
		
		Brut.isValid("");
	}
	
	
	@Test (expected = ExceptionChampVide.class)
	public void testBrutEspaces() throws ExceptionBrutNegatif, ExceptionBrutString, ExceptionChampVide{
	
		Brut.isValid("   ");
	}
	
	@Test ()
	public void testBrutChaineValide() throws ExceptionBrutNegatif, ExceptionBrutString, ExceptionChampVide{
		
			assertTrue(Brut.isValid("12"));
	}

	@Test
	public void testBrutDecimal() throws ExceptionBrutNegatif{
		
		assertTrue(Brut.isValid(10.55555));
	}
	
	@Test(expected= ExceptionBrutString.class)
	public void testBrutChaineNonValide() throws ExceptionBrutNegatif, ExceptionBrutString, ExceptionChampVide{
		
		Brut.isValid("lol");
	}

	@Test (expected = ExceptionBrutNegatif.class)
	public void testBrutDoubleInferieur0() throws ExceptionBrutNegatif{
		
		Brut.isValid(-10);
	}


}
