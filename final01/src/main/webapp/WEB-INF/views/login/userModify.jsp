<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원정보 수정</title>
	<%@ include file="../module/head.jsp" %>
</head>


<body>
	
	<header class="mb-3"></header>
	
	<section class="container">
	
	<div class="div-center">
		<div class="div-bc div-left">
		
			<div class="div-middle">
				<div class="div1-profile-pic">
					<img src="${data.url}" alt="프로필사진" />
				</div>
				<div class="div1-profile">
					<input type="text" id="id_name" name="name" value="${data.name}" >
				</div>
			</div>
			
		</div>
		
		<div class=" div-right">
	
			<table class="table table-divcenter2">
				
				<tr>
					<td><label>전화번호</label></td>
					<td><input type="text" id="id_phone" name="phone" value="${data.phone}" ></td>
					<td></td>
				</tr>
				
				<tr>
					<td><label>주소</label></td>
					<td><input type="text" id="id_address" name="address" value="${data.address}"></td>
					<td></td>
				</tr>
				
				<tr>
					<td><label>이메일</label></td>
					<td><input type="text" id="id_email" name="email" value="${data.email}"></td>
					<td></td>
				</tr>
				<tr>
					<td><label>비밀번호 변경</label></td>
					<td><input type="text" id="id_password" name="password" value="${data.password}"></td>
					<td></td>
				</tr>
				<tr class="table-underline-off">
					<td class="table-underline-off"></td>
					<td class="table-underline-off"></td>
					<td class="table-underline-off"><button class="btn btn-primary button-right" onclick="location.href='signout'">회원탈퇴</button></td>
				</tr>
				
				
			</table>
			
		</div>
	</div>
		
	<div>
		<button class="btn btn-primary button-right" onclick="location.href='/'">취소</button>
		<button class="btn btn-primary button-right" type="submit" id="modify-btn">완료</button>
		
	</div>
	
	</section>


</body>
</html>