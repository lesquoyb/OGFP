package modele.dao;

import java.util.ArrayList;
import java.util.List;

import modele.Action;
import modele.Condition;
import modele.Regle;

import org.jdom2.Attribute;
import org.jdom2.Element;

public class DAORegle extends DAO<Regle> {

	public DAORegle(){
		adresseFichier = "./src/modele/dao/fichier/regles.xml";
		ouvrirFichier();
	}
	
	@Override
	protected boolean compare(Element elem, Regle exemple) {
		if(exemple.getCondition().toString().equals(elem.getAttributeValue("Condition"))){
			if (exemple.getAction().toString().equals(elem.getAttributeValue("Action"))){
				return true;
			}
		}
		return false;
	}

	@Override
	protected ArrayList<Regle> convertieListe(List<Element> liste){
		ArrayList<Regle> listeRetour = new ArrayList<Regle>();
		for (Element e : liste){
			String cond = e.getAttributeValue("Condition");
			String action = e.getAttributeValue("Action");
			if (Condition.isValid(cond) && Action.isValid(action)){
				Condition c = new Condition(cond);
				Action a = new Action(action);
				listeRetour.add(new Regle(c,a));
			}
		}
		return listeRetour;
		
	}
	
	@Override
	protected ArrayList<Element> creationListe(Regle exemple) {
		
		ArrayList<Element>listeRetour = new ArrayList<Element>();
		Element regle = new Element("regle");
		regle.setAttribute(new Attribute("Action", exemple.getAction().toString()));
		regle.setAttribute(new Attribute("Condition", exemple.getCondition().toString()));
		listeRetour.add(regle);
		return listeRetour;
	}

	@Override
	protected Regle getElementBase() {
		return new Regle();
	}

}
