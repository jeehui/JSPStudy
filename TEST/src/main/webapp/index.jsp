<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사원등록</h1>
	<form action="/TEST/insert.do" method="post">
	
	<input type="text" placeholder="사원명" name="name">
	&nbsp;&nbsp;&nbsp;
	<input type="text" placeholder="사원번호" name="no">
	&nbsp;&nbsp;&nbsp;
	<input type="text" placeholder="부서" name="dept">
	<button>등록</button>
	</form>
	
</body>
</html>