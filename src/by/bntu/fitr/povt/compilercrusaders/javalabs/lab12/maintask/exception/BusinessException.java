package by.bntu.fitr.povt.compilercrusaders.javalabs.lab12.maintask.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 593307475228832486L;

	public BusinessException() {
		super();
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

}
