package tests;

import static org.junit.Assert.assertFalse;
import modele.Condition;

import org.junit.Test;

public class TestCondition {

	@Test
	public void testDeuxOperateursDeSuite(){
		
		assertFalse(Condition.isValid("lol =< 12"));
	}
	
	@Test
	public void testTroisOperateursDeSuite(){
		assertFalse(Condition.isValid("lol =<> 789"));
	}
	
	
}
