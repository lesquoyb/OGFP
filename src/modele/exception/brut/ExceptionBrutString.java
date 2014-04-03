package modele.exception.brut;

public class ExceptionBrutString extends Exception{

	public ExceptionBrutString() {
		super("Le brut ne doit contenir que des chiffres.");
	}

	public ExceptionBrutString(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExceptionBrutString(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ExceptionBrutString(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ExceptionBrutString(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
