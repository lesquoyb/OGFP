package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import modele.Cotisation;
import modele.ListeCotisation;

import org.junit.Test;

public class TestListeCotisation {

	@Test
	public void testCreationCotisationVide() {
	
		ListeCotisation l = new ListeCotisation();
		l.creationCotisationVide();
		Cotisation c = new Cotisation();
		assertTrue(l.getCotisations().get(0).equals(c));
	}
	
	@Test
	public void testInitialiseListeTrue() {
	
		ArrayList<Cotisation> liste = new ArrayList<Cotisation>();
		liste.add(new Cotisation());
		liste.add(new Cotisation("coucou", 0.2));
		ListeCotisation l = new ListeCotisation(liste);
		assertTrue(l.getCotisations().equals(liste));
	}	
	

}
