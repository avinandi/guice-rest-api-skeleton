package guice.sank.rest.app.domainObjects;

import java.util.List;

public class ProductConfiguration extends DomainObject {
	private List<ConfigAttribute> configAttributes;

	private ProductConfiguration() {}

	public ProductConfiguration(List<ConfigAttribute> configAttributes) {
		this.configAttributes = configAttributes;
	}
}
