package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import modele.Action;
import modele.Condition;
import modele.Cotisation;
import modele.Employe;
import modele.FichePaie;
import modele.ListeCotisation;
import modele.ListeRegle;
import modele.Operateur;
import modele.Regle;
import modele.dao.DAOPaie;

import org.junit.Before;
import org.junit.Test;

public class TestDAOPaie {
	
	
	private DAOPaie paie= new DAOPaie();
	private FichePaie fich;
	
	@Before
	public void initTest(){

		ArrayList<Cotisation>listeCotis = new ArrayList<Cotisation>();
		listeCotis.add(new Cotisation("retraite", .5));
		ArrayList<Regle> regles = new ArrayList<Regle>();
		regles.add(new Regle(new Condition("Net < 1000 "), new Action("biere = 540")));
		ListeCotisation listeCotisation =new ListeCotisation(listeCotis);
		listeCotisation.creationCotisationVide();
		ListeRegle listeRegle = new ListeRegle(regles);
		listeRegle.creationRegle();
		fich = new FichePaie(listeCotisation,listeRegle, new Employe("baptiste","lesquoy","maitre du monde",999999999.99));
		
		paie.setAdresseFichier("./src/modele/dao/fichier/testEcriturePaie.xml");
	}
	
	@Test
	public void testLecture() {

		paie.setAdresseFichier("./src/modele/dao/fichier/testLecturePaie.xml");
		ArrayList<Cotisation>listeCotis = new ArrayList<Cotisation>();
		listeCotis.add(new Cotisation("taxe au pif", .5));
		ArrayList<Regle> regles = new ArrayList<Regle>();
		regles.add(new Regle(new Condition("Net < 1000 "), new Action("bar= 600")));
		ListeCotisation listeCotisation =new ListeCotisation(listeCotis);
		listeCotisation.creationCotisationVide();
		ListeRegle listeRegle = new ListeRegle(regles);
		listeRegle.creationRegle();
		ArrayList<FichePaie>liste = paie.lireFichier();
		FichePaie fichePaie = new FichePaie(listeCotisation,listeRegle, new Employe("baptiste","lesquoy","maitre du monde",999999999.99));
		assertTrue(liste.get(0).equals(fichePaie));
	}

	@Test
	public void testEcriture(){
		paie.ajouter(fich);
		ArrayList<FichePaie> liste = paie.lireFichier();
		paie.supprimerElement(fich);
		assertTrue(liste.get(liste.size()-1).equals(fich));
	}
	
	@Test
	public void testSuppression(){

		paie.ajouter(fich);
		paie.supprimerElement(fich);
		ArrayList<FichePaie> liste = paie.lireFichier();
		assertTrue(liste.size()==0);
	}

}
