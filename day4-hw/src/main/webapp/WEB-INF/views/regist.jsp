<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 사용자 관리</title>
</head>
<body>
	<h1>SSAFY 사용자 관리</h1>
	<!-- 코드작성 -->
	<form method= "post" action="${root}/user/login">
		<label>아이디</label>
		<input type = "text" name="id"/>
		<br>
		<label>비밀번호</label>
		<input type = "password" name="password"/>
		<br>
		<label>이름</label>
		<input type = "text" name="name"/>
		<br>
		<label>이메일</label>
		<input type = "email" name="email"/>
		<br>
		<label>나이</label>
		<input type = "age" name="age"/>
		<br>
		<button type = "submit">등록</button>
		<button>초기화</button>
	</form>
</body>
</html>