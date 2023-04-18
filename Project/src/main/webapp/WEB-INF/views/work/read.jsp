<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- sweetalert -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<style>
@charset "UTF-8";

#workMain {
	display: grid;
	grid-template-columns: 1fr;
}

#workMain #workContentDate {
	text-align: end;
	width:80%;
	margin:20px auto;
	font-size: 0.8rem;
}

#won_icon{
	background-image: url('../img/won-icon.png');
	background-size: cover;
	width: 20px;
	height: 20px;
	margin-right:5px;
	display: inline-block;
}
#location_icon{
	margin-left:30px;
	background-image: url('../img/location-icon.png');
	background-size: cover;
	width: 20px;
	height: 20px;
	margin-right:5px;
	display: inline-block;
}
#date_icon{
	margin-left:30px;
	background-image: url('../img/date-icon.png');
	background-size: cover;
	width: 20px;
	height: 20px;
	margin-right:5px;
	display: inline-block;
}#time_icon{
	margin-left:30px;
	background-image: url('../img/time-icon.png');
	background-size: cover;
	width: 20px;
	height: 20px;
	margin-right:5px;
	display: inline-block;
}
#contentImg{
	width:50%;
}
#work_blank_65px {
	height: 65px;
}

#work_blank_30px {
	height: 30px;
}

#workTitle {
	height: fit-content;
	width: 80%;
	margin: auto;
	border-radius:10px;
	box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px,
		rgba(60, 64, 67, 0.15) 0px 2px 6px 2px;
	padding: 20px;
}

#workTitle .contentTitle{
	margin-bottom: 10px;
}

#workTitle div:nth-child(2) {
	font-size: 1.3rem;
	font-weight: bolder;
	color: black;
}

#workTitle div:nth-child(1) {
	color: #ffc022;
	border: 1px solid #ffc022;
	background-color: #ffc02210;
	width: fit-content;
	padding: 3px;
	border-radius: 5px;
}

#workTitle div:nth-child(3), #workTitle div:nth-child(1), #workTitle span {
	font-size: 0.8rem;
}

#workTitle span:nth-child(1){
	color:#ffc022;
	font-weight:bolder;
}

#work_title_location {
	background-color: #FECCBE;
	width: 60px;
	padding: 1px;
	color: #ff6347;
	border-radius: 20%;
	text-align: center;
}

#workContent {
	display: grid;
	width: 70%;
	margin: auto;
	line-height: 30px;
}

#work_content_detail {
	display: grid;
	grid-template-columns: 1fr;
	gap: 5px;
	border-bottom:solid #9e9ea447 1px;
}

#work_content_detail_1 {
	display: grid;
	grid-template-columns: auto auto 1fr;
	gap: 5px;
}

#work_content_user_photo {
	background-image: url('../img/logo.png');
	background-size: cover;
	width: 30px;
	height: 30px;
	align-self: end;
	border-radius: 50%;
}

#work_content_detail_2 {
	display: grid;
	grid-template-columns: 30px auto auto auto auto auto 1fr;
	gap: 5px;
}

#work_view_icon {
	background-image: url('../img/view-icon.png');
	background-size: cover;
	width: 15px;
	height: 15px;
	align-self: start;
	grid-column: 2/3;
}

#work_view_num {
	line-height: 15px;
	grid-column: 3/4;
}

#work_to_list {
	justify-self: end;
	grid-column: 7/8;
	align-self: start;
}

#work_to_list:hover {
	cursor: pointer;
	color:black;
}

#work_content_crud {
	right: 10px;
	background-image: url('../img/menu-icon.png');
	background-size: cover;
	width: 15px;
	height: 15px;
	justify-self: end;
	align-self: center;
	grid-column: 8/9;
}

#work_content_crud_list {
	width: 4vw;
	display: grid;
	grid-template-rows: repeat(3, 1fr);
	box-shadow: rgb(38, 57, 77) 0px 20px 30px -10px;
	font-size: 0.5rem;
	gap: 3px;
}

#work_content_crud:hover {
	cursor: pointer;
	transform: scale(1.2);
}

