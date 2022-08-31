<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    
  <c:url var="find_idUrl" value="../login/find_id/"/>
  <form action="${find_idUrl}" method="post">
	<meta charset="UTF-8">
	<title>아이디 찾기</title>
	<%@ include file="../module/head.jsp" %>
</head>
<body>
<div id ="find_id" name="find_id">
  <div align="center">
	<p id ="title" name = "title" align ="center"></p> 
	<h2>아이디 찾기</h2>
	<p>아이디는 가입하신 이메일을 통해 찾을 수 있습니다.</p>
	
     <div class=""></div>
     <table>
         <tr>
             <td>
                <br>
                 <input placeholder="이메일"  id="email1" name="email" size=50px; required>
             </td>
         </tr>
     </table>
    
     <br>
       <br>
	     <input type="submit" id="find_idBtn" value="아이디 찾기" size= 50px;> <br><br>
	     <!--  <input type="button" id="goLoginBtn" value="취소"size= 50px;>-->
  </form>
 </div>
 </div>
    <br><br><br><br>
	<br><br><br><br>
	<br><br><br><br>
	<br><br><br><br>
	<br><br><br><br>
	<%@ include file="../module/footer.jsp" %>
</body>
</html>