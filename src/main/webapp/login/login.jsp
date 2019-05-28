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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <title>Sign in</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/css/signin.css" rel="stylesheet">
	<script>
		$(document).ready(function() {
			//문서 로딩이 완료되고 나서 실행되는 부분
			//rememberMe CheckBox 값 체크
			//1. rememberMe 쿠키가 있는지?
			//	1.1. 있다면, 그 값이 true인지?
			//	1.2. true라면, input id = "rememberMe" CheckBox를 체크.
			var rememberMe = getCookie("rememberMe");
			if(rememberMe=="true"){
				$("#rememberMe").prop("checked", true);
				$("#userId").val(getCookie("userId"));
				$("#password").focus();
			} else {
				$("#rememberMe").prop("checked", false);
				$("#userId").focus();
			}
			
// 			$("#signInBtn").on("click", function() {
				
// 				if($("#rememberMe").prop("checked")) {
// 				// 만약 Remember Me CheckBOX가 체크되어 있는경우
// 				// 사용자 ID를 userId 쿠키값으로 저장
// 				// true값을 rememberMe 쿠키값으로 저장
// 					setCookie("userId", $("#userId").val(), 30);
// 					setCookie("rememberMe", "true", 30);
// 				} else {
// 				// 만약 Remember Me CheckBox가 체크되어 있는경우
// 				// userId, rememberMe 쿠키값을 삭제
// 					deleteCookie("userId");
// 					deleteCookie("rememberMe");
// 				}
				
// 				$("#frm").submit();
// 			})
			
			$("#frm").on("submit", function() {
				if($("#rememberMe").prop("checked")) {
					// 만약 Remember Me CheckBOX가 체크되어 있는경우
					// 사용자 ID를 userId 쿠키값으로 저장
					// true값을 rememberMe 쿠키값으로 저장
						setCookie("userId", $("#userId").val(), 30);
						setCookie("rememberMe", "true", 30);
					} else {
					// 만약 Remember Me CheckBox가 체크되어 있는경우
					// userId, rememberMe 쿠키값을 삭제
						deleteCookie("userId");
						deleteCookie("rememberMe");
					}
			})
			
			$("#password").keypress(function(key) {
				if(key.which == 13) {
					$("#signInBtn").click();
				}
			})
		})
		// 쿠키값 저장
		// expires : 현재 날짜로부터 며칠동안 유효한지? (정수값)
		function setCookie(cookieName, cookieValue, expires) {
			var dt = new Date();
			dt.setDate(dt.getDate() + parseInt(expires) );
			document.cookie = cookieName + "=" + cookieValue + "; path=/; expires=" + dt.toGMTString() + ";";
			
		}
		
		// 쿠키값 삭제
		function deleteCookie(cookieName) {
			setCookie(cookieName, "", -9);
		}
		
		// 쿠키 이름에 해당하는 쿠키 값을 조회
		function getCookie(cookieName) {
			var cookieValue = "";
			var cookieString = document.cookie;
			if(cookieString) {
				var cookies = document.cookie.split("; ");
				for(var i = 0; i<cookies.length; i++) {
					var cookie_i = cookies[i];
					if(cookie_i.startsWith(cookieName)) {
					var cookiesplit = cookie_i.split("=");
						cookieValue = cookiesplit[1]; 
						break;
					}
				}
			}
			return cookieValue;
		}
		
	</script>
	<script>
		console.log(getCookie("userId"));
	</script>	
  </head>

  <body>

    <div class="container">

      <form id = "frm" class="form-signin" action="<%=request.getContextPath()%>/login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="userId" class="sr-only">User ID</label>
        <input type="text" id="userId" name = "userId" class="form-control" placeholder="User ID" required>
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" class="form-control" name="password" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" id = "rememberMe" value="true"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" id = "signInBtn">Sign in</button>
      </form>

    </div> <!-- /container -->
  </body>
</html>
