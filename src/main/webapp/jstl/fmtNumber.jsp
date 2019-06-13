<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>formatNumber</h2>
	<c:set value="10000000.23" var="num"/>
	num : ${num }<br>
	<fmt:setLocale value="ko_KR"/>
	<!-- type : number, currency, or percentage -->
	parseNum = <fmt:formatNumber value="${num }"/><br>
	parseNum = <fmt:formatNumber value="${num }" type="currency"/><br>
	parseNum = <fmt:formatNumber value="${num }" type="number"/><br>
	parseNum = <fmt:formatNumber value="${num }" type="percent"/><br>
	<fmt:setLocale value="de_DE"/>
	parseNumDe = <fmt:formatNumber value="${num }"/><br>
	parseNumDe = <fmt:formatNumber value="${num }" type="currency"/><br>
	parseNumDe = <fmt:formatNumber value="${num }" type="number"/><br>
	parseNumDe = <fmt:formatNumber value="${num }" type="percent"/><br>
	<br>
	<h2>parseNumber (String -> number / 1,000,000 -> 100000)</h2>
	<fmt:setLocale value="ko"/>
	<c:set value="1,000,000" var="numStr"/>
	numStr = ${numStr }<br>
	numStr(parseNumber) = <fmt:parseNumber value="${numStr }" pattern="0,000.00"/>
</body>
</html>