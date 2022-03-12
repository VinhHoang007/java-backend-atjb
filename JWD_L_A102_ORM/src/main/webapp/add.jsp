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
        <%@include file="/css/add.css"%>
    </style>
    
    
<title>Insert title here</title>
</head>
<body>
    <!-- add Employee -->
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
                <span class="col-1"></span>  <a href="http://localhost:8080/JWD_L_A102_ORM/login"
                    class="col-8">Employee list</a>
            </div>
            <div class="row emp-list align-items-center">
                <span class="col-1"></span>  <a href="http://localhost:8080/JWD_L_A102_ORM/add.jsp"
                    class="col-8">Add Employee</a>
            </div>
        </div>

        <div class="content col-10">
        <h2 class="p-4">Add Employee</h2>
            <form action="add_employee" method="post">

                <div class="form-group">
                    <label for="">First name<span>(*)</span></label>
                    <input type="text" name="firstname" id="firstname" class="form-control" placeholder="First name"
                        aria-describedby="helpId" maxlength="50" required>
                    <small id="first-name-err" class="text-danger"></small>
                </div>

                <div class="form-group">
                    <label for="">Last name<span>(*)</span></label>
                    <input type="text" name="lastname" id="lastname" class="form-control" placeholder="Last name"
                        aria-describedby="helpId" maxlength="50" required>
                    <small id="last-name-err" class="text-danger"></small>
                </div>

                <div class="form-group">
                    <label for="">Phone number<span>(*)</span></label>
                    <input type="text" name="phone" id="phone" class="form-control" placeholder="Phone number"
                        aria-describedby="helpId" required>
                    <small id="phone-err" class="text-danger"></small>
                </div>

                <div class="form-group">
                    <label for="">Date of birth<span>(*)</span></label>
                    <input type="date" value="1997-05-23" name="dob" id="dob" class="form-control" placeholder="Date of birth"
                        aria-describedby="helpId" required>
                    <small id="dob-err" class="text-danger"></small>
                </div>

                <div class="form-group">
                    <label for="">Gender<span>(*)</span></label>
                    <input type="radio" name="gender" id="gen-male" class="ml-4" value ="1" checked>Female
                    <input type="radio" name="gender" id="gen-female" class="ml-4" value ="0">Male
                </div>

                <div class="form-group">
                    <label for="">Account<span>(*)</span></label>
                    <input type="text" name="account" id="account" class="form-control" placeholder="Account"
                        aria-describedby="helpId" required>
                    <small id="account-err" class="text-danger"></small>
                </div>

                <div class="form-group">
                    <label for="">Email<span>(*)</span></label>
                    <input type="text" name="email" id="email" class="form-control" placeholder="Email" aria-describedby="helpId" required>
                    <small id="email-err" class="text-danger" ></small>
                </div>

                <div class="form-group">
                    <label for="">Password<span>(*)</span></label>
                    <input type="password" name="password" id="password" class="form-control" placeholder="Password" aria-describedby="helpId" required>
                    <small id="password-err" class="text-danger" ></small>
                </div>

                <div class="form-group">
                    <label for="">Address</label>
                    <textarea class="form-control" name="address"></textarea>
                </div>

                <div class="form-group">
                    <label for="">Status</label>
                    <input type="checkbox" name="Status" id="" class="ml-5">Active
                </div>

                <div class="form-group">
                    <label for="">Department<span>(*)</span></label>
                    <select name="department" id="department" class="form-control">
                        <option value="Fsoft Academy 1">Fsoft Academy 1</option>
                        <option value="Fsoft Academy 2">Fsoft Academy 2</option>
                        <option value="Fsoft Academy 3">Fsoft Academy 3</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="">Remark</label>
                    <textarea class="form-control" name="remark"></textarea>
                </div>

                <div class="form-group">
                    <a type="button" href="http://localhost:8080/JWD_L_A102_ORM/list_employee" id="btn-comback" class="btn btn-primary"><i class="fas fa-backward"></i> Back</a>
                    <button type="reset" name="" id="btn-reset" class="btn btn-warning"><i class="fas fa-redo"></i> Reset</button>
                    <button type="submit" name="" id="btn-addEmp" class="btn btn-success"><i class="fas fa-plus"></i> Add</button>
                </div>
            </form>
        </div>
    </div>
            

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/all.js">
    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.js">
    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js">
    </script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/popper.min.js">
    </script>


    
</body>
</html>