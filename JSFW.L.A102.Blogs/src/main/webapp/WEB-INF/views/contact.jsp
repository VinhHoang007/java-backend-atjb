<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact US</title>

<style>
        <%@include file="/css/all.css"%>
        <%@include file="/css/bootstrap.min.css"%>
        <%@include file="/css/fStyle.css"%>
    </style>
</head>
<body>
	<div class="container-fluid row">
		<div class="container-title Header col-12">
			<h2>Blog</h2>
		</div>
		<div class="col-12 container-navigation Navigation-menu">
			<ul>
				<li class="home"><a class="text-white text-decoration-none" href="<c:url value="/home"/>">Home</a></li>
                <li class="about"><a class="text-white text-decoration-none" href="<c:url value="/about"/>">About</a></li>
                <li class="contact"><a class="text-white text-decoration-none" href="<c:url value="/contact"/>">Contact</a></li>
                <c:if test = "${sessionScope.userLogin.userName != Null}">
                    <li class="login"><a class="text-white text-decoration-none" href="<c:url value="/logout"/>">Logout ${sessionScope.userLogin.userName}</a></li>
                </c:if>
                <c:if test = "${sessionScope.userLogin.userName == Null}">
                    <li class="login"><a class="text-white text-decoration-none" href="<c:url value="/login"/>">Login</a></li>
                </c:if>  
			</ul>
		</div>


		<nav aria-label="breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a class="text-decoration-none" href="<c:url value="/home"/>">Home</a></li>
				<li class="breadcrumb-item active" aria-current="page">Contact</li>
			</ol>
		</nav>


		<div class="content">
			<!-- welcome -->


			<div class="row content-contact">
				<div class="col-12 ml-3">
					<h3 class="title">Contact Us</h3>
					<p>If you have business inquiries or other questions, please
						fill out the following form to contact us. Thank you.</p>
					<p>
						Fields with <span class="requid">*</span> are required
					</p>
					<form action="">
						<div class="form-group">
							<label for="">Name <span class="requid">*</span></label> <input
								type="text" name="" id="" class="form-control" placeholder=""
								aria-describedby="helpId"> <label for="">Email <span
								class="requid">*</span></label> <input type="text" name="" id=""
								class="form-control" placeholder="" aria-describedby="helpId">
							<label for="">Subject <span class="requid">*</span></label> <input
								type="text" style="width: 100%;" name="" id=""
								class="form-control" placeholder="" aria-describedby="helpId">
							<label for="">Body <span class="requid">*</span></label>
							<textarea name="" id="" cols="60" rows="5"></textarea>
							<button class="mt-4">Submit</button>
						</div>
					</form>
				</div>
			</div>




		</div>

		<div class="Footer">
			<p>Copyright©2016 by My Company</p>
			<p>All rights reserved</p>
		</div>
		
    </div>
    <script type="text/javascript" src="<c:url value="/js/all.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/jquery-3.6.0.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/popper.min.js"/>"></script>
</body>
</html>