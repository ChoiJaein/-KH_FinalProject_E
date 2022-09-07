<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상품정보</title>
	<%@ include file="../module/head.jsp" %>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
	
</head>
<body>
	<header><%@ include file="../module/navigation.jsp" %>
	</header>
	<%@ include file="../module/categoryNavigation.jsp" %>
	<c:url var="boardUrl" value="/board" />
	<section class="container" style="width:1250px;">

				<table class="table">
					<tr>
						<td style="text-align:left; vertical-align : bottom;"><h2>게시글 제목</h2></td>
						<td style="text-align:right; vertical-align : bottom; color:gray;"><h6>2022년 00월 00일          조회수 : 0회</h6></td>
					</tr>
				</table>
		<div style="width:100%;">
			<div style="float:left;">
				<div style="width:400px; height:400px; background-color:gray;">
					<img id="previewImg" class="image-360" alt="profile" src="https://asset.fujifilm.com/www/kr/files/styles/600x400/public/2021-05/65281e835b2f6b169876a63441a39c7f/pic_xsystem_50.jpg?itok=TF-yhBJI"
                  width="400px" height="400px" style="max-width:400px; max-height:400px;" />
				</div>
			</div>
			<div style="float:left; width:800px; margin-left:5px;">
				<label>카테고리 > 가전/디지털</label>
				<div style="float:right;"  onclick="ajaxWishList(id_like, ${data.id});">
					<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16">
	 					<path d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/>
					</svg>
				</div>
				<br><br>
				<h3>상품이름</h3>
				<br>
				<h4 style="text-align:right;">1,000,000원</h4>
				<hr>
				<label>유형 : 직거래</label>
				<br>
				<label>상태 : 새상품</label>
				<br><br><br>
				<c:set var="status" value="111"/>
				<c:if test="${empty status}">
				<button class="btn btn-primary" style="float:right;">바로구매</button>
				<h4 style="float:right;">판매중</h4>
				</c:if>
				<c:if test="${not empty status}">
				<button class="btn btn-primary" style="float:right; background-color:red;" disabled>구매불가</button>
				<h4 style="float:right;">판매완료</h4>
				</c:if>
			</div>	
		</div>		
<br>
			
			<div style="clear:both;">
			<hr>
			
				<h5>상품정보</h5>
				<br><br>
				<p>
					상품에 대한 내용이 들어갈 위치.상품에 대한 내용이 들어갈 위치.
					상품에 대한 내용이 들어갈 위치.상품에 대한 내용이 들어갈 위치.
					상품에 대한 내용이 들어갈 위치.상품에 대한 내용이 들어갈 위치.
					상품에 대한 내용이 들어갈 위치.상품에 대한 내용이 들어갈 위치.
					상품에 대한 내용이 들어갈 위치.상품에 대한 내용이 들어갈 위치.
					상품에 대한 내용이 들어갈 위치.상품에 대한 내용이 들어갈 위치.
					상품에 대한 내용이 들어갈 위치.상품에 대한 내용이 들어갈 위치.
					상품에 대한 내용이 들어갈 위치.상품에 대한 내용이 들어갈 위치.
				</p>
			</div>	
			
			<br><br><br><br><br><br>
			
			<hr>
			<div style="width:100%; background-color:lightgray;">
				<label style="font-size:20px;">상품 후기</label>
			</div>
			
			<c:if test="${empty status}">
			<label>구매하시고 후기를 남겨보세요.</label>
			</c:if>

		

			<c:set var="accountId" value="111" />

			<c:set var="buyId" value="${status}" />
			<c:set var="myId" value="${accountId}" />
			
		
			
			<c:choose>
				<c:when test="${buyId == myId}">
					<label>내가구매함</label>
				</c:when>
				<c:when test="${not empty status}">
					<label>구매자가 후기를 남기기 전 입니다.</label>
				</c:when>
				
				
				
			</c:choose>
	</section>
	
	<footer><%@ include file="../module/footer.jsp" %></footer>
</body>
</html>