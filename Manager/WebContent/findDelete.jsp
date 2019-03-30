<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="home/css/comm.css" type="text/css" rel="stylesheet"></link>
<title></title>
</head>
<body>
	 <c:choose>
 	 <c:when test="${param.type=='search'}">
 		<h2 align="center">查找用户</h2> 
 	 </c:when>
 	 <c:when test="${param.type=='delete'}">
 		<h2 align="center">删除用户</h2> 
 	 </c:when>
 	</c:choose>
	<c:set var="function" scope="session" value="${param.type}"></c:set>
	
	<div class="findDelete" align="center">
	<form action="/Manager/UserCLServlet" method="post" target="MainFrame">
		用户学号：<input type="text" name="id">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		姓名：<input type="text" name="userName">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<input type="submit" value="${param.type}"/>
	</form>
	<b style="color: red">${err}</b>
	</div>
	
</body>
</html>