<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<section id="container">
		<form action="/member/register" method="post">
			<div class="form-group has-feedback">
				<label class="control-label" for="accountId">계정아이디</label>
				<input class="form-control" type="text" id="accountId" name="accountId" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="password">비밀번호</label>
				<input class="form-control" type="text" id="password" name="password" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="name">이름</label>
				<input class="form-control" type="text" id="name" name="name" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="name">이메일</label>
				<input class="form-control" type="text" id="name" name="name" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="name">주소</label>
				<input class="form-control" type="text" id="name" name="name" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="name">전화번호</label>
				<input class="form-control" type="text" id="name" name="name" />
			</div>
			<div class="form-group has-feedback">
				<button class="btn btn-success" type="submit" id="submit">회원가입</button>
				<button class="cancle btn btn-danger" type="button">취소</button>
			</div>
		</form>
	</section>

</body>
</html>