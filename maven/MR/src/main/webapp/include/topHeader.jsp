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
<header>
	<div id="login">
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
	<nav id="top_menu">
		<ul>
			<li><a href="/">HOME</a></li>
		</ul>
	</nav>
</header>