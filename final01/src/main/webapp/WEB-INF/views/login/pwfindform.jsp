<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    
    
	<meta charset="UTF-8">
	<title>비밀번호 찾기</title>
	<%@ include file="../module/head.jsp" %>
</head>
<body>
	   <div align="center">
       <p id ="title" name = "title" align ="center"></p> 
		<form action="../login/find_pw" method="post">
		<h2>비밀번호 찾기</h2>
		<p>비밀번호는  가입하신 아이디와 이메일을 통해 찾을 수 있습니다.</p>
		<div id ="find_PwFormDiv" name="find_Pw" class=""/>
		<form id ="find_Pw" name="find_Pw">
	        <table>
		         <tr><td>
	             <input type ="text" id="id_account" placeholder="아이디" size=50px;>
	             <div class="caution" id="idDiv"></div>
        		</td></tr>
        		 <br><br>
	             <tr><td>
	             <input placeholder="이메일" type="text" id="email2" size=50px;> <br><br>
	             <div align="center">
                <input type="button" id="findPwBtn" value="비밀번호 찾기" size= 50px;> <br><br>
	             </td></tr>
             </table>
        </div>
     </div>
   </form>
</div>
    <br><br><br><br>
	<br><br><br><br>
	<br><br><br><br>
	<br><br><br><br>
	<br><br><br><br>
	<%@ include file="../module/footer.jsp" %>
</body>
</html>