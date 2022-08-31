<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width" initial-scale=1">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script type="text/javascript">
	var request = new XMLHttpRequest();
    function searchFunction(){
    	request.open("Post", "/ZipSearchServlet?address=" + encodeURIComponent(document.getElementById("address").value),true)
   		request.onreadystatechange = searchProcess;
    	request.send(null);
    }
    function  searchProcess(){
    	var table = document.getElementById("ajaxTable");
    	table.innerHTML = "";
    	if(request.readyState = 4  && request.status == 200){
    		var object = eval('(' + request.responseText + ')');
			console.log(object);
    	}
    }
</script>
</head>
<body>
	<br>
	<div class="container">
		<div class="form-group row pull-right ">
			<div class="col-xs-8">
				<input class="form-control" id="address"  onkeyup="searchFunction()" type="text" size="10">
			</div>
			<div class="col-xs-2">
				<button class="btn btn-primary"  onclik="searchFunction();" type="button">검색</button>
			</div>
		</div>
		<table class="table" style="text-align: center; border: 1px solid #dddddd">
			<thead>
				<tr>
					<th style="background-coilor : #fafafa; text-align: center;">우편번호</th>			
					<th style="background-coilor : #fafafa; text-align: center;">동</th>			
					<th style="background-coilor : #fafafa; text-align: center;">업데이트 날짜</th>			
					<th style="background-coilor : #fafafa; text-align: center;">주소</th>			
				</tr>
			<tbody id="ajaxTable">
				<tr>
					<td>동</td>
					<td>동</td>
					<td>동</td>
					<td>동</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>