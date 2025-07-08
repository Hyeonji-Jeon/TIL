<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>1.GET</h1>
 <form action="write" method="get">
   아이디: <input type="text" name="userid"> <br>
   비번: <input type="text" name="paswd"> <br>
   <button>요청</button>
 </form>
 
 
 <h1>2. POST</h1>
  <form action="write" method="post">
   아이디: <input type="text" name="userid"> <br>
   비번: <input type="text" name="paswd"> <br>
   <button>요청</button>
 </form>
</body>
</html>