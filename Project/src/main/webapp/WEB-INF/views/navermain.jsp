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
<!--네이버 api 스크립트  -->
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<!--//네이버 api 스크립트  -->
</head>
<body>
	<!--네이버 api 스크립트  body-->
	<script type="text/javascript">
		var naver_id_login = new naver_id_login("d4BfN7Rrtw6r1gxH_amr",
				"http://localhost:8080/naverMain");
		// 접근 토큰 값 출력
		/* alert(naver_id_login.oauthParams.access_token); */
		// 네이버 사용자 프로필 조회
		naver_id_login.get_naver_userprofile("naverSignInCallback()");
		// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
		function naverSignInCallback() {
			/* alert(naver_id_login.getProfileData('email'));
			alert(naver_id_login.getProfileData('nickname'));
			alert(naver_id_login.getProfileData('age')); */
		
			var age = naver_id_login.getProfileData('age');
			var birthday = naver_id_login.getProfileData('birthday');
			var email = naver_id_login.getProfileData('email');
			var enc_id = naver_id_login.getProfileData('enc_id');
			var gender = naver_id_login.getProfileData('gender');
			var id = naver_id_login.getProfileData('id');
			var nickname = naver_id_login.getProfileData('nickname');
			var profile_image = naver_id_login.getProfileData('profile_image');

			//document.getElementById('naver-email').textContent = email;
			document.getElementById('naver-nickname').textContent = nickname;
			//document.getElementById('naver-age').textContent = age;

			console.log("나이 :" + age);
			console.log("생일 :" + birthday);
			console.log("이메일 :" + email);
			console.log("enc_id :" + enc_id);
			console.log("성별 :" + gender);
			console.log("아이디 :" + id);
			console.log("닉네임 :" + nickname);
			console.log("프로필 이미지 :" + profile_image);

			$.ajax({
				url : '/saveNaverUserInfo',
				type : 'POST',
				data : {
					email : email,
					nickname : nickname,
				}
			});
		}
	</script>
	<!--// 네이버 api 스크립트  body-->
	<%-- ${user} --%>
	<jsp:include page="layout/naverheader_logout.jsp" />
	<jsp:include page="layout/nav.jsp" />
	<div id="content">
		<jsp:include page="./content.jsp" />
	</div>
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
	<!-- <div id="naver-profile">
		<p>
			Email: <span id="naver-email"></span>
		</p>
		<p>
			Nickname: <span id="naver-nickname"></span>
		</p>
		<p>
			Age: <span id="naver-age"></span>
		</p>
	</div>  -->

	<script>
		$(document).ready(function() {
			$("#goChat").click(function() {
				window.location.href = "/users/naverchat";
			});
		});
	</script>
</body>
</html>