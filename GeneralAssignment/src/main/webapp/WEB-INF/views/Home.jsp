<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
   <style>
        <%@include file="/css/bootstrap.min.css"%>
        <%@include file="/css/fStyle.css"%>
    </style>
<title>Home</title>
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
                                    <span class="col-10">List Customer Detail</span>
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

            <div class="col-10 data-show">

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
   
</body>
</html>