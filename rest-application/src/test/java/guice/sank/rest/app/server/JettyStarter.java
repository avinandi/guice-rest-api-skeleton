package guice.sank.rest.app.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.GuiceFilter;
import guice.sank.rest.app.listners.LocalGuiceServletContextListener;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.webapp.WebAppContext;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class JettyStarter implements TestServer {
	private final Server server;

	public JettyStarter(Integer port, Module... modules) {
		this.server = new Server(port);
		final WebAppContext webAppContext = new WebAppContext(".", "/");
		this.server.setHandler(webAppContext);
		createServletContext(webAppContext, modules);
	}

	private void createServletContext(WebAppContext webAppContext, Module... modules) {
		final Injector injector = Guice.createInjector(modules);
		final FilterHolder filterHolder = new FilterHolder(GuiceFilter.class);

		webAppContext.addEventListener(new LocalGuiceServletContextListener(injector));
		webAppContext.addFilter(filterHolder, "/*", EnumSet.of(DispatcherType.REQUEST));
	}

	@Override
	public String getServerUrl() {
		return "http://localhost:" + getActualPort();
	}

	private Integer getActualPort() {
		return ((ServerConnector)this.server.getConnectors()[0]).getLocalPort();
	}

	@Override
	public void start() throws Exception {
		this.server.start();
	}

	@Override
	public void stop() throws Exception {
		this.server.stop();
	}
}
