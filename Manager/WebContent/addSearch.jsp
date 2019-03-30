<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="home/css/comm.css" type="text/css" rel="stylesheet"></link>
<title></title>
</head>
<body>
 
 	<c:choose>
 	 <c:when test="${param.type=='add'}">
 		<h2 align="center">添加用户</h2> 
 	 </c:when>
 	 <c:when test="${param.type=='update'}">
 		<h2 align="center">修改用户信息</h2> 
 	 </c:when>
 	</c:choose>
	<c:set var="function" scope="session" value="${param.type}"></c:set>
	
	<div class="addSearch" align="center">
	<form action="/Manager/UserCLServlet" target="MainFrame">
	   <table border="1" cellpadding="5" cellspacing="1" align="center">
	    <tr> 
	      <th>学号</th>
	      <td><input type="text" name="id" id="numberID" value="${param.id}"></td>
	     </tr>  
	     <tr>
	     	 <th>学生姓名</th>
	     	<td><input type="text" name="userName" id="userNameID"></td>
	     </tr>
	     <tr>
	     	 <th>年龄</th>
	     	<td><input type="text" name="age" id="ageID"></td>
	     </tr>
	     <tr>
	        <th>性别</th>
	     	<td>女<input type="radio" name="sex" value="女" id="sexID">&nbsp&nbsp&nbsp男<input type="radio" name="sex" value="男" id="sexID"></td>
	     </tr>
	     <tr>
	        <th>邮箱</th>
	       <td><input type="text" name="email" id="emailID"></td>
	     </tr>
	     <tr>
	        <th>出生日期</th>
	       <td><input type="text" name="date" id="dateID"></td>
	     </tr>
	     <tr>
	     	<td colspan="2" align="center"><input type="submit" value="提交" onclick="return addSearch()"></td>
	     </tr>
	   </table>
	</form>
	<b style="color: red">${err}</b>
	</div>

	
	<script type="text/javascript">
		function addSearch() {
			var id = document.getElementById("numberID").value;
			var name = document.getElementById("userNameID").value;
			var sex = document.getElementById("sexID").value;
			var email = document.getElementById("emailID").value;
			var date = document.getElementById("dateID").value;
			
			if(id==""||name==""||sex==""||age=="") {
				window.alert("用户的学号，姓名，性别,年龄不能为空！")
				return false;
			}
			
			var reg_id =/^(\d){6}$/;
			if(!reg_id.test(id)) {
				window.alert("请输入六位数的学号信息！");
				return false;
			}
			
			 var reg_email = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
	    	 if(email!="") {
	    		 if(!reg_email.test(email)) {
	    			 window.alert("请输入正确的邮箱格式");
		    		   return false;
	    		 }  
	    	 }
	    	 
	    	 var reg_date =/^(\d{4})-(\d{2})-(\d{2})$/;
	    	 if(date!="") {
	    		 if(!reg_date.test(date)) {
		    		 window.alert("输入的日期格式不正确，请按照1999-01-01的格式输入!");
		    		 return false;
		    	 }
	    	 }
			return true;
		}
	</script>
	
</body>
</html>