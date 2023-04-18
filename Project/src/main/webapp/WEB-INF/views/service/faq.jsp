<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ</title>
<style>
#faqWrapper {
	width: 70%;
	margin: auto;
	margin-bottom: 10vh;
}

#faqWrapper #faqHeader {
	margin-top: 50px;
	margin-bottom: 50px;
	text-align: center;
}

#faqWrapper p {
	color: #565877;
}

#faqWrapper .accordion-button:focus, #faqWrapper .accordion-button:not(.collapsed)
	{
	color: #565877;
	background-color: #c7c9db29;
}

#faqWrapper .accordion-button:not(.collapsed)::after {
	background-image: url(data : image/ svg + xml, % 3csvg xmlns =
		'http://www.w3.org/2000/svg' viewBox = '0 0 16 16' fill = '%238D9AA8'
		% 3e % 3cpath fill-rule = 'evenodd' d =
		'M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z'
		/ % 3e % 3c/ svg % 3e) !important;
	transform: rotate(-180deg);
}

#faqWrapper .accordion-button::after {
	background-image: url(data : image/ svg + xml, % 3csvg xmlns =
		'http://www.w3.org/2000/svg' viewBox = '0 0 16 16' fill = '%238D9AA8'
		% 3e % 3cpath fill-rule = 'evenodd' d =
		'M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z'
		/ % 3e % 3c/ svg % 3e) !important;
}

.accordion-button:focus {
	z-index: 3;
	border-color: #ffc02230;
	outline: 0;
	box-shadow: 0 0 0 .25rem #ffc02230;
}
</style>
</head>

<body>
	<div id="faqWrapper">
		<h2 id="faqHeader">자주 묻는 질문</h2>
		<!-- FAQ 시작 -->
		<div class="accordion justify-content-center" id="accordionExample">
			<div class="accordion-item">
				<h2 class="accordion-header" id="headingOne">
					<button class="accordion-button" type="button"
						data-bs-toggle="collapse" data-bs-target="#collapseOne"
						aria-expanded="true" aria-controls="collapseOne">계정 신고</button>
				</h2>
				<div id="collapseOne" class="accordion-collapse collapse show"
					aria-labelledby="headingOne" data-bs-parent="#accordionExample">
					<div class="accordion-body">
						<p>1. 신고를 한 경우 2~3일 내로 신고된 계정이 정지됩니다.</p>
						<p>2. 신고된 계정은 메일을 통해 신고 내용이 전달됩니다.</p>
						<p>3. 계정이 정지된 경우 페이지 이용이 불가합니다.</p>
					</div>
				</div>
			</div>
			<div class="accordion-item">
				<h2 class="accordion-header" id="headingTwo">
					<button class="accordion-button collapsed" type="button"
						data-bs-toggle="collapse" data-bs-target="#collapseTwo"
						aria-expanded="false" aria-controls="collapseTwo">이용방법</button>
				</h2>
				<div id="collapseTwo" class="accordion-collapse collapse"
					aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
					<div class="accordion-body">
						<p>
							<b>1. 카테고리</b><br>
							<br> 사무 - 타이핑, 번역, 문서 작업 등<br> <br> 주거 - 청소 ,벌레,
							쓰레기, 배달, 조립, 설치<br> <br> 반려동물 - 산책, 미용실, 병원, 물주기, 밥주기<br>
							<br> 대행 - 구매대행, 환불대행<br> <br> 기타(물건 빌려주세요)
						</p>
						<p><b>2. 채팅</b><br><br>
						심부름 매칭 성공시 채팅으로 이동이 가능합니다. 
					</div>
				</div>
			</div>
			<div class="accordion-item">
				<h2 class="accordion-header" id="headingThree">
					<button class="accordion-button collapsed" type="button"
						data-bs-toggle="collapse" data-bs-target="#collapseThree"
						aria-expanded="false" aria-controls="collapseThree">문의 답장
						처리기간</button>
				</h2>
				<div id="collapseThree" class="accordion-collapse collapse"
					aria-labelledby="headingThree" data-bs-parent="#accordionExample">
					<div class="accordion-body">
						<p>문의 시 24시간내로 보내신 email로 답장이 갑니다.</p>
					</div>
				</div>
			</div>
			<div class="accordion-item">
				<h2 class="accordion-header" id="headingFour">
					<button class="accordion-button collapsed" type="button"
						data-bs-toggle="collapse" data-bs-target="#collapseFour"
						aria-expanded="false" aria-controls="collapseFour">버그제보</button>
				</h2>
				<div id="collapseFour" class="accordion-collapse collapse"
					aria-labelledby="headingFour" data-bs-parent="#accordionExample">
					<div class="accordion-body">
						<p>보고시 24시간내로 보내신 email로 답장이 갑니다.</p>
						<p>최대한 빠르게 수정하도록 노력하겠습니다.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- FAQ 끝 -->



	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>


</body>
</html>