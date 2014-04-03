package vue;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import vue.interfaces.INet;
import controleur.CtrlCalculNet;
import controleur.CtrlPrincipal;

public class PanneauNet extends JPanel implements INet{

	private JLabel net;
	private JLabel labNet;
	private JLabel labRes;
	private JButton calculer;
	private JButton enregistrer;
	private JButton comparer;
	private CtrlCalculNet controleur;
	private CtrlPrincipal controleurEnregistrer;
	
	public PanneauNet(CtrlCalculNet contr, CtrlPrincipal contrEnreg){
		this.setBackground(new Color(150,150,150));
		net = new JLabel("Net",SwingConstants.CENTER);
		labNet = new JLabel("Résultat net:");
		labRes = new JLabel("");
		
		controleur = contr;
		controleurEnregistrer = contrEnreg;
		calculer = new JButton("calculer");
		calculer.addActionListener(controleur);
		enregistrer = new JButton("Enregistrer");
		enregistrer.setActionCommand("Sauvegarder une fiche de paie");
		enregistrer.addActionListener(controleurEnregistrer);
		comparer = new JButton("comparer");
		comparer.setActionCommand("Comparer");
		comparer.addActionListener(controleurEnregistrer);
		JPanel centre = new JPanel(new GridLayout(1,4));
		centre.add(labNet);
		centre.add(labRes);
		centre.add(calculer);
		centre.add(enregistrer);
		centre.add(comparer);
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setLayout(new FlowLayout());
		this.add(net);
		this.add(centre);
		
		this.setVisible(true);
	}

	@Override
	public void setNet(double net) {
		labRes.setText(Double.toString(net));
	}

	
	
	@Override
	public CtrlCalculNet getControleur() {
		return controleur;
	}

	@Override
	public String getNet() {
		return labRes.getText();
	}
	
}
