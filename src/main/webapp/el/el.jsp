<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- scope객체에 저장한 속성명 -->
	userId : ${userId}<br>
	<!-- 특정 scope 객체에 있는 속성을 명시적으로 가져올 경우 -->
	userId(pageScope) : ${pageScope.userId}<br>
	userId(requestScope) : ${requestScope.userId}<br>
	userId(sessionScope) : ${sessionScope.userId}<br>
	userId(applicationScope) : ${applicationScope.userId}<br>
	<%session.removeAttribute("userId");%>
	
	<h2>EL로 파라미터 접근 = param.파라미터명</h2>
	${param.userId} 
</body>
</html>