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
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i>일자리 목록
						</div>
						<div class="card-body">
							<table id="datatablesSimple">
								<thead>
									<tr>
										<th>제목</th>
										<th>내용</th>
										<th>작성날짜</th>
										<th>금액</th>
										<th>카테고리</th>
										<th>조회수</th>
										<th>상태</th>
										<th>보드지역</th>
										<th>첨부파일</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>바둑한판 알바1</td>
										<td>고고고 ㅎㅎ</td>
										<td>2023/04/16</td>
										<td>65000원</td>
										<td>함께놀기</td>
										<td>465</td>
										<td>진행중</td>
										<td>서울 구로구</td>
										<td>hello.jpg</td>
									</tr>
									<tr>
										<td>바퀴벌레퇴치</td>
										<td>살려주세요</td>
										<td>2023/04/17</td>
										<td>7844원</td>
										<td>벌레</td>
										<td>952</td>
										<td>진행중</td>
										<td>서울 양천구</td>
										<td>wwwk.jpg</td>
									</tr>
									<tr>
										<td>바둑한판 알바6</td>
										<td>고고고 ㅎㅎ</td>
										<td>2023/04/16</td>
										<td>65000원</td>
										<td>함께놀기</td>
										<td>465</td>
										<td>진행중</td>
										<td>서울 구로구</td>
										<td>hello.jpg</td>
									</tr>
									<tr>
										<td>바둑한판 알바9</td>
										<td>고고고 ㅎㅎ</td>
										<td>2023/04/16</td>
										<td>65000원</td>
										<td>함께놀기</td>
										<td>465</td>
										<td>진행중</td>
										<td>서울 구로구</td>
										<td>hello.jpg</td>
									</tr>
									<tr>
										<td>바둑한판 알바44</td>
										<td>고고고 ㅎㅎ</td>
										<td>2023/04/16</td>
										<td>65000원</td>
										<td>함께놀기</td>
										<td>465</td>
										<td>진행중</td>
										<td>서울 구로구</td>
										<td>hello.jpg</td>
									</tr>
									<tr>
										<td>바둑한판 알바55</td>
										<td>고고고 ㅎㅎ</td>
										<td>2023/04/16</td>
										<td>65000원</td>
										<td>함께놀기</td>
										<td>465</td>
										<td>진행중</td>
										<td>서울 구로구</td>
										<td>hello.jpg</td>
									</tr>
									<tr>
										<td>바퀴벌레퇴치</td>
										<td>살려주세요</td>
										<td>2023/04/17</td>
										<td>7844원</td>
										<td>벌레</td>
										<td>952</td>
										<td>진행중</td>
										<td>서울 양천구</td>
										<td>wwwk.jpg</td>
									</tr>

									<tr>
										<td>바퀴벌레퇴치</td>
										<td>살려주세요</td>
										<td>2023/04/17</td>
										<td>7844원</td>
										<td>벌레</td>
										<td>952</td>
										<td>진행중</td>
										<td>서울 양천구</td>
										<td>wwwk.jpg</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</main>
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
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
		crossorigin="anonymous"></script>
	<script src="js/datatables-simple-demo.js"></script>
</body>
</html>