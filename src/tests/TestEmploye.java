package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import modele.Employe;
import modele.exception.ExceptionChampVide;
import modele.exception.brut.ExceptionBrutNegatif;
import modele.exception.brut.ExceptionBrutString;
import modele.exception.cotisation.ExceptionNomContientCaractereSpe;
import modele.exception.nom.ExceptionNomContientChiffre;

import org.junit.Test;

public class TestEmploye {
	
	
	
	@Test
	public void testNomTrue() throws ExceptionChampVide, ExceptionNomContientCaractereSpe, ExceptionNomContientChiffre {
		assertTrue (Employe.isValidNom("Maxime"));
	}
	
	/*@Test
	public void testNomAvecChiffreFalse() throws ExceptionChampVide, ExceptionNomContientCaractereSpe, ExceptionNomContientChiffre {
		assertFalse (Employe.isValidNom("Maxime2"));
	}
	
	@Test
	public void testNomAvecCaractereSpeciauxFalse() throws ExceptionChampVide, ExceptionNomContientCaractereSpe, ExceptionNomContientChiffre{
		assertFalse (Employe.isValidNom("Maxime/"));
	}*/
	
	@Test
	public void testSalaireTrue() throws ExceptionChampVide, ExceptionNomContientCaractereSpe, ExceptionNomContientChiffre, ExceptionBrutNegatif, ExceptionBrutString {
		assertTrue (Employe.isValid(new Employe("Louis", "Maxime", "cadre", 3000.0 )));
	}

}
