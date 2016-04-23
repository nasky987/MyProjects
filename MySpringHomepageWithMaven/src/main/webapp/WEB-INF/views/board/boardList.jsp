<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일시</td>
			<td>조회수</td>
		</tr>
		<c:if test="${not empty boardList}">
			<c:forEach var="boardItem" items="${boardList}">
				<tr>
					<td>${boardItem.no}</td>
					<td><a href="board/${boardItem.no}">${boardItem.title}</a></td>
					<td>${boardItem.writer}</td>
					<td>${boardItem.writeDate}</td>
					<td>${boardItem.hit}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div>
		<a href="board/write">글쓰기</a>
	</div>
</body>
</html>