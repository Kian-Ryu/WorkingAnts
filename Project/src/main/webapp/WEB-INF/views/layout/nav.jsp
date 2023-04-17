<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nav</title>

</head>
<body>
	<nav class="nav">
		<div class="justify-content-center" id="dropdownMenuLink"
			data-bs-toggle="dropdown" aria-expanded="false">
			<div id="userWrapper">
				<button class="dropbtn" id="serviceCenter">심부름</button>
				<div class="dropdown-content" id="serviceCenterContent">
					<a href="#">사무</a> <a href="#">주거</a><a href="#">반려동물</a> <a
						href="#">대행</a><a href="#">기타</a>
				</div>
			</div>
			<div id="userWrapper">
				<button class="dropbtn" id="serviceCenter">채팅</button>
			</div>
			<div id="userWrapper">
				<button class="dropbtn" id="serviceCenter">마이페이지</button>
				<div class="dropdown-content" id="serviceCenterContent">
					<a href="#">내 정보</a> <a href="#">내 심부름</a>
				</div>
			</div>
			<div id="userWrapper">
				<button class="dropbtn" id="serviceCenter">고객센터</button>
				<div class="dropdown-content" id="serviceCenterContent">
					<a href="#">자주 묻는 질문</a> <a href="#">문의하기</a>
				</div>
			</div>
		</div>
	</nav>
</body>
</html>