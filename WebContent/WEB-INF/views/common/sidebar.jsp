<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="col-md-2 d-none d-md-block bg-light sidebar">
	<div class="sidebar-sticky">
		<ul class="nav flex-column">
			<li class="nav-item">
				<a class="nav-link" href="main.do" id="home"> 
					<span data-feather="home"></span>Home
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="travelerManager.do" id="traveler"> 
					<span data-feather="users"></span>유저 관리
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="planerManager.do" id="planer"> 
					<span data-feather="book"></span>플래너 관리
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="eventManager.do" id="event"> 
					<span data-feather="book"></span>이벤트 관리
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="reviewManager.do" id="review"> 
					<span data-feather="book"></span>여행 후기 관리
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="" id="free"> 
					<span data-feather="book"></span>자유 게시판 관리
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="" id="guide"> 
					<span data-feather="book"></span>가이드 관리
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="dataUploadList.do" id="upload"> 
					<span data-feather="book"></span>자료 업로드 
				</a>
			</li>
		</ul>
		
		<script type="text/javascript">
			var id = '${menu_id}';
			$('.nav-item').children().removeClass('active');
			$('#'+id).addClass('active');
		</script>
		
		


		<h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
			<span>Saved reports</span> 
			<a class="d-flex align-items-center text-muted" href="#"> 
				<span data-feather="plus-circle"></span>
			</a>
		</h6>
		<ul class="nav flex-column mb-2">
			<li class="nav-item"><a class="nav-link" href="#"> <span data-feather="file-text"></span> Current month </a></li>
			<li class="nav-item"><a class="nav-link" href="#"> <span data-feather="file-text"></span> Last quarter </a></li>
			<li class="nav-item"><a class="nav-link" href="#"> <span data-feather="file-text"></span> Social engagement </a></li>
			<li class="nav-item"><a class="nav-link" href="#"> <span data-feather="file-text"></span> Year-end sale </a></li>
		</ul>
	</div>
</nav>