<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
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
			<c:url var="NoticeAddUrl" value="/notice/add" />
			<form action="${NoticeAddUrl}" method="post" enctype="multipart/form-data">
				<div class="mb-3">
					<input class="form-control" type="text" name="title" placeholder="제목을 입력하세요.">
				</div>
				<div class="mb-3">
					<textarea class="form-control" name="content" rows="8"
						placeholder="내용을 입력하세요."></textarea>
				</div>
				<div class="mb-3 text-end">
					<button class="btn btn-primary" type="button" onclick="formCheck(this.form);">저장</button>
				</div>
			</form>
		</div>
</html>