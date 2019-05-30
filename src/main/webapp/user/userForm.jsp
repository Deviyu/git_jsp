<%@page import="kr.or.ddit.paging.model.PageVO"%>
<%@page import="kr.or.ddit.user.model.UserVO"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>사용자 등록</title>
<%@include file="/common/basicLib.jsp"%>
</head>

<body>
	<!--header-->
	<%@include file="/common/header.jsp"%>
	
	<div class="row">
		<!-- left -->
		<%@include file = "/common/left.jsp"%>
		
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

			<div class="row">
				<div class="col-sm-8 blog-main">
					<h2 class="sub-header">사용자 등록</h2>
					
					<form class="form-horizontal" role="form" action="${pageContext.request.contextPath }/userCreate" method="post">
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">프로필 사진</label>
						<div class="col-sm-10">
							<input type = "file" name="filename"/>
						</div>
					</div>
					
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
								<input type="text" class="form-control" id="userId" name="userId" placeholder="사용자 아이디">
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">비밀번호</label>
						<div class="col-sm-10">
								<input type="password" class="form-control" id="pass" name="pass" placeholder="비밀번호">
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name" name="name" placeholder="사용자 이름">
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">생일</label>
						<div class="col-sm-10">
							<input type="date" class="form-control" id="birth" name="birth">
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="alias" name="alias" placeholder="별명">
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="zipcd" name="zipcd" placeholder="우편번호">
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="addr1" name="addr1" placeholder="주소">
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="addr2" name="addr2" placeholder="상세주소">
						</div>
					</div>
					
					
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">사용자 등록</button>
						</div>
					</div>
					
				</form>
				
				</div>
			</div>
		</div>
	</div>
</body>
</html>
