<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="java.util.ArrayList, model.vo.*"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function logout(){location.href="/kh_exam/logout";}
</script>
</head>
<body>
<body>
<div>
<label><%= loginUser.getName() %>님</label>
<div>
<button>정보수정</button>
<button id="logoutBtn" onclick="logout();">로그아웃</button>
</body>
</html>