<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file = "/admin/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
</head>
<body>

<script type="text/javascript">
	function filterAction(){
		var form = document.getElementById("change_psw_form");
		var real_psw = document.getElementById("real_psw");
		var old_psw = document.getElementById("old_psw");
		var new_psw = document.getElementById("new_psw");
		var confim_psw = document.getElementById("confim_psw");
		
		
		if(old_psw.value == "" || new_psw.value == ""|| confim_psw.value == ""){
			alert("您有空格忘记填写了");
			return false;
		}
		if(old_psw.value != real_psw.value){
			alert("旧密码错误");
			return false;
		}
		if(new_psw.value == real_psw.value){
			alert("新旧密码相同");
			return false;
		}
		if(confim_psw.value != new_psw.value){
			alert("新密码与确认密码不一致");
			return false;
		}
		form.submit();
	}

</script>

<form id = "change_psw_form" action = "/ShoppingMarket/servlet/LoginServlet" method = "post">
<input type = "hidden" name = "cmdStr" value = "change_psw">
<input type = "hidden"	id = "real_psw" name = "real_psw" value = "${sessionScope.loginUser.getPass_word()}">

	<table>
	<tr><td>旧密码:<input type = "text" id = "old_psw" name = "old_psw"></td></tr>
	<tr><td>新密码:<input type = "text" id = "new_psw" name = "new_psw"></td></tr>
	<tr><td>确认密码:<input type = "text" id = "confim_psw" name = "confim_psw"></td></tr>
	<tr><td><input type = "button" onclick = "javascript:filterAction()" name = "button" value = "确定修改"></td></tr>
	</table>
	
</form>
	
</body>
</html>