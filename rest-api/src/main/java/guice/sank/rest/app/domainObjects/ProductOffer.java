package guice.sank.rest.app.domainObjects;

import java.util.List;

public class ProductOffer extends DomainObject {
	private List<ActiveOffer> activeOffers;

	private ProductOffer(){}

	public ProductOffer(List<ActiveOffer> activeOffers) {
		this.activeOffers = activeOffers;
	}
}
