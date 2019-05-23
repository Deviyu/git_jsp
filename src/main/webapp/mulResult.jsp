<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mulResult.jsp</title>
</head>
<body>
	값 1 : <%=request.getParameter("param1") %><br>
	값 2 : <%=request.getParameter("param2") %><br>
	계산결과 : <%=session.getAttribute("mulResult") %><br>
</body>
</html>