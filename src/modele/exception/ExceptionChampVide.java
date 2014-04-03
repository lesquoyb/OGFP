package modele.exception;

public class ExceptionChampVide extends Exception{

	public ExceptionChampVide() {
		super("Le champ ne doit pas être vide");
	}

	protected ExceptionChampVide(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	protected ExceptionChampVide(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	protected ExceptionChampVide(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	protected ExceptionChampVide(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
