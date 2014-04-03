package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import modele.Action;
import modele.Condition;
import modele.Operateur;
import modele.Regle;
import modele.dao.DAORegle;

import org.junit.Test;

public class TestDAORegle {

	
	DAORegle regle = new DAORegle();
	
	
	public TestDAORegle(){
		regle.setAdresseFichier("./src/modele/dao/fichier/testEcritureRegleXML");
	}
	
	@Test
	public void testLecture() {

		regle.setAdresseFichier("./src/modele/dao/fichier/testLectureRegleXML");
		ArrayList<Regle>liste = regle.lireFichier();
		Regle reg = new Regle(new Condition("Brut","3200",new Operateur(">")),new Action("TrancheA = 4200"));
		assertTrue(liste.get(0).equals(reg));
	}

	@Test
	public void testEcriture(){
		
		Regle reg = new Regle(new Condition("Net","5000",new Operateur("<")), new Action("TrancheA = 9000"));
		regle.ajouter(reg);
		ArrayList<Regle> liste = regle.lireFichier();
		regle.supprimerElement(reg);
		assertTrue(liste.get(liste.size()-1).equals(reg));
	}
	
	@Test
	public void testSuppression(){

		Regle reg = new Regle(new Condition("Net","5000",new Operateur("<")), new Action("TrancheA = 9000"));
		regle.ajouter(reg);
		regle.supprimerElement(reg);
		ArrayList<Regle> liste = regle.lireFichier();
		assertTrue(liste.size()==0);
	}
	
}
