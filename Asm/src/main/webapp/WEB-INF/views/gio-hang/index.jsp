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
    <h1 class="text-center">Hiển thị thông tin cửa hàng</h1>
    <a href="/gio-hang/form-add" class="mb-2 btn btn-success">Add</a>
    <table class="table table-sm">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Customer</th>
            <th scope="col">ID_NV</th>
            <th scope="col">Mã</th>
            <th scope="col">Ngày Tạo</th>
            <th scope="col">Ngày Thánh Toán</th>
            <th scope="col">Name Customer</th>
            <th scope="col">Address</th>
            <th scope="col">Phone Number</th>
            <th scope="col">Status</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listGioHang.content}" var="gioHang" varStatus="stt">
            <tr>
                <td>${stt.index + 1}</td>
                <td>${gioHang.khachHang.ten}</td>
                <td>${gioHang.idNhanVien}</td>
                <td>${gioHang.ma}</td>
                <td>${gioHang.ngayTao}</td>
                <td>${gioHang.ngayThanhToan}</td>
                <td>${gioHang.tenNguoiNhan}</td>
                <td>${gioHang.diaChi}</td>
                <td>${gioHang.sdt}</td>
                <td>${gioHang.tinhTrang}</td>
                <td>
                    <a href="/gio-hang/detail/${gioHang.id}" class="btn btn-primary">Detail</a>
                    <a href="/gio-hang/delete/${gioHang.id}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="text-center">
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="/gio-hang/hien-thi?page=0">First</a></li>
                <li class="page-item"><a class="page-link"
                                         href="/gio-hang/hien-thi?page=${listGioHang.number-1}">Previous</a></li>
                <c:forEach begin="0" end="${listGioHang.totalPages - 1}" varStatus="index">
                    <li class="page-item"><a class="page-link"
                                             href="/gio-hang/hien-thi?page=${index.begin + index.count-1}">
                            ${index.begin + index.count}
                    </a></li>
                </c:forEach>
                <li class="page-item"><a class="page-link" href="/gio-hang/hien-thi?page=${listGioHang.number+1}">Next</a>
                </li>
                <li class="page-item"><a class="page-link"
                                         href="/gio-hang/hien-thi?page=${listGioHang.totalPages-1}">Last</a></li>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>