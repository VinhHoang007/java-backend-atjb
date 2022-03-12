<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="demo.spring.mvc.dtos.HomeListItemDTO"%>

<html>
<body>
    <h2>List page !</h2>

    <%
        List<HomeListItemDTO> data = (List<HomeListItemDTO>) request.getAttribute("data");
    if (data == null) {
        data = new ArrayList<HomeListItemDTO>();
    }
    %>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Address</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (HomeListItemDTO item : data) {
            %>
            <tr>
                <td><%=item.getId()%></td>
                <td><%=item.getName()%></td>
                <td><%=item.getAddress()%></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
