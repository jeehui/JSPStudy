<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사원상세정보</h1>
	<div>사원번호 ${sessionScope.emp.no}</div>
	<div>사원명 ${sessionScope.emp.name}</div>
	<div>부서명 ${sessionScope.emp.dept}</div>
	<div>급여 ${sessionScope.emp.salary}</div>
	<div>입사일자 ${sessionScope.emp.hired}</div>
	<div>
		<!--request에 사원번호, 사원명, 부서명, 급여, 입사일자 저장해두면 update.jsp로 forward 할 수 있음.-->
		<form action="/MYBATIS/updatePage.do" method="post">
			<input type="hidden" name="no" value="${emp.no}">
			<input type="hidden" name="name" value="${emp.name}">
			<input type="hidden" name="dept" value="${emp.dept}">
			<input type="hidden" name="salary" value="${emp.salary}">
			<input type="hidden" name="hired" value="${emp.hired}">
			<button>수정</button>		
		</form>
	</div>
	
	<div>
		<input type="button" value="삭제" onclick="fnDelete()">
		<script>
			function fnDelete(){
				if(confirm('삭제할까요?')){
					location.href = '/MYBATIS/delete.do?no=${emp.no}';
				}
			}
		</script>
	</div>
	
</body>
</html>