package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class ElServlet
 */
@WebServlet("/el")
public class ElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(ElServlet.class);
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		logger.debug("service : {}", req.getRequestURI());
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세가지 Scope 객체에 서로 같은 id를 가졌지만 다른 value를 가진 속성을 부여
		request.setAttribute("userId", "brown/request");
		request.getSession().setAttribute("userId", "cony/session");
		getServletContext().setAttribute("userId", "sally/application");
		
		request.getRequestDispatcher("/el/el.jsp").forward(request, response);
	}

	

}
