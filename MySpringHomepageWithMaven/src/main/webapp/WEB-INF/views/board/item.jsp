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
	번호 : <input type="text" name="no" value="${boardVo.no}" readonly="readonly"/><br/>
	제목 : <input type="text" name="title" value="${boardVo.title}" readonly="readonly"/><br/>
	내용 : <textarea rows="20" cols="40" name="content" readonly="readonly">${boardVo.content}</textarea><br/>
	작성자 : <input type="text" name="writer" value="${boardVo.writer}" readonly="readonly"/><br/>
	작성일 : <input type="text" name="writeDate" value="${boardVo.writeDate}" readonly="readonly"/><br/>
	조회수 : <input type="text" name="hit" value="${boardVo.hit}" readonly="readonly"/><br/>
</body>
</html>