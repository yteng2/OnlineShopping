<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="${request.contextPath}/header"></jsp:include>
<p>From Session : <%=session.getAttribute("partResult") %></p>
<div class = "container">
<c:forEach var = "item" items = "${ partResult }">
	<div class = 'row'>
		<li>
		<a href = './item_big_id = ${ item.getId() }'>
		<img src="/OnlineShopping/image = ${item.getId()}" height="50" width="50"/>
		<div class = "">
			<h5>${ item.getName() }</h5>
		</div>
		</a>
		<button>add to cart</button>
		<button>buy it now</button>
		</li>
	</div>

</c:forEach>
</div>
<div>
<p>total ${size} pages</p>
<c:forEach begin="1" end="${size}" varStatus="loop">
	<a href = './search:page = ${loop.index}'>${loop.index}</a>
</c:forEach>
</div>

<p><a href = '#'>total ${ item }${partResult.size() } items </a></p>
</body>
</html>