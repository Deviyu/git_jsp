package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter("/*")
public class LoginCheckFilter implements Filter {
	private static final Logger logger = LoggerFactory
			.getLogger(LoginCheckFilter.class);
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = ((HttpServletRequest)request);
		// /login, /js, /css /image
		String uri = req.getRequestURI();
		uri = uri.substring(req.getContextPath().length());
		logger.debug("uri : {}", uri);
		if( uri.startsWith("/login") || uri.startsWith("/js") || uri.startsWith("/css") || uri.startsWith("/bootstrap") || uri.startsWith("/image") || uri.startsWith("/requestCount")) {
			chain.doFilter(request, response);
		} else if(req.getSession().getAttribute("USER_INFO") != null) {
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse)response).sendRedirect(req.getContextPath() + "/login");
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
