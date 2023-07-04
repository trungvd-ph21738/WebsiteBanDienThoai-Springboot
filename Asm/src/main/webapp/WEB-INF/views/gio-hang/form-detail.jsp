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
    <form:form action="/gio-hang/update/${gioHang.id}" method="post" modelAttribute="gioHang">
        <div>
            <form:label path="khachHang">Khách Hàng</form:label>
            <form:select path="khachHang">
                <form:options items="${khachHangs}" itemLabel="ten"/>
            </form:select>
        </div>
        <div>
            <form:label path="idNhanVien">ID Nhân Viên</form:label>
            <form:input path="idNhanVien"></form:input>
        </div>
        <div>
            <form:label path="ma">Mã Giỏ Hàng</form:label>
            <form:input path="ma"></form:input>
        </div>
        <div>
            <form:label path="ngayTao">Ngày Tạo</form:label>
            <form:input path="ngayTao" type="date"></form:input>
        </div>
        <div>
            <form:label path="ngayThanhToan">Ngày Thanh Toán</form:label>
            <form:input path="ngayThanhToan" type="date"></form:input>
        </div>
        <div>
            <form:label path="tenNguoiNhan">Tên Người Nhân</form:label>
            <form:input path="tenNguoiNhan"></form:input>
        </div>
        <div>
            <form:label path="diaChi">Địa Chỉ</form:label>
            <form:input path="diaChi"></form:input>
        </div>
        <div>
            <form:label path="sdt">Số Điện Thoại</form:label>
            <form:input path="sdt"></form:input>
        </div>
        <div>
            <form:label path="tinhTrang">Trạng Thái</form:label>
            <form:input path="tinhTrang"></form:input>
        </div>
        <form:button>Thêm mới</form:button>
    </form:form>
</div>
</body>
</html>
