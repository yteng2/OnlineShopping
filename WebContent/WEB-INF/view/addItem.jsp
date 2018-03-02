<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="${request.contextPath}/header"></jsp:include>
<div class = 'container'>
	<div class = 'row'>
		<li>
		<a href = './item_big_id = ${item.getId()}'>
		<img src="/OnlineShopping/image = ${item.getId()}" height="50" width="50"/>
		<div class = "">
			<h5>${ item.getName() }</h5>
		</div>
		</a>
		<p>Item has been add to you cart.</p>
		<a href="./go_back">keep shopping</a>
		<a href="./pre_check_out"> check out</a>
		</li>
	</div>
</div>

</body>
</html>