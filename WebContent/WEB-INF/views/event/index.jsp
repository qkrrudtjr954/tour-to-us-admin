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

<a href="eventInsert.do">이벤트 작성하기</a>

<div class="row no-gutters">
	<div class="table-responsive">
		<table class="table table-striped table-sm" id="myTable">
			<thead>
				<tr>
					<th>No</th>
					<th>이벤트 제목</th>
					<th>카테고리</th>
					<th>행사 기간</th>
					<th>상세보기</th>
					<th>상태 변경</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${events }" var="event" varStatus="i">
					<tr>
						<td>${i.index }</td>
						<td>${event.title }</td>
						<td>${event.category }</td>
						<td>${event.from_date } ~ ${event.to_date }</td>
						<td><button class="btn btn-success" onclick="moveToDetail(${event.seq})">Detail</button></td>
						<td>
							<c:choose>
								<c:when test="${event.status == 0 }">
									<button class="btn btn-primary" onclick="changeStatus(this, ${event.seq})">공개</button>
								</c:when>
								<c:when test="${event.status == 2 }">
									<button class="btn btn-danger disabled">삭제됨</button>
								</c:when>
								<c:otherwise>
									<button class="btn btn-warning" onclick="changeStatus(this, ${event.seq})">비공개</button>								
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$('#myTable').DataTable({
			"order" : [ [ 0, "desc" ] ]
		});
	});
	
	function changeStatus(button, seq){
		$.ajax({
			url : 'changeEventStatus.do',
			method : 'POST',
			data : { seq : seq },
			success : function (data) {
				if(data.status == 0){					
					$(button).parent().html('<button class="btn btn-primary" onclick="changeStatus(this, '+seq+')">공개</button>');
				}else {					
					$(button).parent().html('<button class="btn btn-warning" onclick="changeStatus(this, '+seq+')">비공개</button>');
				}
			}
		})
	}
	
	function moveToDetail(seq) {
		location.href = 'eventDetail.do?seq='+seq;
	}
</script>
