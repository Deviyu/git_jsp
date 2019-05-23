package kr.or.ddit.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.UserVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class LoginController
 */
/**
* LoginController.java
* 로그인 처리 컨트롤러
* @author PC07
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* PC07 최초 생성
*
* </pre>
*/

// web.xml servlet, servlet-mapping --> java annotation 
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	private static final long serialVersionUID = 1L;
	
	// 사용자 로그인 화면 요청 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("LoginController doGet()");
		
		//Login  화면을 처리해줄 누군가에게 위임.
		//단순 Login화면을 html로 응답을 생성해주는 작업이 필요.
		// /login/login.jsp으로 위임 -> 서버상에서 별도의 상태변경을 만드는 요청이 아니기때문에 Dispatch 방식으로 위임.
		if(request.getSession().getAttribute("USER_INFO")!=null) {
			//session에 사용자 정보가 있을 경우 --> main화면으로 이동
			logger.debug("사용자 정보 있음");
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		} else {
			//session에 사용자 정보가 없을 경우 --> 기존 로직대로 로그인 화면으로 이동
//		response.sendRedirect(request.getContextPath() + "/login/login.jsp"); (만약 리다이렉트를 한다면)
			logger.debug("사용자 정보 없음");
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		}
	}
	
	// 로그인 요청 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("parameter userId (Ctrl) : {}", request.getParameter("userId"));
		logger.debug("parameter password (Ctrl) : {}", request.getParameter("password"));
		
		//사용자 Parameter : userId, password
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		//db에서 해당사용자의 정보조회 (service, dao 필요)
		// omit.
		
		//해당 사용자 정보를 이용하여 사용자가 보낸 userId, password가 일치하는지 검사
		// -> userId : brown, password : brown1234일때 일치판정
		if(userId.equals("brown") && password.equals("brown1234")) {
			//만약, 일치하면.. (로그인 성공)
			//Session에 사용자 정보를 넣어준다. (사용 빈도가 높음)
			
			HttpSession session = request.getSession();
			session.setAttribute("USER_INFO", new UserVO("브라운", "brown", "곰"));
			//메인화면으로 이동 (Dispatch)
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		} else {
			//만약, 불일치하면.. (아이디 혹은 비밀번호가 잘못 입력되었음)
			//로그인 화면으로 이동 : localhost/jsp/login
			//현 상황에서는 /jsp/login url로 dispatch 할 수 없음 (Method 방식이 Post 상태이기 때문)
			response.sendRedirect(request.getContextPath() + "/login");
		}
		
		
	}

}
