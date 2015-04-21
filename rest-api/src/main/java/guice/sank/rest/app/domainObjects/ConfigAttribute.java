package guice.sank.rest.app.domainObjects;

public class ConfigAttribute extends DomainObject {
	private String name;
	private String value;

	private ConfigAttribute() {}

	public ConfigAttribute(String name, String value) {
		this.name = name;
		this.value = value;
	}
}
