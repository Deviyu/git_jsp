<%@ page language="java" contentType="application/vnd.ms-excel; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	response.setHeader("Content-Disposition", "attachment; filename=line.xls");
	response.setHeader("Content-Description", "JSP Generated Data"); 
	response.setContentType("application/vnd.ms-excel");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Excel Download</title>
</head>
<body>
	<table>
		<tr>
			<th>이름</th>
			<th>영문명</th>
		</tr>
		<tr>
			<td>샐리</td>
			<td>Sally</td>
		</tr>
		<tr>
			<td>브라운</td>
			<td>Brown</td>
		</tr>
	</table>
</body>
</html>