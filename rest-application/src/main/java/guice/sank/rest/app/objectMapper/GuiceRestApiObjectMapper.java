package guice.sank.rest.app.objectMapper;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

public class GuiceRestApiObjectMapper extends ObjectMapper {

	public GuiceRestApiObjectMapper() {
		disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		super.setAnnotationIntrospector(createAnnotationIntrospectors());
		registerModule(new Jdk8Module());
	}

	private AnnotationIntrospector createAnnotationIntrospectors() {
		//First try to use JAXB annotations like @XmlElement, then Jackson annotations like @JsonProperty
		AnnotationIntrospector primary = new JaxbAnnotationIntrospector(getTypeFactory());
		AnnotationIntrospector secondary =  new JacksonAnnotationIntrospector();
		return AnnotationIntrospector.pair(primary, secondary);
	}
}
