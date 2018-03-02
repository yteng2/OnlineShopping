<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
								<a href="#" class="active" id="login-form-link">
								<spring:message code="label.login"/></a>
							</div>
							<div class="col-xs-6">
								<a href="#" id="register-form-link">
								<spring:message code="label.register"/></a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form id="login-form" action="./login" modelAttribute="user" method="post" role="form" style="display: block;">
									<div class="form-group">
										<input type="text" name="email" id="username" class="form-control" placeholder="<spring:message code="label.username"/>" >
									</div>
									<div class="form-group">
										<input type="password" name="password" id="password" class="form-control" placeholder="<spring:message code="label.password"/>">
									</div>
									<div class="form-group text-center">
<!-- 										<input type="checkbox" tabindex="3" class="" name="remember" id="remember">
										<label for="remember"> Remember Me</label> -->
									</div>
									<div class="form-group text-center" style = "color:red">
										<p>${ failed != null ? 'username/password didn\'t match':''}</p>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login"
												 value="<spring:message code="label.login"/>">
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-lg-12">
												<div class="text-center">
<!-- 													<a href="" tabindex="5" class="forgot-password">Forgot Password?</a> -->
												</div>
											</div>
										</div>
									</div>
								</form>
								<form id="register-form" action="./register" method="post" role="form" style="display: none;" modelAttribute="user">
									<div class="form-group">
										<input type="text" class="form-control" name = "firstName" placeholder=<spring:message code="label.first_name"/> path = "firstName"/>
									</div>
									<div class="form-group">
										<input type="text" class="form-control" name = "lastName" placeholder="<spring:message code="label.last_name"/>" path = "lastName"/>
									</div>
									<div class="form-group">
										<input type="email" class="form-control" name = "user_email" placeholder="<spring:message code="label.email_address"/>" path="email"/>
									</div>
									<div class="form-group">
										<input type="password" class="form-control" name = "password" placeholder="<spring:message code="label.password"/>" path = password/>
									</div>
									<div class="form-group">
										<input type="password" class="form-control" name="password1" placeholder="<spring:message code="label.confirm_password"/>"/>
									</div>
									<div class="form-group">
										<input type="text" class="form-control" name = "phone" placeholder="<spring:message code="label.phone_number"/>" path="phone"/>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<BUTTON type="submit" class="form-control btn btn-register" value="Register Now"><spring:message code="label.register_now"/></BUTTON>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

<script src="${pageContext.request.contextPath}/resources/js/Login_Register.js" type="text/javascript"></script>

</body>
</html>