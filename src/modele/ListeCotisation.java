package modele;

import java.util.ArrayList;

public class ListeCotisation {
	
	private ArrayList<Cotisation> cotisations;
	
	public ListeCotisation() {
		this.cotisations = new ArrayList<Cotisation>();
		this.cotisations.add(new Cotisation());
	}
	
	public ListeCotisation(ArrayList<Cotisation> cotisations) {
		this.cotisations = cotisations;
	}

	public ArrayList<Cotisation> getCotisations() {
		return cotisations;
	}

	public void setCotisations(ArrayList<Cotisation> cotisations) {
		this.cotisations = cotisations;
	}
	
	public void creationCotisationVide() {
		this.cotisations.add(new Cotisation());
	}
	
	public void ajouterCotisation(Cotisation cotisation) {
		this.cotisations.set(this.cotisations.size()-1, cotisation);
		creationCotisationVide();
	}
	
	public void supprimerCotisation(int id) {
		this.cotisations.get(id).setSupprime(true);
		
	}
	
	public void retablirCotisation(int id) {
		this.cotisations.get(id).setSupprime(false);
	}

	public void modifierCotisation(int id, Cotisation cotisation) {
		this.cotisations.set(id, cotisation);
	}

	public void retirerTotalementListe(int id){
		this.cotisations.remove(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListeCotisation other = (ListeCotisation) obj;
		if (cotisations == null) {
			if (other.cotisations != null)
				return false;
		} else if (!cotisations.equals(other.cotisations))
			return false;
		return true;
	}

	

}
