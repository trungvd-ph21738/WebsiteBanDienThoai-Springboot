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
    <h1 class="text-center">Thông Tin Hóa Đơn</h1>
    <table class="table table-sm">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Customer</th>
            <th scope="col">Staff</th>
            <th scope="col">Mã</th>
            <th scope="col">Ngày Tạo</th>
            <th scope="col">Ngày Thánh Toán</th>
            <th scope="col">Ngày Ship</th>
            <th scope="col">Ngày Nhận</th>
            <th scope="col">Name Customer</th>
            <th scope="col">Address</th>
            <th scope="col">Phone Number</th>
            <th scope="col">Status</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listHoaDon}" var="hoaDon" varStatus="stt">
            <tr>
                <td>${stt.index + 1}</td>
                <td>${hoaDon.khachHang.ho} ${hoaDon.khachHang.tenDem} ${hoaDon.khachHang.ten}</td>
                <td>${hoaDon.nhanVien.ho} ${hoaDon.nhanVien.tenDem} ${hoaDon.nhanVien.ten}</td>
                <td>${hoaDon.ma}</td>
                <td>${hoaDon.ngayTao}</td>
                <td>${hoaDon.ngayThanhToan}</td>
                <td>${hoaDon.ngayShip}</td>
                <td>${hoaDon.ngayNhan}</td>
                <td>${hoaDon.tenNguoiNhan}</td>
                <td>${hoaDon.diaChi}</td>
                <td>${hoaDon.sdt}</td>
                <td>${hoaDon.tinhTrang == 1? "Chưa xác nhận": "Đã xác nhận"}</td>
                <td>
                    <a href="/hoa-don-chi-tiet/detail/${hoaDon.id}" class="btn btn-warning">Detail</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>