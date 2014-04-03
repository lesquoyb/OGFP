package modele.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import modele.FichePaie;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public abstract class DAO<Exemple> {

	protected String adresseFichier;
	
	protected Document doc;

	protected Element racine ;
	
	
	/**
	 * Compare un élement de la liste avec un objet metier, retourne true s'ils sont identiques
	 * @param elem
	 * @param exemple
	 * @return
	 */
	protected abstract boolean compare(Element elem, Exemple exemple);
	
	/**
	 * Ouvre le fichier et initialise la racine.
	 */
	protected void ouvrirFichier(){
	     doc = null;
	 
		SAXBuilder sxb = new SAXBuilder();
	      try
	      {
	         doc = sxb.build(new File(adresseFichier));
	      }
	      catch(Exception e){
	    	  System.out.println(e);
	      }
	    racine = doc.getRootElement();
	}

	/**
	 * Enregistre le <b>doc</b> dans le fichier XML.
	 * @param fichier
	 * @param doc
	 */
	protected void enregistre()
	{
		try
		{
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			sortie.output(doc, new FileOutputStream(adresseFichier));
		}
		catch (java.io.IOException e){}
	}
	
	/**
	 * Retourne la liste d'élements contenu dans le fichier.
	 * @return
	 */
	public ArrayList<Exemple> lireFichier(){
		return convertieListe(racine.getChildren());
	};
	
	/**
	 * Créé la liste des attributs d'un élement afin de pouvoir l'ajouter à un fichier XML.
	 * @param exemple
	 * @return
	 */
	protected abstract ArrayList<Element> creationListe(Exemple exemple);
	
	/**
	 * Ajoute un élément dans le fichier.
	 * @param exemple
	 */
	public void ajouter(Exemple exemple) {
		
		Exemple base = getElementBase();
		if (!exemple.equals(base)){
			for(Element element : creationListe(exemple)){
				racine.addContent(element);
				enregistre();	
			}
		}	
	}
	
	/**
	 * Retourne un objet de classe <b>Exemple</b> construit avec le constructeur de base (sans paramètre).
	 * @return
	 */
	protected abstract Exemple getElementBase();

	public void viderFichier(){
		for(Exemple e : lireFichier()){
			supprimerElement(e);
		}
	}
	
	/**
	 * Convertie une liste d'élements tirées du fichier XML en une liste d'objets metier.
	 * @param liste
	 * @return
	 */
	protected abstract ArrayList<Exemple> convertieListe(List<Element> liste);
	
	
	/**
	 * Supprime un élément du fichier.
	 * @param exemple
	 */
	public void supprimerElement(Exemple exemple) {
		String nom = exemple.getClass().getName().substring(7).toLowerCase();
		List<Element>liste = racine.getChildren(nom);
		for(Element e : racine.getChildren(nom) ){
			if (compare(e,exemple)){
				racine.getChildren().remove(e);
				enregistre();
				break;
			}
		}
	}
	
	
	public String getAdresseFichier() {
		return adresseFichier;
	}

	public void ajouter(ArrayList<Exemple> liste){
		if (liste.size() != 0){
			for(Exemple e : liste){
				ajouter(e);
			}
		}

	}
	
	/**
	 * change l'adresse du fichier et le réouvre.
	 * @param adresseFichier
	 */
	public void setAdresseFichier(String adresseFichier) {
		this.adresseFichier = adresseFichier;
		ouvrirFichier();
	}
}
