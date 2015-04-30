package guice.sank.rest.app.exceptions;

public class CmsDataAccessException extends RuntimeException {

	public CmsDataAccessException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public CmsDataAccessException(String message) {
		super(message);
	}
}
