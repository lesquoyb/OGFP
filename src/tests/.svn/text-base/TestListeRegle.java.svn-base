package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import modele.Action;
import modele.Condition;
import modele.ListeRegle;
import modele.Operateur;
import modele.Regle;
import modele.Variable;

import org.junit.Test;

public class TestListeRegle {

	@Test
	public void testCreationRegleVide() {
	
		ListeRegle l = new ListeRegle();
		l.creationRegle();
		Regle c = new Regle();
		assertTrue(l.getRegles().get(0).equals(c));
	}
	
	@Test
	public void testInitialiseListeTrue() {
	
		ArrayList<Regle> liste = new ArrayList<Regle>();
		liste.add(new Regle());
		liste.add(new Regle(new Condition("Brut","12",new Operateur("<")),new Action(new Variable("Brut"), 1000)));
		ListeRegle l = new ListeRegle(liste);
		assertTrue(l.getRegles().equals(liste));
	}	
	
}
