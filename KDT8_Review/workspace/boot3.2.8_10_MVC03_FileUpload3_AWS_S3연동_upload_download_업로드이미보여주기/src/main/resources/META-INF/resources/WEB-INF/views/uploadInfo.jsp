<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${uploadDTO.theFile.originalFilename}
aws:<img src="${url}" width="100" height="100" ><br>
다운로드:<a href="download?key=${key}">${key}</a><br>
<a href="${url}">${url}</a>
</body>
</html>