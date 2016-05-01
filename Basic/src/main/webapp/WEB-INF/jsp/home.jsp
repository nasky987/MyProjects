<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<c:out value="<Test>The time on the server is ${serverTime}."></c:out>
<P>  The time on the server is ${serverTime}. </P>
</body>

<c:out value="${test}"></c:out>

<form action="" method="post">
	<input type="text" name="test">
	<input type="submit">
</form>
</html>
