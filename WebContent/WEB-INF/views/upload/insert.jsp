
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<fmt:requestEncoding value="UTF-8" />

<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote-bs4.css" rel="stylesheet">


<style>
	.upload-form-label{
		font-size: 20px;
		font-weight: 500;
		width: 20%;
		border-bottom: 2px solid gray;
	}
	
	.uploadForm div.form-group {
		margin-bottom: 20px;
	}
</style>
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
	<div class="offset-md-3 col-md-6">
		<form action="uploadInsertAf.do" method="POST" class="uploadForm">
			<div class="form-group">
				<label class="upload-form-label" for="title">자료 제목</label> 
				<input type="text" class="form-control" id="title" name="title" aria-describedby="emailHelp" placeholder="Title"> 
			</div>
			
			<div class="form-row d-flex align-items-center">
				<div class="form-group col-md-9">
					<label class="upload-form-label" for="pic">표지</label>
					<br> 
					<input type="file" id="pic-temp">
					<input type="hidden" name="pic" value="no-cover.png">
				</div>
				<div class="form-group col-md-3">
					<img id="show-cover" alt="" src="${initParam.IMG_SERVER_PATH }/image/no-cover.png" width="100%" style="border:1px solid gray;">
				</div>
			</div>

			<div class="form-group">
				<label class="upload-form-label" for="title">파일</label>
				<br> 
				<input type="file" name="filename">
			</div>

			<div class="form-group">
				<label class="upload-form-label" for="title">지역</label> 
				<select class="form-control" id="location" name="location" style="width: 200px">
				<c:forEach var="part" items="${korea }">
					<option>${part.name }</option>
				</c:forEach>
			</select>
			</div>
	
			<div class="form-group">
				<label class="upload-form-label" for="title">내용</label> 
				<div class="row no-gutters">
					<textarea id="summernote" name="content"></textarea>
				</div>
			</div>
			
			<div class="d-flex justify-content-center">
				<input class="btn btn-primary btn-lg" type="submit" value="자료 등록하기">
			</div>
		</form>
	</div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote-bs4.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#summernote').summernote({
		height : 300, // set editor height
		width: '100%',
		minHeight : null, // set minimum height of editor
		maxHeight : null, // set maximum height of editor
		focus : true, // set focus to editable area after initializing summernote
		lang : 'ko-KR',
		callbacks : {
			onImageUpload : function(files, editor,welEditable) {
				sendFile(files[0], this);
			},
		},toolbar : [['style',['bold', 'italic', 'underline', 'clear' ] ],
					['font',['strikethrough', 'superscript', 'subscript' ] ],
					[ 'fontsize',[ 'fontsize' ] ],
					[ 'color', [ 'color' ] ],
					['para',[ 'ul', 'ol','paragraph' ] ],
					[ 'height',[ 'height' ] ],
					[ 'insert',[ 'picture' ] ] ]
		});
});

function sendFile(file, editor) {
	var formData = new FormData();
	formData.append("userImage", file);
	
	$.ajax({
			data : formData, 
			type : "POST",
			url : '${initParam.IMG_SERVER_PATH}/upload',
			cache : false,
			contentType : false,
			processData : false,
			success : function(data) {
			console.log(data);
				var url = '${initParam.IMG_SERVER_PATH }/image/'+ data.filename;
				$(editor).summernote('editor.insertImage', url);
			}
	});
}

$('#pic-temp').change(function() {
	sendCoverPicture(this.files[0]);
});

function sendCoverPicture(file, dom) {
	formdata = new FormData();
	formdata.append("userImage", file);
	$.ajax({
		data : formdata,
		type : "POST",
		url : '${initParam.IMG_SERVER_PATH}/upload',
		cache : false,
		contentType : false,
		processData : false,
		success : function(data) {
			var filename = data.filename;

			$('input[name="pic"]').val(filename);
			$('#show-cover').attr('src', '${initParam.IMG_SERVER_PATH}/image/' + filename);

		}
	});
}

$('input[name="filename"]').change(function() {
	if(this.files[0] != null){		
		sendPdfFile(this.files[0], this);
	}
});

function sendPdfFile(file, dom) {
	formdata = new FormData();
	formdata.append("guideFile", file);
	$.ajax({
		data : formdata,
		type : "POST",
		url : '${initParam.FILE_SERVER_PATH }/upload',
		cache : false,
		contentType : false,
		processData : false,
		success : function(data) {
			var filename = data.filename;

			$(this).val(filename);
		}
	});
}
</script>
