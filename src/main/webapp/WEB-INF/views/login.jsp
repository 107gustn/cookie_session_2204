<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src=" https://cdn.jsdelivr.net/npm/js-cookie@rc/dist/js.cookie.min.js "></script>
	<script type="text/javascript">
		const co = Cookies.get("myCookie")
		
		function popup(){
			alert( co )
			console.log( '${cook}' ==  '' )
			console.log( '${cook}' ==  null )
			if ( '${cook}' == '') {
				window.open("popup", "", "width=300, height=200" )
			}
		}
		popup()
	</script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	cookie페이지 입니다.<br>
	<c:choose>
		<c:when test="${name == null }">
			<form action="logChk" method="post">
				<input type="text" name="id" placeholder="아이디"><br>
				<input type="text" name="pwd" placeholder="비밀번호"><br>
				<input type="submit" value="로그인">
			</form>
		</c:when>
		<c:otherwise>
			<hr>
			${name }님 로그인 상태입니다.<br>
			<a href="main">main 이동</a>
		</c:otherwise>
	</c:choose>

</body>
</html>