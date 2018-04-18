<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
	<h1 class="h2">${doc_title }</h1>
	<div class="btn-toolbar mb-2 mb-md-0">
		<div class="btn-group mr-2">
			<button class="btn btn-sm btn-outline-secondary" onclick="location.href='todoongManager.do'">투둥이 관리</button>
			<button class="btn btn-sm btn-outline-secondary" onclick="location.href='toditorManager.do'">투디터 관리</button>
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
					<th>투둥이 제목</th>
					<th>여행 지역</th>
					<th>여행기간</th>
					<th>상세 보기</th>
					<th>공개 여부</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todoonglist }" var="todoong" varStatus="i">
					<tr>
						<td>${i.index }</td>
						<td>${todoong.title }</td>
						<td>${todoong.location }</td>
						<td>${todoong.from_date } ~ ${todoong.to_date }</td>
						<td><button class="btn btn-success" onclick="moveToDetail(${todoong.seq})">Detail</button></td>
						<td>
							<c:choose>
								<c:when test="${todoong.status == 0 }">
									<button class="btn btn-secondary">진행중</button>
								</c:when>
								<c:when test="${todoong.status == 1 }">
									<button class="btn btn-primary">공개</button>
								</c:when>
								<c:when test="${todoong.status == 2 }">
									<button class="btn btn-primary">비공개</button>
								</c:when>
								<c:when test="${todoong.status == 3 }">
									<button class="btn btn-danger disabled">user삭제</button>
								</c:when>
								<c:when test="${todoong.status == 4 }">
									<button class="btn btn-danger disabled">admin삭제</button>	</c:when>
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
	function moveToDetail(seq) {
		location.href = 'todoongGuideDetail.do?seq='+seq;
	}
</script>
