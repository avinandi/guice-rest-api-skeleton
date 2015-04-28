package guice.sank.rest.app.di;

import com.google.inject.Module;

public class LocalGuiceRestApiContext extends GuiceRestApiContext {

	public LocalGuiceRestApiContext() {
		super(getLocalModules());
	}

	private static Module[] getLocalModules() {
		return new Module[] {
				// Add Local modules
		};
	}
}
