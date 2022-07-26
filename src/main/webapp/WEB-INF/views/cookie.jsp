<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	cookie.jsp<br>
	cookie : ${cookie }<br>
	popcookie : ${popcookie }<br>
	
	<c:if test="${popcookie == null }">
		<script type="text/javascript">
			open("popup", "", "width=300, height=200, top=500, left=500")
		</script>
	</c:if>
	
</body>
</html>