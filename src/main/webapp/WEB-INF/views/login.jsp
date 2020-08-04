<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>로그인</title>
</head>
<body>
<%
	String path = request.getContextPath();
%>
<%=path%>

<!--유저의 값이 null 이면 아래로 탄다 if 문  -->
<c:if test="${user == null}">
<form role="form" method="post" autocomplete="off" action="<%=path%>/login"> <!--절대경로 표시 해주기 위해서 path 넣어줬다  -->
	<p>
		<label for="userId">아이디</label>
		<input type="text" id="userId" name="id" />
	</p>
	<p>
		<label for="userPass">패스워드</label>
		<input type="password" id="userPass" name="pw" />
	</p>
	<p><button type="submit">로그인</button></p>
<!-- 	<p><a href="/member/register">회원가입</a></p> -->
</form>
</c:if>

<c:if test="${msg == false}">
	<p style="color:#f00;">로그인에 실패했습니다. 아이디 또는 패스워드를 다시 입력해주십시오.</p>
</c:if>


<!--user가 실제 있으면, 접속이 되서 게시판으로 접근  -->
<c:if test="${user != null}">
	<p>${user.username}님 환영합니다.</p>
	
	<!-- <a href="member/modify">회원정보 수정</a>, <a href="member/withdrawal">회원탈퇴</a><br/> -->
	<a href="<%=path%>/list">게시판 리스트</a><br>
	<a href="<%=path%>/logout">로그아웃</a>
	
</c:if>

</body>
</html>






















