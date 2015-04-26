package guice.sank.rest.app.domainObjects.sfdc;

import guice.sank.rest.app.domainObjects.DomainObject;

import java.util.List;

public class ProductOffer extends DomainObject {
	private List<ActiveOffer> activeOffers;

	private ProductOffer(){}

	public ProductOffer(List<ActiveOffer> activeOffers) {
		this.activeOffers = activeOffers;
	}
}
