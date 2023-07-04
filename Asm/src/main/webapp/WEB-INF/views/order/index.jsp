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
    <h1 class="text-center">Thông tin giỏ hàng</h1>
    <a href="/home/hien-thi" class="mb-2 btn btn-success">Buy</a>
    <a href="/thanh-toan/xac-minh" class="mb-2 btn btn-warning">Thanh Toán</a>
    <table class="table table-sm">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Product Name</th>
            <th scope="col">Producer Name</th>
            <th scope="col">Color</th>
            <th scope="col">Product Line</th>
            <th scope="col">Quantity</th>
            <th scope="col">Price</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listCTSP}" var="iTem" varStatus="stt">
            <tr>
                <td>${stt.index + 1}</td>
                <td>${iTem.tenSanPham}</td>
                <td>${iTem.tenDongSanPham}</td>
                <td>${iTem.mauSac}</td>
                <td>${iTem.nhaSanXuat}</td>
                <td>${iTem.soLuong}</td>
                <td>${iTem.giaBan * iTem.soLuong}</td>
                <td>
                    <a href="/order/delete/${iTem.id}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>