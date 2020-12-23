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
<style>
body{
	margin: 0;
	background-color: black;
	color: white;
}
nav a{
	text-decoration: none;
}
nav a:visited{
	color: gray;
}
nav a:hover{
	background-color: aliceblue;
	color: teal;
}
a{
	text-decoration: none;
	color: aqua;
}
#wrap{
	height: 30px;
	display: flex;
}
#top_menu{
	flex:1;
}

#login {
	flex:2;
}

</style>
<header id="header">

	<div id="wrap">
		<div id="top_menu">
			<nav>
				<a href="/">HOME</a>
				<a href="/center/notice.jsp">NOTICE</a>
				<a href="/review/reviewNotice.jsp">REVIEW</a>
				<a href="/best/award.jsp">CINE</a>
			</nav>
		</div>
		
		<div id="login">
		
			<input type="text" class="input_box" name="search">
			<input type="submit" value="검색" class="btn">
			
			<%
			if (id != null) {
				%>
				<%=id %>님 반갑습니다
				<a href="/member/userInfo.jsp">내정보</a>
				<a href="/member/logout.jsp">Logout</a>
				<%
			} else { // id == null
				%>
				<a href="/member/login.jsp">Login</a> | <a href="/member/join.jsp">Join</a>
				<%
			}
			%>
			
		</div>
	</div>
</header>