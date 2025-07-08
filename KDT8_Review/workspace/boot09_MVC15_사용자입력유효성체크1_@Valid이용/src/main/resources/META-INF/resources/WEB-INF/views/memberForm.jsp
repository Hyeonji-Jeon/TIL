<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
 <h1>회원가입 화면</h1>
 <form:form modelAttribute="xxx" method="post">
	<table>
		<tr>
			<td>userid:</td>
			<td><form:input type="text" path="userid"/></td>
			<td><form:errors  path="userid"/></td>
		</tr>
		<tr>
			<td>passwd:</td>
			<td><form:input type="text" path="passwd"/></td>
			<td><form:errors  path="passwd"/></td>
		</tr>
		<tr>
			<td>username:</td>
			<td><form:input type="text" path="username"/></td>
			<td><form:errors  path="username"/></td>
		</tr>
		<tr>
			<td>phone:</td>
			<td><form:input type="text" path="phone"/></td>
			<td><form:errors  path="phone"/></td>
		</tr>
		<tr>
			<td>targetDate:</td>
			<td><form:input type="date" path="targetDate"/></td>
			<td><form:errors  path="targetDate"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="회원가입"/>
			</td>
		</tr>
	</table>
</form:form>
 
 
 
</body>
</html>