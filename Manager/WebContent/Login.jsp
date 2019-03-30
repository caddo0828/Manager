<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,java.net.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" href="/home/css/style.css" style="stylesheet"></link>
<title>管理员登录界面</title>
</head>
<body>
	
	<h2 align="center">管理员登录界面</h2>
	<div id="login" align="center">
	<form action="/Manager/ManagerLoginServlet" method="post" onsubmit="return ckLogin()">
		 <table border="1" cellpadding="5" cellspacing="1">
		   <tr>
		      <td>用户名： </td>
		      <td><input type="text" name="username" id="usernameID" value="${sessionScope.loginManager.userName}" /> </td>
		   </tr>
		   <tr>
		      <td>密     码&nbsp&nbsp：</td>
		      <td><input type="password" name="password" id="passwordID"  value="${loginManager.password}" /> </td>
		   </tr>
		   <tr>
		      <td>验证码：</td>
		      <td>
		       		<input type="text" name="RandomNumber" id="numberID"/> 
		       		 <img alt="" src="/Manager/ImageServlet"/>
					 <a href="http://localhost:8080/Manager/Login.jsp" >看不清，换一张 </a> 
		      </td>
		   </tr>
		  <tr>
		      <td>是否保存账户信息</td>
		      <td>
		      	          保存<input type="radio" name="statue" value="keep"/>&nbsp&nbsp
	                                           不保存<input type="radio" name="statue" value="nokeep"/>
		      </td>
		   </tr>
		  <tr>
		      <td align="center"> <input type="submit"  value="Login" onclick="return ckLogin()"/> </td>
		      <td> <input type="button" value="Register" onclick="window.location.href='DoRegister.jsp'"> </td>
		  </tr>
		 </table>
	</form>
		<b style="color: red">${requestScope.err }</b>
	</div>
	
	<script type="text/javascript">
		function ckLogin() {
			var uname = document.getElementById("usernameID").value;
			var pwd = document.getElementById("passwordID").value;
			var number = document.getElementById("numberID").value;
			
			if(uname==""||pwd==""||number=="") {
		       window.alert("用户相关的注册信息不能为空！")
			   return false;
			}	
			return true;		
		}
	</script>

</body>
</html>