#work_content_crud:hover #work_content_crud_modify, #work_content_crud:hover #work_content_crud_delete
	{
	display: block;
	cursor: pointer;
	z-index: 3;
}

#work_content_crud_modify {
	grid-row: 2/3;
	background-color: white;
	padding: 2px;
	display: none;
}

#work_content_crud_delete {
	grid-row: 3/4;
	background-color: white;
	padding: 2px;
	display: none;
}

#work_copy_icon {
	background-image: url('../img/copy-url-icon.png');
	background-size: cover;
	width: 15px;
	height: 15px;
	justify-self: start;
	grid-column: 6/7;
}

#work_copy_icon:hover {
	cursor: pointer;
	transform: scale(1.2);
}
#work_content_user_name, #workTitle span{
	color:#262b3f;
}
#work_content_plan_day {
	background-color: #FECCBE;
	width: 60px;
	padding: 2px;
	color: #ff6347;
	border-radius: 20%;
	text-align: center;
}

#work_blank_25px {
	height: 25px;
	border-bottom: 1px dashed black;
}

#work_content_title {
	font-size: 1.2rem;
	font-weight: bolder;
}

#work_content_article {
	min-height: 50vh;
}

#work_content_article img {
	width: 70%;
	margin: auto;
}

#ri_content_plan_day {
	background-color: #f1f6fa;
	width: 60px;
	padding: 2px;
	color: #3f8ef1;
	border-radius: 20%;
	text-align: center;
	display: inline-block;
	margin-right: 25px;
}

.spanclass {
	display: none;
}
</style>
<title>WorkView</title>
</head>
<body>
	<div id='workMain'>
		<div id='workContentDate'>2023-04-18 16:00:58</div>

		<div id='workTitle'>
			<div class="contentTitle">진행중</div>
			<div class="contentTitle">[위치]벌레좀 잡아주세요!!</div>
			<div class="contentTitle">주거/바퀴벌레</div>
			<hr>
			<div id='won_icon'></div>
			<span>10,000원</span>
			
			<div id='location_icon'></div>
			<span>위치</span>
			<div id='date_icon'></div>
			<span>2023-04-28</span>
			<div id='time_icon'></div>
			<span>9시 ~ 12시</span>
			
		</div>

		<div id='work_blank_65px'></div>

		<div id='workContent'>

			<div id='work_content_detail'>
				<div id='work_content_detail_1'>
					<div id='work_content_user_photo'
						style="background-image: url('../img/logo.png')"></div>
					<div id='work_content_user_name'>닉네임</div>
				</div>

				<div id='work_content_detail_2'>
					<div id='work_view_icon'></div>
					<div id='work_view_num'>78</div>
					<div id='work_copy_icon'></div>

					<div id='work_to_list' onclick="BackPage()">목록으로</div>
					<div id='work_content_crud'>
						<div id='work_content_crud_list'>
							<div id='work_content_crud_modify' onclick="modifyPageMove()">수정하기</div>
							<div id='work_content_crud_delete' onclick="deleteTrue()">삭제하기</div>
						</div>
					</div>
				</div>
				<div id='work_content_detail_2_blank'></div>
			</div>

			<div id='work_blank_30px'></div>
			
			<div id='work_blank_30px'></div>
			<div id='work_content_body'>
					<div id='blank_div'></div>
					<img id="contentImg" src="../img/helpAnt.png">
					<div id='work_blank_30px'></div>
					<div id='work_content_article'>dpfpfpdkajflekw;lahgjksdpfhewjfnbjv</div>
				

				<div id='work_blank_25px'></div>
				<div id='work_blank_30px'></div>

			</div>

		</div>
	</div>
	<script>
		function BackPage(){
			$("#content").load("/jsp/list");
		}
		function modifyPageMove(){
			$("#content").load("/jsp/modify");
		}
		function deleteTrue(){
		swal({
			  title: "정말 삭제하시겠습니까?",
			  text: "한번 지우면 되돌릴 수 없습니다!",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
			    swal("지워졌습니다!", {
			      icon: "success",
			    }).then(function(){
			    	$("#content").load("/jsp/list");                   
			    });

			  } else {
			    swal("삭제가 취소되었습니다.");
			  }
			});
		}
	</script>
</body>
</html>