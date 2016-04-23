<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
 -->
	<jsp:include page="../common/header.jsp" />
<body>
	
	<table border="1">
		<tr>
			<td>고유번호</td>
			<td>이메일주소</td>
			<td>암호</td>
			<td>이름</td>
			<td>생년월일</td>
			<td>성별</td>
			<td>핸드폰 번호</td>
			<td>가입일</td>
			<td>최종 로그인 시간</td>
		</tr>
		
		<c:forEach var="member" items="${members}">
			<tr>
				<td>${member.no}</td>
				<td>${member.email}</td>
				<td>${member.password}</td>
				<td>${member.name}</td>
				<td>${member.birth}</td>
				<td>${member.gender}</td>
				<td>${member.phoneNumber}</td>
				<td>${member.regDate}</td>
				<td>${member.loginDate}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>