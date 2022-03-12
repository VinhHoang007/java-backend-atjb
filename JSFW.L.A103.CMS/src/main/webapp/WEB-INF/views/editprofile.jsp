<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <style>
        <%@include file="/css/all.css"%>
        <%@include file="/css/bootstrap.min.css"%>
        <%@include file="/css/content.css"%>
    </style>
<title>Edit Profile</title>
</head>
<body>
	<div class="container-fluid">

        <div class="row header">
            <div class="col-12">
                <div class="row parent-list-header">
                    <div class="col-11" style="font-weight: bold;">CMS</div>
                    <div class="col-1 icon-user"><a href="#" style="font-size:25px"><i class="fas fa-user-tie"></i><i class="fas fa-caret-down"></i></a>
                        <div class="row list-header">
                            <div class="col-12 row bg-item">
                                <div class="col-2"><i class="fas fa-user-secret"></i></div>
                                <div class="col-10"><a href="<c:url value="/showEditProfile"/>">User profile</a></div>
                            </div>
                            <div class="col-12 row bg-item">
                                <div class="col-2"><i class="fas fa-sign-out-alt"></i></div>
                                <div class="col-10"><a href="<c:url value="/login"/>">Logout</a></div>
                            </div>
                        </div>
                    </div>                    
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-2 side-bar">
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="Search">
                    <div class="input-group-append">
                        <button class="btn btn-success" type="submit"><i class="fas fa-search"></i></button>
                    </div>
                </div>

                <ul>
                    <li class="bg-item">
                        <a href="<c:url value = "/viewContent"/>" class="row">
                            <span class="col-2"><i class="fas fa-table"></i></span>
                            <span class="col-10"> View Contents</span>
                        </a>
                    </li>
                    <li class="line-item"></li>
                    <li class="bg-item">
                        <a href="<c:url value = "/showAddContent"/>" class="row">
                            <span class="col-2"><i class="fas fa-edit"></i> </span>
                            <span class="col-10"> Form Contents</span>
                        </a>
                    </li>
                </ul>



            </div>
            <div class="col-10">
                <div class="col-12 mt-5">
                    <h2>Edit Profile</h2>
                </div>
                <div class="line"></div>
                <div class="col-12 mt-4">
                    <div class="card">
                        <h5 class="card-header">Profile Form Elements</h5>
                        <div class="card-body">
                        
                            <form action="editProfile" method="post" modelAttribute ="profile">
                            <input type="hidden" value="${member.id}" class="form-control" name ="id" >
       <%--                      <input type="hidden" value="${member.userName}" class="form-control" name ="userName" >
                            <input type="hidden" value="${member.email}" class="form-control" name ="email" > --%>
                
                                <div class="form-group">
                                    <label class="label-color">First Name</label>
                                    <input type="text" value="${member.firstName}" class="form-control" name ="firstName" id=""placeholder="Enter the first name" maxlength="50">
                                    <small id="emailHelp" class="form-text text-muted"></small>
                                </div>

                                <div class="form-group">
                                    <label class="label-color">Last Name</label>
                                    <input type="text" value="${member.lastName}" class="form-control" id=exampleInputEmail1"
                                        name ="lastName"aria-describedby="emailHelp" placeholder="Enter the last name" maxlength="50">
                                    <small id="emailHelp" class="form-text text-muted"></small>
                                </div>

                                <div class="form-group">
                                    <label class="label-color">Email</label>
                                    <div><span>${member.email}</span></div>
                                </div>

                                <div class="form-group">
                                    <label class="label-color">Phone</label>
                                    <input type="text" class="form-control" id=""
                                        name ="phone" placeholder="Enter your phone number" value="${member.phone}">
                                    <small id="emailHelp" class="form-text text-muted"></small>
                                </div>

                                <div class="form-group">
                                    <label class="label-color">Description</label>
                                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                                </div>

                                <button type="submit" class="btn btn-primary">Submit Button</button>
                                <button type="reset" class="btn btn-primary">Reset Button</button>
                            </form>
                        </div>
                    </div>
                </div>


            </div>
        </div>
    </div>
	<script type="text/javascript" src="<c:url value="/js/all.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/jquery-3.6.0.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/popper.min.js"/>"></script>
</body>
</html>