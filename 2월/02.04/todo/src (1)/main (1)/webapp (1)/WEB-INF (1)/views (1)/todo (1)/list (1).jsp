<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Todo List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="card shadow">
            <div class="card-header bg-primary text-white text-center">
                <h3>Todo List</h3>
                <a href="/todo/add" class="text-white">새로운 Todo 추가</a>
            </div>
            <div class="card-body">
                 <ul id="todoList" class="list-group">
                
                	<li class="list-group-item d-flex justify-content-between align-items-center">
                        예제 할 일 1 <button class="btn btn-danger btn-sm" onclick="removeTodo(this)">삭제</button>
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        예제 할 일 2 <button class="btn btn-danger btn-sm" onclick="removeTodo(this)">삭제</button>
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        예제 할 일 3 <button class="btn btn-danger btn-sm" onclick="removeTodo(this)">삭제</button>
                    </li>
                
                </ul>
            </div>
        </div>
    </div>

    <script>
    
    const result = '${param.result}'; //query string 처리 가능 
    
    if(result === 'add'){
    	
    	window.alert("새로운 Todo가 등록되었습니다.");
    	window.history.pushState(null, "", "?"); //새로고침 문제 해결을 위해서 사용
    }
    
    </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
