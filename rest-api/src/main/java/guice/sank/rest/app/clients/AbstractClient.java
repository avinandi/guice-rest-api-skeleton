package guice.sank.rest.app.clients;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import guice.sank.rest.app.exceptions.ApiClientValidationException;
import guice.sank.rest.app.exceptions.CmsDataAccessException;
import guice.sank.rest.app.exceptions.MaintenanceException;
import guice.sank.rest.app.exceptions.NoResultFoundFromCmsException;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class AbstractClient {
	protected Client client;
	private String baseUri;

	protected AbstractClient(Client client, String baseUri) {
		this.client = client;
		this.baseUri = baseUri;
	}

	public <T> Function<String, T> doGet(Class<? extends T> clazz) {
		return (String resourcePath) -> this.client.resource(constructUrl(resourcePath)).get(clazz);
	}

	public <T> Function<String, T> doPostAndExtractResponse(Object obj, Class<? extends T> clazz) {
		return (String resourcePath) -> this.client.resource(constructUrl(resourcePath)).post(clazz, obj);
	}

	public Consumer<String> doPost(Object obj) {
		return (String resourcePath) -> this.client.resource(constructUrl(resourcePath)).post(obj);
	}

	public <T> Function<String, T> doPutAndExtractResponse(Object obj, Class<? extends T> clazz) {
		return (String resourcePath) -> this.client.resource(constructUrl(resourcePath)).put(clazz, obj);
	}

	public Consumer<String> doPut(Object obj) {
		return (String resourcePath) -> this.client.resource(constructUrl(resourcePath)).put(obj);
	}

	private String constructUrl(String resourcePath) {
		return baseUri + resourcePath;
	}

	public static class HandleWithException {

		public static void consume(String resourcePath, Consumer<String> consumer) {
			try {
				consumer.accept(resourcePath);
			} catch (UniformInterfaceException ex) {
				handleUniformInterfaceException(ex);
			}
		}

		public static <T> T apply(String resourcePath, Function<String, T> function) {
			return applyAndReturnOptional(resourcePath, function).orElseThrow(() -> new NoResultFoundFromCmsException(""));
		}

		public static <T> Optional<T> applyAndReturnOptional(String resourcePath, Function<String, T> function) {
			try {
				return Optional.ofNullable(function.apply(resourcePath));
			} catch (UniformInterfaceException ex) {
				return handleUniformInterfaceException(ex);
			}
		}

		private static <T> Optional<T> handleUniformInterfaceException(UniformInterfaceException ex) {
			switch (ex.getResponse().getStatus()) {
			case HttpServletResponse.SC_NOT_FOUND: throw new NoResultFoundFromCmsException("Not found", ex);
			case HttpServletResponse.SC_BAD_REQUEST: throw new ApiClientValidationException("Validation failed", ex);
			case HttpServletResponse.SC_SERVICE_UNAVAILABLE: throw new MaintenanceException("Service unavailable as of now", ex);
			case HttpServletResponse.SC_NO_CONTENT: return Optional.empty();
			default: throw new CmsDataAccessException("Data access exception", ex);
			}
		}
	}
}
