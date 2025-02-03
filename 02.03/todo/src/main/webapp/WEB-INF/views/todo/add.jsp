<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Todo List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card shadow-sm">
					<div class="card-header text-center bg-primary text-white">
						<h4>Todo 입력</h4>
					</div>
					<div class="card-body">
						<form action="/todo/add" method="post" >
							<div class="input-group mb-3">
								 <input
									type="text" class="form-control" name="Title"
									placeholder="할 일 제목 입력">
							</div>
							<div class="mb-3">
								 <input
									type="text" class="form-control" name="writer"
									placeholder="작성자 이름 입력">
							</div>
							<div class="text-center">
								<button class="btn btn-primary w-100 mb-3">추가</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
