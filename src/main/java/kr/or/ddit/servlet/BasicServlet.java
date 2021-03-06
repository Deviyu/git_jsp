package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("BasicServlet init()");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.write("<html>");
		pw.write("	<head>");
		pw.write("		<title>Hello World!</title>");
		pw.write("		<style>");
		pw.write("			span { font-weight : bold; }");
		pw.write("		</style>");
		pw.write("	</head>");
		pw.write("	<body>");
		pw.write("		<span>Hello, World!</span>");
		pw.write("	</body>");
		pw.write("</html>");
		pw.close();
	}
	
}
