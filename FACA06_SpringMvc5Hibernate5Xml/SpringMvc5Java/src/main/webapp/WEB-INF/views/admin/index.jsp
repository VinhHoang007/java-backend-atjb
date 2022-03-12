<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Admin</title>
</head>
<body>
    <% 
    String usernamelogin = (String)session.getAttribute("usernamelogin");
    String rolelogin = (String)session.getAttribute("rolelogin");
    %>
    <h1>Welcome To Home Admin</h1>
    <h2>User : <%= usernamelogin %></h2>
    <h2>Role : <%= rolelogin %></h2>
    <h2>${usernamelogin}</h2>
</body>
</html>