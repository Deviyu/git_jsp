<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sumResult.jsp</title>
</head>
<body>
	시작값 : <%=request.getParameter("start") %> <br> 
	종료값 : <%=request.getParameter("end") %> <br>
	합산결과 : <%=session.getAttribute("sumResult") %>
</body>
</html>