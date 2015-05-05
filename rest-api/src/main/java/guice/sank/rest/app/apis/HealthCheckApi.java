package guice.sank.rest.app.apis;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Api(value = "Health check resource", description = "Provides the news about health")
@Path("/health-check")
public class HealthCheckApi {

	@GET
	@Path("/ping")
	@ApiOperation(value = "Check server is reachable", response = String.class)
	@Produces({"text/plain"})
	public String ping() {
		return "pong...";
	}
}
