<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>b.jsp페이지</title>
</head>
<body>
<%!
// 디클러레이션 (사용하지 않는다)
	int age = 10;
	public String getName(){
		return "강감찬";
	}
%>
<%
	String r_name = (String)request.getAttribute("r_name");
	out.print(r_name);
%>
1. 이페이지는 a.jsp 페이지 내에 출력됩니다
<br>
2. 여기는 b.jsp페이지 내용 입니다.
</body>
</html>