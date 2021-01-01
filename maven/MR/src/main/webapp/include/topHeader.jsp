<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 로그인 상태유지 쿠키정보 가져오기
Cookie[] cookies = request.getCookies();

if (cookies != null) {
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals("id")) {
	String id = cookie.getValue();

	// 로그인 인증 처리(세션에 id값 추가)
	session.setAttribute("id", id);
		}
	}
}

// 세션값 가져오기
String id = (String) session.getAttribute("id");
// 세션값 있으면	..님 반가워요~	[로그아웃]으로 바뀌고 [회원가입]은 없어짐
// 세션값 없으면 [로그인] [회원가입]
%>

<link href="/css/bootstrap.css" rel="stylesheet">
<script src="/script/jquery-1.6.1.min.js"></script>

<style>
img {width:30px;}
.navbar-brand{padding:2px;}
body {background-color: #2E2E2E;}
nav {
	margin: 40px 0 30px;
}
.wrap{
	background-color: #ebebeb;
	padding: 50px;
	border-radius: 5px;
	margin-bottom: 20px;
}
</style>

<nav class="navbar navbar-expand-lg navbar-light bg-light rounded">

	<a class="navbar-brand" href="/">
		<img src="/img/movie_icon.png"/>
	</a>
	
	<div class="collapse navbar-collapse" id="navbarText">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item">
				<a class="nav-link" href="/center/notice.jsp">NOTICE</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/review/reviewNotice.jsp">REVIEW</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/review/bestReview.jsp">CINE</a>
			</li>
		</ul>
		
		<form class="form-inline my-2 my-lg-0" role="search">
			<input type="text" class="form-control mr-sm-2" name="search" placeholder="Search">
			<input type="submit" value="검색" class="btn btn-dark my-2 my-sm-0" style="margin: 0 20px 0 0;">
		</form>
		
		<div class="nav navbar-nav navbar-right">
		<%
		if (id != null) {
			%>
			<span class="nav-link">
				<%=id %>님 반갑습니다
			</span>
			<a class="nav-link" href="/member/info.jsp">내정보</a>
			<a class="nav-link" href="/member/logout.jsp">Logout</a>
			</div>
			<%
		} else { // id == null
			%>
			<a class="nav-link" href="/member/login.jsp">Login</a>
			<span class="nav-link" style="color:lightgray;">|</span>
			<a class="nav-link" href="/member/join.jsp">Join</a>
			</div>
			<%
		}
		%>
	</div>
</nav>