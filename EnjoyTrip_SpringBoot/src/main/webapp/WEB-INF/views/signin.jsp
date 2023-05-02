<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.2/examples/sign-in/" />

<link href="${root}/resources/css/min.css" rel="stylesheet" />
<link href="${root}/resources/css/sign-in.css" rel="stylesheet" />
<link href="${root}/resources/css/spot-style.css" rel="stylesheet" /> 
<%
	String signupMsg = "";
	if (request.getParameter("signup-msg") == null) {
		signupMsg = "";
	} else {
		signupMsg = request.getParameter("signup-msg");
	}
	
	//쿠키값으로 id정보 받아오기
	String idcookie = "";
	Cookie[] cookies = request.getCookies(); //쿠키생성
	if (cookies != null && cookies.length > 0)
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("idRemember")) { // 아이디 저장한 쿠키
				idcookie = cookies[i].getValue();
			}
			if (cookies[i].getName().equals("idRemember")) { // isremem
				idcookie = cookies[i].getValue();
			}
		}
%>
</head>
<body class="text-center bg-light">
	<div class="container">
		<main class="form-signin w-100 m-auto">
		<svg xmlns="http://www.w3.org/2000/svg" width="72" height="57"	fill="currentColor" class="bi bi-person-check-fill mb-4" viewBox="0 0 16 16">
          	<path fill-rule="evenodd" d="M15.854 5.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 0 1 .708-.708L12.5 7.793l2.646-2.647a.5.5 0 0 1 .708 0z" />
          	<path	d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
       	</svg>
		<h1 class="h3 mb-3 fw-normal">Please sign in</h1>
		<div class="text-muted" id="signup-msg">${signinMsg}</div>
		<form id="form-login" method="POST" action="${root}/user/login">
			<div class="form-floating">
				<input type="text" class="form-control" id="userid" name="id"
					placeholder="id" value="<%=idcookie%>"/> <label for="floatingInput">ID</label>
			</div>
			<div class="form-floating">
				<input type="password" class="form-control" id="userpwd" name="pw"
					placeholder="Password" /> <label for="floatingPassword">Password</label>
			</div>

			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me" name="rememberId"/>
					Remember ID
				</label>
			</div>
			<button class="w-50 btn btn-primary" type="submit" id="btn-login" style="margin-bottom:2rem">Sign in</button>
			<a class="w-30 btn btn-secondary" id="btn-findPw"
				href="${root}/user/findPw" style="margin-bottom:2rem">Find PW</a>
		</form>
		</main>
		<!-- footer -->
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	</div>
</body>
</html>