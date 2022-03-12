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
	
	<style type="text/css">
	   .height-form-label{
	       height: 6rem;
	   }
	</style>
<title>Add Xe</title>
</head>
<body>
    <div class="col-12 mt-4 wrapper-card">
        <div class="card create-customer-card">
            <h5 class="card-header">Customer Form</h5>
            <div class="card-body">
                <form:form action="${pageContext.request.contextPath}/addXe" method="post"
                    id="create-xe-form" modelAttribute="xe">

                    <div class="form-group height-form-label">
                        <label class="label-color font-label font-weight-bold">Hang San xuat</label>
                        <form:input path="hangSanXuat" id="hangSanXuat"
                            class="form-control" placeholder="hangSanXuat" maxlength="50" />
                        <form:errors path="hangSanXuat" cssClass="form-text text-danger" />
                        <small id="hangSanXuat-err" class="form-text text-danger"></small>
                    </div>

                    <div class="form-group height-form-label">
                        <label class="label-color font-label font-weight-bold">Bien So Xe</label>
                        <form:input path="bienSo" id="bienSo" class="form-control"
                            placeholder="Enter the Bien So" maxlength="50" />
                        <form:errors path="bienSo" cssClass="form-text text-danger" />
                        <small id="bienSo-err" class="form-text text-danger"></small>
                    </div>

                    <div class="form-group height-form-label">
                        <label class="label-color font-label font-weight-bold">Han Kiem Dinh</label>
                        <form:input type="date" path="hanKiemDinh" id="phone" class="form-control"
                            placeholder="Enter the Han Kiem Dinh" maxlength="50" />
                        <form:errors path="hanKiemDinh" cssClass="form-text text-danger" />
                        <small id="hanKiemDinh-err" class="form-text text-danger">${messageErrDate}</small>
                    </div>

                    <div class="form-group height-form-label">
                        <label class="label-color font-label font-weight-bold">Ma Nha Xe</label>
                        <form:input path="maNhaXe" id="maNhaXe" class="form-control"
                            placeholder="Enter the maNhaXe" maxlength="50" />
                        <form:errors path="maNhaXe" cssClass="form-text text-danger" />
                        <small id="maNhaXe-err" class="form-text text-danger"></small>
                    </div>

                    <button type="button" class="btn btn-success" id="btn-addXe">Submit</button>
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
	<script type="text/javascript" src="<c:url value="/js/validator1.js"/>"></script>
</body>
</html>