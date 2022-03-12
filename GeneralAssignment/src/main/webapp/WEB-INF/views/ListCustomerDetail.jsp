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
<title>List Customer Detail</title>
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

            <div class="col-10 data-show">
                <div class="col-12 mt-3">
                    <h2>Detail Customer Information</h2>
                </div>
                <div class="line"></div>
                <div class="col-12 mt-4">
                    <div class="card">
                        <h5 class="card-header">Customer List Table</h5>
                        <div class="card-body">
                        
                            <form action="searchCustomerDetail" class="justify-content-center">
                                    <div class="row justify-content-center">
                                        <div class="col-md-8">
                                            <div class="input-group mb-4"> <input type="text" class="form-control input-text" placeholder="Search Customer ..." style="border-color: #f8c146;" name="customerName">
                                                <div class="input-group-append"> <button class="btn btn-outline-warning btn-lg" type="submit"><i class="fa fa-search"></i></button> </div>
                                            </div>
                                        </div>
                                    </div>
                            </form>
                            
                            <table class="table table-bordered table-hover">
                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">CustomerID</th>
                                        <th scope="col">Customer Name</th>
                                        <th scope="col">ComputerID</th>
                                        <th scope="col">Position</th>
                                        <th scope="col">Status</th>
                                        <th scope="col">Date Use Computer</th>
                                        <th scope="col">Begin Time</th>
                                        <th scope="col">ServiceID</th>
                                        <th scope="col">Date Use Service</th>
                                        <th scope="col">Time Use Service</th>
                                        <th scope="col">Quantity</th>
                                        <th scope="col">Total Money</th>
                                    </tr>
                                </thead>
                                <tbody>
                                
                                    <c:if test="${listCustSearchDetail == Null}">
                                        <%int count = 1; %>
                                     <c:forEach var="cust" items="${lstCustomer}" > 
                                        <c:forEach var="money" items="${lstMoney}" > 
                                            <c:if test="${cust[0] == money[0]}"> 
			                                    <tr>
			                                    
			                                        <th scope="row"><%=count++ %></th>
			                                        <td>${cust[0]}</td>
			                                        <td>${cust[1]}</td>
			                                        <td>${cust[2]}</td>
			                                        <td>${cust[3]}</td>
			                                        <td>${cust[4]}</td>
			                                        <td>${cust[5]}</td>
			                                        <td>${cust[6]}</td>
			                                        <td>${cust[7]}</td>
			                                        <td>${cust[8]}</td>
			                                        <td>${cust[9]}</td>
			                                        <td>${cust[10]}</td>
			                                        <td>${money[1]}</td>
                
			                                    </tr>
			                                </c:if>    
		                              </c:forEach>
                                    </c:forEach>
                                    </c:if>
                                    
                                    <c:if test="${listCustSearchDetail != Null}">
                                        <%int count = 1; %>
                                     <c:forEach var="cust" items="${listCustSearchDetail}" > 
                                        <c:forEach var="money" items="${lstMoney}" > 
                                            <c:if test="${cust[0] == money[0]}"> 
                                                <tr>
                                                
                                                    <th scope="row"><%=count++ %></th>
                                                    <td>${cust[0]}</td>
                                                    <td>${cust[1]}</td>
                                                    <td>${cust[2]}</td>
                                                    <td>${cust[3]}</td>
                                                    <td>${cust[4]}</td>
                                                    <td>${cust[5]}</td>
                                                    <td>${cust[6]}</td>
                                                    <td>${cust[7]}</td>
                                                    <td>${cust[8]}</td>
                                                    <td>${cust[9]}</td>
                                                    <td>${cust[10]}</td>
                                                    <td>${money[1]}</td>
                
                                                </tr>
                                            </c:if>    
                                      </c:forEach>
                                    </c:forEach>
                                    </c:if>
                                    
                                </tbody>
                            </table>
                            
                            <c:if test="${listCustSearchDetail == Null}">
                            <div class="mt-0 ml-4">
                            <nav aria-label="Page navigation example">
                                <ul class="pagination">
                                    <c:if test = "${indexPage==1}">
                                        
                                            <li class="page-item disabled"><a class="page-link" href="<%=request.getContextPath()%>/Customer/showListCustomerDetail?index=${previous}">Previous</a></li>
                                    </c:if>
                          
                                    <c:if test = "${indexPage>1}">
                                            <li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/Customer/showListCustomerDetail?index=${previous}">Previous</a></li>
                                  
                                    </c:if>
                         
                                         <c:forEach begin = "1" end ="${numberPage}" var="i">
                        
                                                    <li class="page-item ${(indexPage==i)?'active':'' }"><a class="page-link" href="<%=request.getContextPath()%>/Customer/showListCustomerDetail?index=${i}">${i}</a></li>
                             
                                         </c:forEach>
                                
                                    <c:if test = "${indexPage==numberPage}">
                                                           
                                            <li class="page-item disabled" ><a class="page-link" href="<%=request.getContextPath()%>/Customer/showListCustomerDetail?index=${next}">Next</a></li>
                                     
                                    </c:if>
                                
                                    <c:if test = "${indexPage<numberPage}">
                                
                                            <li class="page-item" ><a class="page-link" href="<%=request.getContextPath()%>/Customer/showListCustomerDetail?index=${next}">Next</a></li>
                                  
                                    </c:if>
                                </ul>
                            </nav>  
                        </div>
                        
                        </c:if>
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
</body>
</html>