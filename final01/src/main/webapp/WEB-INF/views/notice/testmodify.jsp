<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정 - ${data.title}</title>

<!-- 테스트 파일임 -->
</head>
<script type="text/javascript">
	function formCheck(form) {
		if(form.title.value === undefined || form.title.value.trim() === "") {
			var modal = new bootstrap.Modal(document.getElementById("errorModal"), {
				keyboard: false
			});
			modal.show();
			return;
		}
		form.submit();
	}
</script>
<body>
	<header></header>
	<section class="container">
		<div class="mt-3">
			<c:url var="noticeModifyUrl" value="/notice/modify" />
			<form action="${noticeModifyUrl}" method="post">
				<input type="hidden" name="notId" value="${data.notId}">
				<div class="mb-3">
					<input class="form-control" type="text" name="title" value="${data.title}" placeholder="제목을 입력하세요.">
				</div>
				<div class="mb-3">
					<textarea class="form-control" name="content" rows="8"
						placeholder="내용을 입력하세요.">${data.content}</textarea>
				</div>
				<div class="mb-3 text-end">
					<button class="btn btn-primary" type="button" onclick="formCheck(this.form);">저장</button>
				</div>
				
			</form>
		</div>
	</section>
</body>
</html>