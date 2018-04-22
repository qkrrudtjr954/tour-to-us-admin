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
	<div class="table-responsive">
		<table class="table table-striped table-sm" id="myTable">
			<thead>
				<tr>
					<th>No</th>
					<th>플래너 제목</th>
					<th>여행 지역</th>
					<th>여행 기간</th>
					<th>상태</th>					
					<th>상세보기</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${planers }" var="planer" varStatus="i">
					<tr>
						<td>${i.index }</td>
						<td>${planer.title }</td>
						<td>${planer.location }</td>
						<td>${planer.from_date } ~ ${planer.to_date }</td>
						<td>
							<c:choose>
								<c:when test="${planer.status == 0 }">
									<button class="btn btn-warning">미완료</button>
								</c:when>
								<c:when test="${planer.status == 1 }">
									<button class="btn btn-success">완료(공개)</button>
								</c:when>
								<c:when test="${planer.status == 2 }">
									<button class="btn btn-success">완료(비공개)</button>
								</c:when>
								<c:when test="${planer.status == 3 }">
									<button class="btn btn-danger disabled">user삭제</button>
								</c:when>
								<c:when test="${planer.status == 4 }">
									<button class="btn btn-danger disabled">admin삭제</button>	</c:when>
							</c:choose>
						</td>
						<td><button class="btn btn-primary" onclick="moveToDetail(${planer.seq})">Detail</button></td>
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
	
	function moveToDetail(seq) {
		location.href = 'planerDetail.do?seq='+seq;
	}
</script>
