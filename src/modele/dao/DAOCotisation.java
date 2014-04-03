package modele.dao;
import java.util.ArrayList;
import java.util.List;

import modele.Cotisation;

import org.jdom2.Attribute;
import org.jdom2.Element;


public class DAOCotisation extends DAO<Cotisation> {
	


	/**
	 * initialise les variables et ouvre le document.
	 */
	public DAOCotisation(){
		
		adresseFichier = "./src/modele/dao/fichier/cotisations.xml";
		ouvrirFichier();
	}

	/**
	 * Convertie une liste d'elements XML en une liste de Cotisations
	 * @param liste
	 * @return
	 */
	@Override
	protected ArrayList<Cotisation> convertieListe(List<Element> liste){
		ArrayList<Cotisation> listeRetour = new ArrayList<Cotisation>();
		for(Element e : liste){
			String nom = e.getAttributeValue("nom");
			double taux = Double.parseDouble(e.getAttributeValue("taux"));
			listeRetour.add(new Cotisation(nom,taux ));
		}
		return listeRetour;
	}
	

	@Override
	protected ArrayList<Element> creationListe(Cotisation cotisation){
		Attribute nom = new Attribute("nom", cotisation.getNom());
		Attribute taux = new Attribute("taux",String.valueOf(cotisation.getTaux()));
		ArrayList<Element>liste = new ArrayList<Element>();
		Element elem = new Element("cotisation");
		elem.setAttribute(nom);
		elem.setAttribute(taux);
		liste.add(elem);
		return liste;
	}

	@Override
	protected boolean compare(Element elem, Cotisation exemple) {
		return (elem.getAttributeValue("nom").equals(exemple.getNom())       
				&&  (elem.getAttributeValue("taux").equals( String.valueOf( exemple.getTaux() ) ) ));
	}
	
	
	@Override
	protected Cotisation getElementBase() {
		return new Cotisation();
	}



	
	

	
}
