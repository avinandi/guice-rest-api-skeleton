package guice.sank.rest.app.exceptions;

public class MaintenanceException extends RuntimeException {
	public MaintenanceException(String message) {
		super(message);
	}

	public MaintenanceException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
