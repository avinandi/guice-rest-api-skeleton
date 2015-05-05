package guice.sank.rest.app.domainObjects.cms;

import guice.sank.rest.app.domainObjects.DomainObject;

import java.util.List;

public class Property extends DomainObject {
	public final String name;
	public final String type;
	public final String multiple;
	public final List<String> values;

	public Property(final String name, final String type, final String multiple, final List<String> values) {
		this.name = name;
		this.type = type;
		this.multiple = multiple;
		this.values = values;
	}
}
