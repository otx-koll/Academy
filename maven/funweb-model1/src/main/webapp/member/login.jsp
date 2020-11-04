<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%-- head 컨텐트 영역 --%>
<jsp:include page="/include/headContent.jsp" />
</head>

<body>
<div id="wrap">
    <!-- header 영역 -->
	<jsp:include page="/include/topHeader.jsp"/>
	
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
		<h1>Login</h1>
		<form action="" id="join">
			<fieldset>
				<legend>Login Info</legend>
				<label>User ID</label>
				<input type="text" name="id"><br>
				<label>Password</label>
				<input type="password" name="pass"><br>
			</fieldset>
			
			<div class="clear"></div>
			<div id="buttons">
				<input type="button" value="Submit" class="submit">
				<input type="button" value="Cancel" class="cancel">
			</div>
		</form>
	</article>
	
	<div class="clear"></div>
	<!-- footer 영역 -->
	<jsp:include page="/include/bottomFooter.jsp"/>
</div>

</body>
</html>   

