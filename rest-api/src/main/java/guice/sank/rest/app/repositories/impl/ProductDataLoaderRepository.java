package guice.sank.rest.app.repositories.impl;

import com.google.inject.Inject;
import guice.sank.rest.app.clients.CmsClient;
import guice.sank.rest.app.domainObjects.sfdc.ProductOffer;
import guice.sank.rest.app.repositories.DataLoaderRepository;

public class ProductDataLoaderRepository implements DataLoaderRepository {

	private final CmsClient cmsClient;

	@Inject
	public ProductDataLoaderRepository(CmsClient cmsClient) {
		this.cmsClient = cmsClient;
	}

	@Override
	public void postRequestToCms(ProductOffer productOffer) {

	}
}
