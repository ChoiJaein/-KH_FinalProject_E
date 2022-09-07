<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<c:forEach items="${ndata}" var="ndata">
		<c:url var="noticeDetailUrl" value="/notice/detail">
			<c:param name="id">${ndata.notId}</c:param>
		</c:url>
		<tr onclick="location.href='${noticeDetailUrl}'">
			<td>${ndata.notId}</td>
			<td>${ndata.title}</td>
			<td>운영자</td>
			<td>${ndata.createDate}</td>
		</tr>
	</c:forEach>

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
		<tr onclick="location.href='/detail?id=${data.bid}'">
			<td><img src="${data.url}"> </td>
			<td>${data.btitle}</td>
			<td>${data.price}</td>
			<td>${data.dealmethod}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>