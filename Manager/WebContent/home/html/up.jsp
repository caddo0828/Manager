<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	
	 <h4>用户管理界面</h4>
	  <font>欢迎 <b style="color: red">${loginManager.userName }</b>登录管理系统</font>&nbsp&nbsp&nbsp&nbsp  
	  <font>在线人数<b style="color: red">${applicationScope.onLineNum}</b></font>
	 
	    <%-- target 重新展开界面  
	        _blank : 新标签页中显示出跳转的界面
			_self : 在当前页中刷新显示
			_top :  在顶层页面中显示
			_parent : 在父界面中显示    --%>
	  <b><a href="/Manager/LoginOutServlet" target="_parent" >安全退出</a></b>
	 
	 
</body>
</html>