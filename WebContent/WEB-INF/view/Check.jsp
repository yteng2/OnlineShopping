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
	<div >
		<h1 style = "text-align: center;"><spring:message code="label.check"/></h1>
	</div>
	<div class = "container">
		<div class = "row table table-hover">
			<div class = "col-md-12">
			<c:set var="total" value="${0}"/>
			<c:forEach var = "item" items = "${cart}" varStatus="loop">
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
			<br>
			  <div class="col-sm-4"></div>
			  <div class="col-sm-4">
			  <a href = "./" class = "btn btn-primary btn-block"><spring:message code="label.keep_shopping"/></a>
			  </div>
			  <div class="col-sm-4"></div>
	</div>
</body>
</html>