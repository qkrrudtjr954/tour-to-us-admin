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
	<table class="table">
		<tr>
			<td colspan="2">
				<img alt="" src="${initParam.IMG_SERVER_PATH }/image/${traveler.profile}" width="50px" height="50px">
			</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${traveler.name }</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${traveler.email }</td>
		</tr>
		<tr>
			<th>계급</th>
			<td>
				<c:choose>
					<c:when test="${traveler.author eq 0 }">
						투둥이 
					</c:when>
					<c:when test="${traveler.author eq 1 }">
						투디터 
					</c:when>
					<c:otherwise>
						누구냐 넌 
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<div class="d-flex justify-content-center" style="width: 100%;">
					<button id="upgradeBtn" class="btn btn-lg btn-success">진급하기</button>
					<button id="downgradeBtn" class="btn btn-lg btn-danger">강등하기</button>
				</div>
			</td>
		</tr>
	</table>
</div>

<script type="text/javascript">
$('#upgradeBtn').on('click', function () {
	var users = [];
	users[0] = ${traveler.seq};
	
	$.ajax({
		url : 'updateLevel.do',
		data : { users : users },
		method : 'POST',
		success : function (data) {
			if(data){
				alert('상태가 변경되었습니다.');
				window.location.reload(true);					
			}
		}
	})
})
$('#downgradeBtn').on('click', function () {
	var users = [];
	users[0] = ${traveler.seq};
	
	$.ajax({
		url : 'downdateLevel.do',
		data : { users : users },
		method : 'POST',
		success : function (data) {
			if(data){
				alert('상태가 변경되었습니다.');
				window.location.reload(true);					
			}
		}
	})
})
</script>
