package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import modele.Operateur;
import vue.interfaces.IPanneauRegle;
import controleur.CtrlRegle;

public class PanneauRegle extends JPanel implements IPanneauRegle {

	private JPanel panneauSaisie;
	private CtrlRegle controleur;
	private ArrayList<JTextField> saisieVariable;
	private ArrayList<JTextField> saisieValeurVar;
	private ArrayList<JTextField> saisieActionVar;
	private ArrayList<JTextField> saisieActionValeur;

	private ArrayList<JButton> ajouterRegle;
	private ArrayList<JButton> modifierRegle;
	private ArrayList<JComboBox<String>> saisieSigne;
	private JScrollPane panneauScrollable;
	
	public PanneauRegle(CtrlRegle controleur){
		this.controleur = controleur;
		this.controleur.setVue(this);
		
		
		saisieSigne = new ArrayList<JComboBox<String>>();
		saisieVariable = new ArrayList<JTextField>();
		saisieValeurVar = new ArrayList<JTextField>();
		saisieActionVar = new ArrayList<JTextField>();
		saisieActionValeur = new ArrayList<JTextField>();
		ajouterRegle = new ArrayList<JButton>();
		modifierRegle = new ArrayList<JButton>();
		
		this.creePanneau();
	}
	
	/**
	 * Initialise les composants du panneau.
	 */
	private void creePanneau() {
		
		// Panel de saisie
		this.panneauSaisie = new JPanel();
		this.panneauSaisie.setLayout(new BoxLayout(this.panneauSaisie, BoxLayout.PAGE_AXIS));
		
		// Panel vide qui sert uniquement à la propreté de l'affichage
		JPanel pVide = new JPanel();
		pVide.setBackground(new Color(210,210,210));
		pVide.add(this.panneauSaisie);
		
		panneauScrollable = new JScrollPane(pVide, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//panneauScrollable.setPreferredSize(new Dimension(650, 150));
		panneauScrollable.getVerticalScrollBar().setUnitIncrement(15);
		this.setLayout(new BorderLayout());
		this.add(panneauScrollable);
		
		this.rafraichitAffichage();
		
	}

	/**
	 * Ajoute une ligne de saisie de règle.
	 * @param noLigne
	 * @return
	 */
	private JPanel creeLigne(int noLigne) {
		
		JTextField champVariable = new JTextField(this.controleur.getRegles(noLigne).getCondition().getVariable().toString());
		champVariable.setDisabledTextColor(Color.black);
		champVariable.setPreferredSize(new Dimension(50,30));
		this.saisieVariable.add(champVariable);
		
		JTextField champValeurVar = new JTextField(this.controleur.getRegles(noLigne).getCondition().getValeurTest());
		champValeurVar.setDisabledTextColor(Color.black);
		champValeurVar.setPreferredSize(new Dimension(50,30));
		this.saisieValeurVar.add(champValeurVar);
		
		JTextField champActionVariable = new JTextField(this.controleur.getRegles(noLigne).getAction().getVariable().toString());
		champActionVariable.setDisabledTextColor(Color.black);
		champActionVariable.setPreferredSize(new Dimension(100,30));
		this.saisieActionVar.add(champActionVariable);
		
		JTextField champActionValeur = new JTextField(String.valueOf(this.controleur.getRegles(noLigne).getAction().getValeur()));
		champActionValeur.setDisabledTextColor(Color.black);
		champActionValeur.setPreferredSize(new Dimension(100,30));
		this.saisieActionValeur.add(champActionValeur);
		
		JComboBox<String> cbbSigne = new JComboBox<String>(Operateur.listeOperateurs);
		cbbSigne.setSelectedItem(this.controleur.getRegles(noLigne).getCondition().getOperateur().toString());
		this.saisieSigne.add(cbbSigne);
		
		JButton bAjouter;
		if ((champVariable.getText().equals("")) && (champValeurVar.getText().equals("")) && (Double.parseDouble(champActionValeur.getText()) == 0) && (champActionVariable.getText().equals("Test"))) {
			bAjouter = new JButton("Ajouter");
			bAjouter.setActionCommand("ajouterRegle"+noLigne);
			bAjouter.addActionListener(this.controleur);
			this.ajouterRegle.add(bAjouter);
		}
		else {
			bAjouter = new JButton("Supprimer");
			bAjouter.setActionCommand("supprimerRegle"+noLigne);
			bAjouter.addActionListener(this.controleur);
			this.ajouterRegle.add(bAjouter);
		}
		
		JButton bModifier = new JButton("Modifier");
		bModifier.setActionCommand("modifierRegle"+noLigne);
		bModifier.addActionListener(this.controleur);
		bModifier.setEnabled(false);
		this.modifierRegle.add(bModifier);
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p.setBackground(new Color(230,230,230));
		p.setAlignmentX(LEFT_ALIGNMENT);
		p.add(new JLabel("Condition : "));
		p.add(champVariable);
		p.add(cbbSigne);
		p.add(champValeurVar);
		p.add(new JLabel("Action : "));
		p.add(champActionVariable);
		p.add(new JLabel("="));
		p.add(champActionValeur);
		//p.add(new JLabel("% "));
		p.add(bAjouter);
		p.add(bModifier);
		return p;
		
	}
	
	/**
	 * Met à jour l'affichage.
	 */
	@Override
	public void rafraichitAffichage() {
		this.panneauSaisie.removeAll();
		
		saisieSigne = new ArrayList<JComboBox<String>>();
		saisieVariable = new ArrayList<JTextField>();
		saisieValeurVar = new ArrayList<JTextField>();
		saisieActionVar = new ArrayList<JTextField>();
		saisieActionValeur = new ArrayList<JTextField>();
		ajouterRegle = new ArrayList<JButton>();
		
		int nb = this.controleur.getNombreRegles();
		for (int i=0; i < nb; i++) {
			this.panneauSaisie.add(this.creeLigne(i));
			
		}

		this.validate();
	}


	
	@Override
	public String getVariable(int i) {
		return saisieVariable.get(i).getText();
	}


	@Override
	public String getValeurVar(int i) {
		return saisieValeurVar.get(i).getText();

	}


	@Override
	public String getSigne(int i) {
		return saisieSigne.get(i).getSelectedItem().toString();

	}


	@Override
	public String getAction(int i) {
		return saisieActionVar.get(i).getText() + "=" + saisieActionValeur.get(i).getText();
	}
	
	private void validerLigne(int noLigne){

		this.saisieVariable.get(noLigne).setEnabled(false);
		this.saisieValeurVar.get(noLigne).setEnabled(false);
		this.saisieActionVar.get(noLigne).setEnabled(false);
		this.saisieActionValeur.get(noLigne).setEnabled(false);	
		this.saisieSigne.get(noLigne).setEnabled(false);
		this.ajouterRegle.get(noLigne).setEnabled(true);
		this.modifierRegle.get(noLigne).setEnabled(true);
		this.ajouterRegle.get(noLigne).setText("Supprimer");
		this.ajouterRegle.get(noLigne).setActionCommand("supprimerRegle"+noLigne);		
	}

	
	@Override
	public void ajouterLigne(int noLigne) {
	
		this.validerLigne(noLigne);
		JPanel p = this.creeLigne(this.controleur.getNombreRegles()-1);
		this.panneauSaisie.add(p, -1);
		this.validate();
	}
	
	
	@Override
	public void supprimerLigne(int noLigne) {
		
		this.ajouterRegle.get(noLigne).setText("Retablir");
		this.ajouterRegle.get(noLigne).setActionCommand("retablirRegle"+noLigne);
	}
	
	
	@Override
	public void retablirLigne(int noLigne) {
		
		this.ajouterRegle.get(noLigne).setText("Supprimer");
		this.ajouterRegle.get(noLigne).setActionCommand("supprimerRegle"+noLigne);
	}
	
	@Override
	public void modifierLigne(int noLigne) {
		
		this.saisieVariable.get(noLigne).setEnabled(true);
		this.saisieValeurVar.get(noLigne).setEnabled(true);
		this.saisieActionVar.get(noLigne).setEnabled(true);
		this.saisieActionValeur.get(noLigne).setEnabled(true);
		this.saisieSigne.get(noLigne).setEnabled(true);
		this.ajouterRegle.get(noLigne).setEnabled(false);
		this.modifierRegle.get(noLigne).setText("Valider");
		this.modifierRegle.get(noLigne).setActionCommand("validerModifRegle"+noLigne);
	}
	
	
	@Override
	public void validerModifLigne(int noLigne) {
		

		this.validerLigne(noLigne);
		this.modifierRegle.get(noLigne).setText("Modifier");
		this.modifierRegle.get(noLigne).setActionCommand("modifierRegle"+noLigne);
		this.validate();
	}

	
	@Override
	public CtrlRegle getControleur() {
		return controleur;
	}


	@Override
	public void erreur(String message) {
		JOptionPane.showMessageDialog(this,
				 message,
			    "Erreur",
			    JOptionPane.ERROR_MESSAGE);
	}

	
	@Override
	public boolean isSupprimeeRegle(int id) {
		return this.ajouterRegle.get(id).getActionCommand().startsWith("retablir");
	}
	
}
