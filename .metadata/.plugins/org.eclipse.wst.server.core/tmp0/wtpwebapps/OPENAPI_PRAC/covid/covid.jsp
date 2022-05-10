<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
	
	//페이지 로드 이벤트
	$(document).ready(function(){
		fnCovid19InfStateJson();
	})
	
	//함수
	function fnCovid19InfStateJson(){
		$('#btn_covid').on('click', function(){
			$.ajax({
				url: '/OPENAPI/covid19InfStateJson.do',
				type: 'get',
				dataType: 'xml',
				success: function(responseText){
					$('#covidInfo').empty();
					$.each($(responseText).find('item'), function(i, item){
						var tr = '<tr>';
						tr += '<td>' + $(item).find('SEQ').text()+'</td>';
						tr += '<td>' + $(item).find('STATE_DT').text()+'</td>';
						tr += '<td>' + $(item).find('STATE_TIME').text()+'</td>';
						tr += '<td>' + $(item).find('DECIDE_CNT').text()+'</td>';
						tr += '<td>' + $(item).find('DEATH_CNT').text()+'</td>';
						$('#covidInfo').append(tr);
					})
				}
			})
		})
	}
</script>
</head>
<body>
	<input type="button" value="코로나 감염현황 조회"  id="btn_covid">
	
	<hr>
	
	<table border="1">
		<thead>
			<tr>
				<td>게시글번호</td>
				<td>기준일</td>
				<td>기준시간</td>
				<td>확진자 수</td>
				<td>사망자 수</td>
			</tr>
		</thead>
		<tbody id="covidInfo">
		
		</tbody>
	</table>
</body>
</html>