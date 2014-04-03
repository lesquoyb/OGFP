package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.Brut;
import modele.Employe;
import modele.exception.ExceptionChampVide;
import modele.exception.brut.ExceptionBrutNegatif;
import modele.exception.brut.ExceptionBrutString;
import modele.exception.cotisation.ExceptionNomContientCaractereSpe;
import modele.exception.nom.ExceptionNomContientChiffre;
import vue.interfaces.ISaisieBrut;

/**
 * Test si le brut saisie est valide.
 * @author lesquoy1u
 *
 */
public class CtrlSaisieBrut implements ActionListener{
		
		private ISaisieBrut brut;
		private Employe employe;
		
		public CtrlSaisieBrut() {
			
		}
		
		public void setVue(ISaisieBrut br){
			this.brut = br;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String saisie = brut.getBrut();
			String nom = brut.getNom();
			String prenom = brut.getPrenom();
			String statut = brut.getStatut();
			
				try {
					if ( Brut.isValid(saisie) && Employe.isValidNom(prenom) && Employe.isValidNom(nom) ){
						employe = new Employe(nom,prenom,statut,Double.parseDouble(saisie));
						brut.setValide(true);
					}
					else{
						employe = null;
					}
				} catch (ExceptionBrutNegatif | ExceptionBrutString
						| ExceptionChampVide | NumberFormatException | ExceptionNomContientCaractereSpe | ExceptionNomContientChiffre e) {
					employe = null;
					brut.erreur(e.getMessage());
				}

		}		
		
		public Employe getEmploye(){
			return employe;
		}
		
}
