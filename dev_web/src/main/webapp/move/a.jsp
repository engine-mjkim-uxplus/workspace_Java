<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a.jsp</title>
</head>
<body>
 여기는 a.jsp페이지 입니다
<%
	request.setAttribute("age",30);
%>
1. 시작입니다
<%@include file="b.jsp" %>
2. 마지막입니다
<!-- 
<include> 요청이 유지되고 있는 것으로 판단한다
a.jsp에 요청이 들어오고 실행흐름이 b.jsp로 이동했다가 b.jsp를 다 처리하면
a.jsp로 다시 끌고 와서 a.jsp에 출력을 내보낸다

 -->

</body>
</html>