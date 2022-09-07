<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<thead class="text-center">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
	</thead>
	<tbody class="text-center">
	<c:forEach items="${nData}" var="ndata">
		<c:url var="noticeDetailUrl" value="/notice/detail">
			<c:param name="id">${nData.notId}</c:param>
		</c:url>
		<tr onclick="location.href='${noticeDetailUrl}'">
			<td>${nData.notId}</td>
			<td>${nData.title}</td>
			<td>운영자</td>
			<td>${nData.createDate}</td>
		</tr>
	</c:forEach>
	</tbody>

	<thead class="text-center">
		<tr>
			<th>사진</th>
			<th>제목</th>
			<th>가격</th>
			<th>거래유형</th>
		</tr>
	</thead>
	<tbody class="text-center">
	<c:forEach items="${data}" var="data">
		<c:url var="boardDetailUrl" value="/board/detail">
			<c:param name="id">${data.bId}</c:param>
		</c:url>
		<tr onclick="location.href='${boardDetailUrl}'">
			<td><img src="${data.url}"> </td>
			<td>${data.bTitle}</td>
			<td>${data.price}</td>
			<td>${data.dealMethod}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>