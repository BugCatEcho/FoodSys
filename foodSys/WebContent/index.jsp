<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IndexPage</title>

<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#sb").click(function() {
			var text = $(".inid").val();
			if (text == "") {
				alert("卡号不能为空!");
			} else {
				$.ajax({
					url : "motion?",
					data : {
						"motion" : "exist",
						"uid" : $("input[name='uid']").val()
					},
					type : "POST",
					dataType : "TEXT",

					success : function(data) { //回调函数，data为形参，是从login-cl.php页面返回的值
						if (data.trim() == "OK")//trim()去空格
						{
							$("#form1").submit();
						} else {
							alert(data);
						}
					}
				})
			}

		});
	});
</script>
<link href="css/buttons.css" rel="stylesheet">

<link href="css/idx.css" rel="stylesheet">

</head>
<body bgcolor="#fff">
	<img src="img/idx/indexbg.jpg">
	<h2 style="color: #ffffff;">&nbsp;欢迎来到点餐系统</h2>
	<div id="jsdiv">

		<form id="form1" action="motion" method="post">

			<span>Pls Enter ID:</span> <br /> <input type="hidden" name="motion"
				value="qa" /> <input name="uid" class="inid" type="text" /> <br />
			<br /> <input
				class="button button-glow button-border button-rounded button-primary"
				type="button" id="sb" value="开始点餐" />
		</form>
	</div>
	<a id="a1" href="#"></a>
	<a id="a2" href="#"></a>
	<a id="a3" href="#"></a>
	<a id="a4" href="#"></a>
	<a id="a5" href="CastleLogin.jsp"></a>
	<a id="a6" href="#"></a>
</body>
</html>