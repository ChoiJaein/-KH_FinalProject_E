<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	공지사항  
</h1>
<table>

	
	<thead class="text-center">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody class="text-center">
	<c:forEach items="${data}" var="data">
		<c:url var="noticeDetailUrl" value="/notice/detail">
			<c:param name="id">${data.notId}</c:param>
		</c:url>
		<tr onclick="location.href='${noticeDetailUrl}'">
			<td>${data.notId}</td>
			<td>${data.title}</td>
			<td>운영자</td>
			<td>${data.createDate}</td>
			<td>${data.viewCnt}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<nav>
			<div>
				<c:url var="noticeUrl" value="/notice" />
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
</body>
</html>
