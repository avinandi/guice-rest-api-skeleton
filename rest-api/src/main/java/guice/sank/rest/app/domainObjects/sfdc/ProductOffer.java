package guice.sank.rest.app.domainObjects.sfdc;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModelProperty;
import guice.sank.rest.app.domainObjects.DomainObject;

import java.util.List;

public class ProductOffer extends DomainObject {
	@ApiModelProperty(required = true)
	public final List<ActiveOffer> activeOffers;

	@JsonCreator
	public ProductOffer(@JsonProperty("activeOffers") List<ActiveOffer> activeOffers) {
		this.activeOffers = activeOffers;
	}
}
