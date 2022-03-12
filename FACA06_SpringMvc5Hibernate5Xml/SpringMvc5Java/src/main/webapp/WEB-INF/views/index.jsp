<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home User</title>
</head>
<body>
    <% 
    String usernamelogin = (String)session.getAttribute("usernamelogin");
    String rolelogin = (String)session.getAttribute("rolelogin");
    %>
    <h1>Welcome To Home User</h1>
    <h2>User : <%= usernamelogin %></h2>
    <h2>Role : <%= rolelogin %></h2>
    <h2></h2>
</body>
</html>