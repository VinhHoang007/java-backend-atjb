<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css" />
    <style>
        <%@include file="/css/fStyle.css"%>
    </style>
<title>Login</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-4 col-lg-offset-4">
				<div class="panel panel-default my-login">
					<div class="panel-heading">
						<h3 class="panel-title">Please Sign In</h3>
					</div>
					<div class="panel-body">
						<form accept-charset="UTF-8" role="form" action="checkLogin" method="post" modelAttribute="member">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="E-mail" name="email"
										type="text" maxlength="50" />
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password"
										name="passWord" type="password" maxlength="50" />
								</div>
								<div class="checkbox" style="margin: 14px 0px;">
									<label> <input name="remember" type="checkbox"
										value="Remember Me" /> Remember Me
									</label>
								</div>
								<input class="btn btn-lg btn-success btn-block" type="submit"
									value="Login" style="margin-top: 25px" />
								<small id="" class="text-danger">${messageErrorLogin}</small>	
							</fieldset>
						</form>

					</div>
					<div class="register">
						<a href="<c:url value="/register"/>">Click here to Register</a>
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