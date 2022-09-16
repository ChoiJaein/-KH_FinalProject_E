<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="java.util.*" %>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공지사항</title>
<%@ include file="../module/head.jsp" %>

</head>
<body>
<header></header>
<section class="container">


 <div class="mb-5 mt-5">
  <c:url var="noticeUrl" value="/notice"/>
	  <h5 class="float-start mt-3">공지사항 <i class="bi bi-megaphone"></i></h5> 
	  
<!-- 권한체크 // 접속자세션 eq 관리자권한 체크-->
  <c:if test="">
  </c:if>	   
	  <button class="btn btn-primary float-end mb-1" type="button" onclick="location.href='${noticeUrl}/add'">글 작성</button>  
 </div> 


<!--테이블 -->
<table class="table table-hover">
 <colgroup>
	<col class="col-1">
	<col class="col-auto">
	<col class="col-2">
	<col class="col-2">
 </colgroup>
	<thead>
	  <tr> 
	    <th>번 호</th>
	    <th>제 목</th>
	    <th>작성자</th>
	    <th>작성일</th> 
	  </tr>
	</thead>

	<tbody>  
	   <br>
	   <c:if test="${not empty datas}">
		   <c:forEach items="${datas}" var="data">
		     <c:url value="/notice/detail" var="noticeDetailUrl" >
		        <c:param name="id">${data.id}</c:param>
		      </c:url>
			      <tr onclick="location.href='${noticeDetailUrl}'">
			        <td>번 호</td>
			        <td>제 목</td> 
			        <td>작 성 자</td>
			        <td>작 성 일</td>
			      </tr>
		   </c:forEach>
		 </c:if>	 
		</tbody> 	  
  </table>

<!-- 페이징  
    <nav> 
     <div>     	   
       	<ul class="pagination justify-content-center">
			<c:if test="${pageData.hasPrevPage()}">
				<li class="page-item">
				  <a class="page-link" href="${noticeUrl}?page=${pageData.prevPageNumber}">Prev</a>
				</li>
			 </c:if>
				<c:forEach items="${pageData.getPageNumberList(pageData.currentPageNumber - 2, pageData.currentPageNumber + 2)}" var="num">
					<li class="page-item ${pageData.currentPageNumber eq num ? 'active' : ''}">
					   <a class="page-link" href="${noticeUrl}?page=${num}">${num}</a>
					</li>
				 </c:forEach>
				<c:if test="${pageData.hasNextPage()}">
				    <li class="page-item">
					   <a class="page-link" href="${noticeUrl}?page=${pageData.nextPageNumber}">Next</a>
	               </li>
	          </c:if>
           </ul>
     </div>  
    </nav>
-->  
 </section>

<!--하단페이지-->    
 <%@ include file="../module/footer.jsp" %>

 <script type="text/javascript">

 </script>
</body>
</html>