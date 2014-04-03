package tests;

import static org.junit.Assert.*;
import modele.Operateur;

import org.junit.Test;

public class TestOperateur {
	
	private Operateur inferieur = new Operateur("<");
	private Operateur inferieurEgal = new Operateur("<=");
	private Operateur superieur = new Operateur(">");
	private Operateur egal = new Operateur("=");

	
	@Test
	public void testOperateurTrue(){
		
		assertTrue(Operateur.isValid("="));
	}
	
	@Test
	public void testOperateurFalse(){
		
		assertFalse(Operateur.isValid("egal")); 
	}
	
	@Test
	public void testOperateurTrueAvecEspaces(){
		
		assertTrue(Operateur.isValid(" =  "));
	}
	
	@Test
	public void comparaisonDoublesTrue() {
		
		assertTrue(inferieurEgal.resultatOperation(12, 50));
	}
	
	@Test
	public void comparaisonDoubleFalse(){
		
		assertFalse(superieur.resultatOperation(12, 50));
	}
	
	@Test
	public void comparaisonStringTrueAvecNombre(){
		
		assertTrue(inferieur.resultatOperation("12","50"));
	}
	
	@Test
	public void comparaisonStringTrue(){
		
		assertTrue(egal.resultatOperation("coucou","coucou"));
	}
	

	@Test
	public void comparaisonStringFalse(){
		
		assertFalse(egal.resultatOperation("bonjour","bonsoir"));
	}

}
