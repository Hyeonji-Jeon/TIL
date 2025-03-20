<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>상품 상세 정보</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<c:if test="${user != null }">
USER : ${user}  <b> CART : ${count} </b>
</c:if>

    <div class="container mt-4">
        <h2 class="text-center mb-4">상품 상세 정보</h2>
        <div class="card mx-auto" style="max-width: 600px;">
            <img src="http://localhost/${dto.img }" class="card-img-top" alt="상품 이미지">
            <div class="card-body">
                <h5 class="card-title">상품명: ${dto.pname }</h5>
                <p class="card-text"><strong>상품 번호:</strong> ${dto.pno }</p>
                <p class="card-text"><strong>가격:</strong> ${dto.price }</p>
                <p class="card-text"><strong>설명:</strong> 이 상품은 예제 상품으로 상세 설명이 여기에 들어갑니다.</p>
                
                <form action="/cart/add" method="post">
                	<input type='hidden' name="pno" value="${dto.pno}">
                	<button class="btn btn-primary">구매하기</button>
                </form>
                
                
                <a href="/product/list" class="btn btn-secondary">목록으로 돌아가기</a>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>





