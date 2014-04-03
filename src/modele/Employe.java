package modele;

import modele.exception.ExceptionChampVide;
import modele.exception.brut.ExceptionBrutNegatif;
import modele.exception.brut.ExceptionBrutString;
import modele.exception.cotisation.ExceptionNomContientCaractereSpe;
import modele.exception.nom.ExceptionNomContientChiffre;
import outils.Outils;

public class Employe {

	private String nom;
	private String prenom;
	private String statut;
	private double salaireBrut;
	private double salaireNet;
	
	
	public Employe(String nom, String prenom, String statut,double salaireBrut) {
		this.nom = nom;
		this.prenom = prenom;
		this.statut = statut;
		this.salaireBrut = salaireBrut;
		this.salaireNet = salaireBrut;
	}
	

	public Employe(String nom, String prenom, String statut,
			double salaireBrut, double salaireNet) {
		this.nom = nom;
		this.prenom = prenom;
		this.statut = statut;
		this.salaireBrut = salaireBrut;
		this.salaireNet = salaireNet;
	}


	public Employe(){
		nom ="";
		prenom = "";
		statut="";
		salaireBrut=0;
		salaireNet=0;
	}
	
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	public double getSalaireBrut() {
		return salaireBrut;
	}


	public void setSalaireBrut(double salaireBrut) {
		this.salaireBrut = salaireBrut;
	}


	public double getSalaireNet() {
		return salaireNet;
	}


	public void setSalaireNet(double salaireNet) {
		this.salaireNet = salaireNet;
	}
	
	/**
	 * Indique si un nom ou un prenom sont valide.
	 * @param nom
	 * @return
	 * @throws ExceptionChampVide 
	 * @throws ExceptionNomContientCaractereSpe 
	 */
	public static boolean isValidNom(String nom) throws ExceptionChampVide, ExceptionNomContientCaractereSpe, ExceptionNomContientChiffre{
		String temp = nom.replace("\\s", "");
		if (temp.equals("")){
			throw new ExceptionChampVide();
		}
		for (int i = 0; i < 10 ; i++){
			if (nom.contains(String.valueOf(i))){
				throw new ExceptionNomContientChiffre();
			}
		}
		if (Operateur.contientOperateur(nom) || Outils.contientCaracInterdit(nom)){
			throw new ExceptionNomContientCaractereSpe();
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
		Employe other = (Employe) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (Double.doubleToLongBits(salaireBrut) != Double
				.doubleToLongBits(other.salaireBrut))
			return false;
		if (Double.doubleToLongBits(salaireNet) != Double
				.doubleToLongBits(other.salaireNet))
			return false;
		if (statut == null) {
			if (other.statut != null)
				return false;
		} else if (!statut.equals(other.statut))
			return false;
		return true;
	}


	public static boolean isValid(Employe e) throws ExceptionChampVide, ExceptionNomContientCaractereSpe, ExceptionNomContientChiffre, ExceptionBrutNegatif, ExceptionBrutString{
		if (e == null){
			throw new ExceptionBrutString();
		}
		else{
			return (Employe.isValidNom(e.getNom())
					&& Employe.isValidNom(e.getPrenom())
					&& Outils.isStatut(e.getStatut())
					&& Brut.isValid(e.getSalaireBrut())
					&& Brut.isValid(e.getSalaireNet()));
		}
	}
	
	
}
