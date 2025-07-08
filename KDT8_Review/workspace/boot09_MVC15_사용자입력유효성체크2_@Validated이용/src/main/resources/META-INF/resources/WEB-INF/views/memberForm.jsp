<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
 <h1>회원가입 화면</h1>
 ${errorMessage}
 <form  method="post" action="member">
	<table>
		<tr>
			<td>userid:</td>
			<td><input type="text" name="userid"/></td>
		</tr>
		<tr>
			<td>passwd:</td>
			<td><input type="text" name="passwd"/></td>
		</tr>
		<tr>
			<td>username:</td>
			<td><input type="text" name="username"/></td>
		</tr>
		<tr>
			<td>phone:</td>
			<td><input type="text" name="phone"/></td>
		</tr>
		<tr>
			<td>targetDate:</td>
			<td><input type="date" name="targetDate"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="회원가입"/>
			</td>
		</tr>
	</table>
</form>
 
 
 
</body>
</html>