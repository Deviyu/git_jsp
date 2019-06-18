<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mulInput.jsp</title>
</head>
<body>
	<form action = "${cp}/jsp/mulCalculation" method = "post">
		값 1 : <input type = "number" name = "param1"> <br>
		값 2 : <input type = "number" name = "param2"> <br>
		<input type = "submit" value = "계산">
	</form>
</body>
</html>