<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>File Upload Test</h1>

	<form method="post" action="/product/ex1" enctype="multipart/form-data">
	
		<div>
			<input type='text' name="title">
		</div>
		
		<div>
			<input type='file' name="files">
		</div>
	
		<button>SUBMIT</button>
	</form>
</body>
</html>