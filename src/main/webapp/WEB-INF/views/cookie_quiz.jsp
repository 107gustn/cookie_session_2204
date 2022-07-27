<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src=" https://cdn.jsdelivr.net/npm/js-cookie@rc/dist/js.cookie.min.js "></script> <!-- 쿠키 라이브러리 -->

	<script type="text/javascript">
		const co = Cookies.get("myCookie") /* 현재 브라우저에 있는 쿠키값을 얻어옴 */
		
		function popup(){
			alert( co )
			console.log( '${cook}' ==  '' )
			console.log( '${cook}' ==  null )
			if ( '${cook}' == '') {
				window.open("popup", "", "width=300, height=200" ) /* "컨트롤러 JSP 경로","새창으로 열음", "크기지정" */
			}
			/*
			if( co != undefined ){
				alert("쿠키 생성")
			}
			if( co != 'testCookie' ) {
				window.open("popup", "", "width=300, height=200" )
			}
			*/
			
		}/* 서버로부터 받아온 데이터는 ''를 붙여준다.(안붙이면 변수로 인식)  */
		popup() /* 페이지 읽히자마자 함수 호출 */
	</script>

	cook = ${cook }<br>
	cookie_quiz
</body>
</html>