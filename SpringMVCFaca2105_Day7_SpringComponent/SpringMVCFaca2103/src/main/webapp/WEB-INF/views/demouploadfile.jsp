<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <form action="receive" method="post" enctype="multipart/form-data">

        <input type="text" name="data1" />
        <input type="file" name="fileUpload1" />

        <button>Submit</button>
    </form>
    
    <p>${addattr1}</p>
    <p>${addattr2}</p>
</body>
</html>