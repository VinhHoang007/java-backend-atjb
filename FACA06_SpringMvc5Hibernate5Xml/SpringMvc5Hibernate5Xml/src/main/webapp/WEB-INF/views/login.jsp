<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
    <% String contextPath = request.getContextPath(); %>
    <form action="<%= contextPath %>/login" method="post">
        <label>Username : </label>
        <input type="text" name="username" />
        <br/>
        <label>Password : </label>
        <input type="text" name="password" />
        <br/>
        <button type="submit">Login</button>
        <button type="reset">Reset</button>
    </form>
    <% String message = (String)request.getAttribute("message"); %>
    <%if (message != null ) {%>
        <h3 style="color : red;"><%= message %></h3>
    <%} %>
</body>
</html>