<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1>Thêm Thông Tin</h1>
    <form:form action="/san-pham/update/${sanPham.id}" method="post" modelAttribute="sanPham">
        <div class="form-group">
            <form:label path="ma">Mã</form:label>
            <form:input path="ma" class="form-control" />
            <form:errors path="ma" cssClass="error text-danger" />
        </div>
        <div class="form-group">
            <form:label path="ten">Tên Sản Phẩm</form:label>
            <form:input path="ten" class="form-control" />
            <form:errors path="ten" cssClass="error text-danger" />
        </div>
        <button type="submit" class="btn btn-primary" onclick="return myFunction3()">Update</button>
    </form:form>
</div>

</body>
</html>