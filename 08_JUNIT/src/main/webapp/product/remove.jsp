<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/JUNIT/reomove.do?product_no=${product.product_no}">삭제</a>
	<input type="button" value="삭제" onclick="location.href='/JUNIT/remove.do?product_no=${product.product_no}'">
	<form action="/JUNIT/remove.do">
		<input type="hidden" name="product_no" value="${product.product_no}"> 
		<!-- 이 값을 보여줄 필요는 없으니까 hidden으로 돌림 -->
		<button>삭제</button>
	</form>
	
	<hr>
	
	<div>${product.product_no}</div>
	<div>${product.name}</div>
	<div>${product.price}</div>
	<div><img src="${contextPath}/storage/${product.image}" alt="${product.image}"></div>
	
</body>
</html>