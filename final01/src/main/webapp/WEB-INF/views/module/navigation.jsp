<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../module/head.jsp" %>

<head>
   <meta charset="UTF-8">
	<style type="text/css">
	   .profile-size{
		margin-top: 8%;
	    margin-bottom: 3%;	    
	    margin-right: 3%;
	    width: 26%;
	    height: 26%;
	    margin:0;
	 }     
	  .top-menu{
	   margin-top: -2rem;
       margin-bottom: 3rem;
       text-align: right;
       margin-right: -3rem;
	  }
	 
	  .button-color{
	   background-color: #00B050 !important; 
	   border-color: #00B050 !important;
	   margin-left: 0.5rem !important;
       width: 70px !important;
	  }
	  .font-color{
	  color:#00B050;
	  font-weight: bolder;
	  }
	  
	  .whole-size{
	  margin: auto;
      min-width: 1110px;
	 }
	 
	 .hr-style{
	   margin-bottom: 5px;
      color: #00B050;
      height: 1px;
      opacity: .5;
	 }
	</style>
</head>  
    
<script type="text/javascript">
 $(function(){
  $('#searchBtn').click(function() {
     window.location = "/home/board/boardList_search"
     + "?keyword="
     + encodeURIComponent($('#keywordInput').val());
     + '${pageMaker.makeQuery(1)}'
    });
 });   
 </script>
<br><br>

<div class="container  text-center">
   	<div class="align-items-start top-menu">				
			<c:if test="${not empty sessionScope.loginData}">
                     <b>${sessionScope.loginData.accountid}</b> 님 환영합니다
                    <a style="color:#00B050;" href="/home/notice">공지사항</a>
					<a style="color:#00B050;" href="/home/myinfo/main">마이페이지</a>
					<a style="color:#00B050;" href="/home/board/upload">게시글 업로드</a>
					<a style="color:#00B050;" href="/home/logout">로그아웃</a>
			</c:if>
			<c:if test="${empty sessionScope.loginData}">
				    <a style="color:#00B050;" href="/home/notice">공지사항</a>
					<a style="color:#00B050;" href="/home/login">로그인</a>
			</c:if>
     </div>

	<div class="align-items-start">
	 <div class="search">
			<img id="previewImg" class="image-360 profile-size" alt="profile" src="./static/img/logo.png" onerror="this.src='../static/img/logo.png'" onclick="location.href='/home'">
			<input class="text_wide "style="height:39px" type="text" id="keywordInput" name="keyword" value="${scri.keyword}">			   
			<button class="btn btn-secondary button-color" id="searchBtn">검 색</button>
	</div>		

		        
	</div>
</div>

<br>
<hr class="hr-style">