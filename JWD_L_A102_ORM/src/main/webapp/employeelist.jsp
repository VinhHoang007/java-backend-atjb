<%@ page import="model.bean.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <style>
        <%@include file="/css/all.css"%>
        <%@include file="/css/bootstrap.min.css"%>
        <%@include file="/css/listEmp.css"%>
        <%@include file="/css/empManager.css"%>
    </style>
    
    
    
    <title>Employee Manager</title>
</head>

<body>
    <% String nameEmployeeLogin = (String)request.getSession().getAttribute("nameEmployeeLogin"); %>
<div class="container-fluid container-manager row">
        <!-- header -->
        <div class="header d-flex col-12">
            <div class="title-header pl-2">
                <i class="fas fa-users"></i> Employee
            </div>
            <div class="func-header">
                <span class="id-admintor mr-4 text-primary">Welcome <%= nameEmployeeLogin %> </span> 
                <a href="http://localhost:8080/JWD_L_A102_ORM/login_view" class="logout"><i class="fas fa-sign-out-alt"></i> Logout</a>
            </div>
        </div>
        <!-- navigation -->
        <div class="navgation col-2 p-3 align-items-center">
            <div class="col-12 row align-items-center">
                <i class="fas fa-tachometer-alt col-2"></i> <span>Dashboard</span>
            </div>
            <div class="col-12 row  align-items-center">
                <i class="fas fa-chart-bar col-2"></i> <span class="col-8 p-0">Employee
                    manager</span> <span class="chart-down col-2"><i
                    class="fas fa-chevron-down"></i></span>
                <!-- <span class="chart-up col-2"><i class="fas fa-chevron-up"></i></span> -->
            </div>
            <div class="row emp-list align-items-center">
                <span class="col-1"></span>  <a href="http://localhost:8080/JWD_L_A102_ORM/list_employee"
                    class="col-8">Employee list</a>
            </div>
            <div class="row emp-list align-items-center">
                <span class="col-1"></span>  <a href="http://localhost:8080/JWD_L_A102_ORM/add.jsp"
                    class="col-8">Add Employee</a>
            </div>
        </div>

        <div class="content col-10">
        <h2 class="p-4">Employee list</h2>
            <!-- Form -->
            <form action = "search_infor" method="get">
            <div class="form-group row">
                <div class="col-5"></div>
                <div class="col-7 row form-search">
                    <div class="col-6 p-0 d-flex input-search">
                        <button type="button" name="" id="" class="btn btn-search m-0 p-0">
                            <i class="fas fa-search"></i>
                        </button>
                        <input type="text" class="form-control col-10" name="search-infor" id="" aria-describedby="helpId"
                            placeholder="User">
                    </div>
                    <!-- <small id="helpId" class="form-text text-muted">Help text</small> -->
                    <div class="group-fill row btn">
                        <span><i class="fas fa-filter"></i>Filter By</span>
                        <select name="field">
                            <option value="name">Name</option>
                            <option value="phone">Phone</option>
    
                        </select>
                    </div>
                    <button type="submit" name="" id="" class="btn btn-primary">Search</button>

                </div>
            </div>
            </form>

            <!-- Table -->
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>name</th>
                        <th>date of birth</th>
                        <th>Address</th>
                        <th>Phone number</th>
                        <th>Department</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                
                <%
                ArrayList<Employee> empList = (ArrayList) request.getAttribute("listEmployee");
	                if (empList != null && empList.size() > 0 ) {
	                    for (int i = 0; i < empList.size(); i++) {
                %>
                    <tr>
                        <td scope="row"><%=i+1 %></td>
                        <td><%=empList.get(i).getFirstName() + " "+ empList.get(i).getLastName() %></td>
                        <td><%=empList.get(i).getDob() %></td>
                        <td><%=empList.get(i).getAddress() %></td>
                        <td><%=empList.get(i).getPhone() %></td>
                        <td><%=empList.get(i).getDeptName() %></td>
                        <td>
                            <a href="/JWD_L_A102_ORM/update_delete_view?id=<%=empList.get(i).getEmployeeID()%>" style="text-decoration: none;">
                        <i class="far fa-eye"></i> View</a>
                        </td>
                        
                    </tr>
                <%
                       }
                    }
                %>  
                 <%
                   String message = (String)request.getAttribute("nodata");
                   if (message != null && !"".equals(message)) {
                %>
                 <tr>
                    <td colspan = "7">
                        <%=message %>
                   </td>
                 </tr> 
                <%  
                   }
                 %>       
                </tbody>
                
            </table>

            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li class="page-item disabled">
                        <a class="page-link" href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                            <span class="sr-only">Previous</span>
                        </a>
                    </li>
                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                            <span class="sr-only">Next</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/all.js">
    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js">
    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.js">
    </script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/popper.min.js">
    </script>
</body>
</html>