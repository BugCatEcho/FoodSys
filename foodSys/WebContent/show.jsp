<%@page import="model.user"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>foodList</title>
<link href="css/buttons.css" rel="stylesheet">
<link href="css/show.css" rel="stylesheet">
</head>

<body>
	<img id="showbg" src="img/show/showbg.jpg">
	<br />

	<table cellspacing="0" border="0" cellpadding="0">
		<tr background="img/show/flower.gif " id="topdiv" height="85" valign="middle">
			<td style="color: #fff;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎用户：<c:out
					value="${user.name}" />
			</td>
			<td width="100" align="center"><a
				href="motion?motion=bill&uid=${user.uid }"
				class="button button-3d button-action button-pill button-small"
				style="font-size: 16px;">结账</a></td>
			</tr>


		<tr>
			<td align="left" valign="top"><c:forEach items="${list }"
					var="fl">
					<div id="food">
						<a href="motion?motion=q1&fid=${fl.fid }&uid=${user.uid }"> <img
							src="img/foodimg${fl.typeid }_${fl.fid }.jpg" width="150"
							>
							<h4>

								<c:out value="${fl.name}" />
							</h4>
							<h5>
								<c:out value="${fl.money }￥" />
							</h5>
						</a>

					</div>
				</c:forEach></td>
			<td b valign="top" align="center" id="tdlist"><a
				class="button button-glow button-small button-primary"
				href="motion?motion=qt&tp=1&uid=${user.uid }">粤菜</a> <a
				class="button button-glow button-small button-caution"
				href="motion?motion=qt&tp=2&uid=${user.uid }">川菜</a> <a
				class="button button-glow button-small button-highlight"
				href="motion?motion=qt&tp=3&uid=${user.uid }">湘菜</a> <a
				class="button button-glow button-small button-royal"
				href="motion?motion=qt&tp=4&uid=${user.uid }">东北菜</a>
				<form action="motion" method="post">
				<input type="hidden" name="motion" value="sc"/>
				<input type="hidden" name="uid" value="${user.uid }"/>
					<input id="search" name="search" type="text" /> 
					<input type="submit" value="搜索" />
				</form> <a href="motion?motion=qa&uid=${user.uid }"
				class="button button-small button-raised button-pill button-inverse">所有菜</a>
				<a href="index.jsp"
				class="button button-3d button-caution button-tiny"><i
					class="fa fa-camera"></i>切换账号</a></td>
		</tr>
	</table>





</body>
</html>