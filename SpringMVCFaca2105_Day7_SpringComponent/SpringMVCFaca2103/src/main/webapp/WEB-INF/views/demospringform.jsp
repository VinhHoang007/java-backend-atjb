<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Demo Spring Form Page</h1>
    
    <!-- path : render ra [name] + [id] + [value] -->
    <springform:form modelAttribute="dto" method="post">
        
        <div>
            <label>Name</label>
            <springform:input path="name"/>
        </div>
        
         <div>
            <label>Subscribe to newsletter?:</label>
            <springform:checkbox path="receiveNewsletter"/>
        </div>
        
        
         <div>
            <label>Interests:</label>
            <springform:checkbox path="interests" value="travel" />travel 
            <springform:checkbox path="interests" value="game" /> Game 
            <springform:checkbox path="interests" value="coffee" />Coffee
        </div>
        
         <div>
            <label>Favourite Word:</label>
            <springform:checkbox path="favouriteWord" value="Magic" />Magic
        </div>
        
        <button type="submit">Send Data</button>
    
    </springform:form>
</body>
</html>