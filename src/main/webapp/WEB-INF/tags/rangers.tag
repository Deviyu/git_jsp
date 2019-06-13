<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name="rangers" type="java.lang.String" required="true"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<select id="rangersSelect">
<c:forTokens var="ranger" items="${rangers }" delims=",">
	<option>${ranger }</option>
</c:forTokens>
</select>
<script>
	$("#rangersSelect").on("change", function() {
		var ranVal = $("#rangersSelect").val();
		console.log(ranVal);
	});
</script>