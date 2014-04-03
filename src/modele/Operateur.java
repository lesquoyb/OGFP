package modele;

import outils.Outils;

public final class Operateur {

	public static String[] listeOperateurs =  {"<=",">=","<",">","="};
	
	private String valeur;
	
	public Operateur(String op){
		if ( isValid(op) ){
			valeur = op;
		}
	}
	
	public Operateur(){
		valeur = listeOperateurs[0];
	}
	
	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	/**
	 * Test si une expression est bien un operateur de comparaison.
	 * @param operateur
	 * @return
	 * 		true ou false;
	 */
	public static boolean isValid(String operateur){
		
		String temp = operateur.replaceAll("\\s", "");
			for(int i = 0 ; i < listeOperateurs.length ; i ++){
				if (listeOperateurs[i].equals(temp)){
					return true;
				}
			}
			return false;		
	}
	
	public static boolean contientOperateur(String expression){
		
		String chTemp =" " + expression + " ";
		for (String s : listeOperateurs){
			String[] temp =  chTemp.split(s);
			if ( temp.length >= 2 ){
				return true;
			}
		}
		return false;
	}

	
	/**
	 * Renvoie l'operateur contenue dans une expression. S'il n'y en a pas, renvoie une chaine vide.
	 * @param expression
	 * @return
	 */
	public static String operateurContenu(String expression){
		
		String chTemp =" " + expression + " ";
		for (String s : listeOperateurs){
			String[] temp =  chTemp.split(s);
			if ( temp.length >= 2 ){
				return s;
			}
		}
		return "";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operateur other = (Operateur) obj;
		if (valeur == null) {
			if (other.valeur != null)
				return false;
		} else if (!valeur.equals(other.valeur))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return valeur;
	}
	
	
	/**
	 * Retourne le résultat de la comparaison entre deux doubles.
	 * Si le signe n'appartient pas à la liste des signes de la classe Operateur, le resultat sera false.
	 * @param valeur1
	 * @param o
	 * @param valeur2
	 * @return
	 */
	public boolean resultatOperation(double valeur1, double valeur2){
		
		if (this.getValeur().equals("<=")){
			return valeur1 <= valeur2 ;
		}
		if (this.getValeur().equals(">=")){
			return valeur1 >= valeur2 ;
		}
		if (this.getValeur().equals("=")){
			return valeur1 == valeur2 ;
		}
		if (this.getValeur().equals("<")){
			return valeur1 < valeur2 ;
		}
		if (this.getValeur().equals(">")){
			return valeur1 > valeur2 ;
		}
		
		return false;
	}
	
	
	/**
	 * Retourne le résultat de la comparaison entre deux String.
	 * Si le signe n'est pas "=" et que les deux valeurs ne sont pas des nombres, le resultat sera false.
	 * @param v1
	 * @param o
	 * @param v2
	 * @return
	 */
	public boolean resultatOperation(String v1, String v2){
		if ( Outils.isDouble(v1) && Outils.isDouble(v2)){	
			return this.resultatOperation(Double.parseDouble(v1), Double.parseDouble(v2));
		}
		if (this.getValeur().equals("=")){
			return v1.equals(v2);
		}
		return false;
	}
	
	
}
