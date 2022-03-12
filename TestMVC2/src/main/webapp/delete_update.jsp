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
<title>Insert title here</title>
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Delete Employee</h2>
        <table class="table table-hover ">
            <thead class="thead-dark">
                <tr>
                    <th class="col-1">#</th>
                    <th class="col-2">Name</th>
                    <th class="col-2">Date Of Birth</th>
                    <th class="col-2">Address</th>
                    <th class="col-2">Phone</th>
                    <th class="col-2">Department</th>
                    <th class="col-1">Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                Employee empList = (Employee) request.getAttribute("employee");
                if(empList == null){empList = new Employee();}
                %>
                    <tr>
                        <td scope="row"><%=1 %></td>
                        <td><%=empList.getFirstName() + " "+ empList.getLastName() %></td>
                        <td><%=empList.getDob() %></td>
                        <td><%=empList.getAddress() %></td>
                        <td><%=empList.getPhone() %></td>
                        <td><%=empList.getDeptName() %></td>
                        <td>
                            <a href="http://localhost:8080/JWD_L_A101/delete_employee?id_del=<%=empList.getEmployeeID() %>">
                            <i class="fas fa-trash-alt"></i></a>
                        </td>
                        
                    </tr>
            </tbody>
        </table>
    </div>

    <div class="container mt-5">
        <h2 class="mb-4">Update Employee</h2>
        <form action="update_employee?id_up=<%=empList.getEmployeeID() %>" method="post">
            <div class="form-row">
                <div class="col">
                    <input type="text" class="form-control" name="firstname" value=<%= empList.getFirstName() %> >
                </div>
                <div class="col">
                    <input type="text" class="form-control" name="lastname" value=<%=empList.getLastName() %>>
                </div>
                <div class="col">
                    <input type="date" class="form-control" name="dob" value=<%=empList.getDob() %>>
                </div>
            </div>

            <div class="form-row mt-4">
                <div class="col">
                    <input type="text" class="form-control" name="phone" value=<%=empList.getPhone() %>>
                </div>
                <div class="col">
                    <input type="text" class="form-control" name="address" value=<%=empList.getAddress() %>>
                </div>
                <div class="col">
                    <input type="text" class="form-control" name="gender" value=<%=empList.getGender() %>>
                </div>
            </div>

            <div class="form-row  mt-4">
                <div class="col">
                    <input type="text" class="form-control" name="department" value=<%=empList.getDeptName() %>>
                </div>
                <div class="col">
                    <input type="text" class="form-control" name="remark" value=<%=empList.getRemark() %>>
                </div>
            </div>
            <div class="form-row  mt-4">
                <a type="button" href="http://localhost:8080/JWD_L_A101/list_employee" id="btn-comback" class="btn btn-primary"><i class="fas fa-backward"></i> Back</a>
                <button type="reset" name="" id="btn-reset" class="btn btn-warning ml-3 mr-3"><i class="fas fa-redo"></i> Reset</button>
                <button type="submit" name="" id="btn-addEmp" class="btn btn-success"><i class="fas fa-plus"></i> Update</button>
            </div>

        </form>
    </div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/all.js">
    </script>
</body>
</html>