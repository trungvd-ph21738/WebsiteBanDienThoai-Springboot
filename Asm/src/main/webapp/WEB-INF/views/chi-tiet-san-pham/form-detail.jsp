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
    <form:form action="/chi-tiet-san-pham/update/${chiTietSanPham.id}" method="post" modelAttribute="chiTietSanPham">
        <div class="form-group">
            <form:label path="sanPham">Sản Phẩm</form:label>
            <form:select path="sanPham" class="form-control">
                <form:options items="${sanPhams}" itemLabel="ten"/>
            </form:select>
        </div>
        <div class="form-group">
            <form:label path="nhaSanXuat">Nhà Sản Xuất</form:label>
            <form:select path="nhaSanXuat" class="form-control">
                <form:options items="${nhaSanXuats}" itemLabel="ten"/>
            </form:select>
        </div>
        <div class="form-group">
            <form:label path="mauSac">Màu Sắc</form:label>
            <form:select path="mauSac" class="form-control">
                <form:options items="${mauSacs}" itemLabel="ten"/>
            </form:select>
        </div>

        <div class="form-group">
            <form:label path="dongSanPham">Dòng Sản Phẩm</form:label>
            <form:select path="dongSanPham" class="form-control">
                <form:options items="${dongSanPhams}" itemLabel="ten"/>
            </form:select>
        </div>
        <div class="form-group">
            <form:label path="namBaoHanh">Năm Bảo Hành</form:label>
            <form:input path="namBaoHanh" class="form-control"/>
            <form:errors path="namBaoHanh" cssClass="error text-danger"></form:errors>
        </div>
        <div class="form-group">
            <form:label path="moTa">Mô Tả</form:label>
            <form:input path="moTa" class="form-control"/>
            <form:errors path="moTa" cssClass="error text-danger"></form:errors>
        </div>
        <div class="form-group">
            <form:label path="soLuongTon">Số Lượng Tồn</form:label>
            <form:input path="soLuongTon" class="form-control"/>
            <form:errors path="soLuongTon" cssClass="error text-danger"></form:errors>
        </div>
        <div class="form-group">
            <form:label path="giaNhap">Giá Nhập</form:label>
            <form:input path="giaNhap" class="form-control"/>
            <form:errors path="giaNhap" cssClass="error text-danger"></form:errors>
        </div>
        <div class="form-group">
            <form:label path="giaBan">Giá Bán</form:label>
            <form:input path="giaBan" class="form-control"/>
            <form:errors path="giaBan" cssClass="error text-danger"></form:errors>
        </div>
        <button type="submit" class="btn btn-primary" onclick="return myFunction3()">Update</button>
    </form:form>
</div>
</body>
</html>