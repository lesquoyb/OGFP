package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import modele.*;

import org.junit.Test;

public class TestRegle {
	

	
	@Test
	public void testVariableTrue(){
		
		assertTrue(Variable.isValid("TrancheA"));
	}
	

	
	@Test
	public void testVariableAvecCaracteresSpeciaux(){
		
		assertFalse(Variable.isValid("variable,,,,fqsdfqs"));
	}
	
	@Test 
	public void testVariableFalse(){
		
		assertFalse(Variable.isValid("12"));
	}
	
	@Test
	public void testExpressionTexteFalse() {
		
		assertFalse(Regle.isValid("toto"));
	}
		

	@Test
	public void testRegleSimpleValeurEntier() {
		
		assertTrue(Regle.isValid("Brut > 3200/TrancheA = 4200"));
	}
	
	@Test
	public void testRegleSimpleValeurReel() {
		
		assertTrue(Regle.isValid("Net < 1600.50/TrancheB = 1500.42"));
	}
	
	@Test
	public void testRegleSimpleValeurCombinaisonReelEntier() {

		assertTrue(Regle.isValid("Net < 550/TrancheC=500.12"));
	}
	
	@Test
	public void testRegleVariableEntier() {

		assertFalse(Regle.isValid("500 < 900/1000=200"));
	}
	
	@Test
	public void testRegleVariableReel() {

		assertFalse(Regle.isValid("25.2 > 20/3.2 = 5"));
	}
	
	@Test
	public void testRegleVariableOperateur() {

		assertFalse(Regle.isValid("= < 2/+ = 6"));
	}
	
	
	@Test
	public void testRegleOperateurEntier() {

		assertFalse(Regle.isValid("statut 50 3/Tranche 36 78"));
	}
	

	@Test
	public void testRegleOperateurReel() {

		assertFalse(Regle.isValid("statut 2.2 6/Pce 5.5 46"));
	}
	
	@Test
	public void testRegleOperateurChaine() {
		
		assertFalse(Regle.isValid("statut superieur 3/RCP egal 6"));
	}
	
	
	@Test
	public void testRegleValeurChaine() {

		assertFalse(Regle.isValid("statut = cinquante/TrancheZ = quarante"));
	}
	
	@Test
	public void testRegleValeurOperateur() {

		assertFalse(Regle.isValid("statut = +/TrancheW = -"));
	}
	
	@Test
	public void testReglePlusQueTroisComposantes() {
		
		assertFalse(Regle.isValid("statut = 50 blabla 30/TrancheA = 200 blablabla"));
	}
		
	
	
}