<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>따-란</title>
<style>
	td { border : 1px solid black; width : 100px; height : 45px; text-align : center; }
</style>
</head>
<body>
	<table>
		<c:forEach var="i" begin="1" end="${empty param.i ? 9 : param.i }">
			<tr>
			<c:forEach var="j" begin="2" end="${empty param.j ? 9 : param.j }">
				<td>${j } * ${i } = ${j*i }</td>
			</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>