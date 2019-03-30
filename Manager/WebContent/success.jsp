<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link href="home/css/comm.css" type="text/css" rel="stylesheet"></link>
</head>
<body>
	
	<c:choose>
	 <c:when test="${empty err}">
	 	<div class="Success" align="center">
		<form action="#" method="post" target="MainFrame">
		<table border="1" cellspacing="1" cellpadding="5" >
		 <tr>
		    <tr> <th >id</th>
				 <th >姓名</th>
			     <th >年龄</th>
			     <th >性别</th>
			     <th >邮箱</th>
			     <th >出生日期</th>
			</tr>
		  	 <tr>
		  		<td>${user.id }</td>
		  		<td>${user.name }</td>
		  		<td>${user.age }</td>
		   		<td>${user.sex }</td>
		    	<td>${user.email }</td>
		    	<td>${user.date}</td>
		  	</tr>
		</table>
		</form>
		<b style="color: red">${message}</b>
		</div>
	 </c:when>
	 <c:otherwise>
		<div class="Error" align="center">
	 		<b style="color: red">${err} </b>
	 	</div>
    </c:otherwise>
	</c:choose>
	
	
	
	
</body>
</html>