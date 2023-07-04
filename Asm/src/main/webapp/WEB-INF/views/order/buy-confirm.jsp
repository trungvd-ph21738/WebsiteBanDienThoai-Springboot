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
    <h1 class="text-center">Thanh Toán</h1>
    <table class="table table-sm">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Product Name</th>
            <th scope="col">Quantity</th>
            <th scope="col">Price</th>
        </tr>
        </thead>
        <tbody>
        <c:set var="tongTien" value="0"></c:set>
        <c:set var="tongSoLuong" value="0"></c:set>
        <c:forEach items="${listSanPhamMua}" var="iTem" varStatus="stt">
            <c:set var="giaSanPham" value="${iTem.giaBan}"></c:set>
            <c:set var="soLuong" value="${iTem.soLuong}"></c:set>
            <tr>
                <td>${stt.index + 1}</td>
                <td>${iTem.tenSanPham}</td>
                <td>${iTem.soLuong}</td>
                <td>${iTem.giaBan * iTem.soLuong}$</td>
            </tr>
            <c:set var="tongTien" value="${tongTien + (iTem.giaBan * iTem.soLuong)}"></c:set>
            <c:set var="tongSoLuong" value="${tongSoLuong + soLuong}"></c:set>
        </c:forEach>
        <tr>
            <th colspan="3">Tổng Tiền (${tongSoLuong} sản phẩm)</th>
            <td>${tongTien}$</td>
        </tr>
        <tr>
            <th colspan="3"> Thanh Toán: ${tongTien}$</th>
            <td>
                <a href="/thanh-toan/dat-hang" class="btn btn-danger" onclick="return myFunction6()">Đặt Hàng</a>
            </td>

        </tr>
        </tbody>
    </table>
</div>
</body>
</html>