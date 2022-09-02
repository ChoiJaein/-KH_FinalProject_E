<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
	<title>로그인</title>
	<%@ include file="../module/head.jsp" %>  
</head>
 </script> 
<body>
	<header class="mb-3"></header>
	<c:url var="mainUrl" value="." />
	<section class="container" style="width: 480px;">
		<c:url var="loginUrl" value="/login" />
		<form action="${loginUrl}" method="post">
		<div class="center-block">
			<h1 align="center"><a href="${mainUrl}/main">지구마켓</a></h1>
		</div>
			<br><br>
			<input type="hidden" name="url" value="${param.url}">
 			<div class="form-floating mb-2">
				<input class="form-control is-invalid" type="text" id="id_accountid" name="accountid" value="" placeholder="아이디를 입력하세요">
				<label for="id_accountid">아이디</label>
			</div>
			<br>
			<div class="form-floating mb-2">
				<input class="form-control is-invalid" type="text" id="id_password" name="password" value="" placeholder="비밀번호를 입력하세요">
				<label for="id_password">비밀번호</label>
			</div>
			<br>
			<div class="mb-2 text-end">
				<button class="btn btn-outline-primary bluebtn" type="submit">로그인</button>
			</div>
		</form>
			
			<div class="mb-2 text-end">
				<button class="btn btn-outline-primary bluebtn" onclick="location.href='findIdPw'">아이디/비밀번호 찾기</button>
			</div>
			<div class="mb-2 text-end">
				<button class="btn btn-outline-primary bluebtn" onclick="location.href='register'">회원가입</button>
			</div>
	</section>
	<br><br><br><br>
	<br><br><br><br>
	<br><br><br><br>
	<br><br><br><br>
	<br><br><br><br>
	<%@ include file="../module/footer.jsp" %>
</body>
</html>