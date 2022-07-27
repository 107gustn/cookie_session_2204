<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		function chk() {
			location.href = "chk"
			window.close()
			// 또는 close();
		}
	</script>

	popup.jsp<br>
	<br><br><br><br><br><br>
	<input type="checkbox" onclick="chk()">하루동안 열지 않음
</body>
</html>