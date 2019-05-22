<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<!-- 어디로 요청을 보낼지? form태그의 action 속성을 이용한다. -->
	<!-- login.jsp -> loginProcess.jsp -->
	
	<form action = "<%= request.getContextPath() %>/login/loginProcess.jsp" method = "post">
		<label for = "userId">user id : </label>
		<input type = "text" name = "userId" value = "Deviyu"> <br>
		<label for = "userId">user id : </label>
		<input type = "text" name = "userId" value = "유승진"> <br>
		<label for = "password"> password : </label>
		<input type = "password" name = "password" value = "pass1234"> <br>
		<input type = "submit" value = "로그인">
	</form>
</body>
</html>