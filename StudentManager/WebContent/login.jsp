<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	// 获得请求的绝对地址
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>登录页面</title>
<link rel="stylesheet" href="/StudentManager/css/style.default.css"
	type="text/css" />
<script type="text/javascript"
	src="/StudentManager/js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript"
	src="/StudentManager/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript"
	src="/StudentManager/js/plugins/jquery.cookie.js"></script>
<script type="text/javascript"
	src="/StudentManager/js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript"
	src="/StudentManager/js/custom/general.js"></script>
<script type="text/javascript" src="/StudentManager/js/custom/index.js"></script>
<script type="text/javascript">
	function validate() {
		var stu_no = document.getElementById("stu_no");
		var password = document.getElementByIf("password");
		if (stu_no == null) {
			alert("学号不能为空");
			return false;
		}
		if (password == null) {
			alert("密码不能为空");
			return false;
		}
		return true;
	}
</script>
</head>


<body class="loginpage">
	<%
		String NO = "";
		String PWD = "";
		// 从客户端读取Cookie
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("COOKIE_NO".equals(cookie.getName())) {
					// 解密获取存储在Cookie中的求职者Email
					NO = com.zzu.student.util.CookieEncryptTool.decodeBase64(cookie.getValue());
				}
				if ("COOKIE_PWD".equals(cookie.getName())) {
					// 解密获取存储在Cookie中的求职者登录密码
					PWD = com.zzu.student.util.CookieEncryptTool.decodeBase64(cookie.getValue());
				}
			}
			System.out.println(NO + "==============" + PWD);
		}
	%>
	<div class="loginbox">
		<div class="loginboxinner">

			<div class="logo">
				<h1 class="logo">
					ZZU<span>学生</span>
				</h1>
				<span class="slogan">信息管理系统</span>
			</div>
			<!--logo-->

			<br clear="all" /> <br />
			<form id="login" action="LoginServlet" method="post">

				<div class="username">
					<div class="staffIdinner">
						<input type="text" name="stu_no" id="stu_no" value="<%=NO%>" />
					</div>
				</div>

				<div class="password">
					<div class="passwordinner">
						<input type="password" name="password" id="password"
							value="<%=PWD%>" />
					</div>
				</div>
				<div>
					<input type="hidden" name="requestPath"
						value="${requestScope.requestPath }">
				</div>

				<input type="submit" value="登录" onclick="validate();" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="重置">

				<div class="keep">
					<input type="checkbox" name="rememberMe" id="rememberMe"
						value="true" /> 记住密码 &nbsp;&nbsp;&nbsp;&nbsp; <a
						href="findpsd.jsp">找回密码</a>
				</div>


			</form>

		</div>
		<!--loginboxinner-->
	</div>
	<!--loginbox-->


</body>
</html>
