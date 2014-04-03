package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import modele.Cotisation;
import modele.dao.DAOCotisation;

import org.junit.Test;

public class TestDAOCotisation {


	DAOCotisation cotis = new DAOCotisation();
	
	public TestDAOCotisation(){
		cotis.setAdresseFichier("./src/modele/dao/fichier/testEcritureCotisationXML");
	}
	
	
	@Test
	public void testLecture() {
		
		cotis.setAdresseFichier("./src/modele/dao/fichier/testLectureCotisationXML");
		ArrayList<Cotisation>liste = cotis.lireFichier();
		Cotisation cotisation = new Cotisation("Retraite",.2);
		assertTrue(liste.get(0).equals(cotisation));
	}
	
	
	@Test
	public void testEcriture(){
		
		Cotisation cot = new Cotisation("Test",0.6);
		cotis.ajouter(cot);
		ArrayList<Cotisation> liste = cotis.lireFichier();
		cotis.supprimerElement(cot);
		assertTrue(liste.get(liste.size()-1).equals(cot));
	}
	
	@Test
	public void testSuppression(){
		Cotisation cot = new Cotisation("LOL",0.9);
		cotis.ajouter(cot);
		cotis.supprimerElement(cot);
		ArrayList<Cotisation> liste = cotis.lireFichier();
		assertTrue(liste.size()==0);
	}
	
}
