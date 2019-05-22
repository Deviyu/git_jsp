<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Process</title>
</head>
<body>
		<%-- post 방식 한글 파라미터 --%>
		<% request.setCharacterEncoding("UTF-8");%>
	<% 
		String[] idArr = request.getParameterValues("userId");
		String password = request.getParameter("password");
	%>
	<h2>request 객체의 getParameter, getParameterValues</h2>
	request.getParameter("userId") : <%=request.getParameter("userId") %><br>
	<% 
		String[] userIds = request.getParameterValues("userId"); 
		for(String userId : userIds) { 
	%>
			<%=userId %><br>
	<% 	
		}	
	%>
	request.getParameter("password") : <%=request.getParameter("password") %><br>
	<h2>request객체의 getParameterMap</h2>
	<% 
		Map<String, String[]> parameterMap = request.getParameterMap(); 
		//parameter : userId, password
		String[] userIdsFromMap = parameterMap.get("userId");
		String[] passwordFromMap = parameterMap.get("password");
		
		for(String ids : userIdsFromMap) {%>
		userIdsFromMap : <%=ids %><br>	
	<%} %>
	
	<% for(String pw : passwordFromMap) { %>
		passwordFromMap : <%=pw %><br>
	<%} %>
	<br>
	
	<h2>request객체의 getParameterNames()</h2>
	<% 
		Enumeration<String> names = request.getParameterNames(); 
		while(names.hasMoreElements()) { %>
		parameterNames : <%=names.nextElement() %><br>
	<%		
		}	
	%>
</body>
</html>