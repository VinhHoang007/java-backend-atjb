<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">

<style>
.height-form-label {
	height: 5rem;
}
</style>
<title>Insert title here</title>
</head>
<body>

	<div class="col-12 mt-4 wrapper-card">
		<div class="card create-customer-card">
			<h5 class="card-header">Customer Form</h5>
			<div class="card-body">
				<form:form action="CreateCustomer" method="post"
					id="create-customer-form" modelAttribute="customer">

					<div class="form-group height-form-label">
						<label class="label-color font-label font-weight-bold">CustomerID
							(KHXXXXX)</label>
						<form:input path="customerID" id="customerID" class="form-control"
							placeholder="Enter the CustomerID" maxlength="50" />
						<form:errors path="customerID" cssClass="form-text text-danger" />
						<small id="customerID-err" class="form-text text-danger">${messageErrIdDuplicate}</small>
					</div>

					<div class="form-group height-form-label">
						<label class="label-color font-label font-weight-bold">Customer
							Name</label>
						<form:input path="customerName" id="customerName"
							class="form-control" placeholder="User Name" maxlength="50"/>
						<form:errors path="customerName" cssClass="form-text text-danger" />
						<small id="customerName-err" class="form-text text-danger"></small>
					</div>

					<div class="form-group height-form-label">
						<label class="label-color font-label font-weight-bold">Address</label>
						<form:input path="address" id="address" class="form-control"
							placeholder="Enter the Address" maxlength="50" />
						<form:errors path="address" cssClass="form-text text-danger" />
						<small id="address-err" class="form-text text-danger"></small>
					</div>

					<div class="form-group height-form-label">
						<label class="label-color font-label font-weight-bold">Phone
							Number</label>
						<form:input path="phone" id="phone" class="form-control"
							placeholder="Enter the Phone Number" maxlength="50" />
						<form:errors path="phone" cssClass="form-text text-danger" />
						<small id="phone-err" class="form-text text-danger"></small>
					</div>

					<div class="form-group height-form-label">
						<label class="label-color font-label font-weight-bold">Email</label>
						<form:input path="email" id="email" class="form-control"
							placeholder="Enter the email" maxlength="50" />
						<form:errors path="email" cssClass="form-text text-danger" />
						<small id="email-err" class="form-text text-danger"></small>
					</div>

					<div class="form-group height-form-label">
						<label class="label-color font-weight-bold">Status</label>
						<form:select class="form-control" id="status" path="email">
							<option value="Available">Available</option>
							<option value="Busy">Busy</option>
							<option value="Fixing">Fixing</option>
						</form:select>
						<form:errors path="email" cssClass="form-text text-danger" />
						<small id="emailHelp" class="form-text text-danger"></small>
					</div>

					<button type="button" class="btn btn-success" id="btn-addCustomer">Submit</button>
					<button type="reset" class="btn btn-primary">Reset</button>
				</form:form>
			</div>
		</div>
	</div>

	<div class="col-12 wrapper-card mb-4">
		<div class="card create-customer-card">
			<h5 class="card-header">Edit Customer Form</h5>
			<div class="card-body">
				<form:form action="updateCustomer" method="post"
					id="create-customer-form" modelAttribute="updateCustomer">

					<div class="form-row">
						<div class="col height-form-label">
							<label class="label-color font-label font-weight-bold">CustomerID</label> 
							<form:input path="customerID" id="customerID" class="form-control"
                            placeholder="Enter the CustomerID" maxlength="50" readonly="true"/>
                            <form:errors path="customerID" cssClass="form-text text-danger" />
                            <small id="customerID-err" class="form-text text-danger">${messageErrIdDuplicate}</small>
						</div>
					</div>

					<div class="form-row">
						<div class="col height-form-label">
							<label class="label-color font-label font-weight-bold">Address</label> 
							<form:input path="address" id="address" class="form-control"
                            placeholder="Enter the Address" maxlength="50" />
                            <form:errors path="address" cssClass="form-text text-danger" />
                            <small id="address-err" class="form-text text-danger"></small>
						</div>

						<div class="col height-form-label">
							<label class="label-color font-label font-weight-bold">Customer Name</label> 
							<form:input path="customerName" id="customerName"
                            class="form-control" placeholder="User Name" maxlength="50" />
                            <form:errors path="customerName" cssClass="form-text text-danger" />
                            <small id="customerName-err" class="form-text text-danger"></small>
						</div>
					</div>

					<div class="form-row">

						<div class="col height-form-label">
							<label class="label-color font-label font-weight-bold">Phone Number</label> 
							<form:input path="phone" id="phone" class="form-control"
                            placeholder="Enter the Phone Number" maxlength="50" />
                            <form:errors path="phone" cssClass="form-text text-danger" />
						</div>

						<div class="col height-form-label">
							<label class="label-color font-label font-weight-bold">Email</label> 
							<form:input path="email" id="email" class="form-control"
                            placeholder="Enter the email" maxlength="50" />
                            <form:errors path="email" cssClass="form-text text-danger" />
                            <small id="email-err" class="form-text text-danger"></small>
						</div>
						
						<div class="col height-form-label">
						  <label class="label-color font-label font-weight-bold">Status</label>
						  <form:select class="form-control" id="status" path="email">
	                            <option value="Available">Available</option>
	                            <option value="Busy">Busy</option>
	                            <option value="Fixing">Fixing</option>
                          </form:select>
                          <form:errors path="email" cssClass="form-text text-danger" />
                          <small id="emailHelp" class="form-text text-danger"></small> 
						</div>
					</div>


					<button type="button" class="btn btn-success" id="btn-addCustomer">Update</button>
					<button type="reset" class="btn btn-primary">Reset</button>
				</form:form>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>