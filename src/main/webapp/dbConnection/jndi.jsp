<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

//JDBC (Java DataBase Connectivity)
		
		String DATASOURCE_CONTEXT = "java:comp/env/jdbc/oracleDB";

		Connection conn = null;
		
		// try/catch 
		
		try {
			long start = System.currentTimeMillis();
			
			InitialContext context = new InitialContext();
			DataSource bs = (DataSource)context.lookup(DATASOURCE_CONTEXT);
			
			for(int i = 0; i < 20; i++) {
				conn = bs.getConnection();
				conn.close();
			}
			
			long end = System.currentTimeMillis();
			System.out.println("duration : " + (end - start) + "ms");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//6. 사용했던 자원을 반납한다.
			if(conn!=null) try{ conn.close(); } catch ( SQLException e2 ) { }
		}

%>