<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>
</head>
<body>
	<div id="contentbody" class="bs-component">
		<img id="contentImg" src="../img/content.png">
	
		<div id="antHot">
			<h2>일개미 인기 일자리</h2>
			<div id="antHotCards">
				<c:forEach var="i" begin="1" end="5">
					<div class="card graytext">
						<h4 class="card-title">애완견 산책</h4>
						<div class="card-body">
							<div class="cardImg"></div>
							<div>10,000원</div>
							<div>위치 : 여의도</div>
							<a href="#" class="btn btn-primary">More</a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		
	</div>
	</div>
</body>
</html>