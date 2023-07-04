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
    <h1 class="text-center">Thông Tin Nhà Sản Xuất</h1>
    <a href="/nha-san-xuat/form-add" class="mb-2 btn btn-success">Add</a>
    <table class="table table-sm">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">ID Number</th>
            <th scope="col">Name</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listNSX.content}" var="nhaSanXuat" varStatus="stt">
            <tr>
                <td>${stt.index + 1}</td>
                <td>${nhaSanXuat.ma}</td>
                <td>${nhaSanXuat.ten}</td>
                <td>
                    <a href="/nha-san-xuat/detail/${nhaSanXuat.id}" class="btn btn-primary">Detail</a>
                    <a href="/nha-san-xuat/delete/${nhaSanXuat.id}" class="btn btn-danger" onclick="return myFunction4()">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="d-flex justify-content-center">
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="/nha-san-xuat/hien-thi?page=0">First</a></li>
                <li class="page-item"><a class="page-link"
                                         href="/nha-san-xuat/hien-thi?page=${listNSX.number-1}">Previous</a></li>
                <c:forEach begin="0" end="${listNSX.totalPages - 1}" varStatus="index">
                    <li class="page-item"><a class="page-link"
                                             href="/nha-san-xuat/hien-thi?page=${index.begin + index.count-1}">
                            ${index.begin + index.count}
                    </a></li>
                </c:forEach>
                <li class="page-item"><a class="page-link" href="/nha-san-xuat/hien-thi?page=${listNSX.number+1}">Next</a>
                </li>
                <li class="page-item"><a class="page-link"
                                         href="/nha-san-xuat/hien-thi?page=${listNSX.totalPages-1}">Last</a></li>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>