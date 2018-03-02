<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

</head>
<body>
	<jsp:include page="${request.contextPath}/header"></jsp:include>
	<div class = 'container'>
		<div class = 'col-md-6'>
			<img src="/OnlineShopping/image = ${itemIndex}" class="img-responsive"/>
		</div>
		<div class = 'col-md-6'>
			<h2>${ item.getName() }</h2>
	
			<h1>$  ${ item.getPrice() }</h1>
		</div>	
	</div>
	<br>
	<div class="container">
	<span style="white-space: pre-line">${item.getDetail() }</span>
	<%-- //<p>${item.getDetail() }</p> --%>
	
	</div>
	<br>
	<div class="container">
		<div class = "row">
			<div class="col-md-6 col-xs-6	" >
				<a href = './addItem id = ${itemIndex}, amount = 1' class = 'btn btn-success' ><spring:message code="label.add_to_cart"/></a>
			</div>
			<div class="col-md-6 col-xs-6" >
				<button class = "btn btn-warning"><spring:message code="label.buy_it_now"/></button>
			</div>
		</div>
	</div>	
</body>
</html>