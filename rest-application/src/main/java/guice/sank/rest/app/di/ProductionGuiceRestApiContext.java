package guice.sank.rest.app.di;

import com.google.inject.Module;

public class ProductionGuiceRestApiContext extends GuiceRestApiContext {

	public ProductionGuiceRestApiContext() {
		super(getProductionModules());
	}

	private static Module[] getProductionModules() {
		return new Module[]{
				// Add production specific modules here
		};
	}
}
