<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
     <%@ include file="../module/head.jsp" %>
	
	<title>아이디 찾기 완료</title>
				<h3>아이디 찾기 검색결과</h3>
			</div>
			<div>
				<h5>
				<c:if test="${not empty sessionScope.emailData}">
	        회원님의 아이디는    ${sessionScope.emailData.accountId} 입니다.
	             
	            </c:if>
				</h5>
			
	
</head>
<body>

</body>
</html>