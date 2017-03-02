<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file ="/admin/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
</head>
<body>


	<table border="1"  cellspacing = "0" cellpadding = "0" bgcolor = "cyan">
		<tr>
			<td>商品编号</td>
			<td>商品名称</td>
			<td>商品描述</td>
			<td>商品价格</td>
			<td>购买</td>
		</tr>
	<c:forEach items = "${requestScope.stockList}" var = "stockModel">
	    <tr>
			<td>${stockModel.id}</td>
			<td>${stockModel.stockName}</td>
			<td>${stockModel.stockComment}</td>
			<td>${stockModel.stockPrice}</td>
			<td><a href = "/ShoppingMarket/servlet/AddStockServlet?stockID=${stockModel.id}&method=buyStock">购买</a></td>
	    </tr>	
	
	</c:forEach>
		


	</table>
<%@ include file = "/admin/footer.jsp" %>
</body>
</html>