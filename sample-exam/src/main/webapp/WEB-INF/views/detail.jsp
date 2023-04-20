<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html; charset=utf-8" %>
<html>
<head>
	<title>index</title>
</head>
<body>
	<%@ include file = "/WEB-INF/views/header.jsp" %>
	<hr>
	<table>
		<tr>
			<th>번호</th>
			<td>${board.no}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${board.title}</td>
		</tr>
		<tr>
			<th>글쓴이</th>
			<td>${board.name}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${board.content}</td>
		</tr>
		<tr>
			<td colspan = "2">
				<a href = "delete?no=${board.no}">삭제하기</a>
			</td>
		</tr>
	</table>
</body>
</html>
