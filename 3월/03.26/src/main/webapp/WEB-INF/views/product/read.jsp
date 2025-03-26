<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="../includes/header.jsp"%>

<h1>Product Read Page</h1>

${product}

<div class="container mt-5">
	<div class="card shadow-lg">
		<div class="card-header bg-primary text-white text-center">
			<h3>상품 조회</h3>
		</div>
		<div class="card-body">

			<!-- 제목 입력 -->
			<div class="mb-3">
				<label for="title" class="form-label">제목</label> <input type="text"
					class="form-control" name="title" placeholder="제목을 입력하세요">
			</div>

			<!-- 내용 입력 -->
			<div class="mb-3">
				<label for="content" class="form-label">내용</label>
				<textarea class="form-control" name="content" rows="5"
					placeholder="내용을 입력하세요"></textarea>
			</div>

			<!-- 작성자 입력 -->
			<div class="mb-3">
				<label for="writer" class="form-label">작성자</label> <input
					type="text" class="form-control" name="writer" placeholder="작성자 이름">
			</div>

			<!-- 버튼 -->
			<div class="text-center">
				<a href="/product/list${requestDTO.pageLink}" class="btn btn-primary">목록</a>
				<a href="/product/modify/${product.pno}${requestDTO.pageLink}" class="btn btn-primary">수정/삭제</a>
			</div>

		</div>
	</div>
</div>

<div class="container mt-5">
	<div class="card shadow-lg p-3">
		<div class="d-flex flex-row gap-2">
			<c:forEach items="${product.fileNames}" var="fileName">
				<div>
					<img src="/files/s_${fileName}" class="img-fluid"
						style="max-width: 100px; height: auto;">
				</div>
			</c:forEach>
		</div>
	</div>
</div>


<%@include file="../includes/footer.jsp"%>
