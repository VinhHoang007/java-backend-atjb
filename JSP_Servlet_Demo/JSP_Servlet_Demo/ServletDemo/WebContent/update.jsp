<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Servlet.SinhVien" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Update Sinh Vien</h2>
<form action="/ServletDemo/update" method="post">
  <div class="container">
    <label for="name"><b>Name</b></label>
    <%
    	SinhVien sv = (SinhVien) request.getAttribute("sinhvien");
    	if (sv == null) {
    		sv = new SinhVien();
    	}
    %>
    <input type="text" name="name" value="<%=sv.getName() %>">

    <label for="age"><b>Age</b></label>
    <input type="text" name="age" value="<%=sv.getAge() %>">


    <button type="submit">Update</button>
  </div>
</form>
</body>
</html>