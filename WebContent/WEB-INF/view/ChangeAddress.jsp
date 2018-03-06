<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="${request.contextPath}/header"></jsp:include>
<div class = "container">
  <div class="row">
    <div class="col-md-8 col-md-offset-2">
      <form:form class="form-horizontal" action = "./updateAddress" method = "post" modelAttribute = "address">
        <fieldset>
          <!-- Form Name -->
         	<legend style = "text-align: center;"><spring:message code="label.change_address" /></legend>

          <!-- Text input-->
          <spring:message code="label.Address_Line" var = "Address_Line"/>
          <div class="form-group">
          	
            <label class="col-sm-3 control-label" for=" ">${ Address_Line } 1</label>
            <div class="col-sm-9">
            	
              <form:input type="text" placeholder="${ Address_Line } 1" class="form-control" path = 'add1' />
              <form:errors path="add1" cssStyle = "color: red;" />
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group">
            <label class="col-sm-3 control-label" for="textinput">${ Address_Line } 2</label>
            <div class="col-sm-9">
            	
              <form:input type="text" placeholder="${ Address_Line } 2" class="form-control" path = 'add2'/>
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group">
           <spring:message code="label.city" var = "city"/>
            <label class="col-sm-3 control-label" for="textinput">${ city }</label>
            <div class="col-sm-9">
              <form:input type="text" placeholder="${ city }" class="form-control" path = "city"/>
              <form:errors path="city" cssStyle = "color: red;" />
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group">
          	<spring:message code="label.state" var = "state"/>
            <label class="col-sm-3 control-label" for="textinput">${ state }</label>
            <div class="col-sm-3">
              <form:input type="text" placeholder="${ state }" class="form-control" path = "state"/>
              <form:errors path="state" cssStyle = "color: red;" />
            </div>
			<spring:message code="label.postcode" var = "postcode"/>
            <label class="col-sm-3 control-label" for="textinput">${ postcode }</label>
            <div class="col-sm-3">
              <form:input type="text" placeholder="${ postcode }" class="form-control" path = 'post'/>
              <form:errors path="post" cssStyle = "color: red;" />
            </div>
          </div>



          <!-- Text input-->
          <div class="form-group">
          <spring:message code="label.country" var = "country"/>
            <label class="col-sm-3 control-label" for="textinput">${ country }</label>
            <div class="col-sm-9">
              <form:input type="text" placeholder="${ country }" class="form-control" path = 'country'/>
              <form:errors path="country" cssStyle = "color: red;" />
            </div>
          </div>

          <div class="form-group">
            <div class="col-sm-offset-3 col-sm-9">
              <div class="pull-right">
                <button type="submit" class="btn btn-primary"><spring:message code="label.confirm"/></button>
              </div>
            </div>
          </div>

        </fieldset>
      </form:form>
    </div><!-- /.col-lg-12 -->
</div><!-- /.row -->
</div>

</body>
</html>