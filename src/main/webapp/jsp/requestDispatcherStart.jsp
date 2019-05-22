<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>requestDispatchStart.jsp</title>
</head>
<body>
	<form action = "<%=request.getContextPath() %>/jsp/requestDispatcherProcess.jsp">
		<input type = "text" name = "userId" value = "sally"/><br>
		<input type = "submit" value = "Request Dispatch">
	</form>
</body>
</html>