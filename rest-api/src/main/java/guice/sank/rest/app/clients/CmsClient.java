package guice.sank.rest.app.clients;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.sun.jersey.api.client.Client;
import guice.sank.rest.app.annotation.CmsApi;
import guice.sank.rest.app.domainObjects.DomainObject;

import javax.inject.Singleton;

@Singleton
public class CmsClient extends AbstractClient {

	@Inject
	public CmsClient(@CmsApi Client cmsClient, @Named("cms.base.uri") String baseUrl) {
		super(cmsClient, baseUrl);
	}
}
