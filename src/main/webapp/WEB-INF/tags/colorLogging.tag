<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="color" type="java.lang.String" required="true"%>
<%@ attribute name="lineSize" type="java.lang.Integer" required="false" %>
<%@ attribute name="value" type="java.lang.String" required="true" %>

<font color="${color}">
	<c:forEach begin="1" end="${empty lineSize ? 5 : lineSize }">${value }</c:forEach>
</font>