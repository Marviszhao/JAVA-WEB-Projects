<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file = "/admin/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品</title>
</head>
<body>
<!-- form action 中不能追加参数，会造成不能解析的bug，就算是get请求也不行 -->
<!-- 如果是method 为post 则input中的参数不会被暴露，get则会在url中暴露出参数 -->
<form action = "/ShoppingMarket/servlet/AddStockServlet?Test=editStock" method = "post">
<input type = "hidden" name = "method" value = "editStock">
<input type = "hidden" name = "stockID" value = "${param.stockID}">
	<table>
	<tr><td>商品名称:<input type = "text" name = "stockName" value = "${param.stockName}"></td></tr>
	<tr><td>商品价格:<input type = "text" name = "stockPrice" value = "${param.stockPrice}"></td></tr>
	<tr><td>商品描述:<input type = "text" name = "stockDes" value = "${param.stockDes}"></td></tr>
	<tr><td><input type = "submit" name = "button" value = "确定修改"></td></tr>
	</table>
	
</form>
	
</body>
</html>