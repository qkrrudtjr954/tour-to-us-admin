
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
	<div class="offset-md-2 col-md-8">
		<div class="event-container">
			<div class="event-title d-flex justify-content-center align-items-center">
				<span class="badge badge-pill" style="background-color: #7DC3BB; color: #fff">${free.category }</span>&nbsp;&nbsp;
				<h1>${free.title }</h1>
			</div>
			<hr>
			<div class="event-content">
				${free.content }
			</div>
		</div>
	</div>
</div>
<div class="d-flex justify-content-center">
	<button class="btn btn-danger btn-lg" id="deleteBtn">자유게시판 삭제하기</button>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		
	});
	
	$("#deleteBtn").on('click', function () {
		if(confirm('정말 삭제하시겠습니까?')){
			$.ajax({
				url: 'freeDelete.do',
				data: { seq : ${free.seq} },
				method: 'GET',
				success: function (data) {
					alert('삭제 됐습니다.');
					console.log(data);
				}
			})
		}
	});
</script>
