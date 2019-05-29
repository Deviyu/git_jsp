<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sumInput.jsp</title>
</head>
<body>
	<h2>두 값(을 포함한) 사이의 수의 합</h2>
	<form action = "${pageContext.request.contextPath}/sumCalculation" method = "post">
		시작값 : <input type = "number" name = "start"><br>
		종료값 : <input type = "number" name = "end"><br>
		<button>계산!</button>
	</form>
</body>
</html>