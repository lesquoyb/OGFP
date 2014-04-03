package modele.dao;

import java.util.ArrayList;
import java.util.List;

import modele.Action;
import modele.Condition;
import modele.Cotisation;
import modele.Employe;
import modele.FichePaie;
import modele.ListeCotisation;
import modele.ListeRegle;
import modele.Regle;
import modele.exception.cotisation.ExceptionNomContientCaractereSpe;
import modele.exception.cotisation.ExceptionNomInvalide;
import modele.exception.cotisation.ExceptionNomNombre;
import modele.exception.cotisation.ExceptionNomVide;
import modele.exception.cotisation.ExceptionTauxCotisationNegatif;
import modele.exception.cotisation.ExceptionTauxCotisationString;
import modele.exception.cotisation.ExceptionTauxSupUn;
import modele.exception.cotisation.ExceptionTauxVide;

import org.jdom2.Attribute;
import org.jdom2.Element;

public class DAOPaie extends DAO<FichePaie> {
	
	

	public DAOPaie() {
		adresseFichier = "./src/modele/dao/fichier/paie.xml";
		ouvrirFichier();
	}

	@Override
	protected boolean compare(Element elem, FichePaie exemple) {
		List<Element> cotisations = new ArrayList<Element>();
		for (Element element : elem.getChildren("cotisations")){
			for(Element e : element.getChildren("cotisation")){
				cotisations.add(e);
			}
		}
		List<Element> regles = new ArrayList<Element>();
		for (Element element : elem.getChildren("regles")){
			for(Element e : element.getChildren("regle")){
				regles.add(e);
			}
		}
		int i = 0;
		for(Element elements : cotisations){
			for(Element element : elements.getChildren()){
				if ( ! element.getAttributeValue("nom").equals(exemple.getCotisations().getCotisations().get(i).getNom())       
						&&  (! element.getAttributeValue("taux").equals( String.valueOf( exemple.getCotisations().getCotisations().get(i).getTaux() ) ))){
							return false;
						}
				i++;
			}

		}
		
		i =0;
		for(Element elements : regles){
			for (Element element : elements.getChildren()){
				if(!exemple.getRegles().getRegles().get(i).getCondition().toString().equals(element.getAttributeValue("Condition"))){
					if ( ! exemple.getRegles().getRegles().get(i).getAction().toString().equals(element.getAttributeValue("Action"))){
						return false;
					}
				}
				i++;				
			}

		}
		Element employe = elem.getChild("employe");
		if (employe == null){
			return false;
		}
		else{
			return (employe.getAttributeValue("nom").equals(exemple.getEmploye().getNom()					)
					&&	employe.getAttributeValue("prenom").equals(exemple.getEmploye().getPrenom() 		)
					&&	Double.parseDouble(employe.getAttributeValue("salaireBrut")) == (exemple.getEmploye().getSalaireBrut()		)
					&&	Double.parseDouble(employe.getAttributeValue("salaireNet")) == (exemple.getEmploye().getSalaireNet()		)
					&&	employe.getAttributeValue("statut").equals(exemple.getEmploye().getStatut()			)
					); 
		}

	}



	@Override
	protected ArrayList<Element> creationListe(FichePaie exemple) {
		Element employe = new Element("employe");
		Element cotisations = new Element("cotisations");
		Element regles = new Element ("regles");
		Element fiche = new Element("fichepaie");
		
		for(Cotisation cotis: exemple.getCotisations().getCotisations()){
			Element cotisation = new Element("cotisation");
			cotisation.setAttribute( new Attribute("taux",String.valueOf(cotis.getTaux())));
			cotisation.setAttribute(new Attribute("nom", cotis.getNom()));
			cotisations.addContent(cotisation);
		}
		
		for(Regle regle: exemple.getRegles().getRegles()){
			Element regleLocal = new Element("regle");
			regleLocal.setAttribute(new Attribute("Action", regle.getAction().toString()));
			regleLocal.setAttribute(new Attribute("Condition", regle.getCondition().toString()));
			regles.addContent(regleLocal);
		}
		
		employe.setAttribute("nom",exemple.getEmploye().getNom());
		employe.setAttribute("prenom",exemple.getEmploye().getPrenom());
		employe.setAttribute("statut",exemple.getEmploye().getStatut());
		employe.setAttribute("salaireBrut",String.valueOf(exemple.getEmploye().getSalaireBrut()));
		employe.setAttribute("salaireNet",String.valueOf(exemple.getEmploye().getSalaireNet()));

		ArrayList<Element> liste = new ArrayList<Element>();
		fiche.addContent(employe);
		fiche.addContent(cotisations);
		fiche.addContent(regles);
		liste.add(fiche);
		return liste;
	}

	@Override
	protected ArrayList<FichePaie> convertieListe(List<Element> liste) {
		ArrayList<FichePaie> listeRetour = new ArrayList<FichePaie>();
		ListeCotisation cotis ;
		ListeRegle listeRegles;
		Employe employe ;
		ArrayList<Element> listeFiches = new ArrayList<Element>();
		for (Element e : liste){
			if (e.getName().equals("fichepaie")){
				listeFiches.add(e);
			}
		}
		for (Element e : listeFiches){
			cotis = new ListeCotisation();
			listeRegles  = new ListeRegle();
				for( Element cotisations : e.getChildren("cotisations")){
					for(Element cotisation : cotisations.getChildren()){
						try {
							if(		Cotisation.isValid(cotisation.getAttributeValue("nom"), cotisation.getAttributeValue("taux"))){
								Cotisation temp = new Cotisation(cotisation.getAttributeValue("nom"), Double.parseDouble(cotisation.getAttributeValue("taux")));
								if(!temp.equals(new Cotisation())){
									cotis.ajouterCotisation(temp);
								}
							}
						} catch (NumberFormatException
								| ExceptionNomContientCaractereSpe
								| ExceptionTauxCotisationString
								| ExceptionTauxSupUn
								| ExceptionTauxCotisationNegatif
								| ExceptionNomVide | ExceptionTauxVide
								| ExceptionNomNombre | ExceptionNomInvalide e1) {
						}
					}


				}
				for (Element regles : e.getChildren("regles")){
					for (Element regle : regles.getChildren()){
						if(Condition.isValid(regle.getAttributeValue("Condition")) && Action.isValid(regle.getAttributeValue("Action"))){
							Condition condition = new Condition(regle.getAttributeValue("Condition"));
							Action action =  new Action(regle.getAttributeValue("Action"));
							if( condition != null && action != null 
							&& ! condition.equals(new Condition()) && !action.equals(new Action())){
								listeRegles.ajoutRegle(new Regle(condition,  action));
							}							
						}

					}
				}
				if (e.getChild("employe") != null){
					Element elemEmploye = e.getChild("employe");
					employe = new Employe(elemEmploye.getAttributeValue("nom"), elemEmploye.getAttributeValue("prenom"), elemEmploye.getAttributeValue("statut"),
											Double.parseDouble(elemEmploye.getAttributeValue("salaireBrut")),Double.parseDouble(elemEmploye.getAttributeValue("salaireNet")) );
				}
				else{
					employe  = new Employe();
				}
				
				FichePaie fiche = new FichePaie(cotis, listeRegles, employe);	

				listeRetour.add(fiche);			
		}
		return listeRetour;
	}

	@Override
	protected FichePaie getElementBase() {
		return new FichePaie();
	}

	
}
