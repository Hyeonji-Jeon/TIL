<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <h1>2. POST</h1>
  <form action="write" method="post">
   아이디: <input type="text" name="userid"> <br>
   비번: <input type="text" name="passwd"> <br>
   <hr>
   취미:<br>
   야구: <input type="checkbox" name="hobby" value="야구"><br>
   농구: <input type="checkbox" name="hobby" value="농구"><br>
   축구: <input type="checkbox" name="hobby" value="축구"><br>
   <button>요청</button>
 </form>
</body>
</html>