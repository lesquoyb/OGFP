package modele;

import java.util.ArrayList;

public class ListeRegle {

	ArrayList<Regle> liste;
	
	public ListeRegle() {
		this.liste = new ArrayList<Regle>();
		this.liste.add(new Regle());
	}
	
	public ListeRegle(ArrayList<Regle> regles) {
		this.liste = regles;
	}

	public ArrayList<Regle> getRegles() {
		return liste;
	}

	public void setRegles(ArrayList<Regle> regles) {
		this.liste = regles;
	}
	
	public void creationRegle() {
		this.liste.add(new Regle(new Condition(),new Action()));
	}
	
	public void ajoutRegle(Regle r){
		liste.set(liste.size()-1, r);
		liste.add(new Regle());
	}
	
	public void supprimerRegle(int id) {
		this.liste.get(id).setSupprime(true);
	}
	
	public void retablirRegle(int id) {
		this.liste.get(id).setSupprime(false);
	}
	
	public void modifierRegle(int id, Regle r) {
		this.liste.set(id, r);
	}


	public void retirerTotalementListe(int id){
		this.liste.remove(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListeRegle other = (ListeRegle) obj;
		if (liste == null) {
			if (other.liste != null)
				return false;
		} else if (!liste.equals(other.liste))
			return false;
		return true;
	}

	
}
