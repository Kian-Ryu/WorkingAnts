<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MainContent</title>
</head>
<body>
	<div id="contentbody" class="bs-component">
		<img id="contentImg" src="../img/content.png">
		<div id="hotWork">
		<h2>요즘 뜨는 심부름</h2>
		<div id="carouselExampleControls" class="carousel slide carousel-dark"
			data-ride="carousel justify-content-center">
			<div class="carousel-inner active">
				<div class="carousel-item active">
					<div class="cards-wrapper justify-content-center">
						<c:forEach var="i" begin="1" end="4">
							<div class="card">
								<img src="../img/helpAnt.png" class="card-img-top" alt="...">
								<div class="card-body">
									<h5 class="card-title">애완견 산책</h5>
									<div>10,000원</div>
									<div>위치 : 여의도</div>
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
									<div>10,000원</div>
									<div>위치 : 여의도</div>
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
		});
	</script>
</body>
</html>