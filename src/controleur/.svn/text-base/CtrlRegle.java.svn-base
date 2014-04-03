package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.Action;
import modele.Condition;
import modele.Cotisation;
import modele.ListeRegle;
import modele.Operateur;
import modele.Regle;
import modele.exception.ExceptionChampVide;
import modele.exception.cotisation.ExceptionNomContientCaractereSpe;
import modele.exception.cotisation.ExceptionNomInvalide;
import modele.exception.cotisation.ExceptionNomNombre;
import modele.exception.cotisation.ExceptionNomVide;
import modele.exception.cotisation.ExceptionTauxCotisationNegatif;
import modele.exception.cotisation.ExceptionTauxCotisationString;
import modele.exception.cotisation.ExceptionTauxSupUn;
import modele.exception.cotisation.ExceptionTauxVide;
import modele.exception.variable.ExceptionVariableNumerique;
import outils.Outils;
import vue.interfaces.IPanneauRegle;
import vue.interfaces.IFichePaie;

public class CtrlRegle implements ActionListener {

	private IPanneauRegle vue;
	private IFichePaie vuePaie;
	private ListeRegle listeRegle;

	public CtrlRegle(){
		listeRegle = new ListeRegle();
	}

	@Override
	public void actionPerformed(ActionEvent commande) {
		int id;
		String ordre = commande.getActionCommand();
		if (ordre.startsWith("ajouterRegle")) {
			id = Integer.parseInt(ordre.substring(12));
			try {
				verifSaisie(id);
			}
			catch (ExceptionChampVide | ExceptionVariableNumerique e){
				vue.erreur(e.getMessage());
				return ;
			}
			String var = vue.getVariable(id);
			String valeurVar = vue.getValeurVar(id);
			Operateur op = new Operateur(vue.getSigne(id));
			Action act = new Action(vue.getAction(id));

			Regle r = new Regle(new Condition(var,valeurVar,op) ,act);
			this.listeRegle.ajoutRegle(r);
			this.vue.ajouterLigne(id);
			this.vuePaie.refreshTabRegle();
			//this.vue.rafraichitAffichage();	

		}

		else if (ordre.startsWith("supprimerRegle")) {

			id = Integer.parseInt(ordre.substring(14));

			this.listeRegle.supprimerRegle(id);
			this.vue.supprimerLigne(id);
			//this.vue.rafraichitAffichage();


		}

		else if (ordre.startsWith("retablirRegle")) {

			id = Integer.parseInt(ordre.substring(13));

			this.listeRegle.retablirRegle(id);
			this.vue.retablirLigne(id);
			//this.vue.rafraichitAffichage();
		}

		else if (ordre.startsWith("modifierRegle")) {

			id = Integer.parseInt(ordre.substring(13));
			this.vue.modifierLigne(id);

		}

		else if (ordre.startsWith("validerModifRegle")) {

			id = Integer.parseInt(ordre.substring(17));
			try {
				verifSaisie(id);
			}
			catch (ExceptionChampVide | ExceptionVariableNumerique e){
				vue.erreur(e.getMessage());
				return ;
			}


			String var = vue.getVariable(id);
			String valeurVar = vue.getValeurVar(id);
			Operateur op = new Operateur(vue.getSigne(id));
			Action act = new Action(vue.getAction(id));

			Regle r = new Regle(new Condition(var,valeurVar,op) ,act);			

			this.listeRegle.modifierRegle(id, r);
			this.vue.validerModifLigne(id);
			this.vuePaie.refreshTabRegle();
		}

	}





	/**
	 *  Verifie que la saisie d'un élément est correcte.
	 * @param id
	 * @throws ExceptionChampVide 
	 * @throws ExceptionVariableNumerique 
	 */
	public void verifSaisie(int id) throws ExceptionChampVide, ExceptionVariableNumerique{
		String var = vue.getVariable(id);
		String valeurVar = vue.getValeurVar(id);
		Operateur op = new Operateur(vue.getSigne(id));
		Action act = new Action(vue.getAction(id));
		if ( var.equals("") || valeurVar.equals("") || op.toString().equals("") || act.getVariable().toString().equals("") ||  String.valueOf(act.getValeur()).equals("")){
			throw new ExceptionChampVide();
		}
		if ( Outils.isDouble(var) || Outils.isDouble(act.getVariable().toString())){
			throw new ExceptionVariableNumerique();
		}
	}

	/**
	 * Met à jour la liste des règles en se basant sur les règles présentes dans la vue.
	 */
	public void miseAJourListe() {

		for (int id=0; id < this.listeRegle.getRegles().size(); id++) {
			Regle regle = this.listeRegle.getRegles().get(id);

			regle.setCondition(new Condition(this.vue.getVariable(id),this.vue.getValeurVar(id),new Operateur(this.vue.getSigne(id))));
			regle.setAction(new Action(this.vue.getAction(id))) ;
		}
	}

	public void setVue(IPanneauRegle vue){
		this.vue = vue;
	}
	
	public void setVuePaie(IFichePaie vuePaie) {
		this.vuePaie = vuePaie;
	}

	public int getNombreRegles() {
		return this.listeRegle.getRegles().size();
	}


	public Regle getRegles(int ligne) {
		return this.listeRegle.getRegles().get(ligne);
	}

	public ListeRegle getListe() {
		return this.listeRegle;
	}

	public void setListe(ListeRegle liste) {

		this.listeRegle=liste;
		this.vue.rafraichitAffichage();
		this.vuePaie.refreshTabRegle();
	}

}
