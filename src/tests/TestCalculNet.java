package tests;

import static org.junit.Assert.assertTrue;
import modele.Cotisation;
import modele.exception.cotisation.ExceptionNomContientCaractereSpe;
import modele.exception.cotisation.ExceptionNomInvalide;
import modele.exception.cotisation.ExceptionNomNombre;
import modele.exception.cotisation.ExceptionNomVide;
import modele.exception.cotisation.ExceptionTauxCotisationNegatif;
import modele.exception.cotisation.ExceptionTauxCotisationString;
import modele.exception.cotisation.ExceptionTauxSupUn;
import modele.exception.cotisation.ExceptionTauxVide;

import org.junit.Test;

public class TestCalculNet {
	
	@Test
	public void testCotisationTrue() throws ExceptionNomContientCaractereSpe, ExceptionTauxCotisationString, ExceptionTauxSupUn, ExceptionTauxCotisationNegatif, ExceptionNomVide, ExceptionTauxVide, ExceptionNomNombre, ExceptionNomInvalide {
		assertTrue(Cotisation.isValid("Retraite" , "0.05"));
	}
	
	@Test(expected = ExceptionNomContientCaractereSpe.class)
	public void testCotisationFalseMauvaisNom() throws ExceptionNomContientCaractereSpe, ExceptionTauxCotisationString, ExceptionTauxSupUn, ExceptionTauxCotisationNegatif, ExceptionNomVide, ExceptionTauxVide, ExceptionNomNombre, ExceptionNomInvalide {
		Cotisation.isValid("*ù$¤", "0.05");
	}
	
	
	 @Test (expected = ExceptionNomNombre.class)
	public void testCotisationFalseNomEntier() throws ExceptionNomContientCaractereSpe, ExceptionTauxCotisationString, ExceptionTauxSupUn, ExceptionTauxCotisationNegatif, ExceptionNomVide, ExceptionTauxVide, ExceptionNomNombre, ExceptionNomInvalide {
		Cotisation.isValid("2", "0.05");
	}
	
	
	@Test (expected = ExceptionTauxCotisationNegatif.class)
	public void testCotisationFalseTauxNegatif() throws ExceptionNomContientCaractereSpe, ExceptionTauxCotisationString, ExceptionTauxSupUn, ExceptionTauxCotisationNegatif, ExceptionNomVide, ExceptionTauxVide, ExceptionNomNombre, ExceptionNomInvalide {
		Cotisation.isValid("Retraite", "-0.05");
	}
	
	@Test (expected = ExceptionTauxSupUn.class)
	public void testCotisationFalseTauxSuperieurAUn() throws ExceptionNomContientCaractereSpe, ExceptionTauxCotisationString, ExceptionTauxSupUn, ExceptionTauxCotisationNegatif, ExceptionNomVide, ExceptionTauxVide, ExceptionNomNombre, ExceptionNomInvalide {
		Cotisation.isValid("Retraite", "10");
	}
	
	@Test (expected = ExceptionTauxCotisationNegatif.class)
	public void testCotisationFalseTauxNul() throws ExceptionNomContientCaractereSpe, ExceptionTauxCotisationString, ExceptionTauxSupUn, ExceptionTauxCotisationNegatif, ExceptionNomVide, ExceptionTauxVide, ExceptionNomNombre, ExceptionNomInvalide {
		Cotisation.isValid("Retraite", "0");
	}
	
	@Test (expected = ExceptionNomVide.class)
	public void testCotisationNomVide() throws ExceptionNomContientCaractereSpe, ExceptionTauxCotisationString, ExceptionTauxSupUn, ExceptionTauxCotisationNegatif, ExceptionNomVide, ExceptionTauxVide, ExceptionNomNombre, ExceptionNomInvalide{
		
		Cotisation.isValid("", "12");
	}
	
	@Test (expected = ExceptionTauxVide.class)
	public void testCotisationTauxVide() throws ExceptionNomContientCaractereSpe, ExceptionTauxCotisationString, ExceptionTauxSupUn, ExceptionTauxCotisationNegatif, ExceptionNomVide, ExceptionTauxVide, ExceptionNomNombre, ExceptionNomInvalide{
		
		Cotisation.isValid("lolilol", "");
	}
	
	
	@Test (expected = ExceptionTauxVide.class)
	public void testCotisationTauxEspaces() throws ExceptionNomContientCaractereSpe, ExceptionTauxCotisationString, ExceptionTauxSupUn, ExceptionTauxCotisationNegatif, ExceptionNomVide, ExceptionTauxVide, ExceptionNomNombre, ExceptionNomInvalide{
		
		Cotisation.isValid("lolilol", "    ");
	}
}
