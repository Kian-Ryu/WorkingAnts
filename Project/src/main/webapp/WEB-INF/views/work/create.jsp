<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Create</title>
<link rel="stylesheet" href="../css/work.css">
<style>
	.CreateWrapper .dropdown-toggle::after{
		display:none !important;
	}
</style>
</head>
<body>
	<div class="CreateWrapper">
	<fmt:formatDate value='${now}' pattern='yyyy-MM-dd' />
		<form name='frm_summernote' class='frm_summernote'>
			<h4 class="mb-3">구인공고 등록</h4>

			<div class="group">
				<input type="text" name="listTitle" required> <span
					class="highlight"></span> <span class="bar"></span> <label>제목*</label>
			</div>

			<div class="group">
				<input type="number" name="listAmount" required> <span
					class="highlight"></span> <span class="bar"></span> <label>금액*</label>
			</div>


			<div class="group">
				<input type="date" name="listFinishDate" required min="${now }"/> <span
					class="highlight"></span> <span class="bar"></span> <label>날짜*</label>
			</div>

			<div class="group" id="listCreateTime">
				<input type="number" name="listStartTime"> <span
					class="highlight"></span> <span class="bar"></span> <label>모집시간</label>
				<span>~</span> <input type="number" name="listEndTime">
			</div>


			<div class="input-group mb-3 group">
				<input type="text" name="listCategory" style="display: none">
				<select class="custom-select listCategory" id="inputGroupSelect01">
					<option selected>카테고리*</option>
					<option value="주거">주거</option>
					<option value="사무">사무</option>
					<option value="반려동물">반려동물</option>
					<option value="대행">대행</option>
					<option value="기타">기타</option>
				</select> <input type="search" id="listCategory2">
			</div>

			<div class="group">
				<input type="text" list="listRegionList" name="listRegion" required>
				<datalist id="listRegionList">
					<option value="지역무관"></option>
					<option value="관악구"></option>
					<option value="양천구"></option>
					<option value="영등포"></option>
					<option value="구로구"></option>
				</datalist>
				<span class="highlight"></span> <span class="bar"></span> <label>지역*</label>
			</div>
			<div class="container">
				<textarea class="summernote" name="listContent" id="summernote"></textarea>
			</div>
			<div class="mb-4" id="btnWrapper">
				<button class="btn btn-md btn-block" id="listCreateBtn"
					type="button">등록</button>
			</div>
		</form>
	</div>
	<script>
		/* 게시하기 버튼 클릭 시, 내가 쓴 글 상세보기 연결 */
		$('#listCreateBtn').on('click',function(){
			var frm = $('.frm_summernote')[0];
			frm.listCategory.value=$(".listCategory").val()+">"+$("#listCategory2").val();
			console.log(frm.listStartTime.value);
		    var param = $(frm).serialize();
		    $.post("/jsp/createList", param, function(data){
		    	$('#content').html(data);				
		    })
		})  
		$(document).ready(function() {
			   var fonts = [ '맑은 고딕', '돋움', '궁서', '굴림', '나눔 고딕', '바탕',
			         'HY견고딕', 'HY견명조', 'HY궁서B', 'HY그래픽M', 'HY목각파임B',
			         'HY신명조', 'HY얕은샘물M', 'HY엽서L', 'HY엽서M', 'HY중고딕', 'HY헤드라인M',
			         '휴먼매직체', '휴먼모음T', '휴먼아미체', '휴먼둥근헤드라인', '휴먼편지체', '휴먼옛체' ];   //삽입할 글씨체
			   fonts.sort();   //폰트 정렬(가나다순)
			   
			   $('.summernote').summernote({
			      height : 600, // set editor height
			      minHeight : null, // set minimum height of editor
			      maxHeight : null, // set maximum height of editor
			      focus : false, // set focus to editable area after initializing summernote
			      lang: "ko-KR",
			      fontNames : fonts,
			      
			      callbacks : {           
			            onImageUpload : function(files, editor, welEditable) {   
			            	console.log('image upload:', files);   
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
			         },
			      	error :function(){
			      		alert("이미지 크기가 너무 큽니다!");
			      	}
			      });
			   }
		});
		
	</script>
</body>
</html>