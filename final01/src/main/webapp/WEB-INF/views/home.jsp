<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:url var="mainUrl" value="." />
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, inital-scale=1">
	<title>Home</title>
</head>
<body>
</header>
<P>  메인 페이지입니다 </P>
<p>
 <a href="/home/login">로그인</a>
</p>

	<c:if test="${not empty sessionScope.loginData}">
	      ${sessionScope.loginData.accountid} 님 환영합니다.
	      <a href="logout">로그아웃</a>
	</c:if>

<!-- 네이버 로그인 callback URL -->
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>	
<script type="text/javascript">
		      var naverLogin  = new naver.LoginWithNaverId(
				   {
					   clientId : "q379z6OiAG3HfRfviHRi",
					   callbackUrl : "http://localhost/home/",
					   isPopup: false,
					   CallbackHandle:true
				   }
		   );
		   
		   naverLogin.init();
		   
		   window.addEventListener('load', function () {
				naverLogin.getLoginStatus(function (status) {
					if (status) {
						
						var email = naverLogin.user.getEmail();
						alert(email);
						console.log(naverLogin.user);
						if( email == undefined || email == null) {
							alert("이메일은 필수정보입니다. 정보제공을 동의해주세요.");
							
							naverLogin.reprompt();
							return;
						}

					} else {
						console.log("callback 처리에 실패하였습니다.");
					}
					 //로그아웃을 위한 토큰
					 //https://nid.naver.com/oauth2.0/token?grant_type=delete&client_id=jyvqXeaVOVmV&client_secret=zhGwpKJh8Z_COq1_XV33cf&access_token=c8ceMEJisO4Se7uGCEYKK1p52L93bHXLnaoETis9YzjfnorlQwEisqemfpKHUq2gY&service_provider=NAVER
				});
			});
		   
		   
		   </script>
		    
</body>
</html>
