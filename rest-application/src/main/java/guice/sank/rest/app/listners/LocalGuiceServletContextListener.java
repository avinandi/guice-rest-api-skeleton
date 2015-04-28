package guice.sank.rest.app.listners;

import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class LocalGuiceServletContextListener extends GuiceServletContextListener {
	final Injector injector;

	public LocalGuiceServletContextListener(Injector injector) {
		this.injector = injector;
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
