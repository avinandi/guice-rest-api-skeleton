package guice.sank.rest.app.clients;

import com.sun.jersey.api.client.Client;

public abstract class AbstractClient {
	protected Client client;
	private String baseUri;

	protected AbstractClient(Client client, String baseUri) {
		this.client = client;
		this.baseUri = baseUri;
	}

	public <T> T doGet(String resourcePath, Class<? extends T> clazz) {
		return this.client.resource(constructUrl(resourcePath)).get(clazz);
	}

	public <T> T doPostAndExtractResponse(String resourcePath, Object obj, Class<? extends T> clazz) {
		return this.client.resource(constructUrl(resourcePath)).post(clazz, obj);
	}

	public void doPost(String resourcePath, Object obj) {
		this.client.resource(constructUrl(resourcePath)).post(obj);
	}

	public <T> T doPutAndExtractResponse(String resourcePath, Object obj, Class<? extends T> clazz) {
		return this.client.resource(constructUrl(resourcePath)).put(clazz, obj);
	}

	public void doPut(String resourcePath, Object obj) {
		this.client.resource(constructUrl(resourcePath)).put(obj);
	}

	private String constructUrl(String resourcePath) {
		return baseUri + resourcePath;
	}
}
