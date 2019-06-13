<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="ctm" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
1. 직접 입력 : ==================================================<br>
2. c:forEach : <c:forEach begin="1" end="50">=</c:forEach><br>
3. customTag : <ctm:logging/><br>
4. loopCustomTag : <ctm:loopLogging/><br>
5. colorLogging : <ctm:colorLogging color="red" value="-"/><br>
6. rangersTag : <ctm:rangers rangers="brown,cony,james,sally,moon"/><br>
7. codeTag : <ctm:code code="P201"/>
</body>
</html>