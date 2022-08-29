<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title >${data.title}</title>
</head>

<!-- 테스트 파일임 -->
<c:url var="jQuery" value="/static/js" />
<script type="text/javascript" src="${jQuery}/jquery-3.6.0.min.js"></script>
<body>
	<header></header>
	<section class="container">
		<div class="mt-3">
			<div class="mb-1 border-bottom border-2 border-secondary">
				<h1>${data.title}</h1>
			</div>
			<div class="mb-3">
				<label class="pe-3 text-secondary text-opacity-75">운영자</label>
				<fmt:formatDate value="${data.createDate}" var="createDate" dateStyle="long" />
				<label class="pe-3 text-secondary text-opacity-75">${createDate}</label>
				<label class="pe-3 text-secondary text-opacity-75">조회수: ${data.viewCnt}</label>
			</div>
			<div class="mb-1 border-bottom border-2 border-secondary">
				<p>${data.content}</p>
			</div>
			<div class="mb-1 text-end">
				<c:url var="noticeUrl" value="/notice"/>
				<button class="btn btn-primary" type="button" onclick="location.href='${noticeUrl}'">목록</button>
				<button class="btn btn-success" type="button"  onclick="location.href='${noticeUrl}/modify?id=${data.notId}'">수정</button>
				<button class="btn btn-danger" type="button"  data-bs-toggle="modal" data-bs-target="#removeModal">삭제</button>
			</div>
		</div>
		
		<div class="modal fade" id="removeModal" tabindex="-1" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h6 class="modal-title">삭제 확인</h6>
						<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body">
						해당 데이터를 삭제하겠습니까?
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-sm btn-danger" data-bs-dismiss="modal" onclick="deleteBoard(${data.notId})">확인</button>
					</div>
				</div>
			</div>
		</div>
	</section>
		<script type="text/javascript">
		function deleteBoard(noticeId) {
			$.ajax({
				url: "${noticeUrl}/delete",
				type: "post",
				data: {
					id: noticeId
				},
				dataType: "json",
				success: function(data) {
					if(data.code === "success") {
						alert("삭제 완료");
						location.href = "${noticeUrl}";
					}
				}
			});
		}
		</script>