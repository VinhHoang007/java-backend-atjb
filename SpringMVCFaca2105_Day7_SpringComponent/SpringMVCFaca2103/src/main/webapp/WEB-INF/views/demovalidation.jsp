<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="springform"
    uri="http://www.springframework.org/tags/form"%>
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
            <label>Name1</label>
            <springform:input path="name1" />
            <springform:errors path="name1" />
        </div>

        <div>
            <label>Name2</label>
            <springform:input path="name2" />
            <springform:errors path="name2" />
        </div>

        <div>
            <label>Embed Item1</label>
            <springform:input path="embed.item1" />
            <springform:errors path="embed.item1" />
        </div>

        <div>
            <label>Embed Item2</label>
            <springform:input path="embed.item2" />
            <springform:errors path="embed.item2" />
        </div>

        <button type="submit">Send Data</button>

    </springform:form>
</body>
</html>