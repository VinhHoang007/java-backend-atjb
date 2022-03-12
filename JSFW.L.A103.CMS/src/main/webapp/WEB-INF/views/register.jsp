
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css" />
    <style>
        <%@include file="/css/fStyle.css"%>
        .err-input{
            color: red;
            font-size: 11px;
        }
        .fix-height{
           height: 62px; 
        }
        
        
    </style>
<title>Register</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-4 col-lg-offset-4">
				<div class="panel panel-default my-register">
					<div class="panel-heading">
						<h3 class="panel-title">Register</h3>
					</div>
					<div class="panel-body">
						<form:form accept-charset="UTF-8" role="form" action="saveMember" method="post" modelAttribute="memberRegis">
							<fieldset>
								<div class="form-group">
								    <div class="fix-height">
								        <form:input path="userName" class="form-control" placeholder="User Name" maxlength="50"/>
                                        <form:errors path="userName" cssClass="err-input"/>
								    </div>							    
								</div>
								<div class="form-group">
									<div class="fix-height">
										   <form:input path="email" class="form-control" placeholder="Email" maxlength="50"/>
										   <form:errors path="email" cssClass="err-input"/>
									</div>    
								</div>
								<div class="form-group">
								    <div class="fix-height">
										<form:input path="passWord" class="form-control" placeholder="passowrd" type="password" maxlength="50"/>
										<form:errors path="passWord" cssClass="err-input"/>
									</div>  	
								</div>
								<div class="form-group">
								    <div class="fix-height">
								       <%--  <form:input path="re-passWord" class="form-control" placeholder="Re Password" type="password" maxlength="50"/> --%>
									   <input class="form-control" placeholder="Re Password"
										  name="re-password" type="password" maxlength="50" />
										<span class="err-input"></span>
										<%-- <form:errors path="passWord" cssClass="error-input"/> --%>
									</div>	
								</div>

								<input class="btn btn-lg btn-success btn-block" type="submit"
									value="Register" style="margin-top: 20px" />
							</fieldset>
						</form:form>
						
						<%-- <form:form action="saveMember" method="POST" modelAttribute="memberRegis">
					
					        Name: <form:input path="userName"/> <form:errors path="userName" cssClass="text-danger"/> <br/><br/>
					        Email: <form:input path="email"/> <form:errors path="email" cssClass="text-danger"/> <br/><br/>
					        pass: <form:input path="passWord"/> <form:errors path="passWord" cssClass="text-danger"/> <br/><br/>
                            <button type="submit">Submit</button>
                        </form:form> --%>

					</div>
					<div class="register">
						<a href="<c:url value ="/login"/>">Click here to Login</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script
		src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	
	<script type="text/javascript" src="<c:url value="/js/all.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/jquery-3.6.0.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/popper.min.js"/>"></script>
</body>
</html>