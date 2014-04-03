package vue;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import modele.Employe;
import modele.FichePaie;
import modele.ListeCotisation;
import modele.ListeRegle;
import vue.interfaces.IFichePaie;
import vue.interfaces.IModelTableCotisation;
import vue.interfaces.IModelTableRegle;
import controleur.CtrlCalculNet;
import controleur.CtrlRegle;
import controleur.CtrlSaisieCotisation;

public class PanneauFichePaie extends JPanel implements IFichePaie {
	
	private CtrlCalculNet controleurCalculNet;
	private CtrlSaisieCotisation controleurCotisation;
	private CtrlRegle controleurRegle;

	private IModelTableCotisation modTabCotis;
	private IModelTableRegle modTabRegle;
	private JScrollPane panCotis;
	private JScrollPane panRegle;
	private JTable tabCotis;
	private JTable tabRegle;
	private Employe employe;
	
	public PanneauFichePaie(CtrlCalculNet c,CtrlSaisieCotisation cotis,CtrlRegle regle){
		
		controleurCalculNet = c;
		controleurCotisation= cotis;
		controleurRegle =regle;
		employe = new Employe();
		
		this.controleurCotisation.setVuePaie(this);
		this.controleurRegle.setVuePaie(this);
		
		panCotis = new JScrollPane();
		panRegle = new JScrollPane();
		modTabCotis = new ModeleTableCotisation(controleurCotisation.getListe().getCotisations());
		modTabRegle = new ModelTableRegle(controleurRegle.getListe().getRegles());
		tabCotis = new JTable((TableModel) modTabCotis);
		tabRegle = new JTable((TableModel) modTabRegle);
		tabCotis.createDefaultColumnsFromModel();
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		panCotis.add(tabCotis);
		panCotis.setViewportView(tabCotis);
		panRegle.add(tabRegle);
		panRegle.setViewportView(tabRegle);
		this.add(panCotis);
		this.add(panRegle);
	}

	@Override
	public CtrlCalculNet getControleurCalculNet() {
		return controleurCalculNet;
	}

	@Override
	public CtrlSaisieCotisation getControleurCotisation() {
		return controleurCotisation;
	}

	@Override
	public CtrlRegle getControleurRegle() {
		return controleurRegle;
	}

	@Override
	public void refreshTabCotis() {
		((AbstractTableModel) modTabCotis).fireTableDataChanged();
		
	}

	@Override
	public void refreshTabRegle() {
		((AbstractTableModel) modTabRegle).fireTableDataChanged();
		
	}

	@Override
	public void setMontant(int index, double valeur) {
		if(index <  modTabCotis.getMontants().size()){
			double m = modTabCotis.getMontants().get(index);
			m = valeur;
		}
		else{
			 modTabCotis.getMontants().add(valeur);
		}
		((AbstractTableModel) modTabCotis).fireTableDataChanged();
	}

	@Override
	public FichePaie getFichePaie() {
		return new FichePaie(new ListeCotisation(modTabCotis.getCotisations()), new ListeRegle(modTabRegle.getRegles()), employe);
	}

	public Employe getEmploye() {
		return employe;
	}

	@Override
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	@Override
	public void setFichePaie(FichePaie fiche) {
		modTabCotis.setListe(fiche.getCotisations());
		modTabRegle.setListe(fiche.getRegles());
		employe = fiche.getEmploye();
	}
	
	
	
	
}
