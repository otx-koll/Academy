<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 로그인 상태유지 쿠키정보 가져오기
Cookie[] cookies = request.getCookies();

if (cookies != null) {
	for (Cookie cookie: cookies) {
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
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="/script/jquery-1.6.1.min.js"></script>

<div class="header">
	<h3><a href="/">HOME</a></h3>
	<nav>
		<ul class="nav nav-pills pull-left">
			<li>
				<a href="/center/notice.jsp">NOTICE</a>
			</li>
			<li>
				<a href="/review/reviewNotice.jsp">REVIEW</a>
			</li>
			<li>
				<a href="/best/award.jsp">CINE</a>
			</li>
		</ul>
		
		<form class="navbar-form navbar-right" role="search">
			<div class="form-group">
				<input type="text" class="form-control" name="search" placeholder="Search">
			</div>
			<input type="submit" value="검색" class="btn btn-default">
			<div class="nav navbar-nav navbar-right">
			<%
			if (id != null) {
				%>
				<%=id %>님 반갑습니다
				<a href="/member/userInfo.jsp">내정보</a>
				<a href="/member/logout.jsp">Logout</a>
				</div>
				<%
			} else { // id == null
				%>
					<a href="/member/login.jsp">Login</a> | <a href="/member/join.jsp">Join</a>
				</div>
				<%
			}
			%>
		</form>
	</nav>
</div>
