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
	<div class = "container">
		<div class = "row table table-hover">
			<div class = "col-md-12">
			<c:set var="total" value="${0}"/>
			<c:forEach var = "item" items = "${ user.getCart() }" varStatus="loop">
				<div class = 'row'>
					<a href = './item_big_id = ${item.getItem().getId()}'>
					<div class="col-md-2">
						<img src="/OnlineShopping/image = ${item.getItem().getId()}" class = "img-responsive"/>
					</div>
					
					<div class = "col-md-10">
						<h5>${ item.getItem().getName() }</h5>
					</div>
					</a>
					
					<div class = "col-md-10">
						<label><spring:message code="label.amount"/> ${ item.getAmount() }</label>
						<label><spring:message code="label.price"/>: $ </label>
						<label>${item.getItem().getPrice()*item.getAmount() }</label>
						<c:set var="total" value="${total + item.getItem().getPrice()*item.getAmount()}" />
					</div>
					
				</div>
			
			</c:forEach>
			<br>
			<br>
			<h3><spring:message code="label.address"/>:</h3>
			<div class = 'container'>
					<div class = "col-md-4 col-offset-4">
						<h4></h4>
						<h4>${ user.getAddress().getAdd1() } ${ user.getAddress().getAdd2() } ${ user.getAddress().getCity() }
						${ user.getAddress().getState() } ${ user.getAddress().getPost() } ${ user.getAddress().getCountry() }</h4>

					</div>
			</div>
			<br>
			<br>
			</div>
				<div class = "col-md-2">
					<label> <spring:message code="label.total"/> $ ${ total }</label>
				</div>
				<div class = "col-md-5">
					<a href = "./cart" class = "btn btn-info btn-block"><spring:message code="label.back"/></a>
				</div>
				<div class = "col-md-5">
					<a href = "./check" class = "btn btn-warning btn-block"><spring:message code="label.confirm"/></a>
				</div>
		</div>
	</div>
</body>
</html>