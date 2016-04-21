<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		${sessionScope.memberVo.name} 님 환영합니다.
		<div>
			<a href="${pageContext.servletContext.contextPath}/member/logout">로그아웃</a>
		</div>
	</c:if>
	<div>Menu 1 ............. Menu N</div>