package guice.sank.rest.app.domainObjects.sfdc;

import guice.sank.rest.app.domainObjects.DomainObject;

import java.util.List;

public class ProductConfiguration extends DomainObject {
	private List<ConfigAttribute> configAttributes;

	private ProductConfiguration() {}

	public ProductConfiguration(List<ConfigAttribute> configAttributes) {
		this.configAttributes = configAttributes;
	}
}
