<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <h1>request scope </h1>
 아이디: ${requestScope.userid} <br>
 비번: ${requestScope.passwd} <br>

<h1>session scope </h1>
 email: ${sessionScope.email} <br>
 address: ${sessionScope.address} <br>
 <h1>application scope </h1>
 phone: ${applicationScope.phone} <br>
</body>
</html>