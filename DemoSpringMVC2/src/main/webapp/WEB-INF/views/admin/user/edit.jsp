<%@ page import= "demo.spring.mvc.entities.UserEntity" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1>User - Add Page </h1>
    
    <% UserEntity data = (UserEntity) request.getAttribute("data"); %>
    <form action="" method="post">
        <div>
            <label>ID: </label>
            <input type = "text" disabled="disabled" value="<%= data.getId()%>"/>
        </div>
        
        <div>
            <label>Username: </label>
            <input type = "text" name ="username" value="<%= data.getUserName() %>"/>
        </div>
        
        <div>
            <label>Password: </label>
            <input type = "password" name ="password" value="<%= data.getPassword() %>"/>
        </div>
         <div>
            <label>Email</label>
            <input type = "text" name ="email" value="<%= data.getEmail() %>"/>
        </div>
         <div>
            <button type="submit">Update</button>
            <button type="reset">Reset</button>
        </div>
        
    </form>
</body>
</html>