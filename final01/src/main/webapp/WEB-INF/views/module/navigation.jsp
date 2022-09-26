<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../module/head.jsp" %>


<script type="text/javascript">
 $(function(){
  $('#searchBtn').click(function() {
     self.location = "board/boardList_search"
     + '${pageMaker.makeQuery(1)}'
     + "?keyword="
     + encodeURIComponent($('#keywordInput').val());
    });
 });   
 </script>
<br><br>
<nav class="navbar">
	<div class="container">
			<a class="navbar-brand" href="/home">지구마켓</a>
			
			<div class="search">
			<input class="text_wide" type="text" id="keywordInput" name="keyword" value="${scri.keyword}">
			   
			<button class="btn btn-secondary" id="searchBtn" type="submit">검색</button>
			</div>
			
			
			<a class="" href="/home/notice">공지사항</a>
			
				<c:if test="${not empty sessionScope.loginData}">
	                     ${sessionScope.loginData.accountid} 님 환영합니다.
						<a class="nav-link" href="/home/myinfo/main">마이페이지</a>
						<a class="nav-link" href="/home/logout">로그아웃</a>
						<a class="nav-link" href="/home/board/upload">게시글 업로드</a>
				</c:if>
				<c:if test="${empty sessionScope.loginData}">
						<a class="nav-link" href="/home/login">로그인</a>
				</c:if>

		        
		</div>
</nav>
<br>
<hr>