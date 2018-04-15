
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style>
.upload-img{
	width: 305px;
    height: 360px;
    margin-top: 30px;
    border-top: 2px solid #7DC3BB;
}

.upload-readcount{
	font-size: 13px;
	color: #484848;
	
}

.upload-content{
	font-size: 13px;
	color: #000;
    width: 370px;
}

.row-content{
	margin-top: 10px;
}

.upload-content-sub{
	margin-left: -13px;
}

h2 {
    display: block;
    font-size: 2rem;
    -webkit-margin-before: 0.83em;
    -webkit-margin-after: 0.83em;
    -webkit-margin-start: 0px;
    -webkit-margin-end: 0px;
}

/* #under-line {
    border-bottom: 1px solid #000;
    /* width: 390px; 
    margin-bottom: 10px;
    margin-top: -25px;
} */

#upload-box{
	margin-left: -30px;
    padding: 40px 0 0 160px;

}

#upload-pic-box{
    margin-right: 90px;
    margin-left: 0;
    /* border-right: 1px solid #DCDCDC; */
}

.hr-tag{
	width: 500px;
	margin: 10px 0 10px -10px;
}

.no-gutters{
	padding: 0 0 40px;
    margin: 0 0 0 -80px;

}

</style>

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

<div class="row no-gutters">
	<div class="offset-md-1 col-md-12 col-xs-12">
		<div class="upload-location">
			<h2>${upload.location }</h2>
		</div>
	</div>

	<div class="offset-md-1 col-md-10 col-xs-12">
		<div class="offset-md-10 col-md-8 upload-count">
			<span class="upload-readcount">조회수 : ${upload.readcount }</span>
		</div>
		<hr>
	</div>
	
	<div class="upload-div">
	<div class="row">
		<div class="offset-md-3 col-md-4 ">
			<div class="row no-gutters" id="upload-pic-box">
				<div class="upload-img">
					<img class="upload-img-top"  src="${upload.pic eq null ? 'image/no-img.png' : upload.pic}" width="300px" height="355px">
				</div>
			</div>
		</div>
		<div class="col-md-5" id="upload-box">
			<div class="row upload-body">
				<span class="upload-title" style="font-weight: bold; font-size: 20px;">${upload.title }</span>
			</div>
			<div class="row upload-content-sub">
				<span class="upload-updated" style="font-weight: bold;">업데이트 : </span>&nbsp;<span class="upload-updated">${fn:substring(upload.last_updated, 0, 10) }</span>
				&nbsp;&nbsp;
				<span class="upload-downcount" style="font-weight: bold;">다운로드 수 : </span>&nbsp;<span class="upload-updated">${upload.downcount }</span>
			</div>
			<div class="row col-md-12" id="under-line">
				<hr class="hr-tag">
			</div>
			<div class="row row-content">
				<span class="upload-content" style="fo">추가 설명 : ${upload.content }</span>
			</div>
		</div>
	</div>
</div>
</div>

<div class="d-flex justify-content-center">
	<button class="btn btn-danger btn-lg" id="deleteBtn">자료 삭제하기</button>
</div>

<script>
$("#deleteBtn").on('click', function () {
	if(confirm('정말 삭제하시겠습니까?')){
		$.ajax({
			url: 'uploadDelete.do',
			data: { seq : ${upload.seq} },
			method: 'GET',
			success: function (data) {
				alert('삭제 됐습니다.');
				console.log(data);
			}
		})
	}
});
</script>
