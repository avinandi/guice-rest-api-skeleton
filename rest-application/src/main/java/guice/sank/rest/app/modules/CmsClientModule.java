package guice.sank.rest.app.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;
import guice.sank.rest.app.annotation.CmsApi;

public class CmsClientModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Client.class).annotatedWith(CmsApi.class).toProvider(CmsClientProvider.class);
	}

	private static class CmsClientProvider implements Provider<Client> {
		private final String crmUsername;
		private final String cmsPassword;

		@Inject
		public CmsClientProvider(@Named("cms.username") String userName, @Named("cms.password") String password) {
			this.crmUsername = userName;
			this.cmsPassword = password;
		}

		@Override
		public Client get() {
			final ClientConfig config = new DefaultClientConfig();
			config.getProperties().put(ClientConfig.PROPERTY_CONNECT_TIMEOUT, 10 * 1000);
			config.getProperties().put(ClientConfig.PROPERTY_READ_TIMEOUT, 10 * 1000);
			Client cmsClient= Client.create(config);
			cmsClient.addFilter(new CmsJerseyClientFilter());
			return cmsClient;
		}

		private class CmsJerseyClientFilter extends ClientFilter {
			@Override
			public ClientResponse handle(ClientRequest clientRequest) throws ClientHandlerException {
				clientRequest.getHeaders().add("user", crmUsername);
				clientRequest.getHeaders().add("password", cmsPassword);
				return getNext().handle(clientRequest);
			}
		}
	}
}
