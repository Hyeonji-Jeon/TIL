<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../includes/header.jsp" %>

	<h1>Board Add Page</h1>
	
	<div class="container mt-5">
    <div class="card shadow-lg">
        <div class="card-header bg-primary text-white text-center">
            <h3>게시글 작성</h3>
        </div>
        <div class="card-body">
            <form action="/board/add" method="post">
                <!-- 제목 입력 -->
                <div class="mb-3">
                    <label for="title" class="form-label">제목</label>
                    <input type="text" class="form-control" name="title" placeholder="제목을 입력하세요">
                </div>

                <!-- 내용 입력 -->
                <div class="mb-3">
                    <label for="content" class="form-label">내용</label>
                    <textarea class="form-control" name="content" rows="5" placeholder="내용을 입력하세요"></textarea>
                </div>

                <!-- 작성자 입력 -->
                <div class="mb-3">
                    <label for="writer" class="form-label">작성자</label>
                    <input type="text" class="form-control" name="writer" placeholder="작성자 이름">
                </div>

                <!-- 버튼 -->
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">등록</button>
                    <button type="reset" class="btn btn-secondary">초기화</button>
                </div>
            </form>
        </div>
    </div>
</div>
	
	
<%@include file="../includes/footer.jsp" %>
