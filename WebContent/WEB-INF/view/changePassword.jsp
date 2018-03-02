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
<form class="form-horizontal" action = "./updatePassword" method = "post">
<fieldset>

<!-- Form Name -->
<legend><spring:message code="label.change_password" /></legend>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="piCurrPass"><spring:message code="label.current_password" /></label>
  <div class="col-md-4">
    	<input id="piCurrPass" name="piCurrPass" type="password" placeholder="" class="form-control input-md" required>   
  </div>
</div>

<!-- Password input-->

	<div class="form-group">
	  <label class="col-md-4 control-label" for="piNewPass"><spring:message code="label.new_password" /></label>
	  <div class="col-md-4">
	    	<input id="piNewPass" name="piNewPass" type="password" placeholder="" class="form-control input-md" required>
	    
	  </div>
	</div>
	
	<!-- Password input-->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="piNewPassRepeat"><spring:message code="label.confirm_password" /></label>
	  <div class="col-md-4">
	    <input id="piNewPassRepeat" name="piNewPassRepeat" type="password" placeholder="" class="form-control input-md" required>
	    
	  </div>
	</div>
	
	<!-- Button (Double) -->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="bCancel"></label>
	  <div class="col-md-8">
<!-- 	  	<a href = "./updatePassword" class="btn btn-danger">Submit</a>
	  	<a href = "./header" class="btn btn-success">Cancel</a> -->
		<input type = "submit" id="bCancel" name="bCancel" class="btn btn-danger" value = "<spring:message code="label.submit" />">
	    <a href = "./header" class="btn btn-success"><spring:message code="label.cancel" /></a>
	  </div>
	</div>

</fieldset>
</form>
</body>
</html>