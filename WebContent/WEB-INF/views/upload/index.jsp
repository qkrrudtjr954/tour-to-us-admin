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
					<th>자료 제목</th>
					<th>자료 지역</th>
					<th>파일 이름</th>
					<th>상세보기</th>
					<th>상태 변경</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${uploadlist }" var="upload" varStatus="i">
					<tr>
						<td>${i.index }</td>
						<td>${upload.title }</td>
						<td>${upload.location }</td>
						<td>${upload.filename }</td>
						<td><button class="btn btn-primary" onclick="moveToDetail(${upload.seq})">Detail</button></td>
						<td>
							<c:choose>
								<c:when test="${upload.status == 0 }">
									<button class="btn btn-primary" onclick="changeStatus(this, ${upload.seq})">공개</button>
								</c:when>
								<c:when test="${upload.status == 1 }">
									<button class="btn btn-danger disabled">삭제됨</button>
								</c:when>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<div class="d-flex justify-content-center">
	<a class="btn btn-lg btn-primary" href="uploadInsert.do">자료 업로드하기</a>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$('#myTable').DataTable({
			"order" : [ [ 0, "desc" ] ]
		});
	});
	
	function moveToDetail(seq) {
		location.href = 'uploadDetail.do?seq='+seq;
	}
</script>
