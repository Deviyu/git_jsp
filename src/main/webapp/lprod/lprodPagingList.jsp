<%@page import="kr.or.ddit.lprod.model.LprodVO"%>
<%@page import="kr.or.ddit.paging.model.PageVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<title>User List(userList.jsp / el+jstl)</title>
<%@include file="/common/basicLib.jsp"%>
</head>

<body>
	<!--header-->
	<%@include file="/common/header.jsp"%>
	
	<div class="row">
		<!-- left -->
		<%@include file = "/common/left.jsp"%>
		
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

			<div class="blog-header">
				<h1 class="blog-title">Lprod Paging List</h1>
				<p class="lead blog-description">물품 대분류 페이징 리스트</p>
			</div>

			<div class="row">
				<div class="col-sm-8 blog-main">
					<h2 class="sub-header">List</h2>
					<div class="table-responsive">
						<table class="table table-striped">
							<tr>
								<th>LPROD_ID</th>
								<th>LPROD_GU</th>
								<th>LPROD_NM</th>
							</tr>
							<c:forEach items="${pagingList }" var="lprod">
								<tr>
									<td>${lprod.lprod_id }</td>
									<td>${lprod.lprod_gu }</td>
									<td>${lprod.lprod_nm }</td>
								</tr>
							</c:forEach>
						</table>
					</div>

					<a class="btn btn-default pull-right">대분류 등록</a>
					<div class="text-center">
						<ul class="pagination">
							<c:choose>
								<c:when test="${pageVO.page eq 1 }">
									<li class = "disabled"><span>≪</span></li>
								</c:when>
								<c:otherwise>
									<li><a href = "${pageContext.request.contextPath}/lprodPagingList?page=${pageVO.page-1 }&pageSize=${pageVO.pageSize }">≪</a></li>
								</c:otherwise>
							</c:choose>
							<c:forEach var = "i" begin="1" end="${paginationSize }">
								<c:choose>
									<c:when test="${pageVO.page eq i }">
										<li class = "active">
											<span>${i }</span>
										</li>
									</c:when>
									<c:otherwise>
										<li>
											<a href = "${pageContext.request.contextPath}/lprodPagingList?page=${i}&pageSize=${pageVO.pageSize }">${i}</a>
										</li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:choose>
								<c:when test="${pageVO.page eq paginationSize }">
									<li	class = "disabled">
										<span>≫</span>
									</li>
								</c:when>
								<c:otherwise>
									<li>
										<a href = "${pageContext.request.contextPath}/lprodPagingList?page=${pageVO.page+1 }&pageSize=${pageVO.pageSize }">≫</a>
									</li>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
