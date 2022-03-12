<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1>Login</h1>
    
    <form action="" method="post">
        <div>
            <label>Usernaem</label>
            <input type = "text" name ="username"/>
        </div>
        
        <div>
            <label>Password</label>
            <input type = "password" name ="password"/>
        </div>

        
         <div>
            <button type="submit">Update</button>
            <button type="reset">Reset</button>
        </div>
        
        <% String message = (String) request.getAttribute("messageServer");
        if(message == null) message = "";
        %>
        <p><%=message %></p>
        
    </form>
</body>
</html>