<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.2/examples/checkout/" />

<link href="${root}/resources/css/min.css" rel="stylesheet" />
<link href="${root}/resources/css/sign-up.css" rel="stylesheet" />
<link href="${root}/resources/css/spot-style.css" rel="stylesheet" />
<!-- Custom styles for this template -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body class="bg-light">
	<div class="container">
		<main> 
		<header>
			<div class="container">
				<a class="btn btn-primary" href="${root}/user/index"
					style="float: right; margin-top: 30px;">Home</a>
			</div>
		</header>
		<div class="py-5 text-center">
			<svg xmlns="http://www.w3.org/2000/svg" width="72" height="57"
				fill="currentColor"
				class="bi bi-person-lines-fill d-block mx-auto mb-4"
				viewBox="0 0 16 16">
            <path
					d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm-5 6s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zM11 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5zm.5 2.5a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1h-4zm2 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2zm0 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2z" />
          </svg>
			<h2>Sign Up</h2>
			<p class="lead">회원가입을 진행해주세요.</p>
		</div>
		<div class="row g-5">
			<div class="col-md-5 col-lg-4 order-md-last">
				<h4 class="d-flex justify-content-between align-items-center mb-3">
					<span class="text-primary">Your Info</span> <span
						class="badge bg-primary rounded-pill">!</span>
				</h4>
				<ul class="list-group mb-3">
					<li class="list-group-item d-flex justify-content-between lh-sm">
						<div>
							<h6 class="my-0">Name</h6>
							<small class="text-muted">이름</small>
						</div> <span class="text-muted" id="Name-print"></span>
					</li>
					<li class="list-group-item d-flex justify-content-between lh-sm">
						<div>
							<h6 class="my-0">ID</h6>
							<small class="text-muted">아이디</small>
						</div> <span class="text-muted" id="id-print"></span>
					</li>
					<li class="list-group-item d-flex justify-content-between lh-sm">
						<div>
							<h6 class="my-0">Email Address</h6>
							<small class="text-muted">이메일 주소</small>
						</div> <span class="text-muted" id="email-print"></span>
					</li>
					<li class="list-group-item d-flex justify-content-between lh-sm">
						<div>
							<h6 class="my-0">Password</h6>
							<small class="text-muted">비밀번호</small>
						</div> <span class="text-muted" id="pw-print"></span>
					</li>
				</ul>

			</div>
			<div class="col-md-7 col-lg-8">
				<h4 class="mb-3">Your Info</h4>
				<form class="needs-validation" method="POST" action="${root}/user/signup" novalidate>
						<div class="col-12">
							<label for="name" class="form-label">Name</label> 
							<input type="text" class="form-control" id="name" name="name" required />
						</div>
						<div class="col-12">
							<label for="usesrId" class="form-label">ID </label> 
							<input type="text" class="form-control" id="id" name="id" required />
							<div class="text-muted" id="idcheck-result"></div>
						</div>
						<div class="col-12">
							<label for="email" class="form-label">Email</label> 
							<input type="email" class="form-control" id="email" name="email" placeholder="sample@example.com" required />
						</div>

						<div class="col-12">
							<label for="password" class="form-label">Password</label> 
							<input type="password" class="form-control" id="pw" name="pw" placeholder="" required />
						</div>

						<div class="col-12">
							<label for="password2" class="form-label">Confirm password</label> 
							<input type="password" class="form-control" id="pw2" placeholder="" required />
							<div class="text-muted" id="pwcheck-result"></div>
						</div>

						<hr class="my-4" />
						<button type = "submit" class="w-100 btn btn-primary btn-lg" id="btn-signup"
							disabled=true style="margin-bottom: 3rem">Sign up</button>
				</form>
			</div>
		</div>
		</main>
	</div>
	<!-- footer -->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<script type="text/javascript" src="${root}/resources/js/infoUpdate.js"></script>
	<script type="text/javascript">
		// name에서 키를 뗀 경우에: 갱신
		document.querySelector("#name").addEventListener("keyup", function() {
			changeInfo();
		});

		//id에서 키를 뗀 경우에: 아이디존재여부 확인->갱신
		document.querySelector("#id").addEventListener("keyup", function() {
			isValidId("${root}");
		});

		// password에서 키를 뗀 경우에: pw체크->갱신
		document.querySelector("#pw").addEventListener("keyup", function() {
			let pw2 = document.querySelector("#pw2").value;
			if (pw2 != null) {
				isEqualPw();
			}
			changeInfo();
		});
		
		// Confirm password에서 키를 뗀 경우에: pw체크->갱신
		document.querySelector("#pw2").addEventListener("keyup", function() {
			isEqualPw();
		});


		
		// email에서 키를 뗀 경우에: 갱신
		document.querySelector("#email").addEventListener("keyup", function() {
			changeInfo();
		});
		
		document.querySelector("#btn-signup").addEventListener("click", function (){ 
			alert("등록이 성공했습니다.");
		});
	</script>
</body>
</html>