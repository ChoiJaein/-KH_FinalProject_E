<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<head>
	<meta charset="UTF-8">
	<title>아이디 / 비밀번호 찾기</title>
	<%@ include file="../module/head.jsp" %>
</head>
<body>
<header class="mb-3"></header>
  <section class="container" style="width: 490px;">
   <c:url var="find_idUrl" value="/login/find_id"/>
   <form action="${find_idUrl}" method="post">
     <div class="center-block">
			<img id="previewImg" style="margin-top: 3rem; margin-bottom: 2rem;" class="image-360 profile-size" alt="profile" src="./static/img/logo.png" onerror="this.src='../static/img/logo.png'" onclick="location.href='/home'">
		</div>
   <div id ="find_id">
   <div align="center">
	  <p id ="title" name = "title" align ="center" style="margin:0;"></p> 
		<h2>아이디 찾기</h2>
		<p>아이디는 가입하신 이메일을 통해 찾을 수 있습니다.</p>
		  <table>
		  <tr><td>
	          <input class="form-control" style="border-style: solid; border-color: #00B050; border-width: revert;"
	                 placeholder="이메일"  id="email" name="email" size=50px;>
	       <br> 
	      </td></tr>
	 </div>         
    <div class="form-label-group">
       <br>
       <br>
        <tr><td>
	          <div align="center">
	            <button type="submit" class="btn btn-outline-success bluebtn"  id="find_id_btn"  value="check" >아이디찾기</button> <br><br>
	            <button type="button" class="btn btn-outline-success bluebtn"  style="margin-top:-1.5rem" id="reset" onclick="location.href='../login'" value="취소" >취소</button> <br><br>
	          </div>
	    </td></tr>
   </div>
  </div>
 </table>
  </form>
   <br>
   
   
   	<title>비밀번호 찾기</title>
    <header class="mb-3"></header>
        <c:url var="find_pwUrl" value="/login/find_pw"/>
		<form action="${find_pwUrl}" method="post" >
		<div id ="find_pw" name="find_pw">
	    <div align="center">   
		<p id ="title" name = "title" align ="center"></p> 
		<h2>비밀번호 찾기</h2>
		<p>비밀번호는  가입하신 아이디와 이메일을 통해 찾을 수 있습니다.</p>
	        <table>
		         <tr><td>
	             <input class="form-control" type ="text" id="id_account" style="border-style: solid; border-color: #00B050; border-width: revert;"
	                    placeholder="아이디" name="accountid" size=50px;>
	             <br>
	             <input class="form-control" type="text" id="email" name="email" style="border-style: solid; border-color: #00B050; border-width: revert; margin-top:-1rem"
	                     placeholder="이메일" size=50px;> <br><br>
        		 </td></tr>
        		 <br><br>
	             <tr><td>
	             
	             <div align="center">
	                <button type="submit"  class="btn btn-outline-success bluebtn" id="findPwBtn" style="margin-top:-1.5rem">비밀번호 찾기</button><br><br>
	                <button type="button" class="btn btn-outline-success bluebtn" style="margin-top:-1.5rem" id="reset" value="취소" onclick="location.href='../login'">취소</button><br><br>
	             </div>
	             </td></tr>

             </table>
        </div>
     </div>
    </div>
  </form>
	
 </section>
    <br><br><br><br>
	<br><br><br><br>
	<br><br><br><br>
	<%@ include file="../module/footer.jsp" %>
</body>
</html>




