<%@page import="kr.or.ddit.paging.model.PageVO"%>
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
	<h2>c:set - 로그인 후 테스트 할 것</h2>
<%-- 	<c:set var="userId" value="${USER_INFO.alias }" scope="request"/> --%>
<%-- 	userId : ${userId} <br> --%>
<%-- 	<c:set target="${USER_INFO}" property="alias" value="문"/> --%>
<%-- 	USER_INFO.alias : ${USER_INFO.alias } <br> --%>
	
	<h2>c:if *** c:if는 java의 if - else if - else중에서 if만 해당</h2>
	<h2>c:choose가 일반적인 if문에 해당</h2>
	<c:if test="${USER_INFO.userId == 'brown' }">
		으악 곰이다
	</c:if>
	<c:if test="${USER_INFO.userId == 'sally' }">
		으악 닭이다
	</c:if>
	
	<h2>c:choose 자바의 if - else if - else 구문</h2>
	<% request.setAttribute("code", "02"); %>
	<c:choose>
		<c:when test="${code eq '01' }">
			code is 01
		</c:when>
		<c:when test="${code eq '02' }">
			code is 02
		</c:when>
		<c:when test="${code eq '03' }">
			code is 03
		</c:when>
		<c:otherwise>
			code is ${code }
		</c:otherwise>
	</c:choose>
	
	<h2>el 연산</h2>
	
	<%
		PageVO pageVO = new PageVO(1, 10);
		request.setAttribute("pageVO", pageVO);
	%>
	page + 2 : ${pageVO.page +2}
	
	<h2>c:forEach 일반 반복문</h2>
	<p>var = "i" begin="1" end="10" step="1"(default = "1")</p>
	<c:forEach var ="i" begin ="1" end="10" step="1">
		${i }<br>
	</c:forEach>
</body>
</html>