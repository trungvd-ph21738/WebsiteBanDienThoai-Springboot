<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>AssignmentJava5</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1 class="text-center">Hóa Đơn Chi Tiết</h1>
    <a href="/hoa-don-chi-tiet/form-add" class="mb-2 btn btn-success">Add</a>
    <table class="table table-sm">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">ID Hóa Đơn</th>
            <th scope="col">ID Sản Phẩm</th>
            <th scope="col">Số Lượng</th>
            <th scope="col">Giá</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listHDCT}" var="hDCT" varStatus="stt">
            <tr>
                <td>${stt.index + 1}</td>
                <td>${hDCT.id.hoaDon.ma}</td>
                <td>${hDCT.id.chiTietSanPham.sanPham.ten}</td>
                <td>${hDCT.soLuong}</td>
                <td>${hDCT.donGia}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>