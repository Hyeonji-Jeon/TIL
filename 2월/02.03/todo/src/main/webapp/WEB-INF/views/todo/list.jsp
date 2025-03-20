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
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card shadow-sm">
                    <div class="card-header text-center bg-primary text-white">
                        <h4>Todo List</h4>
                        	<a href="/todo/add" class="text-white">새로운 Todo 추가</a>
                    </div>
                    <div class="card-body">                   
                        <ul class="list-group">
                            <li class="list-group-item d-flex justify-content-between align-items-center bg-light">
                                <span class="fw-bold text-secondary">📌 프로젝트 계획 세우기</span>
                                <button class="btn btn-danger btn-sm">삭제</button>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center bg-light">
                                <span class="fw-bold text-secondary">🛒 장보기 목록 작성</span>
                                <button class="btn btn-danger btn-sm">삭제</button>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center bg-light">
                                <span class="fw-bold text-secondary">📚 책 한 챕터 읽기</span>
                                <button class="btn btn-danger btn-sm">삭제</button>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center bg-light">
                                <span class="fw-bold text-secondary">🏋️‍♂️ 운동 30분 하기</span>
                                <button class="btn btn-danger btn-sm">삭제</button>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center bg-light">
                                <span class="fw-bold text-secondary">✍️ 일기 쓰기</span>
                                <button class="btn btn-danger btn-sm">삭제</button>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <script>
    
    const result = '${param.result}'; // query string 처리 가능
    
    if(result === 'add'){
    	
    	window.alert("새로운 Todo가 등록되었습니다.");
    	window.history.pushState(null, "", "?"); //새로고침 문제 해결을 위해서 사용
    	
    }
    
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

