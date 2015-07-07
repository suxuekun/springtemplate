<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.techstudio.util.*"%>
<%
	request.setAttribute("WEBAPPS", ConnConfig.getWebAppRoot());
	request.setAttribute("MYPAGE", request.getServletPath());
	
%>
