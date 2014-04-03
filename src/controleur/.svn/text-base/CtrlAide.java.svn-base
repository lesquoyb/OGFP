package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vue.FenetreAideCotisation;
import vue.FenetreAidePrincipale;
import vue.FenetreAideRegle;

public class CtrlAide implements ActionListener {

	
	private FenetreAideCotisation fenCotis;
	private FenetreAidePrincipale fenPrinc;
	private FenetreAideRegle fenRegle;
	
	public CtrlAide(){
		fenCotis = null;
		fenPrinc = null;
		fenRegle = null;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Aide ajout de cotisation")){
			if (fenCotis == null){
				fenCotis = new FenetreAideCotisation();
			}
			else{
				fenCotis.setVisible(true);
			}
		}
		if (e.getActionCommand().equals("Aide ajout de regle")){
			if (fenRegle == null){
				fenRegle = new FenetreAideRegle();
			}
			else{
				fenRegle.setVisible(true);
			}
		}
		if (e.getActionCommand().equals("Aide fenetre principale")){
			if (fenPrinc == null){
				fenPrinc = new FenetreAidePrincipale();
			}
			else{
				fenRegle.setVisible(true);
			}
		}
	}

}
