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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body class="text-center bg-light">

	<div class="container">
		
		<main class="form-signin w-100 m-auto">
		<svg xmlns="http://www.w3.org/2000/svg" width="72" height="57" fill="currentColor" class="bi bi-person-check-fill mb-4" viewBox="0 0 16 16">
         	<path fill-rule="evenodd" d="M15.854 5.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 0 1 .708-.708L12.5 7.793l2.646-2.647a.5.5 0 0 1 .708 0z" />
         	<path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
       	</svg>
		<h1 class="h3 mb-3 fw-normal">Find Password</h1>

		<form id="form-findPw" method="POST" action="${root}/user/findPw">
			<div class="form-floating">
				<input type="text" class="form-control" id="id" name="id"
					placeholder="ID" /> <label for="floatingInput">ID</label>
			</div>
			<div class="form-floating">
				<input type="text" class="form-control" id="name" name="name"
					placeholder="Name" /> <label for="floatingInput">Name</label>
			</div>
			<div class="form-floating">
				<input type="text" class="form-control" id="email" name="email"
					placeholder="sample@example.com" /> <label for="floatingEmail">Email</label>
			</div>
			<button class="btn btn-primary" type="button" id="btn-find" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
			    Find Password
			</button>
			<a class="btn btn-primary" type="button" href="${root}/user/signup">Sign Up</a>
		</form>
		<div class="collapse" id="collapseExample">
		  <div class="card card-body" style="margin-bottom:2rem">
		    Your Password is:
		     <hr>
		     <span id="findPwResult"></span>
		  </div>
		</div>
<%-- 		<c:if test="${not empty password}">
			<div style = "background-color: white">
				<div class="text-muted" style = "font-weight:bold; font-size: 20px">Your Password is:</div>
				<div class="text-muted" style = "font-weight:bold; font-size: 20px">${password}</div>	
			</div>
		</c:if>

	    <c:if test="${not empty noUser}">
	    	<div style = "background-color: white">	    	
				<div class="text-muted" style = "font-weight:bold; font-size: 20px">${noUser}</div>
	    	</div>
		</c:if> --%>
		</main>
		
		<!-- footer -->
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<script type = "text/javascript">
		//비번 찾아오기
	    document.querySelector("#btn-find").addEventListener("click", function () {
	    	let form = this.form;
	    	let id = form.id.value;
	    	let name = form.name.value;
	    	let email = form.email.value;
	    	console.log(id + name + email);
	    	let resultSpan = document.querySelector("#findPwResult");
	        $.ajax({
	            type: 'POST',
	            url: '/user/findPw',
	            data: { id: id,
	            		name: name,
	            		email: email
	            	},
	            success: function(response) {
	            	console.log(response + "=======")
	                if (response != "") {
	    		 		resultSpan.textContent = response;
	                } else {
	                	resultSpan.textContent = "We cannot find password.\n Please check your input again.";
	                }
	            }
	        });
	    });
	</script>

</body>
</html>