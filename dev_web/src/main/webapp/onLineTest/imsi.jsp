<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String test5 = request.getParameter("htest5"); // hidden이면 get방식이다
	// 쿠키 생성하기 - insert here
	Cookie ctest5 = new Cookie("test5", test5);
	ctest5.setPath("/onLineTest");
	ctest5.setMaxAge(30*60); //
	response.addCookie(ctest5);
	response.sendRedirect("score.jsp");
%>