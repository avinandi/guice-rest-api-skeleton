package guice.sank.rest.app.modules;

import com.google.inject.AbstractModule;
import guice.sank.rest.app.repositories.DataLoaderRepository;
import guice.sank.rest.app.repositories.impl.ProductDataLoaderRepository;

public class RepositoryModule extends AbstractModule {
	@Override
	protected void configure() {
		install(new DataLoaderRepositoryModule());
	}

	private class DataLoaderRepositoryModule extends AbstractModule {
		@Override
		protected void configure() {
			bind(DataLoaderRepository.class).to(ProductDataLoaderRepository.class);
		}
	}
}
