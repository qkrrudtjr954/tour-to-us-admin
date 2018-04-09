
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
	<h1 class="h2">Dashboard</h1>
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
	#totalPlaner-container {
		background: red;
	}
	#dayPlaner-container {
		background: blue;
	}
	#timePlaner-container {
		background: green;
	}
	.planer-info {
		height: 500px;
		margin: 10px;
		overflow-x: hidden;
		overflow-y: scroll;
	}
	.dayPlaner-item {
		padding: 10px;
		margin: 5px;
		width: 100%;
	}
</style>
<div class="row no-gutters">
	<div class="col planer-info" id="totalPlaner-container">
		${planer }
		<button class="btn btn-danger" id="deleteBtn">X</button>
	</div>
	<div class="col planer-info" id="dayPlaner-container">
		<c:forEach items="${dayPlaners }" varStatus="i" var="dayPlaner">
			<div class="row no-gutters">
				<div class="dayPlaner-item"  onclick="getTimePlaner(${dayPlaner.seq })">
					${dayPlaner }
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="col planer-info" id="timePlaner-container">
		
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		
	});
	
	$("#deleteBtn").on('click', function () {
		if(confirm('정말 삭제하시겠습니까?')){
			$.ajax({
				url: 'planerDelete.do',
				data: { seq : ${planer.seq} },
				method: 'GET',
				success: function (data) {
					alert('삭제 됐습니다.');
					console.log(data);
				}
			})
		}
	});
	
	function getTimePlaner(seq) {
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
					data.transportation +
				'</div>'+
			'</div>';
		$('#timePlaner-container').append(html);
	}
</script>
