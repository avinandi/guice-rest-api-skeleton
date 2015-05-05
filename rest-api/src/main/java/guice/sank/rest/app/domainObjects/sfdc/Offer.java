package guice.sank.rest.app.domainObjects.sfdc;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import guice.sank.rest.app.domainObjects.DomainObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Offer extends DomainObject {
	public final String Name;
	public final String Id;

	@JsonCreator
	public Offer(@JsonProperty("Name") String Name, @JsonProperty("Id") String Id) {
		this.Name = Name;
		this.Id = Id;
	}
}
