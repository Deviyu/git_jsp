<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:set var="userId" value="${USER_INFO.alias }" scope="request"/>
	userId : ${userId} <br>
	<c:set target="${USER_INFO}" property="alias" value="문"/>
	USER_INFO.alias : ${USER_INFO.alias } <br>
	
	<h2>c:if *** c:if는 java의 if - else if - else중에서 if만 해당</h2>
	<h2>c:choose가 일반적인 if문에 해당</h2>
	<c:if test="${USER_INFO.userId == 'brown' }">
		으악 곰이다
	</c:if>
	<c:if test="${USER_INFO.userId == 'sally' }">
		으악 닭이다
	</c:if>
</body>
</html>