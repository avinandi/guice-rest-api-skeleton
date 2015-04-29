package guice.sank.rest.app.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.GuiceFilter;
import guice.sank.rest.app.listners.LocalGuiceServletContextListener;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.webapp.WebAppContext;

import javax.servlet.DispatcherType;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import static guice.sank.rest.app.server.JettyStarter.LocalServer.*;

public class JettyStarter implements TestServer {
	private final Server server;
	private ServerConnector httpConnector;
	private WebAppContext context;

	public JettyStarter(Integer port, Module... modules) {
		this.server = new Server(port);
		final WebAppContext webAppContext = new WebAppContext(".", "/");
		this.server.setHandler(webAppContext);
		createServletContext(webAppContext, modules);
	}

	public JettyStarter(Integer port) {
		this.server = createServer(port, httpConnector);
		context = deployApplicationTo(this.server, new HashMap<>());
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

	@Override
	public boolean isStarted() {
		return this.server.isStarted();
	}

	@Override
	public boolean isFailed() {
		return this.server.isFailed() || this.context.isFailed();
	}

	public static class LocalServer {

		public static Server createServer(Integer httpPort, ServerConnector httpConnector) {
			final Server createdServer = new Server();
			if (httpPort != null) {
				httpConnector = new ServerConnector(createdServer);
				httpConnector.setPort(httpPort);
				createdServer.addConnector(httpConnector);
			}
			return createdServer;
		}

		public static WebAppContext deployApplicationTo(Server server, Map<String, String> resources) {
			final ContextHandlerCollection contexts = new ContextHandlerCollection();
			for (Map.Entry<String, String> resource : resources.entrySet()) {
				final ResourceHandler handler = new ResourceHandler();
				handler.setCacheControl("no-store");
				contexts.addContext(resource.getKey(), resource.getValue()).setHandler(handler);
			}
			final WebAppContext webAppContext = new WebAppContext(getModule(), getContextPath());
			contexts.addHandler(webAppContext);
			server.setHandler(contexts);
			return webAppContext;
		}

		private static String getContextPath() {
			return "/";
		}

		public static String getModule() {
			return getProjectPath() + "/rest-application" + "/src/main/webapp";
		}

		public static String getProjectPath() {
			return ProjectRootFinder.findProjectRoot().getPath();
		}
	}
}
