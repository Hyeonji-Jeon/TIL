<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@include file="../includes/header.jsp"%>

<h1>Product Read Page</h1>



<div class="container mt-5">
	<div class="card shadow-lg">
		<div class="card-header bg-primary text-white text-center">
			<h3>상품 조회</h3>
		</div>
		<div class="card-body">

			<!-- 상품 -->
			<div class="mb-3">
				<label for="title" class="form-label">상품명</label> <input type="text"
					class="form-control" name="pname" value="${product.pname}" readonly>
			</div>


			<!-- 가격 -->
			<div class="mb-3">
				<label for="price" class="form-label">가격</label> <input
					type="number" class="form-control" name="price"
					value="${product.price}" readonly>
			</div>
			
			<!-- 상품설명 -->
			<div class="mb-3">
				<label for="pdesc" class="form-label">상품설명</label>
				<textarea class="form-control" name="pdesc" rows="5" readonly>${product.pdesc}</textarea>
			</div>

			<!-- 버튼 -->
			<div class="text-center">
				<a href="/product/list${requestDTO.pageLink}" class="btn btn-primary">목록</a>
				
				<sec:authentication property="principal" var="secInfo"/>
				
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
