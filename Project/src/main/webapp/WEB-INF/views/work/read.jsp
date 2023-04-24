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
		<div id='workContentDate'>${work.listDate }</div>

		<div id='workTitle'>
			<div class="contentTitle">${work.listState }</div>
			<div class="contentTitle">[${work.listRegion }]${work.listTitle }</div>
			<div class="contentTitle">${work.listCategory }</div>
			<hr>
			<div id="goChat" style="display: inline;">채팅하기</div>
			<br />
			<div id='won_icon'></div>
			<span>${work.listAmount }원</span>
			<div id='location_icon'></div>
			<span>${work.listRegion}</span>
			<div id='date_icon'></div>
			<span>${work.listFinishDate }</span>
			<div id='time_icon'></div>
			<span>${work.listStartTime }시 ~ ${work.listEndTime }시</span>

		</div>

		<div id='work_blank_65px'></div>

		<div id='workContent'>

			<div id='work_content_detail'>
				<div id='work_content_detail_1'>
					<div id='work_content_user_photo'
						style="background-image: url('../img/logo.png')"></div>
					<div id='work_content_user_name'>${userid }</div>
				</div>

				<div id='work_content_detail_2'>
					<div id='work_view_icon'></div>
					<div id='work_view_num'>${work.listCnt }</div>
					<div id='work_copy_icon'
						onclick="shareMessage()"></div>

					<div id='work_to_list' onclick="BackPage()">목록으로</div>
					<div id='work_content_crud'>
						<div id='work_content_crud_list'>
							<div id='work_content_crud_modify'
								onclick="modifyPageMove(${work.listCode})">수정하기</div>
							<div id='work_content_crud_delete'
								onclick="deleteTrue(${work.listCode})">삭제하기</div>
						</div>
					</div>
				</div>
				<div id='work_content_detail_2_blank'></div>
			</div>

			<div id='work_blank_30px'></div>

			<div id='work_blank_30px'></div>
			<div id='work_content_body'>
				<div id='blank_div'></div>
				<div id='work_content_article'>${work.listContent }</div>


				<div id='work_blank_25px'></div>
				<div id='work_blank_30px'></div>

			</div>

		</div>
	</div>

	<script>

	//'http://192.168.35.20:8080/jsp/index'
	function shareMessage() {
		console.log(Kakao.isInitialized());
	    Kakao.Share.sendDefault({
	      objectType: 'feed',
	      content: {
	        title: '[${work.listRegion}]${work.listTitle}',
	        imageUrl:
	          'https://i.ibb.co/WPqb42s/working-Ant.jpg',
	        link: {
	          // [내 애플리케이션] > [플랫폼] 에서 등록한 사이트 도메인과 일치해야 함
	          mobileWebUrl: 'http://localhost:8080',
	          webUrl: 'http://localhost:8080',
	        },
	      },
	      buttons: [
	        {
	          title: '웹으로 보기',
	          link: {
	            mobileWebUrl:'http://localhost:8080/jsp/index?listCode=${work.listCode}',
	            webUrl: 'http://localhost:8080/jsp/index?listCode=${work.listCode}',
	          },
	        },
	      ],
	      installTalk:true,
	    });
	}
		function BackPage(){
			$("#content").load("/jsp/list");
		}
		function modifyPageMove(listCode){
			console.log("js-modify"+listCode);
			$.post("/jsp/modify", {listCode:listCode}, function(data){
		    	$('#content').html(data);				
		    })  
		}
		function deleteTrue(listCode){
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
			    	console.log(listCode);
			    	$.post("/jsp/remove", {listCode:listCode}, function(data){
				    	$('#content').html(data);				
				    })                   
			    });

			  } else {
			    swal("삭제가 취소되었습니다.");
			  }
			});
		}
	</script>
</body>
</html>