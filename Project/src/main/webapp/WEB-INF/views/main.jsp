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
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="layout/header_logout.jsp" />
	<jsp:include page="layout/nav.jsp" />
	<div id="content">
		<jsp:include page="./content.jsp" />
	</div>
	<jsp:include page="layout/footer.jsp" />
	
	<script>
	$(function(){
		$('#moveFAQ').on('click', function(){
			$('#content').load('/jsp/faq');
		})
		$('#serviceCenter').on('click', function(){
			$('#content').load('/jsp/faq');
		})
		$('#moveInquiry').on('click', function(){
			$('#content').load('/jsp/inquiry');
		})
		$('#WorkPage').on('click', function(){
			$('#content').load('/user/mypage');
		})
		$('.card').on('click', function(){
			$('#content').load('/jsp/view');
		})
	});
	</script>
</body>
</html>