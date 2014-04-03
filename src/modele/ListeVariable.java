package modele;

import java.util.ArrayList;
import java.util.Hashtable;

public class ListeVariable {
	
	Hashtable<String,String> tableVariables;
	
	public ListeVariable(){
		tableVariables = new Hashtable<String,String>();
	}
	
	public ListeVariable(Hashtable<String, String> table ){
		tableVariables = table;
	}
	
	public ArrayList<String> getValeurs(){
		return new ArrayList<String>(tableVariables.values());
	}
	
	/**
	 * Met à jour les couples clefs/valeurs . si les tableaux ne sont pas de même taille, rien ne se passe.
	 * @param clefs
	 * @param valeurs
	 */
	public void setCouples(ArrayList<String> clefs, ArrayList<String> valeurs){
		this.tableVariables.clear();
		if (clefs.size() == valeurs.size()){
			int i = 0;
			for( String c : clefs){
				String v =valeurs.get(i);
				tableVariables.put(c, v);
				i++;
			}
		}
	}
	
	public void supprimer(String clef){
		tableVariables.remove(clef);
	}
	public boolean contientClef(String clef){
		return tableVariables.get(clef) != null;
	}
	
	public void ajouter(String clef, String valeur){
		tableVariables.put(clef, valeur);
	}
	
	public String get(String clef){
		return tableVariables.get(clef);
	}

	public void viderTable(){
		tableVariables.clear();
	}
	
}

