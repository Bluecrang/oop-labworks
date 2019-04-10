package by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.exception;

public class InputException extends BusinessException{

	private static final long serialVersionUID = -6361371802048771077L;

	public InputException() {
		super();
	}

	public InputException(String message, Throwable cause) {
		super(message, cause);
	}

	public InputException(String message) {
		super(message);
	}

	public InputException(Throwable cause) {
		super(cause);
	}
}
