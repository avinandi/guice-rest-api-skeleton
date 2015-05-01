package guice.sank.rest.app.objectMapper;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Provider
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class DefaultObjectMapperProvider extends JacksonJaxbJsonProvider {

	public DefaultObjectMapperProvider() {
		super(new GuiceRestApiObjectMapper(), DEFAULT_ANNOTATIONS);
	}
}
