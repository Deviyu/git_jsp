<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>fmt:formatDate</h2>
	<c:set var="dt" value="<%= new Date()%>"/>
	dt : ${dt }<br>
	<h3>locale : ko_KR</h3>
	fmt:formatDate(dt) : <fmt:formatDate value="${dt }"/><br>
	fmt:formatDate(dt) : <fmt:formatDate value="${dt }" pattern="yyyy-MM-dd"/><br>
	fmt:formatDate(dt)1 : <fmt:formatDate value="${dt }" type="date" dateStyle="FULL"/><br>
	fmt:formatDate(dt)1-1 : <fmt:formatDate value="${dt }" type="date" dateStyle="LONG"/><br>
	fmt:formatDate(dt)1-2 : <fmt:formatDate value="${dt }" type="date" dateStyle="MEDIUM"/><br>
	fmt:formatDate(dt)1-3 : <fmt:formatDate value="${dt }" type="date" dateStyle="SHORT"/><br>
	fmt:formatDate(dt)2 : <fmt:formatDate value="${dt }" type="time"/><br>
	fmt:formatDate(dt)3 : <fmt:formatDate value="${dt }" type="both"/><br>
	
	<h3>locale : de_DE</h3>
	<fmt:setLocale value="de_DE"/>
	fmt:formatDate(dt) : <fmt:formatDate value="${dt }"/><br>
	<fmt:setLocale value="en_US"/>
	<h3>locale : en_US</h3>
	fmt:formatDate(dt) : <fmt:formatDate value="${dt }"/><br>
	
	<h2>parseDate(String to Date)</h2>
	<fmt:setLocale value="ko_KR"/>
	<c:set value="2019.06.13" var="dtStr"/>
	dtStr : ${dtStr }<br>
	fmt:parseDate : <fmt:parseDate value="${dtStr }" pattern="yyyy.MM.dd"/>
</body>
</html>