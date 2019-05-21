<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>factorial.jsp</title>
</head>
<body>
	<%!
		public String hello() {
			return "Hello";
	}
	
		public long fac(int i) {
			long result = i;
			
			if(i == 0) {
				return 1;
			} else {
				return result * fac(i-1);
			}
		}
	%>
	hello() : <%=hello()%><br>
	fac(0) : <%=fac(0)%><br>
	fac(1) : <%=fac(1)%><br>
	fac(2) : <%=fac(2)%><br>
	fac(3) : <%=fac(3)%><br>
	fac(4) : <%=fac(4)%><br>
	fac(5) : <%=fac(5)%><br>
	fac(6) : <%=fac(6)%><br>
	fac(7) : <%=fac(7)%><br>
	fac(8) : <%=fac(8)%><br>
</body>
</html>