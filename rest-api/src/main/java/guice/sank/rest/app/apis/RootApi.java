package guice.sank.rest.app.apis;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class RootApi {

	@GET
	@Produces({"text/html"})
	public String getIndexHtml() {
		return new StringBuilder().append("<html>")
				.append("<p>Guice Skeleton</p>")
				.append("<p>See Documentation: <a href=\"documentation\">documentation</a></p>")
				.append("</html>")
				.toString();
	}
}
