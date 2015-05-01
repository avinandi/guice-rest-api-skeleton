package guice.sank.rest.app.objectMapper;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Optional;

public class GuiceRestApplicationObjectMapperProvider extends DefaultObjectMapperProvider {

	@Override
	public Object readFrom(Class<Object> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException {
		Optional<Object> optionalObject = Optional.ofNullable(
				super.readFrom(type, genericType, annotations, mediaType, httpHeaders, entityStream));
		Object object = optionalObject.orElseThrow(() -> new WebApplicationException(buildResponse("")));
		return object;
	}

	private Response buildResponse(String msg) {
		return Response.status(Response.Status.BAD_REQUEST).type(MediaType.TEXT_PLAIN).entity(msg).build();
	}
}
