package guice.sank.rest.app.filters;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	}

	@Override
	public void destroy() {
	}
}
