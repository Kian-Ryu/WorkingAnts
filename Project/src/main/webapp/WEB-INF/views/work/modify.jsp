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
<link rel="stylesheet" href="../css/work.css">
</head>
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