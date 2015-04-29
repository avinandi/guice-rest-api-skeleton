package guice.sank.rest.app.domainObjects.cms;

import guice.sank.rest.app.domainObjects.DomainObject;

import java.util.List;

public class CmsNode extends DomainObject {
	public final String name;
	public final String type;
	public final String path;
	public final List<Property> properties;

	public CmsNode(final String name, final String path, final List<Property> properties) {
		this.name = name;
		this.path = path;
		this.properties = properties;
		this.type = "mgnl:contentNode";
	}

	private CmsNode() {
		this(null, null, null);
	}
}
