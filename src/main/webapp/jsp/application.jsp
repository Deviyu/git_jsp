<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>application.jsp</title>
</head>
<body>
	<%
		out.write("application.getContextPath() : " + application.getContextPath() +"<br>");
		out.write("application.getServerInfo() : "+ application.getServerInfo() + "<br>");
		out.write("application.getMajorVersion() : "+ application.getMajorVersion() + "<br>");
		out.write("application.getMinorVersion() : "+ application.getMinorVersion() + "<br>");
		out.write("application.application.getInitParameter(\"ADMIN\") : " + application.getInitParameter("ADMIN") + "<br>");
		
		out.write("application.getRealPath(\"/res/190522.txt\") : " + application.getRealPath("/res/190522.txt") + "<br>");
		
		FileInputStream fis = new FileInputStream(new File(application.getRealPath("/res/190522.txt")));
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		
		int ch;
		
		while((ch=isr.read()) != -1) {
			out.write(ch);
		}
		isr.close();
		
		out.write("<br><br>");
		
		FileReader fr = new FileReader(application.getRealPath("/res/190522.txt"));
		BufferedReader br = new BufferedReader(fr);
		
		String temp = "";
		while((temp = br.readLine()) != null) {
			out.write(temp + "<br>");
		}
		br.close();
		
	%>
</body>
</html>