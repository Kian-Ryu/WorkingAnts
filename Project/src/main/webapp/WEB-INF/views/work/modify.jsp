<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Modify</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- 서머노트를 위해 추가해야할 부분 -->
<script src="../summernote/summernote-lite.js"></script>
<script src="../summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="../summernote/summernote-lite.css">
</head>
<style>
.ModifyWrapper {
	width: 80%;
	margin: 10vh auto;
}

.ModifyWrapper .main_div {
	padding: 30px;
}
.ModifyWrapper #listCreateTime input{
	display:inline-block;
}
.ModifyWrapper input, .ModifyWrapper textarea {
	background: none;
	color: #53596e;
	font-size: 18px;
	padding: 8px 8px 8px 13px;
	display: block;
	width: 320px;
	border: none;
	border-radius: 10px;
	border: 1px solid #c6c6c6;
}

.ModifyWrapper input:hover {
	border: 3px solid black;
}

.ModifyWrapper input:focus, .ModifyWrapper textarea:focus {
	outline: none;
	border: 3px solid #f00;
}

.ModifyWrapper input ~ label, .ModifyWrapper textarea ~ label {
	top: -5px;
	font-size: 12px;
	color: #000;
	left: 11px;
}

.ModifyWrapper input:focus ~ label, .ModifyWrapper input:valid ~ label, .ModifyWrapper textarea:focus ~ label,
	.ModifyWrapper textarea:valid ~ label {
	color: #f00;
}

.ModifyWrapper input:focus ~ .bar:before, .ModifyWrapper textarea:focus ~ .bar:before {
	width: 320px;
}

.ModifyWrapper input[type="password"] {
	letter-spacing: 0.3em;
}

.ModifyWrapper #inputGroupSelect01{
	border-top-left-radius:10px;
	border-bottom-left-radius:10px;
	border: 1px solid #c6c6c6;
	padding-left:10px;
	padding-right:10px;
}

.ModifyWrapper .group {
	position: relative;
	margin:5vh auto;
}

.ModifyWrapper label {
	color: #c6c6c6;
	font-size: 16px;
	font-weight: normal;
	position: absolute;
	pointer-events: none;
	left: 15px;
	top: 12px;
	transition: 300ms ease all;
	background-color: #fff;
	padding: 0 2px;
}
.ModifyWrapper #btnWrapper{
	text-align:center;
	margin-top:10vh;
}
.ModifyWrapper #listModifyBtn{
border: 1px solid #c6c6c6;
padding:10px 15px;
color:black;
border-radius : 5px;
}
.ModifyWrapper #listModifyBtn:hover{
border: 1px solid gray;
}
</style>
<body>
	<div class="ModifyWrapper">
		<h4 class="mb-3">구인공고 수정</h4>

		<div class="group">
			<input type="text" required> <span class="highlight"></span>
			<span class="bar"></span> <label>제목*</label>
		</div>

		<div class="group">
			<input type="text" required> <span class="highlight"></span>
			<span class="bar"></span> <label>금액*</label>
		</div>


		<div class="group">
			<input type="date" required> <span class="highlight"></span>
			<span class="bar"></span> <label>날짜</label>
		</div>

		<div class="group" id="listCreateTime">
			<input type="number" required> <span class="highlight"></span>
			<span class="bar"></span> <label>모집시간</label>
			<span>~</span>
			<input type="number" required>
		</div>
		

		<div class="input-group mb-3">
			<select class="custom-select" id="inputGroupSelect01"
				name="listCategory">
				<option selected>카테고리</option>
				<option value="1">주거</option>
				<option value="2">사무</option>
				<option value="3">반려동물</option>
				<option value="4">대행</option>
				<option value="5">기타</option>
			</select> <input type="search" name="listCategory2">
		</div>

		<div class="group">
			<input type="text" list="listRegionList" required>
			<datalist id="listRegionList">
				<option value="관악구"></option>
				<option value="강남구"></option>
				<option value="강서구"></option>
				<option value="구로구"></option>
				<option value="용산구"></option>
				<option value="종로구"></option>
			</datalist>
			<span class="highlight"></span> 
			<span class="bar"></span> 
			<label>지역</label>
		</div>
		<div class="container">
			<textarea class="summernote" name="listContent"></textarea>
		</div>
		<div class="mb-4" id="btnWrapper">
              <button class="btn btn-md btn-block" id="listModifyBtn" type="submit" onclick="viewPageMove()">수정</button>
        </div>
	</div>
	<script>

	function viewPageMove(){
		$("#content").load("/jsp/view");
	}
		$('.summernote').summernote({
			height : 150,
			lang : "ko-KR"
		});
	</script>
</body>
</html>