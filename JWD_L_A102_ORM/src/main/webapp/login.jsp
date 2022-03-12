<%@ page import="insertData.InsertData" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style><%@include file="/css/login.css"%></style>
</head>
<body>
	<form action="login" method="post" style="height:28rem">
        <%--  <%
            InsertData.insertData();
        %>   --%>
        <div class="container">
            <h1>Member Login</h1>
            <div class="my-height-group" >
            <input type="text" placeholder="Username" name="username" required>
            </div>
             
            <div class="my-height-group" style="margin-top: 20px" >
            <input type="password" placeholder="Password" name="password" required>
	             <%
	               String message = (String)request.getAttribute("loginMessage");
	               if (message != null && !"".equals(message)) {
	            %>
	               <small id="emailHelp" style ="color:red"><%=message %> </small>
	            <%  
	               }
	             %>       
            </div>
            
            <button type="submit" style="margin-top: 45px">Login</button>
        </div>

        <div class="footer" style="background-color: #ecf0f1">
            <span class="psw"><a href="#">Forgot Password?</a></span>
        </div>

    </form>
</body>
</html>