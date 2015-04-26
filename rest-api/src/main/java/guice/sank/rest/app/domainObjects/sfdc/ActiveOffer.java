package guice.sank.rest.app.domainObjects.sfdc;

import guice.sank.rest.app.domainObjects.DomainObject;

import java.util.List;

public class ActiveOffer extends DomainObject {
	private List<ProductConfiguration> productConfiguration;
	private Offer offer;
	private String cmsCategory;

	private ActiveOffer() {}

	public ActiveOffer(List<ProductConfiguration> productConfiguration, Offer offer, String cmsCategory) {
		this.productConfiguration = productConfiguration;
		this.offer = offer;
		this.cmsCategory = cmsCategory;
	}
}
