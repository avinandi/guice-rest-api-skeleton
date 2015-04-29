package guice.sank.rest.app.server;

import com.google.inject.Module;
import guice.sank.rest.app.di.LocalGuiceRestApiContext;

import java.util.List;

public class StartJetty {

	public static class StartLocalContext {
		public static void main(String[] args) throws Exception {
			List<Module> injectableModules = new LocalGuiceRestApiContext().getModules();
			TestServer testServer = new JettyStarter(9999, injectableModules.stream().toArray(Module[]::new));
			testServer.start();
		}
	}

	public static class StartLocalWebContext {
		public static void main(String[] args) throws Exception {
			System.setProperty("application.environment.context", LocalGuiceRestApiContext.class.getCanonicalName());
			TestServer testServer = new JettyStarter(9999);
			testServer.start();
		}
	}
}
