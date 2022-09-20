<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="ko">
<head>
   <meta charset="UTF-8">
	<title>로그인</title>
	<%@ include file="../module/head.jsp" %>  
</head>
<body>

	<header class="mb-3"></header>
	<c:url var="mainUrl" value="." />
	<section class="container" style="width: 480px;">
		<c:url var="loginUrl" value="/login" />
		<form action="${loginUrl}" method="post" name ="loginForm">
		<div class="center-block">
			<h1 align="center"><a href="${mainUrl}/home/main">지구마켓</a></h1>
		</div>
			<br><br>
			<input type="hidden" name="url" value="${param.url}">
 			<div class="form-floating mb-2">
				<input class="form-control" type="text" id="id_accountid" name="accountid" value="" placeholder="아이디를 입력하세요">
				<label for="id_accountid">아이디</label>
			</div>
			<br>
			<div class="form-floating mb-2">
				<input class="form-control" type="password" id="id_password" name="password" value="" placeholder="비밀번호를 입력하세요">
				<label for="id_password">비밀번호</label>
			</div>
			<br>
			<div class="mb-2 text-end">
				<button class="btn btn-outline-primary bluebtn" type="submit">로그인</button>
			</div>
		</form>
			
			<div class="mb-2 text-end">
				<button class="btn btn-outline-primary bluebtn" onclick="location.href='./login/findIdPw'">아이디 비밀번호 찾기</button>
			</div>
			<div class="mb-2 text-end">
				<button class="btn btn-outline-primary bluebtn" onclick="location.href='./register'">회원가입</button>
			</div>
	        <div align= 'center'>
	        <!-- 카카오 로그인 -->
	       <button  type="button" class="btn" id="kakao-login-btn"
	        onclick="location.href='/home/login/kakao'">
			  <img src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg" width="210"/>
			</button>

		   
			<!-- 네이버 로그인 -->
			<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>		  
		    <div id ="naverIdLogin"></div>
		   <script type="text/javascript">
		      var naverLogin  = new naver.LoginWithNaverId(
				   {
					   clientId : "q379z6OiAG3HfRfviHRi",
					   callbackUrl : "http://localhost/home/",
					   isPopup: false,
					   loginButton : {color: "green" ,type:3 , height:50}
				   }
		   );
		   
		   naverLogin.init();
		   
		   
		   </script>
		      		      
			
	
</body>
	</section>
	<br><br><br><br>
	<br><br><br><br>
	<br><br><br><br>
	<br><br><br><br>
	<br><br><br><br>
	<%@ include file="../module/footer.jsp" %>
</html>