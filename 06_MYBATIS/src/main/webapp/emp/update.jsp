<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사원번호수정화면</h1>
	<form action="/MYBATIS/update.do" method="post">
		
		<div>사원번호 ${param.no}</div>
		<div>사원명 <input type="text" name="name" value="${param.name}"></div>
		<div>부서명 <input type="text" name="dept" value="${param.dept}"></div>
		<div>급여 <input type="text" name="salary" value="${param.salary}"></div>
		<div>입사일자 ${param.hired}</div>
		<input type="hidden" name="no" value="${param.no}"> <!-- no를 꼭 넣어야 함. 안그러면 사원전체가 수정됨.-->
		<button>수정</button>
		<input type="button" value="사원목록" onclick="location.href='/MYBATIS/list.do'">
	</form>
		
		<!-- request는 일회성이고 session은 일회성이 아니고 저장소느낌?
			request를 정보를 받을땐 일회성으로 저장되지만 다른 페이지로 이동하면(정보가 이동하면)
			없어짐. 그래서 detail.jsp 를 보면 <input type="hidden" 으로 계속 값을 부여함
			session은 그럴 필요없이 update.jsp에 있는 값으로 보여줌
		 -->
	
</body>
</html>