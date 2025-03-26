<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        background-color: #ffffff;
        color: #333;
    }
    .card {
        background-color: #f8f9fa;
        border-radius: 12px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
    }
    .form-control {
        background-color: #ffffff;
        border: 1px solid #ccc;
        color: #333;
    }
    .form-control:focus {
        background-color: #ffffff;
        color: #333;
        border-color: #555;
        box-shadow: 0 0 6px rgba(0, 0, 0, 0.2);
    }
    .btn-custom {
        background-color: #333;
        border-color: #555;
        color: #fff;
    }
    .btn-custom:hover {
        background-color: #555;
        border-color: #777;
    }
    .text-dark-theme {
        color: #222;
    }
</style>
</head>
<body>
<div class="container mt-5">
    <div class="card shadow-lg p-4">
        <h1 class="text-center text-dark-theme mb-4">File Upload</h1>
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
                <button type="submit" class="btn btn-custom btn-lg">Submit</button>
            </div>
        </form>
    </div>
</div>
<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
