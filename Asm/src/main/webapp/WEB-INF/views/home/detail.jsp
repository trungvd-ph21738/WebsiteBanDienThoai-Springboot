<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Shop Homepage - Start Bootstrap Template</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico"/>
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
    <div class="container px-4 px-lg-5 my-5">
        <div class="row gx-4 gx-lg-5 align-items-center">
            <div class="col-md-6">
                <img class="card-img-top mb-5 mb-md-0" src="https://media.vov.vn/sites/default/files/styles/large/public/2022-09/iphone_14.jpg" alt="...">
            </div>
            <div class="col-md-6">
                <div class="small mb-1">Mã: ${cTSP.sanPham.ma}</div>
                <h3 class="display-5 fw-bolder">
                    ${cTSP.sanPham.ten} ${cTSP.mauSac.ten}
                </h3>
                <span class="text-decoration-line-through">Số Lượng Tồn: ${cTSP.soLuongTon}</span>
                <div class="fs-5 mb-5">
                    <span class="text-decoration-line-through text-danger">${cTSP.giaBan} $</span>
                </div>
                <hr>
                <h7 class="lead">Màu Sắc: ${cTSP.mauSac.ten}</h7>
                <br>
                <h7 class="lead">Nhà Sản Xuất: ${cTSP.nhaSanXuat.ten}</h7>
                <br>
                <h7 class="lead">Dòng Sản Phẩm: ${cTSP.dongSanPham.ten}</h7>
                <br>
                <h7 class="lead">Năm Bảo Hành: ${cTSP.namBaoHanh}</h7>
                <br>
                <br>
                <p class="lead">${cTSP.moTa}</p>
                <div class="d-flex">
                    <input id="inputQuantity" class="form-control text-center me-3 mr-3" type="num" value="1"
                           style="max-width: 3rem">

                    <a class="btn btn-outline-dark flex-shrink-0" href="/order/add/${cTSP.id}" onclick="return myFunction5()">Buy</a>
                </div>
            </div>
        </div>
    </div>
</section>

<%--<section class="py-5 bg-light">--%>
<%--    <div class="container px-4 px-lg-5 mt-5">--%>
<%--        <h2 class="fw-bolder mb-4">Related products</h2>--%>
<%--        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">--%>
<%--            <div class="col mb-5">--%>
<%--                <div class="card h-100">--%>
<%--                    <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="...">--%>
<%--                    <div class="card-body p-4">--%>
<%--                        <div class="text-center">--%>
<%--                            <h5 class="fw-bolder">Fancy Product</h5>--%>
<%--                            $40.00 - $80.00--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">--%>
<%--                        <div class="text-center">--%>
<%--                            <a class="btn btn-outline-dark mt-auto" href="#">View options</a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <!-- The rest of the related products -->--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>
</body>
</html>