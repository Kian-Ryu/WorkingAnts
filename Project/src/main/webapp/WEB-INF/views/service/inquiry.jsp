<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의사항</title>
<link rel="stylesheet" href="../css/service.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>

    <!-- 버튼 클릭시 내 문의로 이동하기 -->
    <!-- qna 시작 -->
    <div class="container" id="inquiryWrapper">
        <div class="input-form-backgroud row">
          <div class="input-form col-md-12 mx-auto">
            <h4 class="mb-3">QnA</h4>
            <form class="validation-form"  id="qnaFrm" novalidate>
                <div class="row">
                  <div class="mb-3">
                    <label for="title">문의 제목</label>
                    <input type="text" name="inqTitle" class="form-control" id="title" placeholder="" value="" required>
                    <div class="invalid-feedback">
                      제목을 입력해주세요.
                    </div>
                  </div>
              </div>
    
              <div class="mb-3">
                <label for="content">이메일</label>
                <input type="email" name="inqEmail" class="form-control" id="email" placeholder="you@example.com" required>
                <div class="invalid-feedback">
                  답변을 받을 이메일을 입력해주세요.
                </div>
              </div>

              <div class="mb-3">
                <label for="content">문의 내용</label>
                <textarea class="form-control" name="inqContent" id="content" required></textarea>
                <div class="invalid-feedback">
                  문의 내용을 입력해주세요.
                </div>
              </div>
    
              <hr class="mb-4">
              <div class="mb-4" id="btnWrapper">
              <button class="btn btn-lg btn-block" id="inquiryBtn" type="button">문의 하기</button>
            </div>
            </form>
          </div>
        </div>
      </div>
      <!-- qna 끝 -->


    <!-- JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script>
	/* 문의하기 버튼 클릭 시, insert */
	$('#inquiryBtn').on('click',function(){
		var frm = $('#qnaFrm')[0];
		
	    var param = $(frm).serialize();
	    $.post("/jsp/createQnA", param, function(data){
	    	$('#content').html(data);				
	    	swal("문의가 전송되었습니다!", "24시간내에 답변해드리겠습니다.", "success");
	    })
	})  
	</script>

</body>
</html>