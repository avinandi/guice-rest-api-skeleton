package guice.sank.rest.app.domainObjects.sfdc;

import guice.sank.rest.app.domainObjects.DomainObject;

public class ConfigAttribute extends DomainObject {
	private String name;
	private String value;

	private ConfigAttribute() {}

	public ConfigAttribute(String name, String value) {
		this.name = name;
		this.value = value;
	}
}
