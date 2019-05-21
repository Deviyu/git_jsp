package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimesServlet extends HttpServlet{
	private Logger logger = LoggerFactory.getLogger(TimesServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String param = req.getParameter("j");
		String param2 = req.getParameter("i");
		
		//trace / debug / info / warn / error
		logger.debug("param : {}", param);
		logger.debug("param2 : {}", param2);
		
		int param_int = Integer.parseInt(param);
		int param2_int = Integer.parseInt(param2);
		
		
		logger.debug("param_int : {}", param_int);
		logger.debug("param2_int : {}", param2_int);
		
		PrintWriter writer = resp.getWriter();
		
		writer.write("<html>");
		writer.write("	<head>");
		writer.write("		<title>TimesTable</title>");
		writer.write("		<style>");
		writer.write("			td { border : 1px solid black; width : 100px; height : 50px; text-align : center; }"); 
		writer.write("		</style>");
		writer.write("	</head>");
		writer.write("	<body>");
		writer.write("		<table>");
		
		for(int num = 1; num < (param2_int + 1); num++) {
			writer.write("<tr>");
			for(int dan = 2; dan < (param_int + 1); dan++) {
				writer.write("<td>" + dan + " * " + num + " = " + (dan * num) + "</td>");
			}
			writer.write("</tr>");
		}
		
		writer.write("		</table>");
		writer.write("	</body>");
		writer.write("</html>");
		writer.close();
	}
}
