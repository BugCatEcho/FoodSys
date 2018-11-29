<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PayPage</title>

<link href="css/buttons.css" rel="stylesheet">
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
	font-size: 16px;
}

#paybg {display：block;
	position: absolute;
	width: 100%;
	height: 100%;
	float: left;
	z-index: -100;
	draggable
	="false"
}

table {
	margin: 0 auto;
	min-width: 630px;
	max-width: 1105px;
	background-color: rgba(230, 230, 230, 0.8);
}
</style>
</head>
<body>
	<img id="paybg" src="img/show/paybg.jpg">
	<br />
	<table border="0" cellpadding="0" cellspacing="0">
		<tr align="center" height="40px" bgcolor="#000" style="color: #fff">
			<td width="40px">ID</td>
			<td width="280px">菜&nbsp;&nbsp;&nbsp;&nbsp;名</td>
			<td width="80px">菜价</td>
			<td width="160px">时间</td>

			<td width="180px">D/F</td>
		</tr>

		<c:set var="count" value="0" />
		<c:forEach items="${list }" var="dd" varStatus="vid">


			<tr align="center" height="40px">
				<td><c:out value="${vid.count}" /></td>
				<td><c:out value="${dd.food.name}" /></td>
				<td><c:out value="${dd.food.money}" /></td>
				<c:set var="count" value="${count+dd.food.money }" />
				<td><c:out value="${dd.addtime}" /></td>

				<td><a class="button button-primary button-small"
					href="motion?motion=rb&uid=${user.uid }&bid=${dd.bid}">移除</a><a
					class="button button-primary button-small"
					href="motion?motion=q1&fid=${dd.fid }&uid=${user.uid }">详细</a></td>
			</tr>

		</c:forEach>
		<tr>
			<td colspan="5" height="40px">共计：<c:out value="${count }" />元(您的账户余额还有：
			<c:out value="${user.money }" />元)
			</td>
		</tr>
		<tr>
			<td colspan="5" height="60px" style="font-size: 16px;" align="center">
				<div class="button-group">
					<a class="button button-pill button-action"
						href="motion?motion=py&uid=${user.uid}">结账</a> <a
						class="button button-pill button-action"
						href="motion?motion=qa&uid=${user.uid}">返回</a>
				</div>
			</td>
		</tr>

	</table>



	<%
		String mess = (String) session.getAttribute("message");
		if ("".equals(mess) | mess == null | "null".equals(mess)) {

		}

		else {
	%>

	<script type="text/javascript">
        alert("<%=mess%>"); 
	</script>
	<%
		session.setAttribute("message", "");

		}
	%>

</body>
</html>