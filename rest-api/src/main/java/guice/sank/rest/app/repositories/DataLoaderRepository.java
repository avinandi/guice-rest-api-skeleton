package guice.sank.rest.app.repositories;

import guice.sank.rest.app.domainObjects.ProductOffer;

public interface DataLoaderRepository {
	void postRequestToCms(ProductOffer productOffer);
}
