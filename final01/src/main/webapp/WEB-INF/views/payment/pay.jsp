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
	<title>결제 페이지</title>
	<%@ include file="../module/head.jsp" %>
 <style type="text/css">
 
      
     .container {
       width: 550px;
       margin: 0 auto;
       }
      
  	 .border-width{
	  width:700px;
	  margin-left : auto;
	  margin-right : auto;
	 }
	 
	 .whole-size{
	  margin: auto;
      min-width: 769px;
	 }
	 
	 .form-label{
	   text-align: left;
	   width:auto;
	   display:block;
	   fontweight: bold;
	   margin-bottom:0.4rem;
	 }
	 
	 .form-input{
	   width:auto;
	   display:block;
	   padding:0.5rem;
	   border:1px solid #CCCCCC;
	   margin-bottom:0.4rem;
	   border-radius: 5px 5px 5px 5px;
	 }
	 	 
	 .form-inline-input{
	  display:inline-block;
	 }
	 
	 .form-size-300{
	   width:300px;
	 }
	 
	  .form-size-610{
	   width:610px;
	 }
	 
	   .form-size-200{
	   width:200px;
	 }
	  .button-left{
	  margin-right: 70px;
	  }
	  
	  input:focus{
	  outline : 1.5px solid  rgba(13, 110, 253, 0.9);
	  }
	 
	 
	
	 
 </style>	
	
</head>
<body>
 <header>
    <%@ include file="../module/navigation.jsp" %>
 </header>
	<%@ include file="../module/categoryNavigation.jsp" %>
  <section class="container whole-size" style="width:750px">
     <div class="mt-5">
     <div class="mb-4 border-bottom border-2 border-secondary border-width">
        <div class="mb-3">
          <h3> <b>결 제</b> <i class="bi bi-credit-card"></i></h3>   
        </div>
    </div>
  </div>
   
<!--주소 Check-->
     <c:url var="payUrl" value="/payment/pay" />
      <form action="${payUrl}" method="post">
     <div style="text-align: center;"> 
      <div>
         <div class="form-inline-input">
            <label class="form-label">First Name</label>
            <input class="form-input form-size-300 mb-4 cursor" type="text" name="FirstName" placeholder="gil-dong">
          </div>
          <div class="form-inline-input">
            <label class="form-label">Last Name</label>
            <input class="form-input form-size-300 mb-4 cursor" type="text" name="LastName"  placeholder="hong">
         </div>
      </div>  
       
      <div>   
         <div class="form-inline-input">
            <label class="form-label">Address</label>
            <input class="form-input form-size-610 mb-1 cursor" type="text" name="AddressFirstLine" placeholder="역삼동 KH정보교육원">
            <input class="form-input form-size-610 mb-4 cursor" type="text" name="AddressSecondLine" placeholder="">
         </div>
      </div>   
      
      <div>  
         <div class="form-inline-input">
           <label class="form-label">Country</label>
           <input class="form-input form-size-200 mb-4 cursor" type="text" name="Country" placeholder="서울특별시">
         </div>
         <div class="form-inline-input">
           <label class="form-label">State</label>
           <input class="form-input form-size-200 mb-4 cursor" type="text" name="State" placeholder="강남구">         
         </div>
          <div class="form-inline-input"> 
           <label class="form-label">Postal Code</label>
           <input class="form-input form-size-200 mb-4 cursor" type="text" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"
                   name="PostalCode"  maxlength="5" placeholder="06234">           
         </div>
       </div> 
        
        
          <div class="text-end button-left">
            <button class="btn btn-primary" type="button" onclick="cancel();">취 소</button>
            <!-- <button class="btn btn-primary" type="button" onclick="finalPay(this.form);">결 제</button> -->
            <button class="btn btn-primary" type="button" id="check_module">결 제</button>
          </div>
       </form>       
  
   
  </section>

 <!--하단--> 
 <%@ include file="../module/footer.jsp" %>
 
 <script type="text/javascript">
 <!--취소버튼-->
  function cancel(){
	if(confirm("결제를 취소하시겠습니까?") === true){
		window.history.back();
	}
	return;
  }
 
 /* <!--결제 버튼-->
 <!--정보입력 빈 칸 방지-->
 function finalPay(form){
	 if(form.FirstName.value =="" || form.LastName.value ==""){
		 alert("이름은 반드시 입력해주세요");
	 }else if(form.AddressFirstLine.value =="" || form.Country.value =="" || form.State.value=="" || form.PostalCode.value ==""){
		 alert("주소를 입력해주세요");
	 }else if(form.NameOnCard.value=="" || form.CardNumber.value=="" || form.Expiration.value=="" || form.CVV.value==""){
		 alert("카드정보를 올바르게 입력해주세요");
	 }else{
		  if(confirm("결제 하시겠습니까?") === true){
			  form.submit();
<!--주소 Check-->			  
			  alert("결제가 완료되었습니다.\n메인화면으로 이동합니다.");
			  location.href="https://www.naver.com";
		  }else{
			  alert("결제에 실패하였습니다.");
		  }			 
	 }
	  
 } */

 
 <!-- 결제 api 테스트!!!!!!!!!! -->
 <!--결제 버튼-->
 <!--정보입력 빈 칸 방지-->
 
 
 $("#check_module").click(function () {
	var IMP = window.IMP;
	var code = "imp33043558"; //가맹점 식별코드
	IMP.init(code);
		//결제요청
		IMP.request_pay({
			pg : 'kcp',
			pay_method: 'card',
			merchant_uid : 'merchant_' + new Date().getTime(),
			name : '결제테스트', // 상품명
			amount : 1,
			buyer_email : 'iamport@siot.do',
			buyer_name : '구매자이름',
			buyer_tel : '010-1234-5678',  //필수항목
			buyer_addr: '서울특별시 강남구 삼성동',   
			buyer_postcode: '123-456',
			//결제완료후 이동할 페이지 kko나 kkopay는 생략 가능
			m_redirect_url : 'localhost/home'
		}, function(rsp){
			if(rsp.success){//결제 성공시
				var msg = '결제가 완료되었습니다';
				var result = {
				"imp_uid" : rsp.imp_uid,
				"merchant_uid" : rsp.merchant_uid,
				"pay_date" : new Date().getTime(),
				"amount" : rsp.paid_amount,
				"card_no" : rsp.apply_num,
				"refund" : 'payed'
				}
				console.log("결제성공 " + msg);
			}
			else{//결제 실패시
				var msg = '';
				msg += '에러 : ' + rsp.error_msg
			}
			console.log(msg);
			alert(msg);
		});//pay
	}); //check1 클릭 이벤트
 
 
  
 </script>
</body>
</html>