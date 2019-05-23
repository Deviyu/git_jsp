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
 * Servlet implementation class SumCalculation
 */
@WebServlet("/sumCalculation")
public class SumCalculation extends HttpServlet {
	private static final Logger logger = LoggerFactory
			.getLogger(SumCalculation.class);

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		
		int sumResult = 0;
		String calcProgress = "";
		
		
		for(int i = start; i<=end; i++) {
			sumResult += i;
			
			if(i!=start) {
				calcProgress += " + " + String.valueOf(i);
			} else {
				calcProgress += String.valueOf(i);
			}
			
		}
		logger.debug("sumResult : {} = {}", calcProgress, sumResult);
		
		request.getSession().setAttribute("sumResult", sumResult);
		request.getRequestDispatcher("/sumResult.jsp").forward(request, response);
	}

}
