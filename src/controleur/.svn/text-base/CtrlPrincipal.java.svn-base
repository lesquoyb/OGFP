package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import modele.Cotisation;
import modele.Employe;
import modele.FichePaie;
import modele.ListeCotisation;
import modele.ListeRegle;
import modele.Regle;
import modele.dao.DAOCotisation;
import modele.dao.DAOPaie;
import modele.dao.DAORegle;
import modele.exception.ExceptionChampVide;
import modele.exception.brut.ExceptionBrutNegatif;
import modele.exception.brut.ExceptionBrutString;
import modele.exception.cotisation.ExceptionNomContientCaractereSpe;
import modele.exception.nom.ExceptionNomContientChiffre;
import vue.FenetreComparaison;
import vue.FenetrePrincipale;
import vue.interfaces.IFichePaie;
import vue.interfaces.INet;
import vue.interfaces.IPanneauRegle;
import vue.interfaces.IPrincipale;
import vue.interfaces.ISaisieBrut;
import vue.interfaces.ISaisieCotisation;

public class CtrlPrincipal implements ActionListener{

	private IPrincipale vue;
	private CtrlRegle ctrlRegle;
	private CtrlSaisieCotisation ctrlCotis;
	private ListeCotisation listeCotis;
	private ListeRegle listeRegle;
	
	public CtrlPrincipal(){
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		DAORegle regle = new DAORegle();
		DAOCotisation cotis = new DAOCotisation();
		
		if (action.equals("Sauvegarder des cotisations et règles")){
			cotis.viderFichier();
			cotis.ajouter(listeCotis.getCotisations());
			regle.viderFichier();
			regle.ajouter(listeRegle.getRegles());	
		}
		else if ( action.equals("Charger des cotisations et règles")){
			ArrayList<Cotisation> lCot = cotis.lireFichier();
			ArrayList<Regle> lRegle = regle.lireFichier();
			lRegle.add(new Regle());
			
			listeCotis.setCotisations(lCot);
			listeRegle.setRegles(lRegle);
			
			ctrlCotis.setListe(listeCotis);
			vue.getPanCotisation().rafraichitAffichage();
			ctrlRegle.setListe(listeRegle);
			vue.getPanRegle().rafraichitAffichage();
		}
		else if ( action.equals("Sauvegarder une fiche de paie")){
			
			FichePaie fiche = vue.getFichePaie().getFichePaie();
			fiche.setEmploye(vue.getPanBrut().getEmploye());
			try {
				if (Employe.isValid(fiche.getEmploye())){
					vue.getPanNet().getControleur().actionPerformed(e);
					fiche.getEmploye().setSalaireNet(Double.parseDouble(vue.getPanNet().getNet()));
					DAOPaie paie = new DAOPaie();
					paie.viderFichier();
					paie.ajouter(fiche);	
				}
			} catch (ExceptionChampVide | ExceptionNomContientCaractereSpe
					| ExceptionNomContientChiffre | ExceptionBrutNegatif | ExceptionBrutString e1) {
				vue.getPanBrut().erreur(e1.getMessage());
			}

		}
		else if ( action.equals("Charger une fiche de paie")){
			DAOPaie paie = new DAOPaie();
			ArrayList<FichePaie>fiches = paie.lireFichier();
			if (fiches.size() > 0){

				FichePaie fichePaie = fiches.get(0);
				vue.getFichePaie().setFichePaie(fichePaie);
				Employe empl = fichePaie.getEmploye();
				vue.getPanBrut().setNom(empl.getNom());
				vue.getPanBrut().setPrenom(empl.getPrenom());
				vue.getPanBrut().setBrut(String.valueOf(empl.getSalaireBrut()));
				vue.getPanBrut().setStatut(empl.getStatut());
				vue.getPanNet().setNet(empl.getSalaireNet());
				vue.getPanCotisation().getControleur().setListe(fichePaie.getCotisations());
				vue.getPanRegle().getControleur().setListe(fichePaie.getRegles());
				vue.getPanNet().getControleur().actionPerformed(e);
			}
			else{
				vue.getPanBrut().erreur("Pas de fiche de paie enregistrée");
			}

		}
		else if (action.equals("Comparer")){
			DAOPaie paie = new DAOPaie();
			ArrayList<FichePaie>fiches = paie.lireFichier();
			if (fiches.size() > 0){

				FichePaie fichePaie = fiches.get(0);
				FenetreComparaison comparaison = new FenetreComparaison();
				comparaison.setFichePaie(fichePaie);
				Employe empl = fichePaie.getEmploye();
				comparaison.setEmploye(empl);
			}
			else{
				vue.getPanBrut().erreur("Pas de fiche de paie enregistrée");
			}
		}
		else if (action.equals("Quitter")){
			System.exit(0);
		}
	}

	public IPrincipale getVue() {
		return vue;
	}

	public void setVue(IPrincipale vue) {
		this.vue = vue;
		ctrlRegle = vue.getPanRegle().getControleur();
		ctrlCotis = vue.getPanCotisation().getControleur();
		listeCotis = ctrlCotis.getListe();
		listeRegle = ctrlRegle.getListe();
	}
}
