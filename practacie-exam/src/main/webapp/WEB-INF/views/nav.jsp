<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav me-auto">
		<c:if test="${empty userInfo}">
			<form method= "post" action="${root}/user/login">
				<input type = "text" name="id"/>
				<input type = "password" name="password"/>
				<button type = "submit">로그인</button>
			</form>
		</c:if>
		<c:if test = "${not empty userInfo}">
			<span style="color:white">${userInfo.name}님 환영합니다.</span>
			<a href= "${root}/user/logout">로그아웃</a>
		</c:if>
		<li class="nav-item"><a class="nav-link" href="${root}/board/list">상품 목록</a></li>
		<li class="nav-item"><a class="nav-link" href="${root}/board/regist">상품 정보 등록</a></li>
		
	</ul>
</nav>