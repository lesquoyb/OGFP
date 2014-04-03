package vue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

import vue.interfaces.IFichePaie;
import vue.interfaces.INet;
import vue.interfaces.IPanneauRegle;
import vue.interfaces.IPrincipale;
import vue.interfaces.ISaisieBrut;
import vue.interfaces.ISaisieCotisation;
import controleur.CtrlAide;
import controleur.CtrlCalculNet;
import controleur.CtrlPrincipal;
import controleur.CtrlRegle;
import controleur.CtrlSaisieCotisation;

public class FenetrePrincipale extends JFrame implements IPrincipale {

	private PanneauSaisieBrut panBrut;
	private PanneauSaisieCotisation panCotis;
	private PanneauNet panNet;
	private PanneauRegle panRegle;
	private PanneauFichePaie panPaie;
	private CtrlCalculNet controleur;
	private JMenuBar barre;
	private CtrlPrincipal controleurFichier;
	private CtrlSaisieCotisation controleurCotis;
	private CtrlAide controleurAide;
	private String logo ="./src/ressources/images/UDL.png";
	
	public FenetrePrincipale(String titre,CtrlCalculNet controller) {
		super(titre);
		Image iconeprincipale = Toolkit.getDefaultToolkit().getImage("./src/ressources/images/icone_moa_gold_dollar.png");
		this.setIconImage(iconeprincipale);
		this.setSize(new Dimension(1020, 500));
		this.setMinimumSize(new Dimension(1020,450));
		this.setLayout(new BorderLayout());
		panBrut = new PanneauSaisieBrut();
		controleurCotis = new CtrlSaisieCotisation();
		panCotis = new PanneauSaisieCotisation(controleurCotis);
		controleurAide = new CtrlAide();
		controleur = controller;
		

		controleurFichier = new CtrlPrincipal();


		panNet = new PanneauNet(controleur, controleurFichier);
		
		CtrlRegle controlRegle = new CtrlRegle();
		panRegle = new PanneauRegle(controlRegle);
		
		JMenu fichier = new JMenu("Fichier");
		JMenuItem quitter = new JMenuItem("Quitter");
		quitter.addActionListener(controleurFichier);
		fichier.add(quitter);
		
		JMenu cotisregle = new JMenu("Cotisations et règles");
		JMenuItem sauver1 = new JMenuItem("Sauvegarder des cotisations et règles");
		sauver1.addActionListener(controleurFichier);
		JMenuItem charger1 = new JMenuItem("Charger des cotisations et règles");
		charger1.addActionListener(controleurFichier);
		cotisregle.add(charger1);
		cotisregle.add(sauver1);
		
		JMenu fichepaie = new JMenu("Fiche de paie");
		JMenuItem sauver2 = new JMenuItem("Sauvegarder une fiche de paie");
		sauver2.addActionListener(controleurFichier);
		JMenuItem charger2 = new JMenuItem("Charger une fiche de paie");
		charger2.addActionListener(controleurFichier);
		fichepaie.add(charger2);
		fichepaie.add(sauver2);
		
		JMenu aide = new JMenu("Aide");
		JMenuItem addCotis= new JMenuItem("Aide ajout de cotisation");

		JMenuItem aidePrincipale= new JMenuItem("Aide fenetre principale");
		aidePrincipale.addActionListener(controleurAide);
		JMenuItem addRegle= new JMenuItem("Aide ajout de regle");
		addRegle.addActionListener(controleurAide);
		addCotis.addActionListener(controleurAide);
		aide.add(addCotis);
		aide.add(addRegle);
		aide.add(aidePrincipale);
		
		barre = new JMenuBar();
		barre.add(fichier);
		barre.add(cotisregle);
		barre.add(fichepaie);
		barre.add(aide);
		
		controleurFichier.setVue(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(barre);
		controleur.setVue(this);
		panPaie = new PanneauFichePaie(controller,controleurCotis,controlRegle);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon icon =new ImageIcon( new ImageIcon("./src/ressources/images/icone_moa_equal_dollar.png").getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));
		ImageIcon icon2 =new ImageIcon( new ImageIcon("./src/ressources/images/icone_moa_down_dollar.png").getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));
		
		tabbedPane.addTab("Fiche de paie", icon, this.panPaie ,"Permet de voir la fiche de paie");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		tabbedPane.addTab("Saisie de cotisations", icon2, this.panCotis,"Permet de saisir des cotisations");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        tabbedPane.addTab("Saisie de regles", icon2, this.panRegle,"Permet de saisir des règles");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
		
        tabbedPane.setBackground(new Color(200,200,200));
        
        this.add(panBrut,BorderLayout.WEST);

		this.add(tabbedPane,BorderLayout.CENTER);
		
		this.add(this.panNet,BorderLayout.PAGE_END);
		//this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	@Override
	public String getBrut() {
		
			return panBrut.getBrut();
	}

	@Override
	public void setNet(double net) {
		panNet.setNet(net);
	}

	@Override
	public ISaisieBrut getPanBrut() {
		return panBrut;
	}

	@Override
	public ISaisieCotisation getPanCotisation() {
		return panCotis;
	}

	@Override
	public IPanneauRegle getPanRegle() {
		return panRegle;
	}

	@Override
	public IFichePaie getFichePaie() {
		return panPaie;
	}

	@Override
	public INet getPanNet() {
		return panNet;
	}
	
		
}
