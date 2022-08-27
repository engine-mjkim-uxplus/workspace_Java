<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.Member" %>
<%
	Member loginUser = new Member();
	loginUser.setName("이순신");
	session.setAttribute("loginUser",loginUser);

%>