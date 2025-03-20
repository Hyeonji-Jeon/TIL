<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Product List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>



<c:if test="${user != null }">
USER : ${user}  <b> CART : ${count} </b>
</c:if>

    <div class="container mt-5">
        <h2 class="mb-4">상품 목록</h2>
        <table class="table table-striped">
            <thead class="table-dark">
                <tr>
                    <th>번호</th>
                    <th>상품명</th>
                    <th>가격</th>
                    <th>이미지</th>
                </tr>
            </thead>
            
            <style>
            .imgList {
            	width: 200px;
            }
            </style>
            
            <tbody>
            	<c:forEach items="${dtoList}" var="product">
                <tr>
                    <td>${product.pno }</td>
                    <td><a href="/product/view/${product.pno}"> ${product.pname }</a> </td>
                    <td>${product.price }</td>
                    <td><img src="http://localhost/${product.img }" class="img-thumbnail imgList" ></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>