package modele.exception.brut;

public class ExceptionBrutNegatif extends Exception{

	public ExceptionBrutNegatif() {
		super("Un brut doit toujours être positif");
	}

	public ExceptionBrutNegatif(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ExceptionBrutNegatif(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ExceptionBrutNegatif(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ExceptionBrutNegatif(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
