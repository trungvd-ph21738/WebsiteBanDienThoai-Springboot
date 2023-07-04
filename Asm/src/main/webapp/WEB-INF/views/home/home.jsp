<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Shop Homepage - Start Bootstrap Template</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body>
<!-- Section-->
<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
            <c:forEach items="${listCTSP}" var="cTSP">
                <div class="col mb-5">
                    <div class="card h-100">
                        <!-- Product image-->
                        <img class="card-img-top" src="https://danviet.mediacdn.vn/upload/1-2020/images/2020-01-24/Soc-iPhone-11-dat-diem-nhiep-anh-DxOMark-gan-bang-iPhone-11-Pro-Max-apple_iphone_11-1024x768-1579853354-width660height495.jpg" alt="..." />
                        <!-- Product details-->
                        <div class="card-body p-4">
                            <div class="text-center">
                                <!-- Product name-->
                                <h5 class="fw-bolder">${cTSP.sanPham.ten}</h5>
                                <!-- Product price-->
                                <h7 class="fw-bolder">${cTSP.giaBan} $</h7>
                                <br>
                                <h8 class="fw-bolder">${cTSP.mauSac.ten}</h8>
                            </div>
                        </div>
                        <!-- Product actions-->
                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                            <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="/home/detail/${cTSP.id}">Chi Tiết Sản Phẩm</a></div>
                        </div>
                        <div class="text-center">
                            <a href="/order/add/${cTSP.id}" onclick="return myFunction5()">
                                <img class="" src="https://media.istockphoto.com/id/1227604000/vi/vec-to/bi%E1%BB%83u-t%C6%B0%E1%BB%A3ng-bi%E1%BB%83u-t%C6%B0%E1%BB%A3ng-gi%E1%BB%8F-h%C3%A0ng-n%C3%BAt-c%E1%BB%ADa-h%C3%A0ng-web-h%C3%ACnh-d%E1%BA%A1ng-%C4%91%C6%A1n-gi%E1%BA%A3n-d%E1%BA%A5u-hi%E1%BB%87u-logo-c%E1%BB%ADa-h%C3%A0ng.jpg?s=612x612&w=0&k=20&c=TJUArUSGe6_Z3I_AQOt7T2G8zeK5SCujHAqm2Ix4fC0=" width="60" />
                            </a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
</body>
</html>