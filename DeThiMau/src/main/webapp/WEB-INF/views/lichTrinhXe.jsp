<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lich Trinh Xe</title>
</head>
<body>
                        <div class="card">
                        <h5 class="card-header">Customer List Table</h5>
                        <div class="card-body">
                        
                            
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
                                  
     
                                </tbody>
                            </table>
                            

                        </div>
                    </div>
</body>
</html>