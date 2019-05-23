<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>scopePrint.jsp</title>
</head>
<body>
	<table>
		<tr>
			<th>Page</th>
			<td><%=pageContext.getAttribute("pageAttribute") %></td>
		</tr>
		<tr>
			<th>Request</th>
			<td><%=request.getAttribute("requestAttribute") %></td>
		</tr>
		<tr>
			<th>Session</th>
			<td><%=session.getAttribute("sessionAttribute") %></td>
		</tr>
		<tr>
			<th>Application</th>
			<td><%=application.getAttribute("applicationAttribute") %></td>
		</tr>
	</table>
</body>
</html>