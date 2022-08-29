<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<%@ include file="../module/head.jsp" %>
</head>
<body>
	<header class="mb-3"></header>
	<c:url var="mainUrl" value="." />
	<section class="container" style="width: 480px;">
		<c:url var="loginUrl" value="/register" />
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
			<div class="form-floating mb-2">
				<input class="form-control is-invalid" type="text" id="id_confirmpassword" name="confirmpassword" value="" placeholder="비밀번호를 입력하세요">
				<label for="id_confirmpassword">비밀번호 확인</label>
			</div>
			<br>
			
			<div class="form-floating mb-2">
				<input class="form-control is-invalid" type="text" id="id_name" name="name" value="" placeholder="닉네임을 입력하세요">
				<label for="id_name">닉네임</label>
			</div>
			<br>
			<div class="form-floating mb-2">
				<input class="form-control is-invalid" type="text" id="id_email" name="email" value="" placeholder="이메일을 입력하세요">
				<label for="id_email">이메일</label>
			</div>
			<br>
			<div class="form-floating mb-2">
				<input class="form-control is-invalid" type="text" id="id_phone" name="phone" value="" placeholder="전화번호를 입력하세요">
				<label for="id_phone">전화번호</label>
			</div>
			<br>
			<div class="form-floating mb-2">
				<input class="form-control is-invalid" type="text" id="id_address" name="address" value="" placeholder="주소를 입력하세요">
				<label for="id_address">주소</label>
			</div>
			
			<br><br>
			
			<div class="mb-2 text-end">
				<button class="btn btn-outline-primary bluebtn" type="submit">가입하기</button>
			</div>
			
			<br>
			
		</form>
	</section>
	<br><br><br><br>
	<br><br><br><br>
	<br><br><br><br>
	<br><br><br><br>
	<br><br><br><br>
	<%@ include file="../module/footer.jsp" %>
</body>
</html>