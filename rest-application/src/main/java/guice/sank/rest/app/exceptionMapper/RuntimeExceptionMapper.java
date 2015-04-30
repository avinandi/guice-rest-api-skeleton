package guice.sank.rest.app.exceptionMapper;

import guice.sank.rest.app.exceptions.CmsDataAccessException;
import guice.sank.rest.app.exceptions.NoResultFoundFromCmsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import static javax.ws.rs.core.Response.*;

public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {
	public static final Logger LOGGER = LoggerFactory.getLogger(RuntimeExceptionMapper.class);

	@Override
	public Response toResponse(RuntimeException exception) {
		Status status = Status.INTERNAL_SERVER_ERROR;
		if(exception instanceof IllegalArgumentException) {
			status = Status.BAD_REQUEST;
			LOGGER.info(exception.getMessage(), exception);
		} else if(exception instanceof IllegalStateException) {
			status = Status.BAD_REQUEST;
			LOGGER.info(exception.getMessage(), exception);
		} else if(exception instanceof NoResultFoundFromCmsException) {
			status = Status.NOT_FOUND;
			LOGGER.info(exception.getMessage(), exception);
		} else if(exception instanceof CmsDataAccessException) {
			LOGGER.warn(exception.getMessage(), exception);
		}

		return Response.status(status).type(MediaType.TEXT_PLAIN).entity(exception.getMessage()).build();
	}
}
