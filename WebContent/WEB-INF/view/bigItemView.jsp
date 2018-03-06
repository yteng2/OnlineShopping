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
	<div class = 'container'>
		<div class = 'col-md-6'>
			<img src="/OnlineShopping/image = ${itemIndex}" class="img-responsive"/>
		</div>
		<div class = 'col-md-6'>
			<h2>${ item.getName() }</h2>
	
			<h1>$  ${ item.getPrice() }</h1>
			
			<div>
				<spring:message code="label.out_stock" var = "out_stock"/>
				<h4 class = 'col-md-12' style = "text-center;color:red">${ item.getStock() eq 0 ? out_stock: ''}</h4>
			</div>		
		</div>	
	</div>
	<br>
	<div class="container">
	<span style="white-space: pre-line">${item.getDetail() }</span>
	<%-- //<p>${item.getDetail() }</p> --%>
	
	</div>
	<br>
	<div class="container">
		<form action = './addItem id = ${itemIndex}'>
		<div class = "row">
			<div class = "col-xs-2">
				<label><spring:message code="label.amount"/> </label>
				<select  name = "amount">
					<c:forEach begin="1" end="${ item.getStock() }" varStatus="loop">

						<option value = '${ loop.index }'> ${ loop.index }</option>

					</c:forEach>
				</select>
			</div>
			<div class="col-md-5 col-xs-10	" >
				<%-- <a href = './addItem id = ${itemIndex}, amount = 1' id = 'go' class = 'btn btn-success btn-block ${ item.getStock() eq 0 ? 'disabled': ''}' ><spring:message code="label.add_to_cart"/></a> --%>
				<button type = 'submit' class = 'btn btn-success btn-block ${ item.getStock() eq 0 ? 'disabled': ''}' ><spring:message code="label.add_to_cart"/></button>
			</div>
			
			<div class="col-md-5 col-xs-10" >
				<a href = "./buy_now id = ${item.getId()}" class = "btn btn-warning btn-block ${ item.getStock() eq 0 ? 'disabled': ''}"><spring:message code="label.buy_it_now"/></a>
			</div>
		</div>
		</form>
	</div>	
	<script>
		
	</script>
</body>
</html>