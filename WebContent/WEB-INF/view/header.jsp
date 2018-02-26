<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "shopping.bean.User" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RJT Compuquest Online Shopping</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
  <!-- Brand and toggle get grouped for better mobile display -->
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="./header">RJT Compuquest</a>
  </div>

  <!-- Collect the nav links, forms, and other content for toggling -->
  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
<!--       <li class="active"><a href="#">Link</a></li>
      <li><a href="#">Link</a></li> -->
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown"> Categories <b class="caret"></b></a>
        <ul class="dropdown-menu">
        	<c:forEach var = "category" items = "${ categories }">
        	<li><a href="./search:${ category }">${category}</a></li>
        	</c:forEach>
<%--           <li><a href="#">${categories[0]}</a></li>
          <li><a href="#">Another action</a></li>
          <li><a href="#">Something else here</a></li>
          <li><a href="#">Separated link</a></li>
          <li><a href="#">One more separated link</a></li> --%>
        </ul>
      </li>
    </ul>
    <div class="col-sm-5 col-md-6">
        <form class="navbar-form" role="search">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="Search" name="q">
            <div class="input-group-btn">
                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
            </div>
        </div>
        </form>
    </div>
    <ul class="nav navbar-nav navbar-right">
	<%User user1 =	(User)session.getAttribute("user");%>
    	<input type = "hidden" id = "user1" value = <%= user1 %>/>
      <li><a href="./login_register"  onclick="test()">LOGIN</a></li>
      <c:set var="user" value = "${sessionScope.user}" />
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" ><%=user1 %>${sessionScope.user eq null ? 'temp' : user.getLastName()}<b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="#">Change Password</a></li>
          <li><a href="#">Update Profile</a></li>
          <li><a href="#">Manage Address</a></li>
          <li class="divider"></li>
          <li><a href="./logOut">Log Out</a></li>
        </ul>
      </li>
      <li><a href="./cart">Cart : ${ cart.size() }</a></li>
    </ul>
  </div><!-- /.navbar-collapse -->
</nav>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</body>
</html>