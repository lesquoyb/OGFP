package tests;

import static org.junit.Assert.*;
import modele.ListeVariable;

import org.junit.Test;

public class TestListeVariable {

	@Test
	public void testContientTrue() {
		
		ListeVariable l = new ListeVariable();
		l.ajouter("Brut", "12");
		assertTrue(l.contientClef("Brut"));
	}
	
	@Test
	public void testContientFalse() {
		
		ListeVariable l = new ListeVariable();
		assertFalse(l.contientClef("Brut"));
	}


	@Test
	public void testgetValeurs() {

		ListeVariable l = new ListeVariable();
		l.ajouter("Brut", "12");
		assertTrue("12".equals(l.getValeurs().get(0)));
	}

	@Test
	public void testViderTable() {

		ListeVariable l = new ListeVariable();
		l.ajouter("Brut", "12");
		l.viderTable();
		assertEquals(0,l.getValeurs().size());
	}

	
}
