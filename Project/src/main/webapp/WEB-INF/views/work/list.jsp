<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>일개미</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="Free HTML Templates" name="keywords">
<meta content="Free HTML Templates" name="description">
<link rel="stylesheet" href="../css/work.css">
</head>


<body>
	<div id="workList">

		<!-- Products Start -->
		<div class="container-fluid py-5">
			<div class="container">
				<div class="mx-auto text-center mb-5" style="max-width: 500px;">
					<h1 class="display-5">
						일개미 구하기 <br> <a href="#" class="btn btn-primary" onclick="workCreate()">구인공고 등록</a>
					</h1>
					<br>
					<h5 class="text-uppercase">요즘 뜨는 심부름</h5>
				</div>
				<div id="carouselExampleControls"
					class="carousel slide carousel-dark"
					data-ride="carousel justify-content-center">
					<div class="carousel-inner active">
						<div class="carousel-item active">
							<div class="cards-wrapper justify-content-center">
								<c:forEach var="i" begin="1" end="4">
									<div class="card">
										<img src="../img/helpAnt.png" class="card-img-top" alt="...">
										<div class="card-body">
											<h5 class="card-title">애완견 산책</h5>
											<div class="card-detail">
												<div>10,000원</div>
												<div>위치 : 여의도</div>
											</div>
											<a href="#" class="btn btn-primary">More</a>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
						<div class="carousel-item">
							<div class="cards-wrapper">
								<c:forEach var="i" begin="1" end="4">
									<div class="card">
										<img src="../img/helpAnt.png" class="card-img-top" alt="...">
										<div class="card-body">
											<h5 class="card-title">줄서기</h5>
											<div class="card-detail">
												<div>10,000원</div>
												<div>위치 : 여의도</div>
											</div>
											<a href="#" class="btn btn-primary">More</a>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>

					</div>
					<a class="carousel-control-prev" href="#carouselExampleControls"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleControls"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div>
		<!-- Products End -->

		<!-- <h6><input type="checkbox" name="" value="">카테고리</h6>
    <h6><input type="checkbox" name="" value="">지역</h6>
    <h6><input type="checkbox" name="" value="">금액</h6> -->



		<!-- Team Start -->
		<div class="container-fluid py-5">
			<div class="container">
				<div class="mx-auto text-center mb-5" style="max-width: 500px;">

					<h1 class="display-5">일개미 구하기</h1>
					<form name="myForm" action="target.html" method="post">
						<select name="categori">
							<option value="categori" selected>카테고리별</option>
							<option value="volvo">지역별</option>
							<option value="saab">금액별</option>
						</select><br>
						<br>
				</div>

				<div class="row g-5">
					<div class="col-lg-4 col-md-6">
						<div class="row g-0">
							<div class="col-10">
								<div class="position-relative">
									<img class="img-fluid w-100" src="../img/workingAnt.jpg" alt="">
									<div class="text-center p-5"
										style="background: rgba(255, 255, 255, 0.85);">
										<h4 class="text-black-50">반려견 산책</h4>
										<span class="text-black-50">금액:50,000</span><br> <span
											class="text-black-50">위치:서울 여의도</span> <a href="#"
											class="btn btn-primary">More</a>

									</div>
								</div>
							</div>

						</div>
					</div>
					<div class="col-lg-4 col-md-6">
						<div class="row g-0">
							<div class="col-10">
								<div class="position-relative">
									<img class="img-fluid w-100" src="../img/workingAnt.jpg" alt="">
									<div class="text-center p-5"
										style="background: rgba(255, 255, 255, 0.85);">
										<h4 class="text-black-50">반려견 산책</h4>
										<span class="text-black-50">금액:50,000</span><br> <span
											class="text-black-50">위치:서울 여의도</span> <a href="#"
											class="btn btn-primary">More</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6">
						<div class="row g-0">
							<div class="col-10">
								<div class="position-relative">
									<img class="img-fluid w-100" src="../img/workingAnt.jpg" alt="">
									<div class="text-center p-5"
										style="background: rgba(255, 255, 255, 0.85);">
										<h4 class="text-black-50">반려견 산책</h4>
										<span class="text-black-50">금액:50,000</span><br> <span
											class="text-black-50">위치:서울 여의도</span> <a href="#"
											class="btn btn-primary">More</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6">
						<div class="row g-0">
							<div class="col-10">
								<div class="position-relative">
									<img class="img-fluid w-100" src="../img/workingAnt.jpg" alt="">
									<div class="text-center p-5"
										style="background: rgba(255, 255, 255, 0.85);">
										<h4 class="text-black-50">반려견 산책</h4>
										<span class="text-black-50">금액:50,000</span><br> <span
											class="text-black-50">위치:서울 여의도</span> <a href="#"
											class="btn btn-primary">More</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6">
						<div class="row g-0">
							<div class="col-10">
								<div class="position-relative">
									<img class="img-fluid w-100" src="../img/workingAnt.jpg" alt="">
									<div class="text-center p-5"
										style="background: rgba(255, 255, 255, 0.85);">
										<h4 class="text-black-50">반려견 산책</h4>
										<span class="text-black-50">금액:50,000</span><br> <span
											class="text-black-50">위치:서울 여의도</span> <a href="#"
											class="btn btn-primary">More</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6">
						<div class="row g-0">
							<div class="col-10">
								<div class="position-relative">
									<img class="img-fluid w-100" src="../img/workingAnt.jpg" alt="">
									<div class="text-center p-5"
										style="background: rgba(255, 255, 255, 0.85);">
										<h4 class="text-black-50">반려견 산책</h4>
										<span class="text-black-50">금액:50,000</span><br> <span
											class="text-black-50">위치:서울 여의도</span> <a href="#"
											class="btn btn-primary">More</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Team End -->


	<!-- Template Javascript -->
	<script src="../js/main.js"></script>
	<script>
		$(function() {
			// 이미지 슬라이드 컨트롤를 사용하기 위해서는 carousel를 실행해야한다.
			$('#carousel-example-generic').carousel({
				// 슬리아딩 자동 순환 지연 시간
				// false면 자동 순환하지 않는다.
				interval : 1000,
				// hover를 설정하면 마우스를 가져대면 자동 순환이 멈춘다.
				pause : "hover",
				// 순환 설정, true면 1 -> 2가면 다시 1로 돌아가서 반복
				wrap : true,
				// 키보드 이벤트 설정 여부(?)
				keyboard : true
			});


			workCreate = function(){
				$("#content").load("/jsp/create");
			}
		});
	</script>

</body>

</html>