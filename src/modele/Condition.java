package modele;

import outils.Outils;

public class Condition {



	
	private boolean valeurCondition;
	private Variable variable;
	private Operateur operateur;
	private String valeurTest;
	
	public Condition(){
		variable = new Variable();
		operateur = new Operateur();
		valeurTest = "";
		valeurCondition = false;
	}
	
	
	public Condition(String partieGauche,String partieDroite,Operateur operateur){
		variable = new Variable(partieGauche);
		this.operateur = operateur;
		valeurTest = partieDroite;
	}
	
	/**
	 * Attention il faut tester si la chaine est valide avant !
	 * @param expression
	 */
	public Condition(String expression){
		String temp = expression.replaceAll("\\s", "");
		String[] partiesCondition;
		if ( Operateur.contientOperateur(temp)){
			String s = Operateur.operateurContenu(temp);
			partiesCondition = temp.split(s);
			variable = new Variable(partiesCondition[0]);
			operateur = new Operateur(s);
			valeurTest = partiesCondition[1];
		}
	}
	
	
	/**
	 * Test si une expression est une condition valide.
	 * @param condition
	 * @return
	 * 			true ou false.
	 */
	public static boolean isValid(String condition){
		
		String temp = condition.replaceAll("\\s", "");
		String[] partiesCondition;
		
		for (int i = 0 ; i < Operateur.listeOperateurs.length; i ++){
			partiesCondition = temp.split(Operateur.listeOperateurs[i]);
			if (partiesCondition.length == 2){

				if(Variable.isValid(partiesCondition[0]) && 
						(Outils.isDouble(partiesCondition[1]) || Outils.isInteger(partiesCondition[1])) ){
					return true;
				}
				else{
					return false;
				}
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
		Condition other = (Condition) obj;
		if (operateur == null) {
			if (other.operateur != null)
				return false;
		} else if (!operateur.equals(other.operateur))
			return false;
		if (valeurCondition != other.valeurCondition)
			return false;
		if (valeurTest == null) {
			if (other.valeurTest != null)
				return false;
		} else if (!valeurTest.equals(other.valeurTest))
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
		return variable.toString() + operateur + valeurTest;
	}


	public boolean isValeurCondition() {
		return valeurCondition;
	}


	public void setValeurCondition(boolean valeurCondition) {
		this.valeurCondition = valeurCondition;
	}


	public Variable getVariable() {
		return variable;
	}


	public void setVariable(Variable variable) {
		this.variable = variable;
	}


	public Operateur getOperateur() {
		return operateur;
	}


	public void setOperateur(Operateur operateur) {
		this.operateur = operateur;
	}


	public String getValeurTest() {
		return valeurTest;
	}


	public void setValeurTest(String valeurTest) {
		this.valeurTest = valeurTest;
	}
	
	
	
	
	 
	
	
	

}
