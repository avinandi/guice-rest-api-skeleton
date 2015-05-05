package guice.sank.rest.app.domainObjects.sfdc;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import guice.sank.rest.app.domainObjects.DomainObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfigAttribute extends DomainObject {
	public final String name;
	public final String value;

	@JsonCreator
	public ConfigAttribute(@JsonProperty("name") String name, @JsonProperty("value") String value) {
		this.name = name;
		this.value = value;
	}
}
