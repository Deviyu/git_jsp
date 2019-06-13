<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>KO</h2>	
<fmt:setLocale value="ko"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg_ko">
		<fmt:message key="GREETING"/><br>
		<fmt:message key="VISITOR"><br>
			<fmt:param value="${param.userId }"/>
		</fmt:message>
	</fmt:bundle>

<h2>EN</h2>
<fmt:setLocale value="en"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg_en">
		<fmt:message key="GREETING"/><br>
		<fmt:message key="VISITOR"><br>
			<fmt:param value="${param.userId }"/>
		</fmt:message>
	</fmt:bundle>

<h2>JA</h2>
<fmt:setLocale value="ja"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg_ja">
		<fmt:message key="GREETING"/><br>
		<fmt:message key="VISITOR">
			<fmt:param value="${param.userId }"/>
		</fmt:message>
	</fmt:bundle>

<h2>KO setBundle</h2>
<fmt:setLocale value="ko"/>
<fmt:setBundle basename="kr.or.ddit.msg.msg_ko" var="msg_ko"/>
<fmt:message bundle="${msg_ko }" key="GREETING"/><br>
<fmt:message bundle="${msg_ko }" key="VISITOR">
	<fmt:param value="${param.userId }"/>
</fmt:message>

<h2>EN setBundle</h2>
<fmt:setLocale value="en"/>
<fmt:setBundle basename="kr.or.ddit.msg.msg_en" var="msg_en"/>
<fmt:message bundle="${msg_en }" key="GREETING"/><br>
<fmt:message bundle="${msg_en }" key="VISITOR">
	<fmt:param value="${param.userId }"/>
</fmt:message>

<h2>JA setBundle</h2>
<fmt:setLocale value="ja"/>
<fmt:setBundle basename="kr.or.ddit.msg.msg_ja" var="msg_ja"/>
<fmt:message bundle="${msg_ja }" key="GREETING"/><br>
<fmt:message bundle="${msg_ja }" key="VISITOR">
	<fmt:param value="${param.userId }"/>
</fmt:message>    
</body>
</html>