package kr.or.ddit.locale.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class SelectLocaleController
 */
@WebServlet("/selectLocale")
public class SelectLocaleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(SelectLocaleController.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("/selectLocale doGet()");
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		logger.debug("/selectLocale doPost()");
		String locale = request.getParameter("locale") == null ? request.getLocale().getLanguage() : request.getParameter("locale");
		request.setAttribute("locale", locale);
		request.getRequestDispatcher("/jstl/selectLocale.jsp").forward(request, response);
	}
}
