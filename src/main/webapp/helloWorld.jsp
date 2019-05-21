<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>helloWorld.jsp</title>
	<style>
		table { width : 100px; height : 100px; border : 1px solid black; }
		td { border : 1px solid black; }
	</style>
</head>
<body>
	<% 
		String str = "<table><tr><td></td><td></td></tr></table>"; 
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY년 MM월 dd일 HH시 mm분 ss초");
		String date_str = sdf.format(date);
	%>
<%-- <% %> : 스크립틀릿 : 자바 코드를 작성하는 영역 --%>
	<%=str %><br>
	현재 시간은 <%=date_str%> 입니다.
	<br>
	<img src = "image/brown.png"/>
</body>
</html>