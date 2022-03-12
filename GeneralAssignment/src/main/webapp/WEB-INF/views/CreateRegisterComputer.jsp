<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
   <style>
        <%@include file="/css/bootstrap.min.css"%>
        <%@include file="/css/fStyle.css"%>
    </style>
<title>Detail Computer</title>
</head>
<body>
    <div class="container-fluid">
        <div class="col-12 header d-flex justify-content-between align-items-center">

            <span class="col-2 text-white" style="font-size:25px; font-weight: bold;">CYBER SECURITY</span>
            <!-- icon user -->
            <span class="text-white float-right text-right myDropdown">
                <a href="#"><i class="fas fa-user-secret fa-2x"></i></a>
                <ul class="mydropdown-menu text-left">
                    <li>
                        <a class="dropdown-item" href="#">
                            <span class="col-1"><i class="fas fa-user-edit"></i></span>
                            User Profile
                        </a>
                    </li>
                    <li>
                        <a class="dropdown-item" href="#">
                            <span class="col-1"><i class="fas fa-sign-out-alt"></i></span>
                            Logout
                        </a>
                    </li>
                </ul>
            </span>
        </div>


        <div class="col-12 row content">
            <div class="col-2 side">
                <ul>
                    <li>
                        <a href="<c:url value="/" />">
                            <span class="col-2"><i class="fas fa-home"></i></span>
                            <span class="col-10 font-weight-bold">
                                Home
                            </span>
                        </a>
                    </li>

                    <li class="my-parent">
                        <a href="#">
                            <span class="col-2"><i class="fas fa-laptop-code"></i></span>
                            <span class="col-10 font-weight-bold">
                                Computer
                                <span style="margin-left:15px"><i class="fas fa-caret-down"></i></span>
                            </span>
                        </a>
                        <ul class="my-child">
                            <li>
                                <a href="<c:url value="/Computer/showCreateComputer" />">
                                    <span class="col-2 ml-4"><i class="fas fa-plus"></i></span>
                                    <span class="col-10">Create Computer</span>
                                </a>
                            </li>
                            <li>
                                <a href="<c:url value="/Computer/showListComputer" />">
                                    <span class="col-2 ml-4"><i class="fas fa-plus"></i></span>
                                    <span class="col-10">List Computer</span>
                                </a>
                            </li>
                            
                        </ul>
                    </li>

                    <li class="my-parent">
                        <a href="#">
                            <span class="col-2"><i class="fas fa-user-tie"></i></span>
                            <span class="col-10 font-weight-bold">
                                Customer
                                <span style="margin-left:18px"><i class="fas fa-caret-down"></i></span>

                            </span>
                        </a>
                        <ul class="my-child">
                            <li>
                                <a href="<c:url value="/Customer/showCreateCustomer" />">
                                    <span class="col-2 ml-4"><i class="fas fa-plus"></i></span>
                                    <span class="col-10">Create Customer</span>

                                </a>
                            </li>
                            <li>
                                <a href="<c:url value="/Customer/showListCustomer" />">
                                    <span class="col-2 ml-4"><i class="fas fa-plus"></i></span>
                                    <span class="col-10">List Customer</span>
                                </a>
                            </li>
                            <li>
                                <a href="<c:url value="/Customer/showListCustomerDetail" />">
                                    <span class="col-2 ml-4"><i class="fas fa-plus"></i></span>
                                    <span class="col-10">List Computer Detail</span>
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="my-parent">
                        <a href="#">
                            <span class="col-2"><i class="fas fa-hamburger"></i></span>
                            <span class="col-10 font-weight-bold">
                                Service

                                <span style="margin-left: 36px;"><i class="fas fa-caret-down"></i></i></span>
                            </span>
                        </a>

                        <ul class="my-child">
                            <li>
                                <a href="<c:url value="/Service/showCreateService" />">
                                    <span class="col-2 ml-4"><i class="fas fa-plus"></i></span>
                                    <span class="col-10">Create Service</span>

                                </a>
                            </li>
                            <li class="listService-Item">
                                <a href="<c:url value="/Service/showListService" />">
                                    <span class="col-2 ml-4"><i class="fas fa-plus"></i></span>
                                    <span class="col-10">List Service</span>

                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="my-parent">
                        <a href="#">
                            <span class="col-2"><i class="fas fa-info-circle"></i></span>
                            <span class="col-10 font-weight-bold">Register
                                <span style="margin-left: 30px;" ><i class="fas fa-caret-down"></i></i></span>
                            </span>
                        </a>

                        <ul class="my-child">
                            <li>
                                <a href="<c:url value="/ServiceUsage/showRegisterService" />">
                                    <span class="col-2 ml-4"><i class="fas fa-plus"></i></span>
                                    <span class="col-10">Register Service Usage</span>
                                </a>
                            </li>
                            <li>
                                <a href="<c:url value="/ComputerUsage/showRegisterComputer" />">
                                    <span class="col-2 ml-4"><i class="fas fa-plus"></i></span>
                                    <span class="col-10">Register Computer Usage</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
    
            <div class="col-10">
                <div class="col-12 mt-5 text-center">
                    <h2>Register Computer Usage</h2>
                </div>
                <div class="line"></div>
                <div class="col-12 mt-4 wrapper-card">
                    <div class="card create-customer-card">
                        <h5 class="card-header">Register Computer Form</h5>
                        <div class="card-body">
                            <form method="post" action="CreateComputerUsage" id="create-computer-form" modelAttribute="computerUsage">

                                <div class="form-group height-form-label">
                                    <label class="label-color font-label">CustomerID</label>
                                    <!-- <input type="text" class="form-control" id="customerID" placeholder="Enter the CustomerID" maxlength="50" name="customerID"> -->
                                    <select class="form-control" id="customerID" name="customerID">
                                        <c:forEach var="ele1" items="${lstCustomer}">
                                            <option value="${ele1.customerID}">${ele1.customerID}</option>
                                        </c:forEach>
                                    </select>
                                    <small id="customerID-err" class="form-text text-danger"></small>
                                </div>

                                <div class="form-group height-form-label">
                                    <label class="label-color font-label">ComputerID</label>
                                    <!-- <input type="text" class="form-control" id="computerID" placeholder="Enter the ComputerID" maxlength="50" name="serviceID"> -->
                                    <select class="form-control" id="customerID" name="computerID">
                                        <c:forEach var="ele2" items="${lstComputer}">
                                            <option value="${ele2.computerID}">${ele2.computerID}</option>
                                        </c:forEach>
                                    </select>
                                    <small id="computerID-err" class="form-text text-danger"></small>
                                </div>

                                <div class="form-group height-form-label">
                                    <label class="label-color font-label">Date Of Usage</label>
                                    <input type="date" class="form-control" id="date-service-usage" placeholder="Chose Date Of Usage" maxlength="50" name="dateOfUseComputer">
                                    <small id="date-service-usage-err" class="form-text text-danger"></small>
                                </div>

                                <div class="form-group height-form-label">
                                    <label class="label-color font-label">Begin Time Of Usage</label>
                                    <input type="time" class="form-control" id="begin-time-computer" placeholder="Chose Date Of Time" maxlength="50" name="timeBeginOfUseComputer">
                                    <small id="begin-time-computer-err" class="form-text text-danger"></small>
                                </div>

                                <div class="form-group height-form-label">
                                    <label class="label-color font-label">Time Of Usage</label>
                                    <input type="number" class="form-control" id="time-computer-use" placeholder="Enter Time Of Use" maxlength="50" name="timeUseComputer" min="1">
                                    <small id="time-computer-use-err" class="form-text text-danger"></small>
                                </div>

                                <button type="button" id="btn-addRegisterComputer" class="btn btn-success">Submit</button>
                                <button type="reset" class="btn btn-primary">Reset</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        
        
    </div>

    <footer>
        <div class="col-12 text-center align-items-center justify-content-center footer row m-0">
            <div class="text-center col-12 mt-2">
                <a href="#"> <i class="fab fa-facebook fa-2x"></i></a>
                <a href="#"> <i class="fab fa-facebook-messenger fa-2x ml-2 mr-2"></i></a>
                <a href="#"> <i class="fab fa-skype fa-2x"></i></i></a>
            </div>
            <p class="text-center col-12 m-0">Copyright © VHN 2021</p>
        </div>
    </footer>

    <script type="text/javascript" src="<c:url value="/js/jquery-3.6.0.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/popper.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/validatorDetailCompute.js"/>"></script>
</body>
</html>