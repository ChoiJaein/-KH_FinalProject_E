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
				<br><br><br>
				<h3>상품이름</h3>
				<br>
				<h4 style="text-align:right;">1,000,000원</h4>
				<hr>
				<label>유형 : 직거래</label>
				<br>
				<label>상태 : 새상품</label>
				<br><br><br>
				<button class="btn btn-primary" style="float:right;">바로구매</button>
				<h4 style="float:right;">판매중</h4>
			</div>	
	</div>		
<br>
			
			<div style="clear:both;">
			<hr>
			
				<h5>상품정보</h5>
				<br><br>
				<p>
					상품정보에 대한 내용이 들어갈 위치.상품정보에 대한 내용이 들어갈 위치.
					상품정보에 대한 내용이 들어갈 위치.상품정보에 대한 내용이 들어갈 위치.
					상품정보에 대한 내용이 들어갈 위치.상품정보에 대한 내용이 들어갈 위치.
					상품정보에 대한 내용이 들어갈 위치.상품정보에 대한 내용이 들어갈 위치.
					상품정보에 대한 내용이 들어갈 위치.상품정보에 대한 내용이 들어갈 위치.
					상품정보에 대한 내용이 들어갈 위치.상품정보에 대한 내용이 들어갈 위치.
				</p>
			</div>	
			
			<br><br><br><br><br><br>
			
			<hr>
			<div style="width:100%; background-color:lightgray;">
				<label style="font-size:20px;">상품 후기</label>
			</div>

			








			<c:if test="${not empty datas}">
				
			</c:if>
			

	</section>
	
	<footer><%@ include file="../module/footer.jsp" %></footer>
</body>
</html>