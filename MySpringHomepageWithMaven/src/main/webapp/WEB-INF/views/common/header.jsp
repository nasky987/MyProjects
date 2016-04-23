<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<meta charset="UTF-8">
	<meta content="blendTrans(Duration=0.0)" http-equiv="Page-Enter" />
	<meta content="blendTrans(Duration=0.0)" http-equiv="Page-Exit" />
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/member.css">
	<title>Main</title>
</head>
	<div>
		<a href="${pageContext.servletContext.contextPath}">홈</a>
	</div>

    <c:if test="${empty sessionScope.memberVo}">
	    <div>
			<a href="${pageContext.servletContext.contextPath}/member/join">회원가입</a>
    	</div>
    	
    	<div>
			<a href="${pageContext.servletContext.contextPath}/member/login">로그인</a>
    	</div>
    </c:if>

	<c:if test="${not empty sessionScope.memberVo}">
		<div>
			<b>${sessionScope.memberVo.name}</b> 님 환영합니다.
			<a href="${pageContext.servletContext.contextPath}/member/logout">로그아웃</a>
		</div>
		
		<ul>
			<li>공지사항</li>
			<li><a href="${pageContext.servletContext.contextPath}/board">자유게시판</a></li>
			<li>관리자</li>
			<li><a href="${pageContext.servletContext.contextPath}/member/listAll">사용자 전체 목록 조회</a></li>
		</ul>
	</c:if>