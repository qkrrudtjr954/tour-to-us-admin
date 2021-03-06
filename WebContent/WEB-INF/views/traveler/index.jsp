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
					<th>이름</th>
					<th>Email</th>
					<th>상세보기</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${travelers }" var="traveler" varStatus="i">
					<tr>
						<td>${i.index }</td>
						<td>${traveler.name }</td>
						<td>${traveler.email }</td>
						<td><button class="btn btn-primary" onclick="moveToDetail(${traveler.seq})">+</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$('#myTable').DataTable({
            "order": [[ 0, "desc" ]],
		});
	});
	
	function moveToDetail(seq) {
		location.href = 'travelerDetail.do?seq='+seq;
	}
</script>
