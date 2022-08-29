<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>로그인</title>
    <%@ include file="../module/head.jsp" %>
</head>
<form name ="login" action="${pageContext.request.contextPath}/login" method="post">
    <p id ="title" name = "title" align ="center"><strong><a href="./">지구마켓</a></strong></p>
    <table align= "center">
    <tr>
       <td>
       <lable>아이디</lable><br>
          <input placeholder="아이디" type="text" name="accountId" id="accountId" size=46px align="center">
       </td>
    </tr>
    <tr>
        <td>
         <lable>비밀번호</lable><br>
            <input placeholder="비밀번호" type="password" name="password" id="password" size=46px>
          
            
        </td>
    </tr>
    <tr>
        <td align= 'center'>
         <!--     <input type="submit" name="loginBtn" id="loginBtn" value="로그인"><br>-->
           <button id="login" class=btn-button  onclick="loginCheck()">로그인</button>
          
        </td>
    </tr>
    <tr>
        <td align='center'>
            <a href="./login/findIdPwForm">아이디/비밀번호 찾기</a>
        </td>
</table>

<script type="text/javascript">

  function loginCheck() {

  let accountId = document.getElementById("accountId").value;
  let password = document.getElementById("password").value;
 
	  
	if(accountId == "") {
	     alert("아이디를 입력해주세요");
	  }else if( password == "") {
	     alert("비밀번호를 입력해주세요");
	  }else {
	          loginForm.submit();
	  } 
	}
 
</script>


</form>