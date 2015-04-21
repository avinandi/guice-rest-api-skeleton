package guice.sank.rest.app.domainObjects;

public class Offer extends DomainObject {
	private String Name;
	private String Id;

	private Offer() {}

	public Offer(String Name, String Id) {
		this.Name = Name;
		this.Id = Id;
	}
}
