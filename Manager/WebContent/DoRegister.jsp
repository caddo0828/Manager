<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员注册界面</title>
</head>
<body>
    <!-- 注意事项：表单提交数据一定要有键值， 多选框键值相同，元素值不同，元素值自己给定 -->
    <h3 align="center">管理员注册</h3>
    <div id="register" align="center">
    <form action="/Manager/ManagerRegisterServlet" method="post"  onsubmit="return ckRegist()">
    	<table border="1" cellpadding="5" cellspacing="1" align="center">
    	   <tr> 
    	   		<td>用户名：</td>
    	  		<td><input type="text" name="username" id="usernameid" />  </td>
    	   </tr>
    	   <tr> 
    	   		<td>密     码：</td>
    	  		<td><input type="password" name="password" id="passwordid"/> </td>
    	   </tr>
    	   <tr> 
    	   		<td>手机号： </td>
    	  		<td><input type="text" name="id" id="numberid"> </td>
    	   </tr>
    	   <tr> 
    	   		<td>性别：</td>
    	  		<td>
    	  			男:<input type="radio" name="sex" value="男" id="sexid"/>&nbsp&nbsp&nbsp&nbsp
    				女:<input type="radio" name="sex" value="女" id="sexid"/>
    	  		 </td>
    	   </tr>
    	   <tr> 
    	   		<td>户籍所在地:</td>
    	  		<td>
    	  			<select name="city" id="cityid"> 
		          		<option value="北京">北京</option> 
		        		<option value="上海">上海 </option>
		        		<option value="成都" >成都</option>
		        		 <option value="江西">江西</option> 
		        		<option value="杭州">杭州 </option>
		        		<option value="深圳">深圳</option>
		       		</select> 
    	  		 </td>
    	   </tr>
    	  <tr>
    	    <td colspan="2" align="center"><input type="submit"  value="Register"  /> </td>
    	  </tr>
    	</table>
	</form>
		<b style="color: red">${requestScope.err}</b>
    </div>


	<script language="javascript">
		function ckRegist() {	
			//alert("表单验证信息");
			//alert: 作用在于提示
			var uname = document.getElementById("usernameid").value
			var pwd = document.getElementById("passwordid").value;
			var id = document.getElementById("numberid").value;
			var city = document.getElementById("cityid").value
			var sex = document.getElementById("sexid").value;
			if(uname==""||pwd==""||id==""||city==""||sex=="") {
		 		window.alert("用户注册信息不能为空");
		 		return false;
			}
			return true;
		} 
	</script>
   
 

	
</body>
</html>