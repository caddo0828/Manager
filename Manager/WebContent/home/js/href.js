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