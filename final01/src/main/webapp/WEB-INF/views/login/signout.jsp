<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원탈퇴</title>
	<%@ include file="../module/head.jsp" %>
</head>
<script type="text/javascript">

function pwCheck(){
	const target = document.getElementById('signout-btn');
	  
	 if(document.getElementById('id_password').value !='' && document.getElementById('id_password_confirm').value!=''){
         if(document.getElementById('id_password').value==document.getElementById('id_password_confirm').value){
             document.getElementById('check').innerHTML='비밀번호가 일치합니다.'
             document.getElementById('check').style.color='green';
             target.disabled = false;
         }
         else{
             document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
             document.getElementById('check').style.color='red';
             target.disabled = true;
         }
     }
}



</script>

<body>
	
	<header class="mb-3"></header>
	
	<section class="container">
	
	<div class="div-center">
		<div class="div-bc div-left">
		
			<div class="div-middle">
				<div class="div-profile">
					<img src="${data.url}" alt="프로필사진" />
				</div>
				<div class="div-profile">
					<input type="text" id="id_name" name="name" value="${data.name}" disabled>
				</div>
			</div>
			
		</div>
		
		<div class="div-info div-right ">
	
			<table class="table table-borderless table-divcenter">
				
				<tr>
					<td><label>아이디</label></td>
					<td><input type="text" id="id_accountid" name="accountid" value="${data.accountid}" disabled></td>
				</tr>
				
				<tr>
					<td><label>비밀번호</label></td>
					<td><input type="text" id="id_password" name="password" onchange="pwCheck()"></td>
				</tr>
				
				<tr>
					<td><label>비밀번호 확인</label></td>
					<td><input type="text" id="id_password_confirm" name="password_confirm" onchange="pwCheck()"></td>
				</tr>
				<tr>
					<td></td>
					<td><label id="check"></label></td>
				</tr>
			</table>
			
		</div>
	</div>
		
	<div>
		<button class="btn btn-primary button-right" onclick="location.href='/main'">취소</button>
		<button class="btn btn-primary button-right" id="signout-btn" onclick="userSignOut(this.form);" disabled>회원탈퇴</button>
		<label class="button-right">탈퇴하실 경우 복구하실 수 없습니다.</label>
	</div>
	
	</section>

<script type="text/javascript">




function userSignOut(form){
	if(confirm("탈퇴하시겠습니까?") == true){
		
		if(${data.password} === document.getElementById('id_password').value){ 
			
	    alert("탈퇴되었습니다.");
		form.submit();
		location.href="/main"; 
			
		} else {
			alert("비밀번호가 일치하지 않습니다.");
		}
	}else{
		return false;
	}
 }

</script>


</body>
</html>