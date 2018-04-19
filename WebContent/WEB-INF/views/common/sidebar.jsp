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
					<span data-feather="send"></span>플래너 관리
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="eventManager.do" id="event"> 
					<span data-feather="gift"></span>이벤트 관리
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="reviewManager.do" id="review"> 
					<span data-feather="book"></span>여행 후기 관리
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="freeManager.do" id="free"> 
					<span data-feather="align-center"></span>자유 게시판 관리
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="todoongManager.do" id="guide"> 
					<span data-feather="book-open"></span>가이드 관리
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="dataUploadList.do" id="upload"> 
					<span data-feather="upload"></span>자료 업로드 
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="userLevel.do" id="level"> 
					<span data-feather="award"></span>진급하기  
				</a>
			</li>
		</ul>
		
		<script type="text/javascript">
			var id = '${menu_id}';
			$('.nav-item').children().removeClass('active');
			$('#'+id).addClass('active');
		</script>
	</div>
</nav>