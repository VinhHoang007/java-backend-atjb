<%@ page import= "java.util.List" %>
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
    <h1>User - List Page </h1>
    
    <% List<UserEntity> data = (List<UserEntity>) request.getAttribute("data"); 
       String contextPath = request.getContextPath();
    %>
    

        	<table>
        	   <thead>
        	       <tr>
        	           <th>User ID</th>
        	           <th>Username</th>
        	           <th>Password</th>
        	           <th>Email</th>
        	       </tr>
        	   </thead>
        	   
        	   <tbody>
        	   <% for(UserEntity item: data){%>
        	       <tr>
                       <td><%=item.getId()%></td>
                       <td><%=item.getUserName()%></td>
                       <td><%=item.getPassword() %></td>
                       <td><%=item.getEmail() %></td>
                       <td>
                            <a href="<%=contextPath%>/admin/user/edit?id=<%=item.getId()%>">Edit</a>
                            <a href="<%=contextPath%>/admin/user/delete?id=<%=item.getId()%>">Delete</a>
                        </td>
                   </tr>
                    <%}%> 
        	   </tbody>
        	</table>
        	
        	<a href="<%=contextPath%>/admin/user/add">New</a>
  
</body>
</html>