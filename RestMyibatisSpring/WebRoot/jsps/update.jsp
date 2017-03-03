<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/RestMyibatisSpring/user/update/${param.id}"  method = "post"><br>
		<br><input type="text" name="user_name" value="${param.name}"><br>
		<br><input type="text" name="user_psw" value="${param.psw}"><br>
		<br><input type="submit" value="提交">
	</form>

</body>
</html>