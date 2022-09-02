<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>  
	<meta charset="UTF-8">
	<title>아이디 찾기</title>
	<%@ include file="../module/head.jsp" %>
	<style>
 #modal.modal-overlay {
            width: 100%;
            height: 100%;
            position: absolute;
            left: 0;
            top: 0;
            display: none;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            background: rgba(255, 255, 255, 0.25);
            box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
            backdrop-filter: blur(1.5px);
            -webkit-backdrop-filter: blur(1.5px);
            border-radius: 10px;
            border: 1px solid rgba(255, 255, 255, 0.18);
        }
        #modal .modal-window {
            background: rgba( 0, 0, 0, 0.70 ); // 69, 139, 197
            box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
            backdrop-filter: blur( 13.5px );
            -webkit-backdrop-filter: blur( 13.5px );
            border-radius: 10px;
            border: 1px solid rgba( 255, 255, 255, 0.18 );
            width: 400px;
            height: 300px;
            position: relative;
            top: -100px;
            padding: 10px;
        }
        #modal .title {
            padding-left: 10px;
            display: inline;
            text-shadow: 1px 1px 2px gray;
            color: white;
            
        }
        #modal .title h2 {
            display: inline;
        }
        #modal .close-area {
            display: inline;
            float: right;
            padding-right: 10px;
            cursor: pointer;
            text-shadow: 1px 1px 2px gray;
            color: white;
        }
        
        #modal .content {
            margin-top: 20px;
            padding: 0px 10px;
            text-shadow: 1px 1px 2px gray;
            color: white;
        }
</style>
</head>
<body>
<header class="mb-3"></header>
  <section>
  
   <c:url var="find_idUrl" value="/login/find_id/"/>
   <form action="${find_idUrl}" method="post">
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
                 <input placeholder="이메일"  id="email" name="email" size=50px; required>
             </td>
         </tr>
     </table>
    
     <br>
       <br>
	     <button type="submit" class="btn btn-outline-primary bluebtn"  id="find_idBtn"  value="아이디 찾기" >아이디찾기</button> <br><br>
  </form>
	     <button type="button" class="btn btn-outline-primary bluebtn"  id="reset" onclick="location.href='../login'" value="취소" >취소</button> <br><br>
   </div>
   </div>
 </section>
    <br><br><br><br>
	<br><br><br><br>
	<br><br><br><br>
	<br><br><br><br>
	<br><br><br><br>
	<%@ include file="../module/footer.jsp" %>
</body>
</html>