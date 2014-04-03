package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import modele.Action;

import org.junit.Test;

public class TestAction {

	
	@Test
	public void testPartieGaucheInt(){
		
		assertFalse(Action.isValid("3541651 = 12"));
	}
	
	@Test
	public void testTroisParties(){
		
		assertFalse(Action.isValid("Brut haha 12"));
	}
	
	@Test
	public void testTroisPartiesAvecSignesSpeciaux(){
		
		assertFalse(Action.isValid("Brut !'( 12"));
	}
	
	
	@Test
	public void testPartieDroiteString(){
		
		assertFalse(Action.isValid("Brut= lol"));
	}
	

	@Test
	public void testPartieDroiteNegative(){
		
		assertTrue(Action.isValid("Brut= -500"));
	}
	
	@Test
	public void testPartieDroiteNegativeEtEspace(){
		
		assertTrue(Action.isValid("Brut= - 500"));
	}
	
	@Test
	public void testActionDeuxEgals(){
		
		assertFalse(Action.isValid("Brut == 12"));
	}
	
	@Test
	public void testActionDeuxEgalsAvecEspace(){
		
		assertFalse(Action.isValid("Brut =  = 12"));
	}

	@Test
	public void testActionUniquementEgal(){
		assertFalse(Action.isValid("="));
	}
	
	@Test
	public void testActionUniquementPartieDroite(){
		assertFalse(Action.isValid("=321"));
	}
	
	@Test
	public void testActionUniquementPartieGauche(){
		assertFalse(Action.isValid("Brut="));
	}
	
	@Test
	public void testActionTrue(){
		
		assertTrue(Action.isValid("Brut = 3"));
	}
	
	@Test
	public void testActionTrueDecimale(){
		
		assertTrue(Action.isValid("Brut = 3.2626"));
	}
	
}
