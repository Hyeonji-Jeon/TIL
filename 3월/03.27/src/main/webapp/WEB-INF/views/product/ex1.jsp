<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../includes/header.jsp" %>

	<h1>File Upload</h1>
	
	<div class="container mt-5">
    <div class="card shadow-lg">
        <div class="card-header bg-primary text-white text-center">
            <h3>File Upload</h3>
        </div>
        <div class="card-body">
            <form method="post" action="/product/add" enctype="multipart/form-data">
                <div class="mb-3">
                <label class="form-label">상품명</label>
                <input type="text" name="pname" class="form-control" value="Test Product">
            </div>
            <div class="mb-3">
                <label class="form-label">상품 설명</label>
                <input type="text" name="pdesc" class="form-control" value="Test Product Desc">
            </div>
            <div class="mb-3">
                <label class="form-label">가격</label>
                <input type="number" name="price" class="form-control" value="5000">
            </div>
            <div class="mb-3">
                <label class="form-label">파일 업로드</label>
                <input type="file" name="files" class="form-control" multiple>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>

            </form>
        </div>
    </div>
</div>
	
	
<%@include file="../includes/footer.jsp" %>
