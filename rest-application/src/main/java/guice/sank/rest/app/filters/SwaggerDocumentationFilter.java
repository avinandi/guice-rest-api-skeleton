package guice.sank.rest.app.filters;

import com.google.inject.Singleton;
import com.wordnik.swagger.jersey.config.JerseyJaxrsConfig;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class SwaggerDocumentationFilter implements Filter {
	private ServletContext servletContext;
	private volatile Boolean swaggerConfigInitialized = false;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		servletContext = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if(!swaggerConfigInitialized) {
			initializeSwaggerConfiguration((HttpServletRequest)request);
			swaggerConfigInitialized = true;
		}
		chain.doFilter(request, response);
	}

	private void initializeSwaggerConfiguration(HttpServletRequest request) {
		final String basePath = getBasePath(request);
		final ServletConfig servletConfig = new SwaggerServletConfig(servletContext, basePath);
		new JerseyJaxrsConfig().init(servletConfig);
	}

	private static String getBasePath(HttpServletRequest request) {
		return new StringBuilder().append(request.getScheme()).append("://").append(request.getServerName())
				.append(":").append(request.getServerPort()).append(request.getContextPath()).toString();
	}

	@Override
	public void destroy() {
	}

	private static class SwaggerServletConfig implements ServletConfig {
		private final ServletContext context;
		private final Map<String, String> initParam;

		public SwaggerServletConfig(ServletContext servletContext, String basePath) {
			this.context = servletContext;
			this.initParam = new HashMap<>();
			initParam.put("api.version", "1.0.1");
			initParam.put("swagger.api.basepath", basePath);
		}

		@Override
		public String getServletName() {
			return null;
		}

		@Override
		public ServletContext getServletContext() {
			return context;
		}

		@Override
		public String getInitParameter(String name) {
			return initParam.get(name);
		}

		@Override
		public Enumeration<String> getInitParameterNames() {
			return Collections.enumeration(initParam.keySet());
		}
	}
}
