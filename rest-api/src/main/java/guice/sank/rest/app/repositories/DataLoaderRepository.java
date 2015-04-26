package guice.sank.rest.app.repositories;

import guice.sank.rest.app.domainObjects.sfdc.ProductOffer;

public interface DataLoaderRepository {
	void postRequestToCms(ProductOffer productOffer);
}
