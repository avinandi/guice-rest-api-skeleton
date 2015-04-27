package guice.sank.rest.app.modules;

import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import com.sun.jersey.spi.container.servlet.ServletContainer;
import guice.sank.rest.app.filters.CharacterEncodingFilter;
import guice.sank.rest.app.filters.JerseyRestApplication;
import guice.sank.rest.app.filters.SwaggerDocumentationFilter;

import java.util.HashMap;
import java.util.Map;

public class RestModule extends ServletModule {

	@Override
	public void configureServlets() {
		super.configureServlets();
		filter("/api-docs", "/api-docs/*").through(SwaggerDocumentationFilter.class);
		filter("/*").through(CharacterEncodingFilter.class);
		serve("/*").with(GuiceContainer.class, getApplicationMap());
	}

	private Map<String, String> getApplicationMap() {
		return new HashMap<String, String>(){{
			put(ServletContainer.APPLICATION_CONFIG_CLASS, getRestApplicationName());
		}};
	}

	protected String getRestApplicationName() {
		return JerseyRestApplication.class.getName();
	}
}
