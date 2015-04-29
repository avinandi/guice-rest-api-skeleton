package guice.sank.rest.app.filters;

import javax.servlet.*;
import java.io.IOException;

public class DocumentationStaticContentFilter implements Filter {
	private RequestDispatcher dispatcher;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ServletContext context = filterConfig.getServletContext();
		dispatcher = context.getNamedDispatcher("default");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		dispatcher.forward(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
	}
}
