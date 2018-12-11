<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@ page
	import="com.qst.itoffer.dao.CompanyDAO,com.qst.itoffer.bean.Company,com.qst.itoffer.bean.Job"%>
<%@ page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	// 获得请求的绝对地址
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to ZZU</title>
<base href="<%=basePath%>">
<meta name="renderer" content="ie-stand">
<link rel="shortcut icon" href="http://www.itoffer.cn/favicon.ico"
	type="image/x-icon" />
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/index.css" type="text/css" rel="stylesheet" />
</head>
<body class="tn-page-bg">
	<!-- 网站公共头文件 -->
	<jsp:include page="top.jsp"></jsp:include>
	<!-- 企业列表展示 -->
	<jsp:include page='${"CompanyServlet"}'>
		<jsp:param value="pageList" name="type"/>
		<jsp:param value="${param.pageNo }" name="pageNo"/>
	</jsp:include>
	<!-- 网站公共尾部 -->
	<iframe src="foot.html" width="100%" height="150" scrolling="no"
		frameborder="0"></iframe>
</body>
</html>