<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

<script>
	
	//페이지
	$(document).ready(function(){
		fnList();
		fnDetail();
		fnAdd();
	})
	
	//$('#btnList').on('click', function(){
	
	function fnList(){
		$.ajax({
			url: '/StaffProject/list.json',
			type: 'GET',
			dataType: 'json',
			success: function(responseText){
				var staffList = $('#staffList');
				staffList.empty();
				$.each(responseText, function(i, staff){
					var tr = '<tr>';
					tr += '<td>' + staff.sno + '</td>';
					tr += '<td>' + staff.name + '</td>';
					tr += '<td>' + staff.dept + '</td>';
					tr += '<td>' + staff.salary + '</td>';
					tr += '</tr>';
					staffList.append(tr);
				})
			},
			error: function(jqXHR){
				alert(jqXHR.responseText);
			}
		})
	}
 
	function fnDetail(){
			
		$('#btnDetail').on('click', function(){
			 var sno = $(this).prev().val();
			$.ajax({
				url: '/StaffProject/query.json',
				data: 'query=' + $('#searchsno').val 
				type: 'GET',
				dataType: 'json',
				success: function(responseText){
					if(responseText.result==true){
						$('#sno').val(responseText.staff.sno);
						$('#name').val(responseText.staff.name);
						$('#dept').val(responseText.staff.dept);
						$('#salary').val(responseText.staff.salary);
					}
				}
			})
		})
	}

		
	function fnAdd(){
		
		$('#btnAdd').on('click', function(){
			
			$.ajax({
				
				url: '/StaffProject/add.json',
				type: 'POST',
				data: $('#formStaff').serialize(),
				dataType: 'json',
				success: function(responseText){
					if(responseText.res==1){
						alert('사원 등록이 성공했습니다.');
						fnList();
						$('#sno').val('');
						$('#name').val('');
						$('#dept').val('');
					}
				},
				error: function(jqXHR){
					alert(jqXHR.status);
					alert(jqXHR.responseText);
				}
			
			
			})
			
			
		})
	}
</script>

</head>
<body>
	
	<form id="formStaff">
	
	<h1>사원등록</h1>
	
	<input type="text" placeholder="사원번호" name="sno" >
	&nbsp;
	<input type="text" placeholder="사원명" name="name">
	&nbsp;
	<input type="text" placeholder="부서명" name="dept">
	<input type="button" value="등록" id="btnAdd">
	<hr>
	<h1>사원조회</h1>
	<input type="text" placeholder="사원번호입력" name="detail">
	<input type="button" value="조회" id="btnDetail">
	<input type="button" value="전체" id="btnList">
	
	<hr>
	
	<h1>사원목록</h1>
		<div>
			<table border="1">
				<thead>
					<tr>
						<td>사원번호</td>
						<td>사원명</td>
						<td>부서명</td>
						<td>연봉</td>
					</tr>
				</thead>
				<tbody id="staffList">
				</tbody>
			</table>
		</div>
	</form>
	
	
</body>
</html>