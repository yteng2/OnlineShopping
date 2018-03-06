<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
	<h2><spring:message code="label.item_add"/></h2>
	<div class = 'row'>
		
		<a href = './item_big_id = ${item.getId()}'>
		<img src="/OnlineShopping/image = ${item.getId()}" class="img-responsive"/>
		<div class = "">
			<h5>${ item.getName() }</h5>
		</div>
		</a>
		
		<a href="./" class = "btn btn-success btn-block"><spring:message code="label.keep_shopping"/></a>
		<a href="./pre_check_out" class = "btn btn-warning btn-block"> <spring:message code="label.check_out"/></a>
		
	</div>
</div>

</body>
</html>