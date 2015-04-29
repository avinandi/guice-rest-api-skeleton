package guice.sank.rest.app.filters;

import com.sun.jersey.api.core.PackagesResourceConfig;
import guice.sank.rest.app.apis.CmsRestApi;
import guice.sank.rest.app.apis.RootApi;

import java.util.Set;

public class JerseyRestApplication extends PackagesResourceConfig {
	public JerseyRestApplication() {
		super(getServletPackages());
		Set<Class<?>> classes = super.getClasses();
		addRestModules(classes);
	}

	private void addRestModules(Set<Class<?>> classes) {
		classes.add(RootApi.class);
		classes.add(CmsRestApi.class);
	}

	private static String[] getServletPackages() {
		return new String[] {
				"com.wordnik.swagger.jaxrs.listing"
		};
	}
}
