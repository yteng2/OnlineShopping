<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="${request.contextPath}/header"></jsp:include>

	<c:if test = '${user.getCart().size() > 0}'>
	<div class = "container">
		<div class = "row table table-hover">
			<div class = "col-md-10">
			<c:set var="total" value="${0}"/>
			<c:forEach var = "item" items = "${ user.getCart() }" varStatus="loop">
				<div class = 'row' id = '${loop.index}'>
					<a href = './item_big_id = ${item.getItem().getId()}'>
					<div class="col-md-2">
						<img src="/OnlineShopping/image = ${item.getItem().getId()}" class = "img-responsive"/>
					</div>
					
					<div class = "col-md-10">
						<h5>${ item.getItem().getName() }</h5>
					</div>
					</a>
					<input type = "hidden" id = "price_${loop.index}" value = "${ item.getItem().getPrice() }">
					<div class = "col-md-10">
						<label><spring:message code="label.amount"/></label>
						<select id = 'amount_${ loop.index }' onchange="change(${loop.index})">
							<c:forEach begin="1" end="${ item.getItem().getStock() }" varStatus="loop2">
		
								<option ${item.getAmount() == loop2.index ? 'selected' : ''}> ${ loop2.index }</option>
		
							</c:forEach>
						</select>
						<label><spring:message code="label.price"/>: $ </label>
						<label id = "curprice_${loop.index}">${item.getItem().getPrice()*item.getAmount() }</label>
						<c:set var="total" value="${total + item.getItem().getPrice()*item.getAmount()}" />
						<button class = "btn btn-danger btn-xs" onclick ="deleteItem(${loop.index})" style="float: right;"><spring:message code="label.remove"/></button>
					</div>
					
				</div>
				<hr>
			</c:forEach>
			</div>
			
			<div class = "col-md-2 well  well-sm " style = 'text-align: center; padding-top: 50px; padding-bottom: 50px;'>
				<br>
				<br>
				<label><spring:message code="label.price"/>: $  </label>
				<label id = "total">${ total }</label>
				<br>
				<br>
				<a href = "./pre_check_out" class = 'btn-lg btn-warning'><spring:message code="label.check_out"/></a>
				<br>
				<br>
				
			</div>
		</div>
	</div>
	</c:if>
	<c:if test = '${ user.getCart().size() == 0 }'>
	<h3><spring:message code="label.empty"/></h3>
	</c:if>

<script src="${pageContext.request.contextPath}/resources/js/Shopping_Cart.js" type="text/javascript"></script>
</body>
</html>