package kr.or.ddit.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

/**
 * Servlet implementation class UserCreateController
 */
@WebServlet("/userCreate")
public class UserCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory
			.getLogger(UserCreateController.class);
	
	private IUserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String alias = request.getParameter("alias");
		String birth = request.getParameter("birth");
		String zipcd = request.getParameter("zipcd");
		String addr1 = request.getParameter("addr1");
		String addr2 =request.getParameter("addr2");
		String filename = request.getParameter("filename");
		
		UserVO userVO = new UserVO(userId, name, alias, pass,
							addr1, addr2, zipcd, birth, filename);
		
		int result = userService.insertUser(userVO);
		request.setAttribute("result", result);
		request.getRequestDispatcher("/user/result.jsp").forward(request, response);
	}

}
