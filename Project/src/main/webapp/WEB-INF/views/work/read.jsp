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
<link rel="stylesheet" href="../css/work.css">
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
			<div id ="goChat"
				style="display:inline;">채팅하기
		</div>
		<br />
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