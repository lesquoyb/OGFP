package modele.exception.cotisation;

public class ExceptionNomVide extends Exception {

	public ExceptionNomVide() {
		super("Le nom doit être mentionné");
	}

	public ExceptionNomVide(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ExceptionNomVide(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ExceptionNomVide(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ExceptionNomVide(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
