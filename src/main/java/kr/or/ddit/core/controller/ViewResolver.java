package kr.or.ddit.core.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {
	public static void viewResolve(HttpServletRequest request, HttpServletResponse response, String viewName) throws IOException, ServletException{
		
		if(viewName.startsWith("redirect:")) {
			response.sendRedirect(viewName.substring("redirect:".length()));
		} else {
			request.getRequestDispatcher(viewName).forward(request, response);
		}
		
	}
}
