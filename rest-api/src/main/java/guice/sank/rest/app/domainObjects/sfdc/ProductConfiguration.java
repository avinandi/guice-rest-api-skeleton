package guice.sank.rest.app.domainObjects.sfdc;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import guice.sank.rest.app.domainObjects.DomainObject;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductConfiguration extends DomainObject {
	public final List<ConfigAttribute> configAttributes;

	@JsonCreator
	public ProductConfiguration(@JsonProperty("configAttributes") List<ConfigAttribute> configAttributes) {
		this.configAttributes = configAttributes;
	}
}
