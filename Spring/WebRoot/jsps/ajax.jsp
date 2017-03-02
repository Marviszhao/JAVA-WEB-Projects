<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



<script type="text/javascript">

	function sendAjaxOne(){
		var req = new XMLHttpRequest();
		req.open("get","ajax.do?method=test1");
		req.setRequestHeader("accept","application/json");
		req.onreadystatechange = function(){
			eval("var result="+req.responseText);
			var name1 = document.getElementById("name1");
			name1.value = result[0].userName;

			var name2 = document.getElementById("name2");
			name2.value = result[1].userName;

		};
		
		req.send(null);
	}
	
	function sendAjaxTwo(){
		var req=  new XMLHttpRequest();
		
		req.open("get", "ajax.do?method=test2");
		req.setRequestHeader("accept", "application/json");
		req.onreadystatechange  = function(){
				eval("var result="+req.responseText);//从action里拿到相应的信息
				document.getElementById("div1").innerHTML=result[0].userName;
				document.getElementById("div2").innerHTML=result[1].userName;
			};
		req.send(null);
		
	}
	
</script>

<table>
	<tr>
			<td><input id="name1" type="text"></td>
			<td><input id="name2" type="text"></td>
			<td><a href = "javascript:void(0)" onclick="sendAjaxOne()">
			第一种方法获取信息</a></td>
	</tr>
	<tr>
			<td><div type="text" id = "div1"></td>
			<td><div type="text" id = "div2"></td>
			<td><a href = "javascript:void(0)" onclick="sendAjaxTwo()">
			第二种方法获取信息</a></td>
	</tr>

</table>



</body>
</html>