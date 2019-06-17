package kr.or.ddit.core.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.controller.Controller;
import kr.or.ddit.dao.DbDaoImpl;
import kr.or.ddit.dao.IDbDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@WebServlet("*.do")
public class FrontController extends HttpServlet{
	private static final Logger logger = LoggerFactory
			.getLogger(FrontController.class);
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		super.doGet(req, resp);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		super.doPost(req, resp);
//	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.debug("Service : {}",request.getRequestURI());
		String uri = request.getRequestURI();
		logger.debug("uri : {}", uri);
		Controller controller = RequestMapping.getController(uri);
		logger.debug("controller : {}",controller);
		String viewName = controller.execute(request, response);
		logger.debug("viewName : {}",viewName);
		ViewResolver.viewResolve(request, response, viewName);
	}
	
}
