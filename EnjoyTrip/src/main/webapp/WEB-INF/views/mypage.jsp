<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.2/examples/checkout/" />

<link rel="stylesheet" href="${root}/resources/css/min.css" />
<link rel="stylesheet" href="${root}/resources/css/sign-up.css" />
<link rel="stylesheet" href="${root}/resources/css/spot-style.css" />
</head>
<body class="bg-light">
	<div class="container">
		<main> <header>
			<div class="container">
				<a class="btn btn-primary" href="${root}/user?action=index"
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
			<h2>My Page</h2>
			<p class="lead">등록된 회원 정보를 조회, 수정할 수 있습니다.</p>
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
				<form class="card p-2" method="post" action="${root}/user">
					<input type="hidden" name="action" value="delete">
					<div class="input-group">
						<input id="confirm-box" type="text" class="form-control"
							name="confirm-box" placeholder="Enter 'Confirm'" />
						<button type="submit" class="btn btn-danger">회원 탈퇴</button>
					</div>
				</form>
			</div>
			<div class="col-md-7 col-lg-8">
				<h4 class="mb-3">Your Info</h4>
				<form class="needs-validation" novalidate>
					<input type="hidden" name="action" value="edit">
					<div class="row g-3">
						<div class="col-12">
							<label for="Name" class="form-label">Name</label> <input
								type="text" class="form-control" id="name" placeholder=""
								value="${userInfo.name}" name="name" required />
							<div class="invalid-feedback">Valid first name is required.</div>
						</div>

						<div class="col-12">
							<label for="id" class="form-label">ID</label> <input type="text"
								class="form-control" id="id" placeholder=""
								value="${userInfo.id}" name="id" required readonly />
							<div class="invalid-feedback">Valid first name is required.</div>
						</div>

						<div class="col-12">
							<label for="email" class="form-label">Email </label> <input
								type="email" class="form-control" id="email"
								placeholder="you@example.com" value="${userInfo.email}"
								name="email" required />
							<div class="invalid-feedback">Please enter a valid email
								address for shipping updates.</div>
						</div>

						<div class="col-12">
							<label for="password" class="form-label">Password</label> <input
								type="password" class="form-control" id="pw" placeholder=""
								value="${userInfo.pw}" name="pw" required />
							<div class="invalid-feedback">Please enter your password.</div>
						</div>

						<div class="col-12">
							<label for="password2" class="form-label">Confirm
								password</label> <input type="password" class="form-control" id="pw2"
								placeholder="" required />
							<div class="text-muted" id="pwcheck-result"></div>
						</div>

						<hr class="my-4" />
						<button type="submit" class="w-100 btn btn-primary btn-lg"
							id="updateBtn" disabled=true style="margin-bottom: 3rem">변경사항
							저장</button>
				</form>
			</div>
		</div>
		</main>
	</div>
	<!-- footer -->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="${root}/resources/js/infoUpdate.js"></script>
	<script>
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

		// name에서 키를 뗀 경우에: 갱신
		document.querySelector("#name").addEventListener("keyup", function() {
			changeInfo();
		});

		// email에서 키를 뗀 경우에: 갱신
		document.querySelector("#email").addEventListener("keyup", function() {
			changeInfo();
		});

	</script>
</body>
</html>