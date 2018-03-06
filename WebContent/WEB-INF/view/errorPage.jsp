<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
	<h1><spring:message code="label.exception" /></h1>
	<hr>
	<h2>${ exception }</h2>
	<hr>
	<h4><spring:message code="label.url" />${ url }</h4>
	<hr>
	<a href = './'><spring:message code="label.main_page" /></a>
</div>

</body>
</html>