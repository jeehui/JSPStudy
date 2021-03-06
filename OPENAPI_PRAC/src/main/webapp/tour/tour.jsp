<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js" integrity="sha256-6XMVI0zB8cRzfZjqKcD01PBsAy3FlDASrlC8SxCpInY=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<script>
	
 $(document).ready(function(){
	
	// datepicker
	$('#currentDate').datepicker({
		showOn: 'focus',
		dateFormat: 'yymmdd'
	});
	
	fnTour();
	
})
	
	function fnTour(){
		$('#btn_tour').on('click', function(){
			$.ajax({
				url: '/OPENAPI/tourStnInfoSvc.do',
				type: 'get',
				dataType:'json',
				success: function(responseText){
					$('#focInfo').empty();
					$.each($(responseText).find('item'), function(i, item){
						var tr = '<tr>';
						tr += '<td>' + $(item).find('courseAreaId').text()+ '</td>';
						tr += '<td>' + $(item).find('courseAreaName').text()+ '</td>';
						tr += '<td>' + $(item).find('spotAreaId').text()+ '</td>';
						tr += '<td>' + $(item).find('spotAreaName').text()+ '</td>';
						tr += '<td>' + $(item).find('courseName').text()+ '</td>';
						tr += '<td>' + $(item).find('spotName').text()+ '</td>';
						tr += '<td>' + $(item).find('thema').text()+ '</td>';
						tr += '<td>' + $(item).find('th3').text()+ '</td>';
						tr += '<td>' + $(item).find('wd').text()+ '</td>';
						tr += '<td>' + $(item).find('ws').text()+ '</td>';
						tr += '<td>' + $(item).find('sky').text()+ '</td>';
						tr += '<td>' + $(item).find('rhm').text()+ '</td>';
						tr += '<td>' + $(item).find('pop').text()+ '</td>';
						tr += '<td>' + $(item).find('rn').text()+ '</td>';
					})
				}
			})
		})
	}
	
</script>
</head>
<body>
	<label for="current">
		조회시작일시	
		<input type="text" id="currentDate" name="currentDate">
	</label>
	<br>
	<label for="courseID">
		코스ID
		<input type="text" id="courseId" name="courseId">	
	</label>
	<br>
	<input type="button" value="조회하기" id="btn_tour">
	
	<hr>
	
	<table border="1">
		<thead>
			<tr>
				<td>코스 지역아이디</td>
				<td>코스 지역이름</td>
				<td>관광지점 지역아이디</td>
				<td>관광지점 지역이름</td>
				<td>관광코스명</td>
				<td>관광지 명</td>
				<td>관광지 명</td>
				<td>3시간 기온</td>
				<td>풍향</td>
				<td>하늘상태</td>
				<td>습도</td>
				<td>강수확률</td>
				<td>강수량</td>
			</tr>
		</thead>
		<tbody id="focInfo">
		
		</tbody>
	</table>
</body>
</html>