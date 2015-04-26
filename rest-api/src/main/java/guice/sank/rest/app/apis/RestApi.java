package guice.sank.rest.app.apis;

import com.google.inject.Inject;
import guice.sank.rest.app.domainObjects.sfdc.ProductOffer;
import guice.sank.rest.app.repositories.DataLoaderRepository;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces({MediaType.APPLICATION_JSON})
@Path("/cms")
public class RestApi {

	@Inject
	private DataLoaderRepository dataLoaderRepository;

	@Path("/")
	@POST
	public void postProductData(final ProductOffer productOffer) {
		dataLoaderRepository.postRequestToCms(productOffer);
	}
}
