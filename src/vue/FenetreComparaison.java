package vue;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import modele.Employe;
import modele.FichePaie;
import vue.interfaces.IComparaison;
import vue.interfaces.IFichePaie;
import vue.interfaces.ISaisieBrut;
import controleur.CtrlCalculNet;
import controleur.CtrlRegle;
import controleur.CtrlSaisieCotisation;

public class FenetreComparaison extends JFrame implements IComparaison{
	
	private IFichePaie panPaie;
	private ISaisieBrut panBrut;
	private JScrollPane panneauScrollable;
	private JLabel net;
	private JLabel resNet;
	
	
	public FenetreComparaison(){
		super("Comparaison");
		this.setPreferredSize(new Dimension(300, 600));
		JPanel pCompar = new JPanel(new BorderLayout());
		net = new JLabel("le net vaut:");
		resNet = new JLabel();
		JPanel sud = new JPanel();
		sud.setLayout(new BoxLayout(sud,BoxLayout.PAGE_AXIS));
		sud.add(net);
		sud.add(resNet);
		Image iconeprincipale = Toolkit.getDefaultToolkit().getImage("./src/ressources/images/icone_moa_gold_dollar.png").getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		this.setIconImage(iconeprincipale);
		panPaie = new PanneauFichePaie(new CtrlCalculNet()	, new CtrlSaisieCotisation(), new CtrlRegle());
		panBrut = new PanneauSaisieBrut();
		pCompar.add((Component) panPaie,BorderLayout.CENTER);
		pCompar.add((Component) panBrut,BorderLayout.WEST);
		this.add(sud,BorderLayout.SOUTH);
		panneauScrollable = new JScrollPane(pCompar, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panneauScrollable.getHorizontalScrollBar().setUnitIncrement(15);
		panneauScrollable.getVerticalScrollBar().setUnitIncrement(15);
		this.add(panneauScrollable);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	@Override
	public void setFichePaie(FichePaie fiche) {
		panPaie.setFichePaie(fiche);
	}

	@Override
	public void setEmploye(Employe employe) {
		panBrut.setBrut(String.valueOf(employe.getSalaireBrut()));
		panBrut.setNom(employe.getNom());
		panBrut.setPrenom(employe.getPrenom());
		panBrut.setStatut(employe.getStatut());
		resNet.setText(String.valueOf(employe.getSalaireNet()));
	}
	
	

}
