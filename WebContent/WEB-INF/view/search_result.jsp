<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList" %>
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
<%-- <p>From Session : <%=((ArrayList)session.getAttribute("partResult")).size()%></p> --%>
<div class = "container" >
	<input type = 'hidden' value = 1>
	<c:forEach var = "item" items = "${ partResult }" varStatus="loop">
		<div class = 'row table table-hover'>
			<div class="col-md-9">
			
				<a href = './item_big_id = ${item.getId()}'>
					<div class="col-md-3">
						<img src="/OnlineShopping/image = ${item.getId()}" class="img-responsive"/>
					</div>	
					<div class="col-md-8" style="text-align: left">
						<h5>${ item.getName() }</h5>
					</div>
					<div class="col-md-1" style="text-align: center;">
						<h5 style = "font-size: large;">$${ item.getPrice() }</h5>
					</div>
				</a>
	
			</div>
			<div class="row" style = "vertical-align:middle">
				<div class = "col-md-3">
					
					<div>
						<spring:message code="label.out_stock" var = "out_stock"/>
						<h4 class = 'col-md-12' style = "text-center;color:red">${ item.getStock() eq 0 ? out_stock: ''}</h4>
					</div>
				
					<div class="col-md-6 col-xs-6	" >
						<a href = './addItem id = ${loop.index}' class = "btn btn-success btn-block ${ item.getStock() eq 0 ? 'disabled': ''}" >
						<spring:message code="label.add_to_cart"/></a>
					</div>
					<div class="col-md-6 col-xs-6" >
						<a href = "./buy_now id = ${item.getId()}" class = "btn btn-warning btn-block ${ item.getStock() eq 0 ? 'disabled': ''}"><spring:message code="label.buy_it_now"/></a>
					</div>

				
				</div>
			</div>	
		</div>
		<hr>
	</c:forEach>
</div>
<div  style="text-align: center">

	<a href = './search:page = ${pageId-1>0?pageId-1:1}' style = "font-size: large;"><</a>
	<c:forEach begin="1" end="${size}" varStatus="loop">
		<a href = './search:page = ${loop.index}' style = "font-size: large;">${loop.index}</a>
	</c:forEach>
	<a href = './search:page = ${pageId+1<size?pageId+1:size}' style = "font-size: large;">></a>
	
	<p><spring:message code="label.total"/> ${size} <spring:message code="label.pages"/>,
	${ item }${searchResult.size() } <spring:message code="label.items"/></p>

</div>


</body>
</html>