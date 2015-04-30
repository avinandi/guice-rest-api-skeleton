package guice.sank.rest.app.exceptions;

public class NoResultFoundFromCmsException extends RuntimeException {

	public NoResultFoundFromCmsException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public NoResultFoundFromCmsException(String message) {
		super(message);
	}
}
