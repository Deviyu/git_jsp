<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/basicLib.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
	$(function() {
		$("select").val("${locale}");
		
		$("#localeSelect").on("change", function() {
			$("#frm").submit();
		})
	})
</script>
<title>Insert title here</title>
</head>
<body>
	<h2>Select Locale</h2>
	<form id="frm" action="${pageContext.request.contextPath }/selectLocale" method="post">
		<select id="localeSelect" name="locale">
			<option value="ko">한국어</option>
			<option value="en">English</option>
			<option value="ja">日本語</option>
		</select>
	</form>
	
<h2>${locale }</h2>	
<fmt:setLocale value="${locale }"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg_${locale }">
		<fmt:message key="GREETING"/><br>
		<fmt:message key="VISITOR"><br>
			<fmt:param value="sally"/>
		</fmt:message>
	</fmt:bundle>
</body>
</html>