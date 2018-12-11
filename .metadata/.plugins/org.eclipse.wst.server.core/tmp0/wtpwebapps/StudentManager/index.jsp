<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>控制台页面</title>
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
	src="/StudentManager/js/plugins/jquery.flot.min.js"></script>
<script type="text/javascript"
	src="/StudentManager/js/plugins/jquery.flot.resize.min.js"></script>
<script type="text/javascript"
	src="/StudentManager/js/plugins/jquery.slimscroll.js"></script>
<script type="text/javascript"
	src="/StudentManager/js/custom/general.js"></script>
<script type="text/javascript"
	src="/StudentManager/js/custom/dashboard.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/plugins/excanvas.min.js"></script><![endif]-->
<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="css/style.ie9.css"/>
<![endif]-->
<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="css/style.ie8.css"/>
<![endif]-->
<!--[if lt IE 9]>
	<script src="js/plugins/css3-mediaqueries.js"></script>
<![endif]-->
</head>

<body class="withvernav">
	<div class="bodywrapper">
		<div class="topheader">
			<div class="left">
				<h1 class="logo">
					ZZU<span>学生</span>
				</h1>
				<span class="slogan">信息管理系统</span>

				<!--search-->

				<br clear="all" />

			</div>
			<!--left-->

			<div class="right">
				<!--<div class="notification">
                <a class="count" href="ajax/notifications.html"><span>9</span></a>
        	</div>-->
				<div class="userinfo">
					<img src="/StudentManager/images/thumbs/avatar.png" alt="" /> <span>管理员</span>
				</div>
				<!--userinfo-->

				<div class="userinfodrop">
					<div class="avatar">
						<a href="GetHeadShotServlet?No=${SESSION_NO }"><img
							src="/StudentManager/images/thumbs/avatarbig.png" alt="" /></a>
						<div class="changetheme">
							切换主题: <br /> <a class="default"></a> <a class="blueline"></a> <a
								class="greenline"></a> <a class="contrast"></a> <a
								class="custombg"></a>
						</div>
					</div>
					<!--avatar-->
					<div class="userdata">
						<h4>
							<a href="/StudentManager/MyselfServlet?No=${SESSION_NO }"><c:out
									value="${SESSION_NO }"></c:out></a>
						</h4>
						<ul>
							<li>开心每一天</li>
							<li>健康每一天</li>
							<li>奋斗每一天</li>
							<li><a href="/StudentManager/password.jsp">修改密码</a></li>
							<li><a href="/StudentManager/LogoutServlet">退出</a></li>
						</ul>
					</div>
					<!--userdata-->
				</div>
				<!--userinfodrop-->
			</div>
			<!--right-->
		</div>
		<!--topheader-->


		<div class="header">
			<ul class="headermenu">
				<c:if test="${identity=='student' }">
					<li class="current"><a href="student.jsp"><span
							class="icon icon-flatscreen"></span>首页</a></li>
				</c:if>
				<c:if test="${identity=='teacher' }">
					<li><a href="teacher.html"><span
							class="icon icon-pencil"></span>Manage Blog</a></li>
				</c:if>
				<c:if test="${identity=='admin' }">
					<li><a href="admin.html"><span
							class="icon icon-message"></span>Messages</a></li>
				</c:if>
			</ul>

			<div class="headerwidget">
				<div class="earnings">
					<div class="one_half">
						<h4>每日一句</h4>
						<h3>越努力,越幸运！</h3>
					</div>
					<!-- <!--one_half-->
					<!--one_half last-->
				</div>
				<!--earnings-->
			</div>
			<!--headerwidget-->

		</div>
		<!--header-->

		<div class="vernav2 iconmenu">
			<ul>
				<li><a href="#formsub" class="editor">学生信息</a> <span
					class="arrow"></span>
					<ul id="formsub">
						<li><a
							href="/StudentManager/StudentBasicinfoServlet?page=first">学生基本信息</a></li>
						<li><a href="/StudentManager/StudentScoreServlet">学生成绩信息</a></li>
						<li><a href="/StudentManager/StudentCourseServlet">课程信息</a></li>
						<li><a
							href="/StudentManager/StudentChooseCourseServlet?page=first">选课</a></li>
					</ul></li>
				<li><a href="#error" class="error">教师信息</a> <span class="arrow"></span>
					<ul id="error">
						<li><a
							href="/StudentManager/TeacherBasicinfoServlet?page=first">教师基本信息</a></li>
						<li><a href="/StudentManager/TeacherCourseServlet">任课信息</a></li>
						<li><a href="/StudentManager/TeacherStudentServlet">学生基本信息</a></li>
						<li><a
							href="/StudentManager/ShowStudentScoreServlet?page=first">成绩信息</a></li>
						<li><a href="/StudentManager/addCourse.jsp">添加课程</a></li>
					</ul></li>

			</ul>

			<a class="togglemenu"></a> <br /> <br />
		</div>
		<!--leftmenu-->

		<div class="centercontent">

			<div class="pageheader">
				<h1 class="pagetitle">欢迎登陆学生信息管理页面</h1>
				<span class="pagedesc">Reading a book is like Re Writing it
					for yourself</span>
			</div>
			<!--pageheader-->

			<div id="contentwrapper" class="contentwrapper">

				<div id="updates" class="subcontent"></div>
				<br clear="all" />

			</div>
			<!-- centercontent -->

		</div>
	</div>
	<!--bodywrapper-->
</body>
</html>