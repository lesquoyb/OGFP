package vue;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class FenetreAideCotisation  extends JFrame{

	private String cheminImage ="./src/ressources/images/aide_cotisation.png";
	private JScrollPane panneauScrollable;
	
	public FenetreAideCotisation(){
		super("Aide de saisie de cotisation");
		JPanel pImage = new JPanel();
		Image iconeprincipale = Toolkit.getDefaultToolkit().getImage("./src/ressources/images/icone_moa_gold_dollar.png").getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		this.setIconImage(iconeprincipale);
		pImage.setLayout(new FlowLayout());
		pImage.add(new JLabel(new ImageIcon(cheminImage)));
		panneauScrollable = new JScrollPane(pImage, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panneauScrollable.getHorizontalScrollBar().setUnitIncrement(15);
		this.add(panneauScrollable);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
}
