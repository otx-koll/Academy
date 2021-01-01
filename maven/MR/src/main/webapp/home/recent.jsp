<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.project.vo.ForumVo"%>
<%@page import="java.util.List"%>
<%@page import="com.project.dao.ForumDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ForumDao forumDao = ForumDao.getInstance();

List<ForumVo> forumList = forumDao.getFiveForums();
%>
<style>
.box1 {
	width: auto;
	background-color: #848cb5;
	color: white;
	padding: 10px;
	text-align: center;
	margin-right: auto;
	margin-left: auto;
}
</style>
<div class="row">
	<div class="col-6">
		<h3><div class="box1">Recent Forum</div></h3>
		<table class="table">
			<%
			SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
			
			for (ForumVo forumVo : forumList) {
			%>
			<tr>
				<td style="color: #00008B; font-weight: bold;"><%=forumVo.getSubject() %></td>
				<td><img src="/img/user.png" style="width:20px; margin: 0 5px;"><%=forumVo.getId() %></td>
				<td style="color:gray;"><%=sdf.format(forumVo.getRegDate()) %></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<br>
	<div class="col-6">
		<h3><div class="box1">Recent Review</div></h3>
		Recent Review
	</div>
</div>
<div class="row">
	<div class="col-6">
		<div></div>
	</div>
	<div class="col-6">
		<h3><div class="box1">Best Review</div></h3>
		Best Review
	</div>
</div>
