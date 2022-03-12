<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Demo Model</title>
</head>
<body>
    <dl>
        <% Enumeration<String> attributeNames = request.getAttributeNames(); %>
        <% while(attributeNames.hasMoreElements()) { %>
            <% 
                String attributeName = attributeNames.nextElement();
                Object value = request.getAttribute(attributeName);
            %>
            
            <dt><%=attributeName %></dt>
            <dd><%=value %></dd>
            
        <% } %>
    </dl>
    
</body>
</html>