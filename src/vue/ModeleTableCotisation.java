package vue;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import vue.interfaces.IModelTableCotisation;
import modele.Cotisation;
import modele.ListeCotisation;

public class ModeleTableCotisation extends AbstractTableModel implements IModelTableCotisation{

	
	protected final String[] titres = {"Nom cotisation","Taux", "Montant"};
	
	protected ArrayList<Cotisation> liste;
	protected ArrayList<Double> montants;
	
	public ModeleTableCotisation (ArrayList<Cotisation> listeCotisation) {
		montants = new ArrayList<Double>();
		liste = listeCotisation;
		this.fireTableDataChanged();
	}
	
	@Override
	public void setListe(ListeCotisation liste) {
		
		this.liste = liste.getCotisations();
		this.fireTableDataChanged();
	}
	
	@Override
	public ArrayList<Cotisation> getCotisations(){
		return liste;
	}
	
	@Override
	public int getColumnCount() {
		return titres.length;
	}

	@Override
	public int getRowCount() {
		if (this.liste==null) {
			return 0;
		}
		return this.liste.size();
	}
	
	@Override
	public String getColumnName(int colIndex) {
		
		return this.titres[colIndex];
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Object objet = null;
		Cotisation cotisation = this.getValueAt(rowIndex);
		if(rowIndex == liste.size()-1){
			return "";
		}
		else{
			switch (columnIndex) {
			
			case 0: objet = cotisation.getNom();break;
			case 1 : objet = cotisation.getTaux();break;
			case 2 : if(rowIndex < montants.size()){
						objet = montants.get(rowIndex);
					}break;
			}
			
			return objet;
		}

	}
	
	@Override
	public Cotisation getValueAt(int rowIndex) {
		return this.liste.get(rowIndex);
	}

	@Override
	public ArrayList<Double> getMontants() {
		return montants;
	}

	@Override
	public void setMontants(ArrayList<Double> montants) {
		this.montants = montants;
	}

	
	
}
