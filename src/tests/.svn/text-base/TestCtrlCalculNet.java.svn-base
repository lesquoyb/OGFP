package tests;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import modele.Action;
import modele.Condition;
import modele.Cotisation;
import modele.ListeVariable;
import modele.Operateur;
import modele.Regle;
import modele.exception.condition.ExceptionComparaisonString;
import modele.exception.variable.ExceptionVariableInexistante;

import org.junit.Test;

import controleur.CtrlCalculNet;

public class TestCtrlCalculNet {

	
	private CtrlCalculNet controleur;
	private Method calculMontant;
	
	
	public TestCtrlCalculNet(){
		ListeVariable l = new ListeVariable();
		l.ajouter("Brut", "1000");
		l.ajouter("Text", "text");
		controleur = new CtrlCalculNet();
		controleur.setListeVar(l);
	}


	@Test
	public void testEstRespecteeRegleValide() throws ExceptionVariableInexistante, ExceptionComparaisonString{

		assertTrue(controleur.estRespectee(new Regle(new Condition("Brut","100",new Operateur(">")), new Action("Brut=1"))));
	}
	
	@Test (expected = ExceptionComparaisonString.class)
	public void testEstRespecteeRegleInvalide() throws ExceptionVariableInexistante, ExceptionComparaisonString{
		controleur.estRespectee(new Regle(new Condition("Text","lol",new Operateur("<=")),
					            new Action("Brut=2")));
	}
	
	@Test (expected = ExceptionVariableInexistante.class)
	public void testEstRespecteeRegleUtilisantVariablesInconnues() throws ExceptionVariableInexistante, ExceptionComparaisonString{
		controleur.estRespectee(new Regle(new Condition("Breutelles","100",new Operateur(">")), new Action("Brut=1")));
	}
}
