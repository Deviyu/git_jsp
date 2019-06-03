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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class UserCreateController
 */
@WebServlet("/userForm")
public class UserFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory
			.getLogger(UserFormController.class);
	
	private IUserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 사용자 등록 화면으로 이동
		request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
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
		String filename 	 = request.getParameter("filename");
		String birth_str	 = request.getParameter("birth");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birth 			 = null;
		try { birth = sdf.parse(birth_str); } catch (ParseException e) { e.printStackTrace();}
		
		UserVO userVO = new UserVO(userId, name, alias, pass,
				addr1, addr2, zipcd, birth, filename);
		
		//사용자가 입력한 userId가 이미 존재하는 userId인지 체크
		UserVO checkDupl = userService.getUser(userId);
		logger.debug("checkDupl : {}",checkDupl);
		//존재하지 않을 경우
		if(checkDupl==null) {
			int result = userService.insertUser(userVO);
			if(result == 1) {
				//정상입력시
				//사용자 페이징리스트 1페이지로 이동
				response.sendRedirect(request.getContextPath() + "/userPagingList?result=1");
			} else {
				//비정상처리시
				//사용자가 입력한 값을 input에 다시 넣어준다.
				request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
			}
		} else {
		//존재할 경우
			//이미 존재하는 userId입니다. 라는 alert창을 띄운다.
			//사용자 등록페이지로 이동, 사용자가 입력한 값을 input에 넣어준다.
			request.setAttribute("duplId", "true");
			doGet(request, response);
		}
		
	}

}
