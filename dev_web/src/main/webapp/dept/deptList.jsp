<%@page import="java.util.List, book.ch1.DeptVO, java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// sendRedirect - 불가(반드시 유지해야 하는 상황 - 쿠킨, 세션)
	// forward - 가능 - 출력
	String s_name = (String)request.getAttribute("s_name");
	List<DeptVO> list = (List)request.getAttribute("list");
	out.print("서버에서 요청객체에 담은 값 : " + s_name); // null (sendRedirect이므로)
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>