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

<script type="text/javascript">
	/* 아이디 중복 확인 */
	function idOverlap() {
				console.log("idOverlap 호출")
				console.log("아이디 입력 값 " + register.accountid.value)
			$.ajax({
				type : "post",
				url : "idOverlap",
				data : {"accountid" : register.accountid.value},
				dataType : "text",
				success : function(data) {
					if(data == "1") {
						alert("사용 가능한 아이디입니다.");
					} else {
						alert("이미 사용중인 아이디입니다.");
					}
				},
				error : function() {
					alert("아이디 중복 확인 실패");
				}
			});
	}
	
	/* 비밀번호 확인 */
	function passConfirm() {
		var password = document.getElementById('id_password');
		var passwordConfirm = document.getElementById('id_passwordConfirm');
		var confirmMsg = document.getElementById('confirmMsg');
		var correctColor = "#00ff00";	//맞았을 때 출력되는 색깔.
		var wrongColor ="#ff0000";	//틀렸을 때 출력되는 색깔
		
		if(password.value == passwordConfirm.value) {
			confirmMsg.style.color = correctColor;
			confirmMsg.innerHTML = "비밀번호 일치";
		} else {
			confirmMsg.style.color = wrongColor;
			confirmMsg.innerHTML = "비밀번호 불일치";
		}
	}
</script>

<body>
	<header class="mb-3"></header>
	<c:url var="mainUrl" value="." />
	<section class="container" style="width: 480px;">
		<c:url var="loginUrl" value="/register" />
		<form action="${loginUrl}" name="register" method="post">
		<div class="center-block">
			<h1 align="center"><a href="${mainUrl}/main">지구마켓</a></h1>
		</div>
			<br><br>
			<input type="hidden" name="url" value="${param.url}">
 			<div class="form-floating mb-2">
				<label for="id_accountid">아이디</label>
				<input class="form-control" type="text" id="id_accountid" name="accountid" value="" placeholder="아이디를 입력하세요" required>
				<input type="button" onclick="idOverlap()" value="중복확인" />
			</div>
			<br>
			<div class="form-floating mb-2">
				<label for="id_password">비밀번호</label>
				<input class="form-control" type="password" id="id_password" name="password" value="" placeholder="비밀번호를 입력하세요" required>
			</div>
			<div class="form-floating mb-2">
				<label for="id_passwordConfirm">비밀번호 확인</label>
				<input class="form-control" type="password" id="id_passwordConfirm" name="passwordConfirm" placeholder="비밀번호를 입력하세요" onkeyup="passConfirm()" required>
				<span id ="confirmMsg"></span>
			</div>
			<br>
			
			<div class="form-floating mb-2">
				<label for="id_name">닉네임</label>
				<input class="form-control is-invalid" type="text" id="id_name" name="name" value="" placeholder="닉네임을 입력하세요" required>
			</div>
			<br>
			<div class="form-floating mb-2">
				<label for="id_email">이메일</label>
				<input class="form-control is-invalid" type="text" id="id_email" name="email" value="" placeholder="이메일을 입력하세요" required>
			</div>
			<br>
			<div class="form-floating mb-2">
				<label for="id_phone">전화번호</label>
				<input class="form-control is-invalid" type="text" id="id_phone" name="phone" value="" placeholder="전화번호를 입력하세요" required>
			</div>
			<br>
			<div class="form-floating mb-2">
				<label for="id_address">주소</label>
				<input class="form-control is-invalid" type="text" id="id_address" name="address" value="" placeholder="주소를 입력하세요" required>
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