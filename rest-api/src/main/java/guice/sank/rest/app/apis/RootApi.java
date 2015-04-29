package guice.sank.rest.app.apis;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Api(value = "RootResource", description = "Provides the root html")
@Path("/")
public class RootApi {

	@GET
	@Produces({"text/html"})
	@ApiOperation(value = "Get swagger documentation link", response = String.class)
	public String getIndexHtml() {
		return new StringBuilder().append("<html>")
				.append("<p>Guice Skeleton</p>")
				.append("<p>See Documentation: <a href=\"documentation\">documentation</a></p>")
				.append("</html>")
				.toString();
	}
}
