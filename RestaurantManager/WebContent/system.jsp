<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
	<head>
		<link rel="stylesheet" type="text/css" href="css/all.css" />
		<link rel="stylesheet" type="text/css" href="css/context.css"/>
		<title></title>
	</head>

	<body id="background">
		<div id="body">
			<!--
            	作者：luchao7285@163.com
            	时间：2017-03-11
            	描述：设置页头
            -->
			<div id="top">
				<div>
					<img src="img/left-top-right.gif" />
				</div>
				<div id="title">
					<p>管理员信息</p>
				</div>
				<div id="top_body">
					<img src="img/content-bg.gif" height="31px" />
				</div>
				<div>
					<img src="img/nav-right-bg.gif" />
				</div>
			</div>
			<!--
            	作者：luchao7285@163.com
            	时间：2017-03-11
            	描述：设置页中
            -->
			<div id="middle">
				<br/>
				<br/>
				<form action="${pageContext.request.contextPath}/ModifyPasswordServlet" method="post">
				<table align="center" border="1" cellspacing="0" cellpadding="0">
					<tr>
						<td colspan="2">更改管理员信息</td>
					</tr>
					<tr>
						<td class="left">管理员账号：</td>
						<td class="right">${request.getSession().getAttribute("userId")}</td>
					</tr>
					<tr>
						<td class="left">管理员密码：</td>
						<td class="right"><input type="text" name="password" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit" /></td>
					</tr>
				</table>
				</form>
				<br/>
				<br/>
			</div>
		</div>
	</body>

</html>