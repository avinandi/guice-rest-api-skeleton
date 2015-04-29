package guice.sank.rest.app.modules;

import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import com.sun.jersey.spi.container.servlet.ServletContainer;
import guice.sank.rest.app.filters.CharacterEncodingFilter;
import guice.sank.rest.app.filters.JerseyRestApplication;
import guice.sank.rest.app.filters.SwaggerDocumentationFilter;

import java.util.HashMap;
import java.util.Map;

public class RestModule extends JerseyServletModule {

	@Override
	public void configureServlets() {
		filter("/*").through(CharacterEncodingFilter.class);
		filter("/api-docs", "/api-docs/*").through(SwaggerDocumentationFilter.class);
		serve("/*").with(GuiceContainer.class, getApplicationMap());
	}

	private Map<String, String> getApplicationMap() {
		return new HashMap<String, String>(){{
			put(ServletContainer.APPLICATION_CONFIG_CLASS, getRestApplicationName());
			put(ResourceConfig.FEATURE_DISABLE_WADL, "true");
		}};
	}

	protected String getRestApplicationName() {
		return JerseyRestApplication.class.getName();
	}
}
