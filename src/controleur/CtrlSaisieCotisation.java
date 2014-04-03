package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.Cotisation;
import modele.ListeCotisation;
import modele.exception.cotisation.ExceptionNomContientCaractereSpe;
import modele.exception.cotisation.ExceptionNomInvalide;
import modele.exception.cotisation.ExceptionNomNombre;
import modele.exception.cotisation.ExceptionNomVide;
import modele.exception.cotisation.ExceptionTauxCotisationNegatif;
import modele.exception.cotisation.ExceptionTauxCotisationString;
import modele.exception.cotisation.ExceptionTauxSupUn;
import modele.exception.cotisation.ExceptionTauxVide;
import vue.interfaces.ISaisieCotisation;
import vue.interfaces.IFichePaie;

public class CtrlSaisieCotisation implements ActionListener{

	private ISaisieCotisation Icotisation;
	private IFichePaie IPaie;
	private ListeCotisation liste;

	public CtrlSaisieCotisation() {
		this.liste = new ListeCotisation();

	}

	public void setVue(ISaisieCotisation vueCotisation){
		Icotisation = vueCotisation;
	}
	
	public void setVuePaie(IFichePaie vuePaie) {
		IPaie = vuePaie;
	}

	public ListeCotisation getListe() {
		return this.liste;
	}

	public void setListe(ListeCotisation liste) {

		this.liste=liste;
		Icotisation.rafraichitAffichage();
	}

	public int getNombreCotisations() {
		return this.liste.getCotisations().size();
	}


	public Cotisation getCotisations(int ligne) {
		return this.liste.getCotisations().get(ligne);
	}

	@Override
	public void actionPerformed(ActionEvent commande) {
		
		int id;

		String ordre = commande.getActionCommand();

		if (ordre.startsWith("ajouterCotisation") || ordre.startsWith("validerModifCotisation")) {
			if (ordre.startsWith("ajouterCotisation") ){
				id = Integer.parseInt(ordre.substring(17));
			}
			else{
				id = Integer.parseInt(ordre.substring(22));
			}
				try {
					if (Cotisation.isValid(Icotisation.getNomCotisation(id), String.valueOf(Double.parseDouble(Icotisation.getTaux(id)) / 100)) ){
						
						double tauxSaisie = Double.parseDouble(Icotisation.getTaux(id)) / 100;
						Cotisation cotisationSaisie = new Cotisation(Icotisation.getNomCotisation(id),tauxSaisie);				
						if (ordre.startsWith("ajouterCotisation") ){
							this.liste.ajouterCotisation(cotisationSaisie);
							this.Icotisation.ajouterLigne(id);
							this.IPaie.refreshTabCotis();
						}
						else{
							this.liste.modifierCotisation(id, cotisationSaisie);
							this.Icotisation.validerModifLigne(id);
						}
										

					}
				} 
				catch (NumberFormatException
						| ExceptionNomContientCaractereSpe
						| ExceptionTauxCotisationString | ExceptionTauxSupUn
						| ExceptionTauxCotisationNegatif | ExceptionNomVide
						| ExceptionTauxVide | ExceptionNomNombre | ExceptionNomInvalide e) {
					Icotisation.erreur(e.getMessage());
				}
				
			Icotisation.setValid(false);

		}
		
		else if (ordre.startsWith("supprimerCotisation")) {
			
			id = Integer.parseInt(ordre.substring(19));
			
			this.liste.supprimerCotisation(id);
			this.Icotisation.supprimerLigne(id);
			
			
		}
		
		else if (ordre.startsWith("retablirCotisation")) {
			
			id = Integer.parseInt(ordre.substring(18));
			
			this.liste.retablirCotisation(id);
			this.Icotisation.retablirLigne(id);
		}
		
		else if (ordre.startsWith("modifierCotisation")) {
			
			id = Integer.parseInt(ordre.substring(18));
			this.Icotisation.modifierLigne(id);
		}

	}

}