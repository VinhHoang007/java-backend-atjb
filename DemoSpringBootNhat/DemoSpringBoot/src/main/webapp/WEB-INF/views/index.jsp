<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello${user.name }</h1>
	<form:form modelAttribute="user" method="post" action="${pageContext.request.contextPath}/admin/user/1">
		<div class="form-group">
			<label for="name">Name</label>
			<form:input path="name" class="form-control" id="name" name="name"
				autocomplete="off" />
				<form:errors path="name" element="span" cssClass="text-danger"></form:errors>
		</div>
		<div class="form-group">
			<label for="username">User Name</label>
			<form:input path="username" class="form-control" id="username" name="username"
				autocomplete="off" />
			<form:errors path="username" element="span" cssClass="text-danger"></form:errors>
		</div>
		<div class="form-group">
			<label for="password">Password</label>
			<form:password path="password" class="form-control" id="password" name="password"
				autocomplete="off" />
			<form:errors path="password" element="span" cssClass="text-danger"></form:errors>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form:form>
	
</body>
</html>