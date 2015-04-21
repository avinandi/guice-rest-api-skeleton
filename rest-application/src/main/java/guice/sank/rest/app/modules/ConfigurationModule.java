package guice.sank.rest.app.modules;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import guice.sank.rest.app.di.GuiceRestApiContext;

import java.util.Properties;
import java.util.ResourceBundle;

public class ConfigurationModule extends AbstractModule {
	private Class<? extends GuiceRestApiContext> clazz;

	public ConfigurationModule(Class<? extends GuiceRestApiContext> clazz) {
		this.clazz = clazz;
	}

	@Override
	protected void configure() {
		Names.bindProperties(binder(), resourceBundleToProperties(ResourceBundle.getBundle(clazz.getName())));
	}

	public static Properties resourceBundleToProperties(ResourceBundle resourceBundle) {
		final Properties properties = new Properties();
		resourceBundle.keySet().forEach(key -> properties.put(key, resourceBundle.getString(key)));
		return properties;
	}
}
