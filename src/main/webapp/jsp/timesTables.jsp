<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>timesTables.jsp</title>
<style>
	td { border : 1px solid black; width : 100px; height : 50px; text-align : center; }
</style>
</head>
<body>
	<% 
		String param_i = request.getParameter("i"); 
		String param_j = request.getParameter("j");
		int int_i = Integer.parseInt(param_i);
		int int_j = Integer.parseInt(param_j);
	%>
	<table>
		<% 
			for(int i = 1; i <= int_i; i++) {
		%>
			<tr>
		<% 
				for(int j = 2; j <= int_j; j++) {
		%>
				<td><%=j%> * <%=i%> = <%=i*j%></td>
		<%	
			}
		%>
			</tr>
		<%		
			} 
		%>
	</table>
</body>
</html>