package guice.sank.rest.app.filters;

import com.google.inject.Singleton;

import javax.servlet.*;
import java.io.IOException;

@Singleton
public class DocumentationStaticContentFilter implements Filter {
	private RequestDispatcher dispatcher;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ServletContext context = filterConfig.getServletContext();
		this.dispatcher = context.getNamedDispatcher("default");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		this.dispatcher.forward(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
	}
}
