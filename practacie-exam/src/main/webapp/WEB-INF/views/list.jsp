<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/head.jsp" %>
</head>
<body>
	<%@ include file="/WEB-INF/views/nav.jsp" %>

	<%-- 페이지만의 내용 --%>
	<form action = "multi-delete">
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
			</tr>
			<c:forEach var = "board" items = "${list}">
				<tr>
					<td>${board.code}</td>
					<td>${board.model}</td>
					<td>${board.price}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	

<%@ include file="/WEB-INF/views/footer.jsp" %>


