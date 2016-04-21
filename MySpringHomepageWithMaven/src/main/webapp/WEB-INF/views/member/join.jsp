<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<form action="join" method="post">
		이메일 : <input type="text" name="email"> <br/>
		암호 : <input type="password" name="password"> <br/>
		이름 : <input type="text" name="name"> <br/>
		생년월일 : <input type="text" name="birth" maxlength="8" size="8"> <br/>
		성별 : <input type="text" name="gender" maxlength="8" size="1"> <br/>
		전화번호 : <input type="text" name="phoneNumber" maxlength=11 size="11"> <br/>
		<input type="submit">
	</form>
</body>
</html>