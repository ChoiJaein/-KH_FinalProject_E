<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../module/head.jsp" %>

<c:url var="mainUrl" value="." />


			<div style="float:left; margin:0 0 0 50px; background-color:skyblue; ">
					<ul style="list-style:none">
						<li>
							<a class="dropdown-item">카테고리</a>
						</li>
						<li>
							<a class="dropdown-item" href="${mainUrl}/list?type=digital">가전/디지털</a>
						</li>
						<li>
							<a class="dropdown-item" href="${mainUrl}/list?type=clothes">의류</a>
						</li>
						<li>
							<a class="dropdown-item" href="${mainUrl}/list?type=bag">가방</a>
						</li>
						<li>
							<a class="dropdown-item" href="${mainUrl}/list?type=accessories">액세서리</a>
						</li>
						<li>
							<a class="dropdown-item" href="${mainUrl}/list?type=baby">유아/출산</a>
						</li>
						<li>
							<a class="dropdown-item" href="${mainUrl}/list?type=pet">반려동물용품</a>
						</li>
						<li>
							<a class="dropdown-item" href="${mainUrl}/list?type=furniture">가구</a>
						</li>
						<li>
							<a class="dropdown-item" href="${mainUrl}/list?type=beauty">뷰티/미용</a>
						</li>
						<li>
							<a class="dropdown-item" href="${mainUrl}/list?type=office">사무</a>
						</li>
						<li>
							<a class="dropdown-item" href="${mainUrl}/list?type=art">예술/악기</a>
						</li>
					</ul>
			</div>