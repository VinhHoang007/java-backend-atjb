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
<title>ListService</title>
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

                                <span style="margin-left: 36px;"><i class="fas fa-caret-down"></i></span>
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
                                <span style="margin-left: 30px;" ><i class="fas fa-caret-down"></i></span>
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
                <div class="col-12 mt-3">
                    <h2>List Service</h2>
                </div>
                <div class="line"></div>
                <div class="col-12 mt-4">
                    <div class="card">
                        <h5 class="card-header">Service List Table</h5>
                        <div class="card-body">
                            
                            <form action="searchService" class="justify-content-center">
                                    <div class="row justify-content-center">
                                        <div class="col-md-8">
                                            <div class="input-group mb-4"> <input type="text" class="form-control input-text" placeholder="Search Service ..." style="border-color: #f8c146;" name="serviceName">
                                                <div class="input-group-append"> <button class="btn btn-outline-warning btn-lg" type="submit"><i class="fa fa-search"></i></button> </div>
                                            </div>
                                        </div>
                                    </div>
                            </form>
                        
                        
                            <table class="table table-bordered table-hover">
                                <thead class="thead-dark">
                         
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">ServiceID</th>
                                        <th scope="col">Service Name</th>
                                        <th scope="col">Unit</th>
                                        <th scope="col">Price</th>
                                        <th scope="col" class="text-center">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                        
                                        
                                    <c:if test="${listComSearch == Null}"> 
                                        <%int count = 1; %> 
                                        <c:forEach var="ser" items="${lstService}" >     
                                    <tr>
                                        <th scope="row"><%=count++ %></th>
                                        <td>${ser.serviceID}</td>
                                        <td>${ser.serviceName}</td>
                                        <td>${ser.unit}</td>
                                        <td>${ser.price }</td>
                                        <td class="d-flex justify-content-center">
                                            <div class="action">
                                            
                                                <c:url var="updateLink" value="/Service/showUpdateService">
                                                    <c:param name="serviceID" value="${ser.serviceID}" />
                                                </c:url>
                                    
                                                <c:url var="deleteLink" value="/Service/deleteService">
                                                    <c:param name="serviceID" value="${ser.serviceID}" />                                    
                                                </c:url> 
                                                
                                                <a style="color: cadetblue;" href="${updateLink}">
                                                    <i class="fas fa-edit"></i>
                                                </a>
    
                                                <a style="color: brown;" href="${deleteLink}"
                                                    onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">
                                                    <i class="fas fa-trash-alt ml-3"></i>
                                                </a>
                                            </div>
                                            
                                        </td>
                                    </tr>
                                    </c:forEach>
                                
                                    </c:if>  
                                    
                                    <c:if test="${listSerSearch != Null}"> 
                                        <%int count = 1; %> 
                                        <c:forEach var="ser" items="${listSerSearch}" >     
                                    <tr>
                                        <th scope="row"><%=count++ %></th>
                                        <td>${ser.serviceID}</td>
                                        <td>${ser.serviceName}</td>
                                        <td>${ser.unit}</td>
                                        <td>${ser.price }</td>
                                        <td class="d-flex justify-content-center">
                                            <div class="action">
                                            
                                                <c:url var="updateLink" value="/Service/showUpdateService">
                                                    <c:param name="serviceID" value="${ser.serviceID}" />
                                                </c:url>
                                    
                                                <c:url var="deleteLink" value="/Service/deleteService">
                                                    <c:param name="serviceID" value="${ser.serviceID}" />                                    
                                                </c:url> 
                                                
                                                <a style="color: cadetblue;" href="${updateLink}">
                                                    <i class="fas fa-edit"></i>
                                                </a>
    
                                                <a style="color: brown;" href="${deleteLink}"
                                                    onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">
                                                    <i class="fas fa-trash-alt ml-3"></i>
                                                </a>
                                            </div>
                                            
                                        </td>
                                    </tr>
                                    </c:forEach>
                                    </c:if>
                                    
                                </tbody>
                            </table>
                        </div>
                        
                        <c:if test="${listSerSearch == Null}">
                            <div class="mt-0 ml-4">
                            <nav aria-label="Page navigation example">
                                <ul class="pagination">
                                    <c:if test = "${indexPage==1}">
                                        
                                            <li class="page-item disabled"><a class="page-link" href="<%=request.getContextPath()%>/Service/showListService?index=${previous}">Previous</a></li>
                                    </c:if>
                          
                                    <c:if test = "${indexPage>1}">
                                            <li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/Service/showListService?index=${previous}">Previous</a></li>
                                  
                                    </c:if>
                         
                                         <c:forEach begin = "1" end ="${numberPage}" var="i">
                        
                                                    <li class="page-item ${(indexPage==i)?'active':'' }"><a class="page-link" href="<%=request.getContextPath()%>/Service/showListService?index=${i}">${i}</a></li>
                             
                                         </c:forEach>
                                
                                    <c:if test = "${indexPage==numberPage}">
                                                           
                                            <li class="page-item disabled" ><a class="page-link" href="<%=request.getContextPath()%>/Service/showListService?index=${next}">Next</a></li>
                                     
                                    </c:if>
                                
                                    <c:if test = "${indexPage<numberPage}">
                                
                                            <li class="page-item" ><a class="page-link" href="<%=request.getContextPath()%>/Service/showListService?index=${next}">Next</a></li>
                                  
                                    </c:if>
                                </ul>
                            </nav>  
                        </div>
                        
                        </c:if>
                        
                        <div class="edit-form">
                            <div class="col-12 mb-4 wrapper-card">
                                <div class="card create-computer-card mt-0">
                                    <h5 class="card-header">Edit Service Form</h5>
                                    <div class="card-body">
                                        <form action="updateService" method="post" id="create-service-form" modelAttribute="serviceUpdate">
            
                                            <div class="form-row">
                                                <div class="col height-form-label">
                                                    <label class="label-color font-label">ServiceID</label>
                                                    <input type="text" class="form-control" id="serviceID"
                                                        maxlength="10" name="serviceID" value="${serShowUpdate.serviceID}" readonly="readonly">
                                                    <small id="serviceID-err" class="form-text text-danger"></small>
                                                </div>
                
                                                <div class="col height-form-label">
                                                    <label class="label-color font-label">Service Name</label>
                                                    <input type="text" class="form-control" id="serviceName" value="${serShowUpdate.serviceName}"
                                                        maxlength="50" name="serviceName">
                                                    <small id="serviceName-err" class="form-text text-danger"></small>
                                                </div>
                                            </div>
                                            
                                            <div class="form-row">
                                                <div class="col height-form-label">
                                                    <label class="label-color font-label">Unit</label>
                                                    <input type="text" class="form-control" id="unit" value="${serShowUpdate.unit}"
                                                        maxlength="50" name="unit">
                                                    <small id="unit-err" class="form-text text-danger"></small>
                                                </div>
                
                                                <div class="col height-form-label">
                                                    <label class="label-color font-label">Price</label>
                                                    <input type="text" class="form-control" id="price" value="${serShowUpdate.price}"
                                                        maxlength="50" name="price">
                                                    <small id="price-err" class="form-text text-danger"></small>
                                                </div>
                                            </div>
                                            
            
                                            <button type="button" id="btn-addService" class="btn btn-success">Update</button>
                                            <button type="reset" class="btn btn-primary">Reset</button>
                                        </form>
                                    </div>
                                </div>
                            </div>

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
                <a href="#"> <i class="fab fa-skype fa-2x"></i></a>
            </div>
            <p class="text-center col-12 m-0">Copyright © VHN 2021</p>
        </div>
    </footer>
    
    <script type="text/javascript" src="<c:url value="/js/jquery-3.6.0.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/popper.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/validatorServiceFor.js"/>"></script>
</body>
</html>