<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Dao.UserDao"%>
<%@page import="Dao.ManagerDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="home/css/comm.css" type="text/css" rel="stylesheet"></link>
<title>用户基本信息</title>
</head>
<body>
	<!-- 查询所有用户的信息 -->
	<h3>用户基本信息表</h3>
	
	<div align="center">
		<table border="1" align="center" cellpadding="10" cellspacing="1" width="100%">
		<tr> <th >id</th>
			<th >姓名</th>
		    <th >年龄</th>
		    <th >性别</th>
		    <th>邮箱</th>
		    <th>出生日期</th>
		    <th>是否修改用户信息</th>
		</tr>
		<c:forEach items="${requestScope.userList }" var="user">
	  	 <tr>
	  		<td style="color: blue;background-color: pink">${user.id }</td>
	  		<td>${user.name }</td>
	  		<td>${user.age }</td>
	   		 <td>${user.sex }</td>
	    	<td>${user.email }</td>
	    	<td>${user.date}</td>
	    	<td><a href="/Manager/addSearch.jsp?type=update&id=${user.id}">修改</a></td>
	  	</tr>
	  </c:forEach>	
	</table>
	</div>
	
	
</body>
</html>