package vue;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import vue.interfaces.IModelTableRegle;
import modele.ListeRegle;
import modele.Regle;

public class ModelTableRegle extends AbstractTableModel implements IModelTableRegle {

	private final String[] titres = {"Condition","Action"};
	private ArrayList<Regle> liste;
	
	public ModelTableRegle(ArrayList<Regle> regles) {
		liste = regles;
	}

	@Override
	public int getColumnCount() {
		return titres.length;
	}

	@Override
	public int getRowCount() {
		return liste.size();
	}
	

	@Override
	public String getColumnName(int column) {
		return titres[column];
	}
	
	@Override
	public ArrayList<Regle> getRegles(){
		return liste;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Regle regle = liste.get(rowIndex);
		if(rowIndex == liste.size()-1){
			return "";
		}
		else{
			if (columnIndex == 0){
				return regle.getCondition().toString();
			}
			else{
				return regle.getAction().toString();
			}
		}

	}

	@Override
	public void setListe(ListeRegle r){
		liste = r.getRegles();
		this.fireTableDataChanged();
	}
	
}
