package guice.sank.rest.app.filters;

import com.sun.jersey.api.core.PackagesResourceConfig;

public class JerseyRestApplication extends PackagesResourceConfig {
	public JerseyRestApplication() {
		super(getServletPackages());
	}

	private static String[] getServletPackages() {
		return new String[] {
				"guice.sank.rest.app.apis"
		};
	}
}
