package guice.sank.rest.app.di;

import com.google.common.collect.Lists;
import com.google.inject.Module;
import guice.sank.rest.app.modules.CmsClientModule;
import guice.sank.rest.app.modules.ConfigurationModule;
import guice.sank.rest.app.modules.RepositoryModule;
import guice.sank.rest.app.modules.RestModule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class GuiceRestApiContext {
	private final List<Module> injectableModules;

	protected GuiceRestApiContext(final Module... modules) {
		injectableModules = Lists.newArrayList();
		injectableModules.addAll(Arrays.asList(modules));
		injectableModules.addAll(createModules());
	}

	private List<? extends Module> createModules() {
		return new ArrayList<Module>() {{
			add(new ConfigurationModule(getContextClass()));
			add(new RestModule());
			add(new RepositoryModule());
			add(new CmsClientModule());
		}};
	}

	public List<Module> getModules() {
		return injectableModules;
	}

	private Class<? extends GuiceRestApiContext> getContextClass() {
		return getClass();
	}
}
