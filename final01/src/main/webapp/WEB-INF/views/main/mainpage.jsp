<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>메인화면</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
	
</head>
<body>
	<header></header>
	<br><br><br><br><br><br>
	<section class="container">
	<div class="mb-1">
		<div>
			<h2>카테고리별 상품 찾기</h2>
		</div>
		
		<c:url var="mainDigital" value="/main/list?type=digital" />
		<c:url var="mainClothes" value="/main/list?type=clothes" />
		<c:url var="mainBag" value="/main/list?type=bag" />
		<c:url var="mainAccessories" value="/main/list?type=accessories" />
		<c:url var="mainBaby" value="/main/list?type=baby" />
		<c:url var="mainPet" value="/main/list?type=pet" />
		<c:url var="mainFurniture" value="/main/list?type=furniture" />
		<c:url var="mainBeauty" value="/main/list?type=beauty" />
		<c:url var="mainOffice" value="/main/list?type=office" />
		<c:url var="mainArt" value="/main/list?type=art" />
		
		<table class="table">
		
			<tr class="text-center">
				<td class="hover" onclick="location.href='${mainDigital}'"><span class="material-symbols-outlined ">photo_camera</span>
					<br><label class="font-large">가전/디지털</label></td>
				<td class="hover" onclick="location.href='${mainClothes}'"><span class="material-symbols-outlined">laundry</span>
					<br><label>의류</label></td>
				<td class="hover" onclick="location.href='${mainBag}'"><span class="material-symbols-outlined">shopping_bag</span>
					<br><label>가방</label></td>
				<td class="hover" onclick="location.href='${mainAccessories}'"><span class="material-symbols-outlined">headphones</span>
					<br><label>액세서리</label></td>
				<td class="hover" onclick="location.href='${mainBaby}'"><span class="material-symbols-outlined">pregnant_woman</span>
					<br><label>유아/출산</label></td>
			</tr>
	
			<tr class="text-center">
				<td class="hover" onclick="location.href='${mainPet}'"><span class="material-symbols-outlined">pets</span>
					<br><label>반려동물상품</label></td>
				<td class="hover" onclick="location.href='${mainFurniture}'"><span class="material-symbols-outlined">bed</span>
					<br><label>가구</label></td>
				<td class="hover" onclick="location.href='${mainBeauty}'"><span class="material-symbols-outlined">face_retouching_natural</span>
					<br><label>뷰티/미용</label></td>
				<td class="hover" onclick="location.href='${mainOffice}'"><span class="material-symbols-outlined">print</span>
					<br><label>사무용품</label></td>
				<td class="hover" onclick="location.href='${mainArt}'"><span class="material-symbols-outlined">image</span>
					<br><label>예술/악기</label></td>
			</tr>
	
		</table>
		
		<br><br>
	
	
		<div>
			<h2>실시간 상품</h2>
		</div>
		
		<table class="table">
		<c:if test="${not empty datas}">
				<c:forEach items="${datas}" var="data">
			<tr class="text-center">
				<td onclick="location.href='/detail?id=${data.bid}'">
					사진코드 들어갈 자리<br>
					${data.btitle}<br>
					${data.price}<br>
					${data.buytype}
				</td>
			</tr>
				</c:forEach>
			</c:if>
		</table>
	
	</div>
	</section>
</body>
</html>