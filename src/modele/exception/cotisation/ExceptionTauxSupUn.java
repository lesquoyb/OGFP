package modele.exception.cotisation;

public class ExceptionTauxSupUn extends Exception {

	public ExceptionTauxSupUn() {
		super("Le taux est un pourcentage du brut, par conséquent il ne peut pas être supérieur à 100.");
	}

	public ExceptionTauxSupUn(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ExceptionTauxSupUn(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ExceptionTauxSupUn(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ExceptionTauxSupUn(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
