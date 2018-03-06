<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ page import = "shopping.bean.User" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>RJT Compuquest Online Shopping</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

</head>
<body>
<link href="${pageContext.request.contextPath}/resources/css/Login_Register.css" rel="stylesheet" >
<nav class="navbar navbar-default" role="navigation">
  <!-- Brand and toggle get grouped for better mobile display -->
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="./">RJT Compuquest</a>
  </div>

  <!-- Collect the nav links, forms, and other content for toggling -->
  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
<!--       <li class="active"><a href="#">Link</a></li>
      <li><a href="#">Link</a></li> -->
      <li class="dropdown">
        <a href="" class="dropdown-toggle" data-toggle="dropdown"> 
        <spring:message code="label.category" />
         <b class="caret"></b>
         </a>
        <ul class="dropdown-menu">
   <%--      	<c:set var="categories" value = "${sessionScope.user}" /> --%>
        	<c:forEach var = "category" items = "${ categories }">
        	<li><a href="./search: category = ${ category }">${category}</a></li>
        	</c:forEach>
<%--           <li><a href="#">${categories[0]}</a></li>
          <li><a href="#">Another action</a></li>
          <li><a href="#">Something else here</a></li>
          <li><a href="#">Separated link</a></li>
          <li><a href="#">One more separated link</a></li> --%>
        </ul>
      </li>
    </ul>
    <div class="col-sm-5">
        <form class="navbar-form" action ="./search">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="<spring:message code="label.search" />" name="keyWord">
            <div class="input-group-btn">
                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
            </div>
        </div>
        </form>
    </div>
    <ul class="nav navbar-nav navbar-right">
	<%User user1 =	(User)session.getAttribute("user");%>
    	<input type = "hidden" id = "user1" value = <%= user1 %>/>
    <% if(user1 == null || user1.getFirstName() == null){ %>
      <li><a href="./login_register"  onclick="test()"><spring:message code="label.login" /></a></li>
      <%}
    else {%>
      
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" ><%=user1.getFirstName()+" "+user1.getLastName() %><b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="./preUpdatePassword"><spring:message code="label.change_password"/></a></li>
          <%-- <li><a href=""><spring:message code="label.update_profile"/></a></li> --%>
          <li><a href="./preUpdateAddress"><spring:message code="label.change_address"/></a></li>
          <li class="divider"></li>
          <li><a href="./logOut"><spring:message code="label.logout"/></a></li>
        </ul>
      </li>
      <%} %>
      <li><a href="./cart"><spring:message code="label.cart" /> : ${ user.getCart().size() }</a></li>
      <li class="dropdown">
	      <a href="" class="dropdown-toggle" data-toggle="dropdown"> 
	      <spring:message code="label.language" />
	      <b class="caret"></b>
	      </a>
	      <ul class="dropdown-menu">
	      	<li><a href="./language?locale=en">English</a></li>
			<li><a href="./language?locale=cn">中文</a></li>
	      </ul>
      </li>
    </ul>
  </div><!-- /.navbar-collapse -->

</nav>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</body>
</html>