<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Create</title>
<!-- 서머노트를 위해 추가해야할 부분 -->
<script src="../summernote/summernote-lite.js"></script>
<script src="../summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="../summernote/summernote-lite.css">
<link rel="stylesheet" href="../css/work.css">
</head>
<body>
	<div class="CreateWrapper">
	<form name='frm_summernote' class='frm_summernote'>
		<h4 class="mb-3">구인공고 등록</h4>

		<div class="group">
			<input type="text" name="listTitle" required> <span class="highlight"></span>
			<span class="bar"></span> <label>제목*</label>
		</div>

		<div class="group">
			<input type="number" name="listAmount" required> <span class="highlight"></span>
			<span class="bar"></span> <label>금액*</label>
		</div>


		<div class="group">
			<input type="date" name="listFinishDate" required> <span class="highlight"></span>
			<span class="bar"></span> <label>날짜*</label>
		</div>

		<div class="group" id="listCreateTime">
			<input type="number" name="listStartTime" required> <span class="highlight"></span>
			<span class="bar"></span> <label>모집시간</label> <span>~</span> <input
				type="number" name="listEndTime" required>
		</div>


		<div class="input-group mb-3 group">
			<select class="custom-select" id="inputGroupSelect01"
				name="listCategory">
				<option selected>카테고리*</option>
				<option value="1">주거</option>
				<option value="2">사무</option>
				<option value="3">반려동물</option>
				<option value="4">대행</option>
				<option value="5">기타</option>
			</select> <input type="search" name="listCategory2">
		</div>

		<div class="group">
			<input type="text" list="listRegionList" name="listRegion" required>
			<datalist id="listRegionList">
				<option value="관악구"></option>
				<option value="강남구"></option>
				<option value="강서구"></option>
				<option value="구로구"></option>
				<option value="용산구"></option>
				<option value="종로구"></option>
			</datalist>
			<span class="highlight"></span> <span class="bar"></span> <label>지역*</label>
		</div>
		<div class="container">
			<textarea class="summernote" name="listContent" id="summernote"></textarea>
		</div>
		<div class="mb-4" id="btnWrapper">
			<button class="btn btn-md btn-block" id="listCreateBtn" type="button">등록</button>
		</div>
		</form>
	</div>
	<script>
		/* 게시하기 버튼 클릭 시, 내가 쓴 글 상세보기 연결 */
		$('#listCreateBtn').on('click',function(){
			var frm = $('.frm_summernote')[0];
		    var param = $(frm).serialize();
		    console.log(param);
		    $.post("/jsp/createList", param, function(data){
		    	console.log("되낭"+data);
				$('#content').html(data);
		    })
		}) 
		$(document).ready(function() {
			   var fonts = [ '맑은 고딕', '돋움', '궁서', '굴림', '굴림체', '궁서체', '나눔 고딕', '바탕',
			         '바탕체', '새굴림', 'HY견고딕', 'HY견명조', 'HY궁서B', 'HY그래픽M', 'HY목각파임B',
			         'HY신명조', 'HY얕은샘물M', 'HY엽서L', 'HY엽서M', 'HY중고딕', 'HY헤드라인M',
			         '휴먼매직체', '휴먼모음T', '휴먼아미체', '휴먼둥근헤드라인', '휴먼편지체', '휴먼옛체' ];   //삽입할 글씨체
			   fonts.sort();   //폰트 정렬(가나다순)
			   
			   $('.summernote').summernote({
			      width : 800,
			      height : 600, // set editor height
			      minHeight : null, // set minimum height of editor
			      maxHeight : null, // set maximum height of editor
			      focus : false, // set focus to editable area after initializing summernote
			      lang: "ko-KR",
			      fontNames : fonts,
			      
			      callbacks : {            
			            onImageUpload : function(files, editor, welEditable) {      
			               for (var i = files.length - 1; i >= 0; i--) {
			                  sendFile(files[i], this);
			               }
			            }
			         }            
			   });
			   
			   function sendFile(file, el) {
			      var form_data = new FormData();
			      form_data.append('file', file);
			      $.ajax({
			         data : form_data,
			         type : "POST",
			         url : '/jsp/UploadFile',
			         enctype : 'multipart/form-data',
			         cache : false,
			         contentType : false,
			         processData : false,
			         success : function(img_name) {         
			            $('#summernote').summernote('editor.insertImage', img_name.url);
			         }
			      });
			   }
		});
		
	</script>
</body>
</html>