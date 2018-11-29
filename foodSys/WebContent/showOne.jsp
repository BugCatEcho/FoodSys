<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=request.getAttribute("food")%></title>
<link href="css/buttons.css" rel="stylesheet">
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
	font-size: 16px;
}

#showbg {display：block;
	position: absolute;
	width: 100%;
	height: 100%;
	float: left;
	z-index: -100;
	draggable
	="false"
}

#foodimg {
	width: 300px;
	height: 300px;
}

table {
	margin: 0 auto;
	background-color: rgba(230, 230, 230, 0.6);
}
</style>

</head>
<body>
	<img id="showbg" src="img/show/showbg.jpg">
	<br />
	<table border="0" cellpadding="0" cellspacing="0" align="center">

		<tr>
			<td colspan="2"><img src="img/show/flower.gif" width="500px"
				height="60px" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center" height="30px">菜品样式</td>
		</tr>
		<tr>
			<td width="300"><img id="foodimg"
				src="img/foodimg${food.typeid }_${food.fid }.jpg"></td>
			<td width="200px" style="font-size: 16px; line-height: 30px;">菜名：<c:out
					value="${food.name }" /> <br /> 价格：<c:out value="${food.money }" /><br />
				介绍：<c:out value="${food.jieshao }" />


			</td>
		</tr>
		<tr>
			<td colspan="2" height="50" align="center"><div
					class="button-group">
					<a class="button button-pill button-action button-glow"
						href="motion?motion=nb&fid=${food.fid }&uid=${user.uid}">添加</a> <a
						class="button button-pill button-action button-glow"
						href="javascript:history.back(-1)">返回</a>
				</div></td>
		</tr>
		<tr>
			<td colspan="2"><img src="img/show/flower.gif" width="500px"
				height="60px" /></td>
		</tr>

	</table>



</body>
</html>