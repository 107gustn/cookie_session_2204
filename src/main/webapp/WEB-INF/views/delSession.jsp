<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	세션 삭제<br>
	id : ${ requestScope.id }<br>
	id : ${ id }<br>
	name : ${ name}<hr>
	<a href="resultSession">확인 세션</a>
	<a href="makeSession">생성 세션</a>

</body>
</html>