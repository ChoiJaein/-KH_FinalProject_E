<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../module/head.jsp" %>

<c:url var="mainUrl" value="." />
<script type="text/javascript">

function search() {
	var searchvalue = document.getElementById('searchvalue').value;
	window.location.href = '${mainUrl}/list?search='+searchvalue;
}

</script>
<br><br>
<nav class="navbar">
	<div class="container">
			<a class="navbar-brand" href="/">지구마켓</a>
			
			<div class="">
			<input class="text_wide" type="text" id="searchvalue" name="search">
			<button class="btn btn-secondary" onclick="search()">검색</button>
			</div>
			
			
			<a class="" href="${mainUrl}/notice">공지사항</a>
			
				<c:if test="${not empty sessionScope.loginData}">
						<a class="nav-link" href="${mainUrl}/mypage">마이페이지</a>
						<a class="nav-link" href="${mainUrl}/logout">로그아웃</a>
				</c:if>
				<c:if test="${empty sessionScope.loginData}">
						<a class="nav-link" href="${mainUrl}/login">로그인</a>
				</c:if>
		
		</div>
</nav>
<br>
<hr>