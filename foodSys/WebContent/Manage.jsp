<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ManagePage</title>
</head>
<body>
	<table>
		<tr>
			<td colspan="4">用户表</td>
		</tr>
		<tr>
			<td>卡号</td>
			<td>姓名</td>
			<td>余额</td>
			<td>D/U</td>
		</tr>
		<c:forEach items="${ulist }" var="list" varStatus="uf">
			<tr>
				<td><c:out value="${list.uid }" /></td>
				<td><c:out value="${list.name }" /></td>
				<td><c:out value="${list.money }" /></td>
				<td><a href="#">删除</a><a href="#">修改</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4"><a href="#">添加</a></td>
		</tr>
	</table>

	<table>
		<tr>
			<td colspan="4">厨师表</td>
		</tr>
		<tr>

			<td>名字</td>
			<td>手机号</td>
			<td>个人介绍</td>

			<td>D/U</td>
		</tr>
		<c:forEach items="${clist }" var="chef" varStatus="cf">


			<tr>

				<td><c:out value="${chef.name }" /></td>
				<td><c:out value="${chef.phone }" /></td>
				<td><c:out value="${chef.vita }" /></td>
				<td><a href="#">删除</a><a href="#">修改</a></td>

			</tr>
		</c:forEach>
		<tr>
			<td colspan="4"><a href="#">添加</a></td>
		</tr>

	</table>


	<table>
		<tr>
			<td colspan="4">菜品表</td>
		</tr>
		<tr>

			<td>菜名</td>
			<td>菜价</td>
			<td>介绍</td>

			<td>D/U</td>
		</tr>
		<c:forEach items="${flist }" var="fl" varStatus="ff">


			<tr>

				<td><c:out value="${fl.name }" /></td>
				<td><c:out value="${fl.money }" /></td>
				<td><c:out value="${fl.jieshao }" /></td>
				<td><a href="#">删除</a><a href="#">修改</a></td>

			</tr>
		</c:forEach>
		<tr>
			<td colspan="4"><a href="#">添加</a></td>
		</tr>

	</table>


</body>
</html>