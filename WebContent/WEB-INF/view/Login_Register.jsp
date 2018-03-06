<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="${pageContext.request.contextPath}/resources/css/Login_Register.css" rel="stylesheet" >
</head>
<body>
<jsp:include page="${request.contextPath}/header"></jsp:include>

<div class="container">
    	<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="${error eq 'register'? '':'active'}" id="login-form-link">
								<spring:message code="label.login"/></a>
							</div>
							<div class="col-xs-6">
								<a href="#" class ="${error eq 'register'? 'active':'' }" id="register-form-link">
								<spring:message code="label.register"/></a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form:form id="login-form" action="./login" modelAttribute="user" method="post" role="form" style="display: ${error eq 'register'? 'none':'block'};">
									<div class="form-group">
										<spring:message code="label.username" var = "email"/>
										<input type="text" name="email" id="username" class="form-control" placeholder="${email}" path="email"/>
									</div>
		
									<div class="form-group">
										<spring:message code="label.password" var = "password"/>
										<input type="password" name="password" class="form-control" placeholder="${ password }" path = "password"/>
									</div>
									<div class="form-group text-center" style = "color:red">
										<p>${ failed != null ? "username/password didn't match":''}</p>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login"
												 value="<spring:message code="label.login"/>">
											</div>
										</div>
									</div>
								</form:form>
								<form:form id="register-form" action="./register" method="post" role="form" style="display: ${error eq 'register'? 'block':'none'};" modelAttribute="user">
									<div class="form-group">
										<spring:message code="label.first_name" var = "firstName"/>
										<form:input type="text" class="form-control" name = "firstName" placeholder="${ firstName }" path = "firstName"/>
										<form:errors path="firstName" cssStyle = "color: red;" />
									</div>
									<div class="form-group">
										<spring:message code="label.last_name" var = "last_name"/>
										<form:input type="text" class="form-control" name = "lastName" placeholder="${ last_name }" path = "lastName"/>
										<form:errors path="lastName" cssStyle = "color: red;"/>
									</div>
									<div class="form-group">
										<spring:message code="label.email_address" var = "email_address"/>
										<form:input type="text" class="form-control" id = "user_email" name = "user_email" placeholder="${ email_address }" path="email"/>
										<form:errors path="email" cssStyle = "color: red;"/>
									</div>
									<div class="form-group">
										<spring:message code="label.password" var="password"/>
										<form:input type="password" class="form-control" name = "password" id = "password" placeholder="${ password }" path = 'password'/>
										<form:errors path="password" cssStyle = "color: red;" />
									</div>
									<div class="form-group">
										<input type="password" class="form-control" name="password1" placeholder="<spring:message code="label.confirm_password"/>"/>
										<form:errors path="password" cssStyle = "color: red;" />
									</div>
									<div class="form-group">
										<spring:message code="label.phone_number" var = "phone_number"/>
										<form:input type="text" class="form-control" name = "phone" placeholder="${ phone_number }" path="phone"/>
										<form:errors path="phone" cssStyle = "color: red;" />
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<BUTTON id = 'register' type="submit" class="form-control btn btn-register" value="Register Now"><spring:message code="label.register_now"/></BUTTON>
											</div>
										</div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<script src="https://code.jquery.com/jquery-3.3.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/Login_Register.js" type="text/javascript"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.js" type="text/javascript"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/additional-methods.js" type="text/javascript"></script>

</body>
</html>