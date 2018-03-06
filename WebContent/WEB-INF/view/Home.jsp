<%@page import="shopping.bean.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="${request.contextPath}/header"></jsp:include>
<div class="container-fluid bg-2 text-center" style = "background-color: #e06d6d; padding-top: 60px;
      padding-bottom: 60px;">
  <h3><spring:message code="label.welcome" /></h3>
</div>
<%-- <%= ((List<Item>)session.getAttribute("searchResult")).size() %> --%>
<div class = "container">
		<c:forEach var = "item" items = "${ searchResult }" varStatus="loop">
			<c:if test = "${ loop.index % 4 == 0 }">
				<div class = "row">
			</c:if>
					<div class = "col-md-3 col-sm-6">
						<a href = './item_big_id = ${item.getId()}' class = "${ item.getStock() eq 0 ? 'disabled': ''}">
							<img src="/OnlineShopping/image = ${item.getId()}" class="img-responsive"/>
						</a>
					</div>

			<c:if test = "${ loop.index % 4 == 3 }">
				</div>
				<hr>
			</c:if>
		</c:forEach>	
</div>
</body>
</html>