<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="/home/hien-thi">Shop Điện Thoại</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">All Products</a></li>
                        <li>
                            <hr class="dropdown-divider"/>
                        </li>
                        <li><a class="dropdown-item" href="#!">Popular Items</a></li>
                        <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex">
                <a class="btn btn-outline-dark" href="/order/hien-thi" role="button">
                    <i class="bi bi-cart-fill me-1"></i>
                    Giỏ Hàng
                    <span class="badge bg-dark text-white ms-1 rounded-pill">${tongSoSanPham}</span>
                </a>
            </form>
        </div>
    </div>
</nav>
<!-- Header-->
<div id="header">
    <%-- Phần header của trang --%>
    <header class="bg-dark py-5">
        <div class="container px-4 px-lg-5 my-5">
            <div class="text-center text-white">
                <h1 class="display-4 fw-bolder">Shop Điện Thoại</h1>
                <p class="lead fw-normal text-white-50 mb-0">Phong Cách Tạo Lên Đẳng Cấp</p>
            </div>
        </div>
    </header>
</div>

<div id="content">
    <div class="row flex-nowrap">
        <!-- Sidebar -->
        <nav id="sidebarMenu" class="collapse d-lg-block sidebar collapse bg-white">
            <div class="position-sticky">
                <div class="list-group list-group-flush mx-3 mt-4">
                    <a
                            href="/home/hien-thi"
                            class="list-group-item list-group-item-action py-2 ripple"
                            aria-current="true"
                    >
                        <i class="fas fa-tachometer-alt fa-fw me-3"></i><span>AppleStore</span>
                    </a>
                    <a href="/order/hien-thi" class="list-group-item list-group-item-action py-2 ripple active">
                        <i class="fas fa-chart-area fa-fw me-3"></i><span>Giỏ Hàng</span>
                    </a>
                    <a href="/chi-tiet-san-pham/hien-thi" class="list-group-item list-group-item-action py-2 ripple"
                    ><i class="fas fa-lock fa-fw me-3"></i><span>Chi Tiết Sản Phẩm</span></a
                    >
                    <a href="/khach-hang/hien-thi" class="list-group-item list-group-item-action py-2 ripple"
                    ><i class="fas fa-chart-line fa-fw me-3"></i><span>Khách Hàng</span></a
                    >
                    <a href="/nhan-vien/hien-thi" class="list-group-item list-group-item-action py-2 ripple">
                        <i class="fas fa-chart-pie fa-fw me-3"></i><span>Nhân Viên</span>
                    </a>
                    <a href="/chuc-vu/hien-thi" class="list-group-item list-group-item-action py-2 ripple">
                        <i class="fas fa-chart-pie fa-fw me-3"></i><span>Chức Vụ</span>
                    </a>
                    <a href="/hoa-don/hien-thi" class="list-group-item list-group-item-action py-2 ripple"
                    ><i class="fas fa-chart-bar fa-fw me-3"></i><span>Hóa Đơn</span></a
                    >
                    <a href="/cua-hang/hien-thi" class="list-group-item list-group-item-action py-2 ripple"
                    ><i class="fas fa-globe fa-fw me-3"></i><span>Cửa Hàng</span></a
                    >
                    <a href="/san-pham/hien-thi" class="list-group-item list-group-item-action py-2 ripple"
                    ><i class="fas fa-building fa-fw me-3"></i><span>Sản Phẩm</span></a
                    >
                    <a href="/mau-sac/hien-thi" class="list-group-item list-group-item-action py-2 ripple"
                    ><i class="fas fa-calendar fa-fw me-3"></i><span>Màu Sắc</span></a
                    >
                    <a href="/dong-san-pham/hien-thi" class="list-group-item list-group-item-action py-2 ripple"
                    ><i class="fas fa-users fa-fw me-3"></i><span>Dòng Sản Phẩm</span></a
                    >
                    <a href="/nha-san-xuat/hien-thi" class="list-group-item list-group-item-action py-2 ripple"
                    ><i class="fas fa-money-bill fa-fw me-3"></i><span>Nhà Sản Xuất</span></a
                    >
                </div>
            </div>
        </nav>
        <div class="col py-3">
            <jsp:include page="${contentPage}"/>
        </div>
    </div>
    <%-- Đây là nơi sẽ chèn nội dung từ view --%>

</div>
<!-- Footer-->
<div id="footer">
    <%-- Phần footer của trang --%>
    <footer class="py-5 bg-dark">
        <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2023</p></div>
    </footer>
</div>

<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<%--<script src="/src/main/webapp/WEB-INF/js/confirm.js"></script>--%>
<script>
    function myFunction5() {
        let text = "Bạn chắc chắn muốn thêm sản phẩm vào giỏ hàng không?";
        let kt = confirm(text);
        if (kt == true) {
            confirm("Thêm sản phẩm vào giỏ hàng thành công");
            return true;
        } else {
            return false;
        }
    }

    function myFunction6() {
        let text = "Bạn có muốn thanh toán đơn hàng không?";
        let kt = confirm(text);
        if (kt == true) {
            confirm("Thanh toán thành công <3");
            return true;
        } else {
            return false;
        }
    }

    function myFunction4() {
        let text = "Bạn chắc chắn muốn xóa";
        let kt = confirm(text);
        if (kt == true) {
            confirm("Xóa thành công");
            return true;
        } else {
            return false;
        }
    }

    function myFunction2() {
        let text = "Bạn chắc chắn muốn xem";
        let kt = confirm(text);
        if (kt == true) {
            return true
        } else {
            return false;
        }
    }

    function myFunction3() {
        let text = "Bạn chắc chắn muốn sửa";
        let kt = confirm(text);
        if (kt == true) {
            return true
        } else {
            return false;
        }
    }

    function myFunction1() {
        let text = "Bạn chắc chắn muốn thêm";
        let kt = confirm(text);
        if (kt == true) {
            return true
        } else {
            return false;
        }
    }

    function xanNhanHoaDon() {
        let text = "Bạn muốn xác nhận hóa đơn không";
        let kt = confirm(text);
        if (kt == true) {
            confirm("Xác nhận đơn hàng thành công");
            return true;
        } else {
            confirm("Đơn hàng chưa được xác nhận");
            return false;
        }
    }
</script>
</body>
</html>