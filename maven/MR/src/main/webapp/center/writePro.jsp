<%@page import="com.project.dao.*"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("utf-8");

String pageNum = request.getParameter("pageNum");
%>

<jsp:useBean id="forumVo" class="com.project.vo.ForumVo" />
<jsp:setProperty property="*" name="forumVo"/>

<%
//ip  regDate  readcount  값 저장
forumVo.setIp(request.getRemoteAddr());
forumVo.setRegDate(new Timestamp(System.currentTimeMillis()));
forumVo.setReadcount(0);  // 조회수

//re_ref  re_lev  re_seq
int num = JdbcUtils.getNextNum("forum"); // insert될 글번호 가져오기
forumVo.setReRef(num); // 주글일때는 글번호가 그룹번호가 됨
forumVo.setReLev(0); // 주글일때는 들여쓰기 레벨이 0 (들여쓰기 없음)
forumVo.setReSeq(0); // 주글일때는 글그룹 내에서 순번이 0 (첫번째)

//DAO 객체 준비
ForumDao noticeDao = ForumDao.getInstance();

//주글 등록하기
noticeDao.addForum(forumVo);

// 글내용 상세보기 화면 content.jsp로 이동
response.sendRedirect("/center/content.jsp?num=" + num + "&pageNum=" + pageNum);
%>


