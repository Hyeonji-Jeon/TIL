<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>404 Not Found</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f8f8f8;
            color: #333;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            justify-content: center;
            height: 100vh;
        }
        .container {
            max-width: 600px;
            margin: auto;
        }
        h1 {
            font-size: 80px;
            margin: 0;
            color: #ff6347;
        }
        p {
            font-size: 20px;
            margin: 10px 0;
        }
        a {
            text-decoration: none;
            color: white;
            background-color: #ff6347;
            padding: 10px 20px;
            border-radius: 5px;
            display: inline-block;
            margin-top: 20px;
        }
        a:hover {
            background-color: #e5533d;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>404</h1>
        <p>죄송합니다. 요청하신 페이지를 찾을 수 없습니다.</p>
        <a href="/">홈으로 돌아가기</a>
    </div>
</body>
</html>
