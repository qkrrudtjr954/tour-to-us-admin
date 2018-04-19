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

<div class="row no-gutters">
	<div class="table-responsive text-center">
		<table class="table table-striped table-sm" id="myTable">
			<col width="5%">
			<col width="10%">
			<col width="30%">
			<col width="30%">
			<col width="25%">
			<thead>
				<tr>
					<th>Check</th>
					<th>No</th>
					<th>이름</th>
					<th>상태</th>
					<th>좋아요 수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${travelers }" var="traveler" varStatus="i">
					<tr>

						<td>
							<input class="traveler_seq" type="checkbox" value="${traveler.target_user_seq }">
						</td>
						<td>${i.index+1 } 위</td>
						<td>${traveler.target_user_name }</td>
						<td>
							<c:choose>
								<c:when test="${traveler.status eq 0 }">
									<span style="color: green;">투둥이</span> 
								</c:when>
								<c:when test="${traveler.status eq 1 }">
									<span style="color: blue;">투디터</span> 
								</c:when>
								<c:otherwise>
									누구냐 넌 
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<img src="${initParam.IMG_SERVER_PATH}/image/heart.png" width="30px" height="30px"> ${traveler.total_likecount }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<div class="row no-gutters">
	<div class="btn-area text-center" style="width: 100%">
		<button id="upgradeBtn" class="btn btn-lg btn-success">진급하기</button>
		<button id="downgradeBtn" class="btn btn-lg btn-danger">강등하기</button>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$('#myTable').DataTable({
            "order": [[ 1, "asc" ]],
		});
	});
	
	function moveToDetail(seq) {
		location.href = 'travelerDetail.do?seq='+seq;
	}
	
	$('#upgradeBtn').on('click', function () {
		var users = [];
		var checked = $('input[class="traveler_seq"]:checked');
		
		for(var i=0; i<$('input[class="traveler_seq"]:checked').length; i++){
			users[i] = parseInt(checked[i].value);
		}
		
		$.ajax({
			url : 'updateLevel.do',
			data : { users : users },
			method : 'POST',
			success : function (data) {
				if(data){
					window.location.reload(true);					
				}
			}
		})
	})
	$('#downgradeBtn').on('click', function () {
		var users = [];
		var checked = $('input[class="traveler_seq"]:checked');
		
		for(var i=0; i<$('input[class="traveler_seq"]:checked').length; i++){
			users[i] = parseInt(checked[i].value);
		}
		
		$.ajax({
			url : 'downdateLevel.do',
			data : { users : users },
			method : 'POST',
			success : function (data) {
				if(data){
					window.location.reload(true);					
				}
			}
		})
	})
</script>
