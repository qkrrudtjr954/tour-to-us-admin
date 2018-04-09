
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote-bs4.css" rel="stylesheet">

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
<!-- 
	private String category;
	private String title;
	private String content;
	private String from_date;
	private String to_date;
	private String last_dated;
	private String reg_date;
	 -->
<div class="row no-gutters">
	<form action="eventInsert.do" method="POST">
		<select class="custom-select" name="category">
			<option selected>Category</option>
			<option value="호텔">호텔</option>
			<option value="관광">관광</option>
			<option value="항공">항공</option>
		</select>

		<div class="form-check form-check-inline">
			<input class="form-check-input" type="radio" name="status" id="status1" value="0">
			<label class="form-check-label" for="inlineRadio1">공개</label>
		</div>
		<div class="form-check form-check-inline">
			<input class="form-check-input" type="radio" name="status" id="status2" value="1">
			<label class="form-check-label" for="inlineRadio2">비공개</label>
		</div>

		<input type="date" name="from_date" class="form-control">
		<input type="date" name="to_date" class="form-control">
		
		<input type="text" name="title" class="form-control">
		
		<textarea id="summernote" name="content"></textarea>
		<input type="submit" value="이벤트 등록하기">
	</form>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote-bs4.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#summernote').summernote({
		height : 300, // set editor height
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
</script>
