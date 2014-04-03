package modele.exception.variable;

public class ExceptionVariableNumerique extends Exception {

	public ExceptionVariableNumerique() {
		super("La variable ne doit pas être un nombre.");
	}

}
