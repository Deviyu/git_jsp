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
	/*
	데이터베이스 처리 순서
	
	1.	드라이버 로딩 -> JDBC라이브러리를 JVM의 메모리에 적재한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
	2.	DB시스템에 접속 -> 접속이 완료되면 Connection 객체가 만들어진다.
			DriverManager.getConnection()메서드를 이용한다.
	3.	질의하기 -> Statement 객체 또는 PreparedStatement객체를 이용하여
				  SQL문을 실행하고 그 결과를 받아온다.
	4.	받아온 결과를 처리한다.
		1) SQL문이 SELECT일 때 -> ResultSet객체가 만들어진다.
 			(ResultSet객체에는 select한 결과가 저장된다.)
 		2) SQL문이 INSERT, UPDATE, DELETE 등일 때 -> 정수값을 반환한다.
 			(정수값은 보통 실행에 성공한 레코드 수를 의미한다.)
 	5.	사용한 자원을 반납한다.
	*/
		// DB작업에 필요한 객체변수 선언
		Connection conn = null;
		
		// try/catch 
		
		try {
			long start = System.currentTimeMillis();
			BasicDataSource bs = new BasicDataSource();
			
			bs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			bs.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			bs.setUsername("Devi");
			bs.setPassword("java");
			bs.setInitialSize(20);
			
			for(int i = 0; i < 20; i++) {
				conn = bs.getConnection();
				conn.close();
			}
			
			long end = System.currentTimeMillis();
			System.out.println("duration : " + (end - start) + "ms");
			bs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//6. 사용했던 자원을 반납한다.
			if(conn!=null) try{ conn.close(); } catch ( SQLException e2 ) { }
		}

%>