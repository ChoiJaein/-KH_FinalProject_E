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
	<%@ include file="../module/head.jsp" %>
			<!-- 얘네 나중에 head.jsp에 모듈화하기 -->
			<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
			<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
</head>
	<script type="text/javascript">
		$(document).ready(function(){
			// 취소
			$(".cancel").on("click", function(){
				location.href = "/login";
			})
		
			$("#submit").on("click", function(){
				if($("#accountId").val()==""){
					alert("아이디를 입력해주세요.");
					$("#accountId").focus();
					return false;
				}
				if($("#password").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#password").focus();
					return false;
				}
				if($("#name").val()==""){
					alert("성명을 입력해주세요.");
					$("#name").focus();
					return false;
				}
			});
		})
	</script>
<body>
	<section id="container">
		<form action="../member/register" method="post">
			<div class="form-group has-feedback">
				<label class="control-label" for="accountId">계정아이디</label>
				<input class="form-control" type="text" id="accountId" name="accountId" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="password">비밀번호</label>
				<input class="form-control" type="password" id="password" name="password" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="name">이름</label>
				<input class="form-control" type="text" id="name" name="name" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="name">이메일</label>
				<input class="form-control" type="text" id="email" name="email" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="name">주소</label>
				<input class="form-control" type="text" id="address" name="address" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="name">전화번호</label>
				<input class="form-control" type="text" id="phone" name="phone" />
			</div>
			<div class="form-group has-feedback">
				<button class="btn btn-success" type="submit" id="submit">회원가입</button>
				<button class="cancel btn btn-danger" type="button">취소</button>
			</div>
		</form>
	</section>

</body>
</html>