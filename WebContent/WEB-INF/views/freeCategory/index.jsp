<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
#addCategory{
    padding-top: 35px;
}
</style>

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
	<h1 class="h2">${doc_title }</h1>
	<div class="btn-toolbar mb-2 mb-md-0">
		<div class="btn-group mr-2">
			<button class="btn btn-sm btn-outline-secondary" onclick="location.href='freeManager.do'">자유게시판</button>
			<button class="btn btn-sm btn-outline-secondary" onclick="location.href='freeCategory.do'">카테고리 관리</button>
		</div>
		<button class="btn btn-sm btn-outline-secondary dropdown-toggle">
			<span data-feather="calendar"></span> This week
		</button>
	</div>
</div>

<div class="row no-gutters">
	<div class="col-md-9">
		<div class="table-responsive">
			<table class="table table-striped table-sm" id="myTable">
				<thead>
					<tr>
						<th>No</th>
						<th>카테고리 제목</th>
						<th>카테고리 설명</th>
						<th>상태 변경</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${categorylist }" var="category" varStatus="i">
						<tr>
							<td>${i.index }</td>
							<td>${category.title }</td>
							<td>${category.description }</td>
							<td>
								<c:choose>
									<c:when test="${category.status == 0 }">
										<button class="btn btn-primary" onclick="changeStatus(this, ${category.seq})">공개</button>
									</c:when>
									<c:when test="${category.status == 1 }">
										<button class="btn btn-danger disabled" onclick="changeStatus(this, ${category.seq})">비공개</button>
									</c:when>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div class="col-md-3">
		<div class="table-responsive" id="addCategory">
			<form action="categoryAdd.do" class="addForm">
				<table class="table table-striped table-sm" id="addtable">
					<thead>
						<tr>
							<th colspan="2" style="text-align: center;">카테고리 추가</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>카테고리 제목</th>
							<td><input type="text" name="title" class="title"></td>
						</tr>
						<tr>
							<th>카테고리 설명</th>
							<td><input type="text" name="description" class="description"></td>
						</tr>
						<tr>
							<td  colspan="2" align="center">					
								<input type="button" class="btn btn-primary" id="addBtn" value="카테고리 추가">
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
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
			url : 'changeCategoryStatus.do',
			method : 'get',
			data : { seq : seq },
			success : function (data) {
				if(data.status == 0){					
					$(button).parent().html('<button class="btn btn-primary" onclick="changeStatus(this, '+data.seq+')">공개</button>');
				}else {					
					$(button).parent().html('<button class="btn btn-danger disabled" onclick="changeStatus(this, '+data.seq+')">비공개</button>');
				}
			}
		})
	}
	
	$("#addBtn").click(function () {
		var title = $(".title").val();
		var description =$(".description").val();
		alert(title+"/"+description);
		
		if(title === ""){
			alert("카테고리 제목을 입력해 주십시오");
			$(".title").focus();
		}else if(description === ""){
			alert("카테고리 설명을 입력해 주십시오");
			$(".description").focus();
		}else{
			$(".addForm").submit();
		}
	});
</script>
