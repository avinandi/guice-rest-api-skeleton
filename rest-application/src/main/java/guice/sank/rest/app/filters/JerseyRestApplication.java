package guice.sank.rest.app.filters;

import com.sun.jersey.api.core.PackagesResourceConfig;

public class JerseyRestApplication extends PackagesResourceConfig {
	public JerseyRestApplication() {
		super(getServletPackages());
	}

	private static String[] getServletPackages() {
		return new String[] {
				"com.wordnik.swagger.jaxrs.listing",
				"guice.sank.rest.app.apis"
		};
	}
}
