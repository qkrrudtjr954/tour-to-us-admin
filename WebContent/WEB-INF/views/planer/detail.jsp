
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
	<h1 class="h2">${doc_title }</h1>
	<div class="btn-toolbar mb-2 mb-md-0">
		<div class="btn-group mr-2">
			<button class="btn btn-sm btn-outline-secondary">Share</button>
			<button class="btn btn-sm btn-outline-secondary">Export</button>
		</div>
		<button class="btn btn-sm btn-outline-secondary dropdown-toggle">
			<span data-feather="calendar"></span> This week
		</button>
	</div>
</div>
<style>
	
	.planer-info {
		height: 500px;
		margin: 10px;
		overflow-x: hidden;
		overflow-y: scroll;
	}
	
	.totalPlaner-item ul li,
	.dayPlaner-item ul li,
	.timePlaner-item ul li{
		font-size: 20px;
	}
	.dayPlaner-item {
		cursor: pointer;
	}
	.totalPlaner-item,
	.dayPlaner-item,
	.timePlaner-item {
		border: 2px solid gray;
		border-radius: 10px;
		padding: 10px;
		margin: 5px;
		width: 100%;
	}
	
	
	.full-dayPlaner,
	.full-timePlaner {
		border: 2px solid gray;
		border-radius: 10px;
		padding: 10px;
		margin: 5px;
	}
	.full-dayPlaner {
		background-color: gray;
		width: 100%;
	}
	.full-timePlaner {
		width: 50%;
	}
</style>

<div class="row no-gutters">
	<div class="alert alert-dark text-center" role="alert" style="width:100%;font-size: 20px;">
		${traveler.like1 }&nbsp;${traveler.like2 }&nbsp;${traveler.like3 }&nbsp; <b>${traveler.name }</b>님의 여행 플랜		
	</div>
</div>
<div class="row no-gutters">
	<div class="col planer-info" id="totalPlaner-container">
		<div class="row no-gutters">
			<div class="totalPlaner-item">
				<ul>
					<li>${planer.title }</li>
					<li>${planer.location }</li>
					<li>${planer.from_date } ~ ${planer.to_date }</li>
					<li>${planer.name }</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="col planer-info" id="dayPlaner-container">
		<c:forEach items="${dayPlaners }" varStatus="i" var="dayPlaner">
			<div class="row no-gutters">
				<div class="dayPlaner-item"  onclick="getTimePlaner(${dayPlaner.seq }, this)">
					<ul>
						<li>일정 : ${dayPlaner.day }</li>
						<li>일차 : ${dayPlaner.day_count } 일 차</li>
					</ul>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="col planer-info" id="timePlaner-container"></div>
</div>

<div class="d-flex justify-content-center">
	<button class="btn btn-danger" id="deleteBtn">Planer 삭제하기</button>&nbsp;&nbsp;&nbsp;
	<button class="btn btn-primary" data-toggle="collapse" data-target="#fullPlaner" aria-expanded="false" aria-controls="fullPlaner">
		Planer 전체 보기 
	</button>
</div>

<div class="row no-gutters">
	<div class="collapse" id="fullPlaner" style="width:100%;">
		<div class="card card-body">
			<c:forEach items="${subPlaners.keySet() }" var="dayPlaner" varStatus="i">
				<div class="row no-gutters">
					<div class="full-dayPlaner">
						<ul>
							<li>일정 : ${dayPlaner.day }</li>
							<li>일차 : ${dayPlaner.day_count } 일 차</li>
						</ul>
					</div>
				</div>
				<c:forEach items="${subPlaners.get(dayPlaner) }" var="timePlaner" varStatus="i">
					<div class="d-flex justify-content-center">
						<div class="full-timePlaner">
							<ul>
								<li>${timePlaner.start_time } ~ ${timePlaner.end_time }</li>
								<li>${timePlaner.transportation }</li>
								<li>${timePlaner.location }</li>
								<li>${timePlaner.expected_cost }</li>
								<li>${timePlaner.types }</li>
								<li>${timePlaner.content }</li>
							</ul>
						</div>
					</div>
				</c:forEach>
			</c:forEach>
		</div>
	</div>
</div>


<script type="text/javascript">
	$(document).ready(function() {
		$('.dayPlaner-item')[0].click();
	});
	
	$("#deleteBtn").on('click', function () {
		if(confirm('정말 삭제하시겠습니까?')){
			$.ajax({
				url: 'planerDelete.do',
				data: { seq : ${planer.seq} },
				method: 'GET',
				success: function (data) {
					alert('삭제 됐습니다.');
					location.href="planerManager.do";
				}
			})
		}
	});
	
	function getTimePlaner(seq, DOM) {
		$('.dayPlaner-item').css('background-color', 'white');
		$(DOM).css('background-color', 'gray');
		
		$('#timePlaner-container').children().remove();
		$.ajax({
			url: 'getTimePlaner.do',
			data: { seq : seq },
			method : 'GET',
			success : function (data) {
				for(var i=0; i<data.length; i++){
					drawHtml(data[i]);
				}
			}
		})
	}
	function drawHtml(data) {
		var html = 
			'<div class="row no-gutters">'+
				'<div class="timePlaner-item">'+
					'<ul>'+
						'<li>' + data.start_time + ' ~ ' + data.end_time + '</li>'+
						'<li>'+ data.transportation +'</li>'+
						'<li>'+ data.location +'</li>'+
						'<li>'+ data.expected_cost +'</li>'+
						'<li>'+ data.types+'</li>'+
						'<li>'+ data.content+'</li>'+
					'</ul>'+
				'</div>'+
			'</div>';
		$('#timePlaner-container').append(html);
	}
</script>
