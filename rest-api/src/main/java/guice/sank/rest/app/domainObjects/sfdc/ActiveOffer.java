package guice.sank.rest.app.domainObjects.sfdc;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModelProperty;
import guice.sank.rest.app.domainObjects.DomainObject;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActiveOffer extends DomainObject {
	@ApiModelProperty(required = true)
	public final List<ProductConfiguration> productConfiguration;
	@ApiModelProperty(required = true)
	public final Offer offer;
	@ApiModelProperty(required = true)
	public final String cmsCategory;

	@JsonCreator
	public ActiveOffer(@JsonProperty("productConfiguration") List<ProductConfiguration> productConfiguration, @JsonProperty("offer") Offer offer,
			@JsonProperty("cmsCategory") String cmsCategory) {
		this.productConfiguration = productConfiguration;
		this.offer = offer;
		this.cmsCategory = cmsCategory;
	}
}
