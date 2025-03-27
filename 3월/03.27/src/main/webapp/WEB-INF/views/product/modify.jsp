<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="../includes/header.jsp"%>

<h1>Product Modify Page</h1>
<div class="container mt-5">
	<div class="card shadow-lg">
		<div class="card-header bg-primary text-white text-center">
			<h3>상품 수정/삭제</h3>
		</div>
		<div class="card-body">
			<form id='form1' action="/product/modify/${product.pno}" method="post" enctype="multipart/form-data">
				<div class="mb-3">
					<label for="pno" class="form-label">상품번호</label> <input type="text"
						class="form-control" name="pno" value="${product.pno}" readonly>
				</div>

				<!-- 제목 입력 -->
				<div class="mb-3">
					<label for="pname" class="form-label">상품명</label> <input
						type="text" class="form-control" name="pname"
						value="${product.pname}" placeholder="제목을 입력하세요">
				</div>

				<div class="mb-3">
					<label for="price" class="form-label">가격</label> <input
						type="number" class="form-control" name="price"
						value="${product.price}">
				</div>

				<div class="mb-3">
					<label for="files" class="form-label">추가이미지</label> <input
						type="file" class="form-control" name="files" multiple="multiple">
				</div>

				<!-- 내용 입력 -->
				<div class="mb-3">
					<label for="pdesc" class="form-label">상품설명</label>
					<textarea class="form-control" name="pdesc" rows="5"
						placeholder="내용을 입력하세요">${product.pdesc}</textarea>
				</div>

				<!-- 버튼 -->
				<div class="text-center">
					<a href="/product/list${requestDTO.pageLink}"
						class="btn btn-primary">목록</a> 
					<a href="/product/modify/${product.pno}${requestDTO.pageLink}"
						class="btn btn-danger delBtn">삭제</a> 
					<a href="/product/modify/${product.pno}${requestDTO.pageLink}"
						class="btn btn-warning modifyBtn">수정</a>
				</div>
				<div class="hiddenFile">
				</div>
			</form>
		</div>
	</div>
</div>

<div class="container mt-5">
	<div class="card shadow-lg p-3">
		<div class="d-flex flex-row gap-3 imgList">
			<c:forEach items="${product.fileNames}" var="fileName">
				<div class="text-center">
					<img src="/files/s_${fileName}" data-file='${fileName}' class="img-fluid"
						style="max-width: 100px; height: auto;">
					<button type="button"
						class="btn btn-danger btn-sm mt-2 delImageBtn">삭제</button>
				</div>
			</c:forEach>
		</div>
	</div>
</div>

<script>


document.querySelector(".modifyBtn").addEventListener("click", e => {
	e.preventDefault()
	e.stopPropagation()

	const hiddenDiv = document.querySelector(".hiddenFile")
	
	const imageList = document.querySelectorAll(".imgList img")
	
	console.log(imageList)//배열
	
	if(imageList.length > 0) {
		
		let str = ''
		
		for(let i = 0; i < imageList.length; i++) {
			
			const imageNode = imageList[i]
			
			const fileName = imageNode.getAttribute("data-file")
			
			console.log(fileName)
			
			str += `<input type='hidden' name="fileNames" value='\${fileName}'>`
			
		}//end for
		
		hiddenDiv.innerHTML = str
		
	}
	
	document.querySelector("#form1").submit()
	
	
},false)



document.querySelector(".imgList").addEventListener("click", e => {
	
	e.preventDefault()
	e.stopPropagation()
	
	const target = e.target
	
	if(! target.classList.contains("delImageBtn")) {
		return;
	}
	
	const targetDiv = target.closest("div")
	
	console.log(targetDiv)
	
	targetDiv.remove()
	
	
	
}, false)


</script>


<%@include file="../includes/footer.jsp"%>
