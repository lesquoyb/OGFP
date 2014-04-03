package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import vue.interfaces.ISaisieCotisation;
import controleur.CtrlSaisieCotisation;

public class PanneauSaisieCotisation extends JPanel implements ISaisieCotisation {
	
	private JPanel panneauSaisieCotisation;
	private ArrayList<JTextField> saisieNomCotisation;
	private ArrayList<JTextField> saisieTaux;
	private boolean valide = false;
	private ArrayList<JButton> ajouterCotisation;
	private ArrayList<JButton> modifierCotisation;
	private CtrlSaisieCotisation controleur;
	private JScrollPane panneauScrollable;
	
	
	public PanneauSaisieCotisation(CtrlSaisieCotisation controleur) {
		
		this.setBackground(new Color(200,200,200));
		this.controleur = controleur;
		this.controleur.setVue(this);
		
		saisieNomCotisation = new ArrayList<JTextField>();
		saisieTaux = new ArrayList<JTextField>();
		ajouterCotisation = new ArrayList<JButton>();
		modifierCotisation = new ArrayList<JButton>();
		
		this.creePanneau();

	}
	
	private void creePanneau() {
		
		// Panel de saisie
		this.panneauSaisieCotisation = new JPanel();
		BoxLayout gestionnaire = new BoxLayout(this.panneauSaisieCotisation, BoxLayout.PAGE_AXIS);
		this.panneauSaisieCotisation.setLayout(gestionnaire);
		
		// Panel vide qui sert uniquement à la propreté de l'affichage
		JPanel pVide = new JPanel();
		pVide.setBackground(new Color(210,210,210));
		pVide.add(this.panneauSaisieCotisation);
		
		panneauScrollable = new JScrollPane(pVide, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//panneauScrollable.setPreferredSize(new Dimension(650, 150));
		panneauScrollable.getVerticalScrollBar().setUnitIncrement(15);
		this.setLayout(new BorderLayout());
		this.add(panneauScrollable);
		
		//this.add(this.creeLigne(0));
		this.rafraichitAffichage();
		
	}
	
	private JPanel creeLigne(int noLigne) {
		
		JTextField champNom = new JTextField(this.controleur.getCotisations(noLigne).getNom());
		champNom.setDisabledTextColor(Color.black);
		champNom.setPreferredSize(new Dimension(300,25));
		this.saisieNomCotisation.add(champNom);
		
		JTextField champTaux = new JTextField();
		champTaux.setDisabledTextColor(Color.black);
		champTaux.setPreferredSize(new Dimension(100,25));
		this.saisieTaux.add(champTaux);
		champTaux.setText(""+this.controleur.getCotisations(noLigne).getTaux());
		
		JButton bAjouter;
		
		if ((champNom.getText().equals("Nom")) && (Double.parseDouble(champTaux.getText()) == 0)) {
			bAjouter = new JButton("Ajouter");
			bAjouter.setActionCommand("ajouterCotisation"+noLigne);
			bAjouter.addActionListener(this.controleur);
		
		}
		else {
			bAjouter = new JButton("Supprimer");
			bAjouter.setActionCommand("supprimerCotisation"+noLigne);
			bAjouter.addActionListener(this.controleur);
		}
		
		
		
		this.ajouterCotisation.add(bAjouter);
		
		JButton bModifier = new JButton("Modifier");
		bModifier.setActionCommand("modifierCotisation"+noLigne);
		bModifier.addActionListener(this.controleur);
		bModifier.setEnabled(false);
		this.modifierCotisation.add(bModifier);
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p.setBackground(new Color(230,230,230));
		p.setAlignmentX(LEFT_ALIGNMENT);
		p.add(new JLabel("Nom : "));
		p.add(champNom);
		p.add(new JLabel("Taux : "));
		p.add(champTaux);
		p.add(new JLabel("% "));
		p.add(bAjouter);
		p.add(bModifier);
		return p;
	}
	
	@Override
	public void rafraichitAffichage() {
		this.panneauSaisieCotisation.removeAll();
		
		this.saisieNomCotisation = new ArrayList<JTextField>();
		this.saisieTaux = new ArrayList<JTextField>();
		this.ajouterCotisation = new ArrayList<JButton>();
		this.modifierCotisation = new ArrayList<JButton>();
		
		int nb = this.controleur.getNombreCotisations();
		for (int i=0; i < nb; i++) {
		this.panneauSaisieCotisation.add(this.creeLigne(i));
		}

		this.validate();
	}
	
	@Override
	public void ajouterLigne(int noLigne) {
		
		this.validerLigne(noLigne);
		JPanel p = this.creeLigne(this.controleur.getNombreCotisations()-1);
		this.panneauSaisieCotisation.add(p, -1);
		this.validate();
	}
	
	private void validerLigne(int noLigne){

		this.saisieNomCotisation.get(noLigne).setEnabled(false);
		this.saisieTaux.get(noLigne).setEnabled(false);		
		this.ajouterCotisation.get(noLigne).setEnabled(true);
		this.modifierCotisation.get(noLigne).setEnabled(true);
		this.ajouterCotisation.get(noLigne).setText("Supprimer");
		this.ajouterCotisation.get(noLigne).setActionCommand("supprimerCotisation"+noLigne);		
	}
	
	@Override
	public void supprimerLigne(int noLigne) {
		
		this.saisieNomCotisation.get(noLigne).setEnabled(false);
		this.saisieTaux.get(noLigne).setEnabled(false);
		this.modifierCotisation.get(noLigne).setEnabled(false);
		this.ajouterCotisation.get(noLigne).setText("Retablir");
		this.ajouterCotisation.get(noLigne).setActionCommand("retablirCotisation"+noLigne);
	}
	
	@Override
	public void retablirLigne(int noLigne) {

		this.modifierCotisation.get(noLigne).setEnabled(true);
		this.ajouterCotisation.get(noLigne).setText("Supprimer");
		this.ajouterCotisation.get(noLigne).setActionCommand("supprimerCotisation"+noLigne);
	}
	
	@Override
	public void modifierLigne(int noLigne) {
		
		this.saisieNomCotisation.get(noLigne).setEnabled(true);
		this.saisieTaux.get(noLigne).setEnabled(true);
		this.ajouterCotisation.get(noLigne).setEnabled(false);
		this.modifierCotisation.get(noLigne).setText("Valider");
		this.modifierCotisation.get(noLigne).setActionCommand("validerModifCotisation"+noLigne);
	}
	
	
	@Override
	public void validerModifLigne(int noLigne) {
		

		this.validerLigne(noLigne);
		this.modifierCotisation.get(noLigne).setText("Modifier");
		this.modifierCotisation.get(noLigne).setActionCommand("modifierCotisation"+noLigne);
		this.validate();
	}

	@Override
	public String getNomCotisation(int no) {
		return this.saisieNomCotisation.get(no).getText();
	}
	
	@Override
	public String getTaux(int no) {
		return this.saisieTaux.get(no).getText();
	}

	@Override
	public void setValid(boolean val) {
		valide = val;
	}
	
	@Override
	public boolean isValid(){
		return valide;
	}

	@Override
	public void viderListe() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CtrlSaisieCotisation getControleur() {
		return controleur;
	}

	@Override
	public void erreur(String message) {
		JOptionPane.showMessageDialog(this,
			    message,
			    "Erreur de saisie",
			    JOptionPane.ERROR_MESSAGE);	
	}

	

	

	@Override
	public boolean isSupprimeeCotisation(int id) {
		return this.ajouterCotisation.get(id).getActionCommand().startsWith("retablir");
	}
	
}
