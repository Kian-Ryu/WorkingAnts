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
			 aria-expanded="false">
			<div class="navWrapper">
				<button class="dropbtn" id="WorkPage">심부름</button>
				<div class="dropdown-content" id="WorkContent">
					<a href="#" onclick="CategoryCheck(this)">사무</a> <a href="#" onclick="CategoryCheck(this)">주거</a><a href="#" onclick="CategoryCheck(this)">반려동물</a> <a
						href="#" onclick="CategoryCheck(this)">대행</a><a href="#" onclick="CategoryCheck(this)">기타</a>
				</div>
			</div>
			<div class="navWrapper">
				<button class="dropbtn" id="ChatPage">채팅</button>
			</div>
			<div class="navWrapper">
				<button class="dropbtn" id="myPage">마이페이지</button>
				<div class="dropdown-content" id="myContent">
					<a href="javascript:void(0);" id="myPagedash">내 정보</a> <a href="/test">내 심부름</a>
				</div>
			</div>
			<div class="navWrapper">
				<button class="dropbtn" id="serviceCenter">고객센터</button>
				<div class="dropdown-content" id="serviceCenterContent">
					<a href='javascript:void(0);' id="moveFAQ" >자주 묻는 질문</a>
					<a href='javascript:void(0);' id="moveInquiry" >문의하기</a>
				</div>
			</div>
		</div>
	</nav>
	<script>
	function CategoryCheck(ths){
		console.log($(ths).text());
 			$.post("/jsp/listCheck", {
			Category : $(ths).text(),
		}, function(data) {
			$('#content').html(data);
		})  
	}
	</script>
</body>
</html>