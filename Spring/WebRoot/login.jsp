<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
<form action = "user.do" method = "post">
  	<br>
  		<input type = "hidden" name = "method" value = "login">
  		用户名：<input type = "text" name = "user_name" ><br>
  		密码：<input type = "text" name = "user_psw" ><br>
  		<input type = "submit"  value = "登录"><br><br>
  		<a href = "/Spring/index.jsp">去注册</a><br><br>
  		<a href = "/Spring/jsps/upload.jsp">.do上传文件</a><br><br>
  		<a href = "/Spring/jsps/upload_rest.jsp">restful上传文件</a>
  	</form>
</body>
</html>