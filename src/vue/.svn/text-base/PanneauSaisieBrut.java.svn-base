package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import modele.Employe;
import outils.Outils;
import vue.interfaces.ISaisieBrut;
import controleur.CtrlSaisieBrut;

public class PanneauSaisieBrut extends JPanel implements ISaisieBrut {
	
	private JTextField montant;
	private JTextField nom;
	private JTextField prenom;
	private JComboBox<String> statut;
	private boolean valide = false;
	private CtrlSaisieBrut controlBrut;
	private String logo ="./src/ressources/images/UDL.png";
	
	public PanneauSaisieBrut() {
		
		controlBrut = new CtrlSaisieBrut();
		controlBrut.setVue(this);
		
		this.nom = new JTextField(12);
		JPanel pNom = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pNom.setBackground(new Color(210,210,210));
		JLabel lNom = new JLabel("Nom : ");
		lNom.setPreferredSize(new Dimension(60, 40));
		pNom.add(lNom);
		pNom.add(this.nom);
		
		this.prenom = new JTextField(12);
		JPanel pPrenom = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pPrenom.setBackground(new Color(210,210,210));
		JLabel lPrenom = new JLabel("Prénom : ");
		lPrenom.setPreferredSize(new Dimension(60, 40));
		lPrenom.setHorizontalAlignment(SwingConstants.LEFT);
		pPrenom.add(lPrenom);
		pPrenom.add(this.prenom);
		
		JPanel panneauGauche = new JPanel();
		BoxLayout gestionnaireGauche = new BoxLayout(panneauGauche, BoxLayout.PAGE_AXIS);
		panneauGauche.setLayout(gestionnaireGauche);
		
		panneauGauche.add(pNom);
		panneauGauche.add(pPrenom);
		
		this.statut = new JComboBox<String>(Outils.listeStatuts);
		JPanel pStatut = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pStatut.setBackground(new Color(210,210,210));
		pStatut.add(new JLabel("Statut : "));
		pStatut.add(this.statut);
		
		this.montant = new JTextField("0.0");
		montant.setPreferredSize(new Dimension(80,30));
		JPanel pBrut = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pBrut.setBackground(new Color(210,210,210));
		pBrut.add(new JLabel("Salaire brut : "));
		pBrut.add(this.montant);

		
		JPanel panneauDroite = new JPanel();
		BoxLayout gestionnaireDroite = new BoxLayout(panneauDroite, BoxLayout.PAGE_AXIS);
		panneauDroite.setLayout(gestionnaireDroite);

		panneauDroite.add(pStatut);
		panneauDroite.add(pBrut);
		
		JPanel panneau = new JPanel();
		JTabbedPane panneauOnglet = new JTabbedPane();
		ImageIcon icon =new ImageIcon( new ImageIcon("./src/ressources/images/icone_moa_up_dollar.png").getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));
		
		BoxLayout gestionnaire = new BoxLayout(panneau, BoxLayout.PAGE_AXIS);
		panneau.setLayout(gestionnaire);

		panneau.add(panneauGauche);
		panneau.add(panneauDroite);

		panneauOnglet.addTab("Salarié", icon, panneau ,"Permet de saisir des information sur le salarié");
		panneau.setBackground(new Color(200,200,200));
		this.setLayout(new BorderLayout());
		//am&lioration du pannel brut
        JPanel panBrutameliore = new JPanel();
		panBrutameliore.add(panneauOnglet);
        this.add(new JLabel(new ImageIcon(logo)),BorderLayout.SOUTH);
		this.add(panBrutameliore);
	}

	@Override
	public String getBrut() {
		return montant.getText();
	}

	@Override
	public String getNom() {
		return nom.getText();
	}

	@Override
	public String getPrenom() {
		return prenom.getText();
	}

	@Override
	public String getStatut() {
		return statut.getSelectedItem().toString();
	}

	@Override
	public void setValide(boolean valide) {
		this.valide = valide;
	}

	@Override
	public boolean isValid() {
		return valide;
	}

	@Override
	public void erreur(String message) {
		JOptionPane.showMessageDialog(this,
			    message,
			    "Erreur de saisie",
			    JOptionPane.ERROR_MESSAGE);	
	}

	@Override
	public CtrlSaisieBrut getControleur() {
		return controlBrut;
	}

	
	
	@Override
	public void setBrut(String s) {
		montant.setText(s);
	}

	@Override
	public void setNom(String s) {
		nom.setText(s);
	}

	@Override
	public void setPrenom(String s) {
		prenom.setText(s);;
	}

	@Override
	public void setStatut(String s) {
		int i = 0;
		for(String chaine :Outils.listeStatuts){
			if (chaine.equals(s)){
				break;
			}
			i++;
		}
		statut.setSelectedIndex((i));
	}

	@Override
	public Employe getEmploye() {
		if ( Outils.isDouble(montant.getText())){
			return new Employe(nom.getText(), prenom.getText(), statut.getSelectedItem().toString(), Double.parseDouble(montant.getText()));
		}
		else return null;
	}
	
	
	
}
