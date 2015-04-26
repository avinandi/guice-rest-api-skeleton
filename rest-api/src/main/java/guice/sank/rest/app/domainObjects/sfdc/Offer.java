package guice.sank.rest.app.domainObjects.sfdc;

import guice.sank.rest.app.domainObjects.DomainObject;

public class Offer extends DomainObject {
	private String Name;
	private String Id;

	private Offer() {}

	public Offer(String Name, String Id) {
		this.Name = Name;
		this.Id = Id;
	}
}
