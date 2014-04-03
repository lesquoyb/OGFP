package modele;

import outils.Outils;

public class Action {
	
	/** Pour plus tard, ces operateurs servent à effectuer des actions telles que l'addition.*/
	//private static String[] operateurAction = {"+","-","*","="};
	private Variable variable;
	private double valeur;
	
	
	public Variable getVariable() {
		return variable;
	}

	public void setVariable(Variable variable) {
		this.variable = variable;
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

	public Action(){
		variable = new Variable("Test");
		valeur = 0;
	}
	
	public Action(Variable var,double valeur){
		variable = var;
		this.valeur = valeur;
	}

	/**
	 * Attention il faut tester si la chaine est valide avant
	 * @param expression
	 */
	public Action(String expression){
		String temp = expression.replaceAll("\\s", "");
		String[] partiesAction = temp.split("=");
		variable = new Variable(partiesAction[0]);
		valeur = Double.parseDouble(partiesAction[1]);
	}
	
	
	/**
	 * Vérifie si une expression est une action valide.
	 * @param action
	 * @return
	 * 			true ou false.
	 */
	public static boolean isValid(String action){

		String temp = action.replaceAll("\\s", "");
		String[] partiesAction = temp.split("=");
		if (partiesAction.length == 2){
			
			if (Variable.isValid(partiesAction[0]) &&
					(Outils.isDouble(partiesAction[1]) || Outils.isInteger(partiesAction[1]))){
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
		Action other = (Action) obj;
		if (Double.doubleToLongBits(valeur) != Double
				.doubleToLongBits(other.valeur))
			return false;
		if (variable == null) {
			if (other.variable != null)
				return false;
		} else if (!variable.equals(other.variable))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return variable.toString() +"="+ valeur ;
	}

	
	
	
}
