<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 등록</title>
	<%@ include file="../module/head.jsp" %>

	
</head>

<body>
	<header></header>
	<br><br><br><br><br><br>
	<section class="container">
	<div class="mb-1">
	<table class="table">
		<tr>
			<th>이미지 등록</th>
			<th><img id="previewImg" class="image-360 mt-5 mb-4" alt="profile" src="" 
                   accept="image/png, image/jpeg, image/jpg" width="250" height="250"></th>
			<th><input id="imgSelect" name="uploadImg" type="file"></th>
			<th></th>
		</tr>
		
		<tr>
			<th>제목</th>
			<th><input class="form-control" type="text" name="title" placeholder="제목을 입력하세요." size="5"></th>
			<th></th>
			<th></th>
		</tr>
		
		<tr>
			<th>카테고리</th>
			<th><select class="form-select" id="id_category" name="categoryid">
					<option>카테고리 선택</option>
					<c:forEach items="${categoryDatas}" var="category">
						<option value="${category.categoryid}">[${category.categoryid}] ${category.categoryname}</option>
					</c:forEach>
				</select></th>
			<th></th>
			<th></th>
		</tr>
		
		<tr>
			<th>내용</th>
			<th colspan="3"><textarea name="content" rows="10" cols="100" placeholder="내용을 입력해주세요."></textarea></th>
		</tr>
		
		<tr>
			<th>유형</th>
			<th><input type="radio" name="chk_type" value="directdelivery" checked>직거래</th>
			<th><input type="radio" name="chk_type" value="delivery">택배거래</th>
			<th></th>
		</tr>
		<tr>
			<th></th>
			<th><input class="" type="text" name="location" placeholder="지역을 입력하세요."></th>
			<th></th>
			<th></th>
		</tr>
		
		<tr>
			<th>가격</th>
			<th><input class="" type="text" name="price" placeholder="가격을 입력하세요." ></th>
			<th></th>
			<th></th>
		</tr>
		
		<tr>
			<th>유형</th>
			<th><input type="radio" name="chk_status" value="new" checked>새상품</th>
			<th><input type="radio" name="chk_status" value="old">중고상품</th>
			<th>　　　　　　　</th>
		</tr>
		
	</table>
		<button class="btn btn-primary" onclick="location.href='/'">취소</button>
		<button class="btn btn-primary" type="submit">등록</button>
	</div>
	</section>
	
	<script type="text/javascript">
$(document).ready(function(){
	 
    // 라디오버튼 클릭시 이벤트 발생
    $("input:radio[name=chk_type]").click(function(){
 
        if($("input[name=chk_type]:checked").val() == "directdelivery"){
            $("input:text[name=location]").attr("disabled",false);
           //직거래일경우 텍스트박스 활성화
 
        }else if($("input[name=chk_type]:checked").val() == "delivery"){
              $("input:text[name=location]").attr("disabled",true);
            //택배거래일경우 텍스트박스 비활성화
        }
    });
});



<!--이미지 업로드 미리보기-->
function showImagePreview(e){
	 var file = e.target.files[0];
	 var imgUrl = URL.createObjectURL(file);
	 previewImg.src = imgUrl;	 
}

<!--이미지 업로드 Ajax-->
 function ajaxImageUpload(e){
	 var file  =  e.target.files[0];
	 var fData = new FormData();
	 fData.append("uploadImage", file, file.name);
	 
	 $.ajax({
		 type:"post",
		 enctype:"multipart/form-data",
		 url:"/ajax/imageUpload",
		 data:fData,
		 processData:false,
	     contentType:false,
	     success:function(data, status){
	    	 previewImg.src = data.src;
	     }
	  
	 });
 } 
</script>
</body>
</html>