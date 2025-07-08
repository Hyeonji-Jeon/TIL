<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <h1>업로드 화면</h1>
  <form action="upload" method="post" enctype="multipart/form-data">
   파일: <input type="file" name="theFile"> <br>
   내용: <input type="text" name="theText"> <br>
   <button>업로드</button>
 </form>
</body>
</html>