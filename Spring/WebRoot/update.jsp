<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新密码</title>
</head>
<body>

	<form action="user.do" method="post">
		<input type="hidden" name="method" value="update"> 
		<input type="hidden" name="id" value="${param.id}"><br> 
		姓名：<input type="text" name="user_name" value="${param.user_name}"><br>
		密码：<input type="text" name="user_psw" value="${param.user_psw}"><br>
		<input type="submit" name="button" value="提交修改">
	</form>

</body>
</html>