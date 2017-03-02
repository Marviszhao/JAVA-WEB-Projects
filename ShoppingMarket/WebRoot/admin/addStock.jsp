<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>>
<%@include file="/admin/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
</head>

<c:if test="${requestScope.type =='insertSucc'}">
	<font size = "6" color = "red">
		插入成功，请继续！<br><br><br>
	</font>
</c:if>

<body>
	<form action="/ShoppingMarket/servlet/AddStockServlet" method="post">
		<input type="hidden" name="method" value="add">
		<table>
			<tr>
				<td>商品名称:<input type="text" name="stock_name">
				</td>
			</tr>
			<tr>
				<td>商品价格:<input type="text" name="stock_price">
				</td>
			</tr>
			<tr>
				<td>商品描述:<input type="text" name="stock_comment">
				</td>
			</tr>

			<tr>
				<td><input type="submit" name="button" value="确定添加">
				</td>
			</tr>
		</table>

	</form>
</body>
</html>