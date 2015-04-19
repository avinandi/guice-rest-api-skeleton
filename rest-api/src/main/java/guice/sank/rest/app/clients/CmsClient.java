package guice.sank.rest.app.clients;

import com.google.inject.Inject;
import com.sun.jersey.api.client.Client;
import guice.sank.rest.app.annotation.CmsApi;

import javax.inject.Singleton;

@Singleton
public class CmsClient extends AbstractClient {
	private final Client cmsClient;

	@Inject
	public CmsClient(@CmsApi Client cmsClient) {
		this.cmsClient = cmsClient;
	}

	/*public void get() {
		cmsClient.resource("").get();
	}*/
}
