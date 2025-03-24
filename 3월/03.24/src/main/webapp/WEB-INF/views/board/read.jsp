<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../includes/header.jsp" %>

	<h1>Board Read Page</h1>
	
	${board }
	
	<div class="container mt-5">
    <div class="card shadow-lg">
        <div class="card-header bg-primary text-white text-center">
            <h3>게시글 읽기</h3>
        </div>
        <div class="card-body">
            
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
                <a href="/board/list${requestDTO.pageLink}" class="btn btn-primary">목록</a>
                <a href="/board/list" class="btn btn-primary">수정/삭제</a>
            </div>
          
        </div>
    </div>

</div>

  <div class="container mt-5">
    <div class="card shadow-lg">
      <div class="card-body">
           <div class="mb-3">
               <label for="username" class="form-label">작성자</label>
               <input type="text" class="form-control" name="replyer" placeholder="이름을 입력하세요" required>
           </div>
           <div class="mb-3">
               <label for="comment" class="form-label">댓글</label>
               <input class="form-control" name="replyText" rows="3" placeholder="댓글을 입력하세요" required/>
           </div>
           <button type="submit" class="btn btn-primary replyAddBtn">댓글 작성</button>
       </div>
    </div>
  </div>    


 <!-- 댓글 목록 -->
  <div class="container mt-5">
      <div class="card shadow-lg">
          <div class="card-header bg-secondary text-white text-center">
              <h3>댓글 목록</h3>
          </div>
          <div class="card-body replyList">
              <div class="comment">
                  <p><strong>사용자1:</strong> 좋은 글이네요!</p>
              </div>
              <div class="comment">
                  <p><strong>사용자2:</strong> 감사합니다. 많은 도움이 되었습니다.</p>
              </div>
              <div class="comment">
                  <p><strong>사용자3:</strong> 더 많은 정보를 알고 싶어요.</p>
              </div>
          </div>
      </div>
  </div>	

<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script>

document.querySelector(".replyAddBtn").addEventListener("click", e=> {
	
	console.log("click")
	
	const replyText = document.querySelector("input[name='replyText']").value
	const replyer = document.querySelector("input[name='replyer']").value
	const bno = ${board.bno}
	
	const replyObj = {bno,replyText,replyer}
	console.log(replyObj)
	
	axios.post("http://localhost:8080/replies", replyObj).then(res => {
		console.log(res.data) //
		printReplies(res.data)
	})
	
	
}, false)


const replyList = document.querySelector(".replyList")

function printReplies(pageData) {
	
	//댓글 목록 출력 
	const {dtoList} = pageData
	
	const replyStrArr = dtoList.map(replyDTO => `<div class="comment">
    <p><strong>사용자1:</strong>\${replyDTO.replyText}</p>
    </div>`)
	
    
    replyList.innerHTML = replyStrArr.join("")
	//댓글 페이지 처리 
	
}



</script>

 
	
<%@include file="../includes/footer.jsp" %>
