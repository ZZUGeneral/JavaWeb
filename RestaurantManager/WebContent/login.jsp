<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	// 获得请求的绝对地址
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/all.css" />
<script type="text/javascript">
	if (top.location != self.location) {
		top.location = "login.jsp";
	}
</script>
<title></title>
</head>
<style type="text/css">
</style>

<body>

	<!--
        	作者：luchao7285@163.com
        	时间：2017-03-11
        	描述：中部
        -->
	<%
		String applicantID = "";
		String applicantPwd = "";
		// 从客户端读取Cookie
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("COOKIE_APPLICANTID".equals(cookie.getName())) {
					// 解密获取存储在Cookie中的求职者Email
					applicantID = com.zzu.minjie.Util.CookieEncryptTool.decodeBase64(cookie.getValue());
				}
				if ("COOKIE_APPLICANTPWD".equals(cookie.getName())) {
					// 解密获取存储在Cookie中的求职者登录密码
					applicantPwd = com.zzu.minjie.Util.CookieEncryptTool.decodeBase64(cookie.getValue());
				}
			}
		}
		System.out.println(applicantID + " ====== " + applicantPwd);
	%>
	<div>
		<!--
            	作者：luchao7285@163.com
            	时间：2017-03-11
            	描述：中部上
            -->
		<div id="body_top"></div>
		<!--
            	作者：luchao7285@163.com
            	时间：2017-03-11
            	描述：中部中
            -->
		<div id="body_middle">
			<div id="body_middle_context">
				<div id="logo">
					<img src="img/logo.png" />
				</div>
				<div id="contacts">
					<p>
						<img src="img/icon-mail2.gif" />客户服务邮箱： <a href="#">admin@apsfc.com</a>
					</p>
					<p>
						<img src="img/icon-phone.gif" />官方网站： <a href="#">http://www.apsfc.com</a>
					</p>
				</div>
				<div id="instruction">
					<img src="img/icon-demo.gif" /> <a href="#">使用说明</a> <img
						src="img/icon-login-seaver.gif" /> <a href="#">在线客服</a>
				</div>
			</div>
			<div id="body_middle_context">
				<form action="LoginServlet" method="post">
					<table id="login">
						<tr>
							<td colspan="2"><b style="font-size: 16px;">登陆网上订餐后台管理</b></td>
						</tr>
						<tr>
							<td class="left">管理员：</td>
							<td class="right"><input type="text" name="ID"
								value="<%=applicantID%>" /></td>
						</tr>
						<tr>
							<td class="left">密码：</td>
							<td class="right"><input type="password" name="password"
								value="<%=applicantPwd%>" /></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="checkbox" name="cookiesave" value="true" />5天内自动登录</td>
						</tr>
						<tr>
							<td colspan="2" align="center" id="submit"><input
								type="submit" value="登录" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
								type="button" value="重置" /></td>
						</tr>
					</table>
				</form>
				<div id="imgwel">
					<img src="img/login-wel.gif" />
				</div>
			</div>
		</div>
		<!--
            	作者：luchao7285@163.com
            	时间：2017-03-11
            	描述：中部下
            -->
		<div id="body_bottom">Copyright © 2015-2020</div>
	</div>
</body>

</html>