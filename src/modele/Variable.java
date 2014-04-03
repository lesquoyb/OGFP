package modele;

import outils.Outils;

public class Variable {

	private String valeur;
	
	
	public Variable(){
		valeur="";
	}
	
	public Variable(String val){
		valeur = val;
	}
	
	/**
	 * Test si une expression est une variable.
	 * @param variable
	 * @return
	 * 			true ou false.
	 */
	public static boolean isValid(String variable){
		
		String temp = variable.replaceAll("\\s", "");
		if (temp.length()>0){
			if ( ! Outils.isDouble(temp)  && ! Operateur.contientOperateur(temp)  &&  ! Outils.contientCaracInterdit(temp)){
				return true;
			}
		}
		return false;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Variable other = (Variable) obj;
		if (valeur == null) {
			if (other.valeur != null)
				return false;
		} else if (!valeur.equals(other.valeur))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return  valeur;
	}
	



	
	
	
}
