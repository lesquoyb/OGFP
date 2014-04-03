package modele;

import modele.exception.cotisation.ExceptionNomContientCaractereSpe;
import modele.exception.cotisation.ExceptionNomInvalide;
import modele.exception.cotisation.ExceptionNomNombre;
import modele.exception.cotisation.ExceptionNomVide;
import modele.exception.cotisation.ExceptionTauxCotisationNegatif;
import modele.exception.cotisation.ExceptionTauxCotisationString;
import modele.exception.cotisation.ExceptionTauxSupUn;
import modele.exception.cotisation.ExceptionTauxVide;
import outils.Outils;

public class Cotisation {
	

	private String nom;
	
	private double taux;
	
	private boolean supprime;
	
	public Cotisation() {
		this.nom = "Nom";
		this.taux = 0;
	}

	public Cotisation(String nom, double taux) {
		this.nom = nom;
		this.taux = taux;
	}

	
	
	public Cotisation(String nom, double taux, boolean supprime) {
		this.nom = nom;
		this.taux = taux;
		this.supprime = supprime;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public boolean isSupprime() {
		return supprime;
	}

	public void setSupprime(boolean supprime) {
		this.supprime = supprime;
	}
	
	public boolean getSupprime(){
		return supprime;
	}

	public static boolean isValidNom(String nom) throws ExceptionNomContientCaractereSpe, ExceptionNomVide, ExceptionNomNombre, ExceptionNomInvalide{
		
		String temp = nom.replaceAll("\\s", "");
		if ( temp.equals("")){
			throw new ExceptionNomVide();
		}
		if (temp.equals("Nom")){
			throw new ExceptionNomInvalide();
		}
		try{
			Double.parseDouble(temp);
		}
		catch(NumberFormatException e){
			if (Outils.contientCaracInterdit(temp)){

				throw new ExceptionNomContientCaractereSpe();
			}	

			return true;
		}
		throw new ExceptionNomNombre();
	}
		
	
	public Cotisation cloner(){
		return new Cotisation(nom,taux,supprime);
	}

	public static boolean isValid(String nom , String taux) throws ExceptionNomContientCaractereSpe, ExceptionTauxCotisationString, ExceptionTauxSupUn, ExceptionTauxCotisationNegatif, ExceptionNomVide, ExceptionTauxVide, ExceptionNomNombre, ExceptionNomInvalide {
		return isValidNom(nom) && isValidTaux(taux);
	}
	
	public static boolean isValidTaux(String Taux) throws ExceptionTauxCotisationString, ExceptionTauxSupUn, ExceptionTauxCotisationNegatif, ExceptionTauxVide{
		
		String temp = Taux.replaceAll("\\s", "");
		if ( temp.equals("")){
			throw new ExceptionTauxVide();
		}
		if (!( Outils.isDouble(temp) || Outils.isInteger(temp) )){
			throw new ExceptionTauxCotisationString();
		}
		double taux = Double.parseDouble(temp);
		if (taux >= 1) {
			throw new ExceptionTauxSupUn();
		}

		if (taux <=0) {
			throw new ExceptionTauxCotisationNegatif();
		}

		return true;

		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cotisation other = (Cotisation) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (Double.doubleToLongBits(taux) != Double
				.doubleToLongBits(other.taux))
			return false;
		return true;
	}

}
