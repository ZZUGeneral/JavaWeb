<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>ZZU学生挂管理系统</title>
<link rel="stylesheet" href="/School/css/style.default.css"
	type="text/css" />
<script type="text/javascript"
	src="/School/js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript"
	src="/School/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="/School/js/plugins/jquery.cookie.js"></script>
<script type="text/javascript"
	src="/School/js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript"
	src="/School/js/plugins/jquery.flot.min.js"></script>
<script type="text/javascript"
	src="/School/js/plugins/jquery.flot.resize.min.js"></script>
<script type="text/javascript"
	src="/School/js/plugins/jquery.slimscroll.js"></script>
<script type="text/javascript" src="/School/js/custom/general.js"></script>
<script type="text/javascript" src="/School/js/custom/dashboard.js"></script>
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
					<img src="/School/images/thumbs/avatar.png" alt="" /> <span>管理员</span>
				</div>
				<!--userinfo-->

				<div class="userinfodrop">
					<div class="avatar">
						<a href="GetHeadShotServlet?No=${SESSION_NO }"><img
							src="/School/images/thumbs/avatarbig.png" alt="" /></a>
						<div class="changetheme">
							切换主题: <br /> <a class="default"></a> <a class="blueline"></a> <a
								class="greenline"></a> <a class="contrast"></a> <a
								class="custombg"></a>
						</div>
					</div>
					<!--avatar-->
					<div class="userdata">
						<h4>
							<a href="/School/MyselfServlet?No=${SESSION_NO }"><c:out
									value="${SESSION_NO }"></c:out></a>
						</h4>
						<ul>
							<li>开心每一天</li>
							<li>健康每一天</li>
							<li>奋斗每一天</li>
							<li><a href="/School/password.jsp">修改密码</a></li>
							<li><a href="/School/LogoutServlet">退出</a></li>
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
				<li class="current"><a href="index.jsp"><span
						class="icon icon-flatscreen"></span>首页</a></li>
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
						<li><a href="/School/StudentBasicinfoServlet?page=first">学生基本信息</a></li>
						<li><a href="/School/StudentScoreServlet">学生成绩信息</a></li>
						<li><a href="/School/StudentCourseServlet">课程信息</a></li>
						<li><a href="/School/StudentChooseCourseServlet?page=first">选课</a></li>
					</ul></li>
				<li><a href="#error" class="error">教师信息</a> <span class="arrow"></span>
					<ul id="error">
						<li><a href="/School/TeacherBasicinfoServlet?page=first">教师基本信息</a></li>
						<li><a href="/School/TeacherCourseServlet">任课信息</a></li>
						<li><a href="/School/TeacherStudentServlet">学生基本信息</a></li>
						<li><a href="/School/ShowStudentScoreServlet?page=first">成绩信息</a></li>
						<li><a href="/School/addCourse.jsp">添加课程</a></li>
					</ul></li>

			</ul>

			<a class="togglemenu"></a> <br /> <br />
		</div>
		<!--leftmenu-->
		<div class="centercontent">

			<div class="pageheader">
				<h1 class="pagetitle">我的信息</h1>
				<span class="pagedesc">页面简介</span>
			</div>
			<!--pageheader-->

			<div id="contentwrapper" class="contentwrapper">
				<div id="validation" class="subcontent">
					<div id="contentwrapper" class="contentwrapper">
						<div class="contenttitle2">
							<h3>我的详细信息</h3>
						</div>
						<c:if test="${! empty myself }">
							<!--contenttitle-->
							<table cellpadding="0" cellspacing="0" border="0"
								class="stdtable" id="dyntable">
								<tbody>

									<tr class="gradeX">
										<td align="center">头像</td>
										<td class="center"><img
											src="/School/images/user/${myself.headShot }" width="150"
											height="150"></td>
									</tr>
									<tr class="gradeX">
										<td align="center">学号</td>
										<td class="center"><c:out value="${myself.no }"></c:out></td>
									</tr>
									<tr>
										<td align="center">姓名</td>
										<td class="center"><c:out value="${myself.name }"></c:out></td>
									</tr>
									<tr>
										<td align="center">性别</td>
										<td class="center"><c:out value="${myself.gender }"></c:out></td>
									</tr>

									<tr>
										<td align="center">院系</td>
										<td class="center"><c:out value="${myself.dept }"></c:out></td>
									</tr>

									<tr>
										<td align="center">生日</td>
										<td class="center"><c:out value="${myself.birthday }"></c:out></td>
									</tr>
									<tr>
										<td align="center">邮箱</td>
										<td class="center"><c:out value="${myself.email }"></c:out></td>
									</tr>

								</tbody>
							</table>
							<div align="CENTER">
								<a href="/School/TeacherBasicinforServlet"><button
										class="stdbtn btn_yellow">返回上一级</button></a> <a
									href="/School/GetUpdateInfoServlet"><button
										class="stdbtn btn_yellow">修改</button></a>
							</div>
						</c:if>

					</div>
				</div>
				<!--subcontent-->

			</div>
			<!--contentwrapper-->

		</div>
		<!-- centercontent -->


	</div>
	<!--bodywrapper-->

</body>
</html>
