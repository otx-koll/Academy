<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%-- head 컨텐트 영역 --%>
<jsp:include page="/WEB-INF/views/include/headContent.jsp" />

<link href="/css/subpage.css" rel="stylesheet" type="text/css"  media="all">
</head>

<body>
<div id="wrap">
<<<<<<< HEAD
    <!-- header 영역 -->
	<jsp:include page="/WEB-INF/views/include/topHeader.jsp"/>
=======
	<%-- header 영역 --%>
	<jsp:include page="/WEB-INF/views/include/topHeader.jsp" />
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
	
	<div class="clear"></div>
	<div id="sub_img_member"></div>
	
	<div class="clear"></div>
	<nav id="sub_menu">  
        <ul>
            <li> <a href="#">Join us</a></li>
            <li> <a href="#">Privacy policy</a></li>
    	</ul>
	</nav>
	
	<article>
		<h1>로그인</h1>
<<<<<<< HEAD
		<form action="loginPro.jsp" method="post" id="join">
=======
		<form action="memberLoginPro.do" method="post" id="join">
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
			<fieldset>
				<legend>Login Info</legend>
				
				<label>User ID</label>
				<input type="text" name="id"><br>
				
				<label>Password</label>
				<input type="password" name="passwd"><br>
				
				<label>로그인 상태 유지</label>
				<input type="checkbox" name="keepLogin" value="true">
				체크하면 10분 동안 로그인 상태가 유지됩니다.
				<br>
			</fieldset>
			
			<div class="clear"></div>
			<div id="buttons">
				<input type="submit" value="로그인" class="submit">
<<<<<<< HEAD
				<input type="button" value="초기화" class="cancel">
=======
				<input type="reset" value="초기화" class="cancel">
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
			</div>
		</form>
	</article>
	
	<div class="clear"></div>
<<<<<<< HEAD
	<!-- footer 영역 -->
	<jsp:include page="/WEB-INF/views/include/bottomFooter.jsp"/>
=======
	<%-- footer 영역 --%>
	<jsp:include page="/WEB-INF/views/include/bottomFooter.jsp" />
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
</div>

</body>
</html>   

<<<<<<< HEAD
=======
    
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
