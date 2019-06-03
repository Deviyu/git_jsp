package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

import org.apache.ibatis.javassist.Loader.Simple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class UserModify
 */
@WebServlet("/userModify")
public class UserModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory
			.getLogger(UserModifyController.class);
	
	private IUserService userService;
	private SimpleDateFormat sdf;
	@Override
	public void init() throws ServletException {
		userService = new UserService();
		sdf = new SimpleDateFormat("yyyy-MM-dd");
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		logger.debug("userId : {}", userId);
		UserVO userVO = userService.getUser(userId);
		request.setAttribute("userVO", userVO);
		request.getRequestDispatcher("/user/userModify.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId		 = request.getParameter("userId");
		String name 		 = request.getParameter("name");
		String pass 		 = request.getParameter("pass");
		String alias 		 = request.getParameter("alias");
		String zipcd 		 = request.getParameter("zipcd");
		String addr1 		 = request.getParameter("addr1");
		String addr2 		 = request.getParameter("addr2");
		String filename 	 = request.getParameter("filename") == null ? "noimage.png" : request.getParameter("filename");
		String birth_str	 = request.getParameter("birth");
		
		Date birth 			 = null;
		try { birth = sdf.parse(birth_str); } catch (ParseException e) { e.printStackTrace();}
		
		UserVO userVO = new UserVO(userId, name, alias, pass,
				addr1, addr2, zipcd, birth, filename);
		
		int result = userService.updateUser(userVO);
		
		request.setAttribute("result", result);
		response.sendRedirect(request.getContextPath()+ "/user?userId="+userId+"&result=1");
		
	}

}
