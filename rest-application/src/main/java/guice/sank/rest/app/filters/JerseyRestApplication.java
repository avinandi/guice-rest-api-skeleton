package guice.sank.rest.app.filters;

import com.sun.jersey.api.core.PackagesResourceConfig;
import guice.sank.rest.app.apis.CmsRestApi;
import guice.sank.rest.app.apis.HealthCheckApi;
import guice.sank.rest.app.apis.RootApi;
import guice.sank.rest.app.exceptionMapper.RuntimeExceptionMapper;
import guice.sank.rest.app.objectMapper.GuiceRestApplicationObjectMapperProvider;

import java.util.Set;

public class JerseyRestApplication extends PackagesResourceConfig {
	public JerseyRestApplication() {
		super(getServletPackages());
		Set<Class<?>> classes = super.getClasses();
		addRestModules(classes);
		addExceptionMapperModules(classes);
		addObjectMapperModules(classes);
	}

	private void addRestModules(Set<Class<?>> classes) {
		classes.add(RootApi.class);
		classes.add(HealthCheckApi.class);
		classes.add(CmsRestApi.class);
	}

	private void addExceptionMapperModules(Set<Class<?>> classes) {
		classes.add(RuntimeExceptionMapper.class);
	}

	private void addObjectMapperModules(Set<Class<?>> classes) {
		classes.add(GuiceRestApplicationObjectMapperProvider.class);
	}

	private static String[] getServletPackages() {
		return new String[] {
				"com.wordnik.swagger.jaxrs.listing"
		};
	}
}
