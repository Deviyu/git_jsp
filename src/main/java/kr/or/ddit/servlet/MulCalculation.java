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
 * Servlet implementation class MulCalculation
 */
@WebServlet("/jsp/mulCalculation")
public class MulCalculation extends HttpServlet {
	private static final Logger logger = LoggerFactory
			.getLogger(MulCalculation.class);
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int param1 = Integer.parseInt(request.getParameter("param1"));
		int param2 = Integer.parseInt(request.getParameter("param2"));
		int mulResult = param1 * param2;
		
		logger.debug("{} * {} = {} ", param1, param2, mulResult);
		
		request.getSession().setAttribute("mulResult", mulResult);
		request.getRequestDispatcher("/mulResult.jsp").forward(request, response);
		
	}

}
