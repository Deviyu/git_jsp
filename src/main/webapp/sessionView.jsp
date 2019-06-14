<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>sessionMap</h2>
	<table>
		<tr>
			<th>Session ID</th>
			<th>USER_INFO.name</th>
		</tr>
		<c:forEach items="${sessionMap }" var="ss">
			<tr>
				<td>${empty ss.key ? null : ss.key }</td>
				<td>${ss.value.getAttribute("USER_INFO").name }</td>
			</tr>
		</c:forEach>
	</table>
	<h2>sessionUserMap</h2>
	<table>
		<tr>
			<th>UserID</th>
			<th>Name</th>
		</tr>
		<c:forEach items="${sessionUserMap }" var="user">
			<tr>
				<td>${user.value.userId}</td>
				<td>${user.value.name }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>