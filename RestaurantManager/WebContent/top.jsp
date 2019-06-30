<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="css/all.css" />
		<link rel="stylesheet" type="text/css" href="css/top.css"/>
		<title></title>
	</head>

	<body scroll="no">
		<div id="background">
			<div>
				<img src="img/logo.gif" />
			</div>
			<div id="title">
				<marquee><a href="" >${Name}</a>您好,感谢登陆使用！</marquee>
			</div>
			<div id="out">
				<a href="LogoutServlet" target="_top"><img src="img/out.gif" /></a>
			</div>
		</div>
	</body>

</html>