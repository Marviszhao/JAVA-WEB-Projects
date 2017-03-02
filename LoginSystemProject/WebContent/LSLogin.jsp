<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录注册界面</title>
</head>
<body>

<font color = 'red' size = '15'>
<c:choose>
<c:when test="${param['code'] ==1 }">注冊成功</c:when>
<c:when test="${param['code'] ==2 }">请进行登录</c:when>
<c:when test="${param['code'] ==3 }">该用户已存在</c:when>
<c:when test="${param['code'] ==4 }">该用户不存在</c:when>
<c:when test="${param['code'] ==5 }">密码不正确</c:when>
<c:when test="${param['code'] ==6 }">账号密码不能为空</c:when>
<c:when test="${param['code'] ==7 }">修改密码成功</c:when>
<c:otherwise>code 参数异常</c:otherwise>
</c:choose>
</font>
<br><br>

<form action="LSLoginServlet" method="post">
用户名 ：<input type = "text" name = "user" value = "${cookie.user.value}">
密码：<input type="text" name ="psw"><br><br>
<input type="submit" value = "登录" name ="button">
<input type="submit" value = "注册" name ="button">

</form>
</body>
</html>