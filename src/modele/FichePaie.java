package modele;

public class FichePaie {
	
	private ListeCotisation cotisations;
	private ListeRegle regles;
	private Employe employe;
	
	public FichePaie(ListeCotisation cotis, ListeRegle regles, Employe employe) {
		
		this.cotisations = cotis;
		this.regles = regles;
		this.employe = employe;
		
	}

	public FichePaie(){
		cotisations = new ListeCotisation();
		regles = new ListeRegle();
		employe = new Employe();
	}
	public ListeCotisation getCotisations() {
		return cotisations;
	}

	public void setCotisations(ListeCotisation cotisations) {
		this.cotisations = cotisations;
	}

	public ListeRegle getRegles() {
		return regles;
	}

	public void setRegles(ListeRegle regles) {
		this.regles = regles;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FichePaie other = (FichePaie) obj;
		if (cotisations == null) {
			if (other.cotisations != null)
				return false;
		} else if (!cotisations.equals(other.cotisations))
			return false;
		if (employe == null) {
			if (other.employe != null)
				return false;
		} else if (!employe.equals(other.employe))
			return false;
		if (regles == null) {
			if (other.regles != null)
				return false;
		} else if (!regles.equals(other.regles))
			return false;
		return true;
	}


	

}


