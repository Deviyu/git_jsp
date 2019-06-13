package kr.or.ddit.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class RequestCountFilter
 */
@WebFilter("/*")
public class RequestCountFilter implements Filter {
	Map<String, Integer> countMap;
    
	public RequestCountFilter() {
        // TODO Auto-generated constructor stub
    }
	
    public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//전처리
		String uri = ((HttpServletRequest)request).getRequestURI();
		if(uri!=null) {
			int count = countMap.getOrDefault(uri, 0);
			countMap.put(uri, ++count);
		}
		chain.doFilter(request, response);
		//후처리
	}

	public void init(FilterConfig fConfig) throws ServletException {
		countMap = new HashMap<>();
		countMap.put("testValue", 10);
		fConfig.getServletContext().setAttribute("countMap", countMap);
	}

}
