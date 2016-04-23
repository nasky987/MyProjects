<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>write Page</h1>
	<form action="write" method="POST">
		제목 : <input type="text" name="title"><br/>
		내용 : <textarea rows="20" cols="40" name="content"></textarea><br/>
		작성자 : ${sessionScope.memberVo.email} <br/>
		<input type="hidden" name="writer" value="${sessionScope.memberVo.email}">
		<input type="submit">
	</form>
</body>
</html>