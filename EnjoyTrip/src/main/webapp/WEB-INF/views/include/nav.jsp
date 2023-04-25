<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Navigation-->
<nav class="navbar navbar-light bg-light static-top">
    <div class="container">
        <a href="${root}/user/index"> <img src="${root}/resources/assets/logo.png" alt=""
            style="width: 250px;">
        </a>
        
        <c:choose>
        	<c:when test="${empty userInfo}">
	        	<div id="member-btns-logout">
	            	<a class="btn btn-primary" href="${root}/user/signup">Sign Up</a>
	            	<a class="btn btn-primary" href="${root}/user/signin">Sign In</a>
	        	</div>
        	</c:when>
        	<c:otherwise>
				<div id="member-btns-login">
            		<a class="btn btn-primary" href="${root}/user/logout">Log out</a>
                	<a class="btn btn-primary" href="${root}/user/mypageForm">My Page</a>
       			</div>
			</c:otherwise>
        
        </c:choose>
    </div>
</nav>