<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Modify</title>

<link rel="stylesheet" href="../css/work.css">
</head>
<body>
	<div class="ModifyWrapper">
		<form name='frm_summernote' class='frm_summernote'>
			<h4 class="mb-3">구인공고 수정</h4>
			<input type="text" value="${work.listCode }" name="listCode" style="">
			<div class="group">
				<input type="text" value="${work.listTitle}" name="listTitle"
					required> <span class="highlight"></span> <span class="bar"></span>
				<label>제목*</label>
			</div>

			<div class="group">
				<input type="text" name="listAmount" value="${work.listAmount }"
					required> <span class="highlight"></span> <span class="bar"></span>
				<label>금액*</label>
			</div>


			<div class="group">
				<input type="date" value="${work.listFinishDate }"
					name="listFinishDate" value="${listFinishDate }" required>
				<span class="highlight"></span> <span class="bar"></span> <label>날짜*</label>
			</div>

			<div class="group" id="listCreateTime">
				<input type="number" name="listStartTime"
					value="${work.listStartTime }"> <span class="highlight"></span>
				<span class="bar"></span> <label>모집시간</label> <span>~</span> <input
					type="number" name="listEndTime" value="${work.listEndTime }">
			</div>


			<c:set var="arr" value="${fn:split(work.listCategory, '>')}" />
			<div class="input-group mb-3 group">
				<input type="text" name="listCategory" value="${work.listCategory }"
					style="display: none"> <select
					class="custom-select listCategory" id="inputGroupSelect01">
					<option value="">카테고리</option>
					<option value="주거" <c:if test="${arr[0]=='주거'}">selected</c:if>>주거</option>
					<option value="사무" <c:if test="${arr[0]=='사무'}">selected</c:if>>사무</option>
					<option value="반려동물" <c:if test="${arr[0]=='반려동물'}">selected</c:if>>반려동물</option>
					<option value="대행" <c:if test="${arr[0]=='대행'}">selected</c:if>>대행</option>
					<option value="기타" <c:if test="${arr[0]=='기타'}">selected</c:if>>기타</option>
				</select> <input type="search" id="listCategory2" value="${arr[1]}" >
			</div>

			<div class="group">
				<input type="text" list="listRegionList" value="${work.listRegion }"
					name="listRegion" required>
				<datalist id="listRegionList">
					<option value="관악구"></option>
					<option value="강남구"></option>
					<option value="강서구"></option>
					<option value="구로구"></option>
					<option value="용산구"></option>
					<option value="종로구"></option>
				</datalist>
				<span class="highlight"></span> <span class="bar"></span> <label>지역</label>
			</div>
			<div class="container">
				<textarea class="summernote" name="listContent" id="summernote">${work.listContent }</textarea>
			</div>
			<div class="mb-4" id="btnWrapper">
				<button class="btn btn-md btn-block" id="listModifyBtn"
					type="button">수정</button>
			</div>
		</form>
	</div>
	<script>
	/* 게시하기 버튼 클릭 시, 내가 쓴 글 상세보기 연결 */
	$('#listModifyBtn').on('click',function(){
		var frm = $('.frm_summernote')[0];
		frm.listCategory.value=$(".listCategory").val()+">"+$("#listCategory2").val();
		console.log(frm.listCategory.value);
	    var param = $(frm).serialize();
	    $.post("/jsp/modifyList", param, function(data){
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
			         }
			      });
			   }
		});

		function viewPageMove() {
			$("#content").load("/jsp/view");
		}
	</script>
</body>
</html>