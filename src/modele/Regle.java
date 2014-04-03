package modele;

public class Regle {

	
	private Condition condition;
	
	private Action action;
	
	private boolean supprime;
	
	public Regle(){
		condition = new Condition();
		action = new Action();
	}
	
	public Regle(Condition c, Action a) {
		condition = c;
		action = a;
	}

	/**
	 * Verifie si une chaine est bien au format necessaire à créer une regle, 
	 * c'est à dire une partie condition et une partie action toutes les deux valide.
	 * @param expression
	 * @return
	 */
	public static boolean isValid(String expression) {
		
		String temp = expression.replaceAll("\\s", "");
		String[] conditionAction = temp.split("/");
		
		if (conditionAction.length==2){
			if ( Condition.isValid(conditionAction[0]) && Action.isValid(conditionAction[1]) ){
				return true;
			}
		}

		return false;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public boolean isSupprime() {
		return supprime;
	}

	public void setSupprime(boolean supprime) {
		this.supprime = supprime;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Regle other = (Regle) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (condition == null) {
			if (other.condition != null)
				return false;
		} else if (!condition.equals(other.condition))
			return false;
		return true;
	}


}
