<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册信息</title>
</head>
<body>
	账号：
	<c:out value="${account }"></c:out>
	<br /> 密码：
	<c:out value="${password }"></c:out>
</body>
</html>