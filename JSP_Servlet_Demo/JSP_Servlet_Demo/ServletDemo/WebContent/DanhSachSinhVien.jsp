<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Servlet.SinhVien" %>
<!DOCTYPE html>
<html>	
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
<h2>Danh sach sinh vien</h2>
<table>
  <tr>
    <th>Name</th>
    <th>Age</th>
    <th>Link</th>
  </tr>
  <%
    ArrayList<SinhVien> sinhVienList = (ArrayList) request.getAttribute("listSinhVien");
    if (sinhVienList != null && sinhVienList.size() > 0 ) {
    	for (int i = 0; i < sinhVienList.size(); i++) {
  %>
  		<tr>
		    <td><%=sinhVienList.get(i).getName() %></td>
		    <td><%=sinhVienList.get(i).getAge() %></td>
		    <td> <a href="/ServletDemo/update_sinh_vien?name=<%=sinhVienList.get(i).getName()%>">Link</a> </td>
  		</tr>
  <%
    	}
    }
  %>
  
</table>
</body>
</html>