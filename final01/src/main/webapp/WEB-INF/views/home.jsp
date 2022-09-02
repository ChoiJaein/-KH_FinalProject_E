<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:url var="mainUrl" value="." />
<html>
<head>
    <meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
<header>
   
 

</header>
<P>  메인 페이지입니다 </P>
<p>
 <a href="/home/login">로그인</a>
</p>

	<c:if test="${not empty sessionScope.loginData}">
	      ${sessionScope.loginData.accountid} 님 환영합니다.
	      <a href="logout">로그아웃</a>
	</c:if>
	
</body>
</html>
