<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Request Count</title>
<style>
	td {width : auto; padding : 10px; border : 1px solid black; }
</style>
</head>
<body>
	<table>
		<tr>
			<th>URI</th>
			<th>Count</th>
		</tr>
		<c:forEach items="${countMap }" var="map">
			<tr>
				<td>${map.key }</td>
				<td>${map.value }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>