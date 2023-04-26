<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
<!-- Favicon -->
<link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon">
<link rel="icon" href="../img/favicon.ico" type="image/x-icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="../lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">

<!-- Template Stylesheet -->
<link href="../css/style.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="../css/main.css" rel="stylesheet">


<!-- BootStrap Stylesheet -->
<link rel="stylesheet" href="../css/bootstrap.min.css">

<!-- jQuery Script -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<!-- BootStrap Script -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
	integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
	crossorigin="anonymous"></script>

<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css"
	rel="stylesheet" />
<link href="css/sb-style.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
<style type="text/css">
			  .star {
		    position: relative;
		    font-size: 2rem;
		    color: #ddd;
		  }
		  
		  .star input {
		    width: 100%;
		    height: 100%;
		    position: absolute;
		    left: 0;
		    opacity: 0;
		    cursor: pointer;
		  }
		  
		  .star span {
		    width: 0;
		    position: absolute; 
		    left: 0;
		    color: yellow;
		    overflow: hidden;
		    pointer-events: none;
		  }
</style>

</head>
<body>
	<jsp:include page="layout/header_logout.jsp" />
	<jsp:include page="layout/nav.jsp" />
	<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
	<div id="layoutSidenav">
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">요청한 일자리</h1>
					<div class="card mb-4">
						<div class="card-body">
							진행중인 퀘스트는 요청한 분의 완료요청이후 즉시 갱신됩니다. 만약, 장시간 갱신이 제한된다면 오른쪽 링크를통해
							관리자에게 문의하세요 <a target="_blank" href="https://datatables.net/">관리자
								채팅 페이지로</a>
						</div>
					</div>
					<div class="card mb-4" id="myreqwork">
						<div class="card-header">
							<i class="fas fa-table me-1"></i>일자리 목록
						</div>
						<div class="card-body">
							<table id="datatablesSimple">
								<thead>
									<tr>
										<th>제목</th>
										<th>작성날짜</th>
										<th>금액</th>
										<th>카테고리</th>
										<th>조회수</th>
										<th>지역</th>
										<th>상태</th>
										<th>별점</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="work" items="${workp}">
										<tr>
											<td><a>${work.listtitle }</a></td>
											<!-- 여기에 페이지 상세 보기로 경로 넣어주세요 -->
											<td>${work.listEndTime }</td>
											<td>${work.listAmount }</td>
											<td>${work.listCategory }</td>
											<td>${work.listCnt }</td>
											<td>${work.listRegion }</td>
											<td>${work.listState }</td>
											<td>
												<c:forEach var="grade" items="${gradelist}">
													<c:if test= "${work.listCode}==${grade.listCode }">
														<c:choose>
															
															<c:when test2 = "${work.state eq '모집중'}">
																모집중
															</c:when>
															<c:when test2 = "${work.state eq '모집완료'}">
																<button type="button" class="btn btn-success btn-modal" data-toggle="modal" data-target="#myModal" data-id="${work.listCode }">별점주기</button>
															</c:when>
															<c:otherwise>
															<span class="star">
																  ★★★★★
																  <span style="${'width:'+(grade.grade*20)+'%'}">★★★★★</span>
																</span>
															</c:otherwise>
														</c:choose>
													</c:if>												
												</c:forEach>
											</td>
										</tr>									
									</c:forEach>
								
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<div class="modal hide" id="myModal">
		<div class"modal-header">
	    	<button class="close" data-dismiss="modal">x</button>
	        <h3>별점 주기</h3>
		</div>
	    <div class="modal-body">
      	<form id="graderegister" action="" method="post">
	         <span class="star">
	            ★★★★★
	            <span>★★★★★</span>
	        	<input id="star" type="range" oninput="drawStar(this)" value="1" step="1" min="0" max="10">
			</span>
	        <input id="thislistcode" type="hidden" name="listCode" class="body-contents" id="contents" />
      	</form>
	    </div>
	</div>
	<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
	<jsp:include page="layout/footer.jsp" />

	<script>
		$(function() {
			$('#moveFAQ').on('click', function() {
				$('#content').load('/jsp/faq');
			})
			$('#serviceCenter').on('click', function() {
				$('#content').load('/jsp/faq');
			})
			$('#moveInquiry').on('click', function() {
				$('#content').load('/jsp/inquiry');
			})
			$('#WorkPage').on('click', function() {
				$('#content').load('/jsp/list');
			})
			$('.card').on('click', function() {
				$('#content').load('/jsp/view');
			})
		});
		$(".btn-modal").click(function(){
			var data = $(this).data('id');
		    $("#contents.body-contents").val(data);
		});
	    const drawStar = (target) => {
	    	  $(`.star span`).css({ width: `${target.value * 10}%` });
	    	}
	    $("#star").mouseup(function(){
	    	Swal.fire({
              title: '별점을 주시겠습니까?',
              text: $("#star").val()*0.5+"점이 맞습니까?",
              icon: 'info',
              showCancelButton: true,
              confirmButtonColor: '#3085d6',
              cancelButtonColor: '#d33',
              confirmButtonText: '확인',
              cancelButtonText: '취소'
          }).then((result) => {
              if (result.isConfirmed) {
				regGrade();
                  Swal.fire(
                		'별점을 주셨습니다~',
                      '',
                      'success'
                  )
              }
          })
	    })
	    
	    function regGrade() {
		    var grade = $("#star").val()*0.5;
		    var listCode = $("#thislistcode").val();
		    $.ajax({
		        url: "/regGrade",
		        data: "listCode=" + listCode + "&grade=" + grade,
		        type:"POST",
		        success: function(data){
		        	$("#myreqwork").replaceWith(data);
		        }
		    })
		}
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
		crossorigin="anonymous"></script>
	<script src="js/datatables-simple-demo.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</body>
</html>