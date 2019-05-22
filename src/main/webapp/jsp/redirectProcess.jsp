<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RedirectProcess.jsp</title>
</head>
<body>
	<%	
		System.out.println("userId parameter redirectProcess : " + request.getParameter("userId"));
		//sendRedirect 메서드의 인자 값을 웹브라우저가 수신한 후에 주소줄에 그대로 붙여넣음.
		response.sendRedirect(request.getContextPath() + "/jsp/redirectTarget.jsp?userId=sally");
	%>
</body>
</html>