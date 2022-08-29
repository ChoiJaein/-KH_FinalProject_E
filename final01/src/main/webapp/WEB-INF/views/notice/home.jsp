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
	<c:forEach items="${datas}" var="datas">
		<c:url var="noticeDetailUrl" value="/notice/detail">
			<c:param name="id">${datas.notId}</c:param>
		</c:url>
		<tr onclick="location.href='${noticeDetailUrl}'">
			<td>${datas.notId}</td>
			<td>${datas.title}</td>
			<td>운영자</td>
			<td>${datas.createDate}</td>
			<td>${datas.viewCnt}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>
