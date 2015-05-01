package guice.sank.rest.app.exceptions;

public class ApiClientValidationException extends RuntimeException {
	public ApiClientValidationException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public ApiClientValidationException(String message) {
		super(message);
	}
}
