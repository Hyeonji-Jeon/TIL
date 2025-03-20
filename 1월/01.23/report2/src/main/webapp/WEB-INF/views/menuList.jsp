<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BurgerKing Menu</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #ffefd5; /* 밝은 배경 색상 */
            color: #333;
            display: flex;
            flex-direction: column;
            align-items: center;
            min-height: 100vh;
        }

        header {
            width: 100%;
            background-color: #ffbb33; /* 버거킹 로고 컬러 */
            padding: 20px 0;
            text-align: center;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        header h1 {
            margin: 0;
            font-size: 32px;
            color: #fff;
        }

        header img {
            max-width: 150px;
            margin-bottom: 10px;
        }

        .menu-container {
            width: 90%;
            max-width: 1200px;
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 25px;
            margin: 40px auto;
        }

        .menu-item {
            background-color: #fff;
            border-radius: 15px;
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
            overflow: hidden;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .menu-item:hover {
            transform: translateY(-10px);
            box-shadow: 0 12px 24px rgba(0, 0, 0, 0.2);
        }

        .menu-item img {
            width: 100%;
            height: auto;
            display: block;
        }

        .menu-item p {
            margin: 0;
            padding: 15px;
            font-size: 18px;
            font-weight: bold;
            text-align: center;
            color: #555;
            background-color: #fffae5;
        }

        footer {
            width: 100%;
            background-color: #333;
            color: #fff;
            padding: 15px 0;
            text-align: center;
            margin-top: auto;
        }

        footer p {
            margin: 0;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <header>
        <img src="imgs/logo.png" alt="BurgerKing Logo">
        <h1>Welcome to BurgerKing Menu</h1>
    </header>

    <div class="menu-container">
        <!-- 메뉴 이미지 출력 -->
	<c:forEach var="image" items="${menuList}">
    	<img src="imgs/menus/${image}" class="menu-item">
	</c:forEach>
 
	</div>

    <footer>
        <p>&copy; 2025 BurgerKing. All Rights Reserved.</p>
    </footer>
</body>
</html>
