<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>out.jsp</title>
<style>
td { border : 1px solid black; width : 100px; height : 55px; text-align : center; }
</style>
</head>
<body>
	<%
		out.write("<table>");	
		for(int i = 2; i <= 9; i++) {
			out.write("<tr>");
			for(int j = 1; j <= 9; j++) {
				out.write("<td>" + i + " * " + j + " = " + (i*j) + "</td>");
			}
			out.write("</tr>");
		}
		out.write("</table>");
	%>
</body>
</html>