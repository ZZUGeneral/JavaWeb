<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>ZZU学生管理</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<script type="text/javascript" src="js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript"
	src="js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.tagsinput.min.js"></script>
<script type="text/javascript" src="js/plugins/charCount.js"></script>
<script type="text/javascript" src="js/plugins/ui.spinner.min.js"></script>
<script type="text/javascript" src="js/plugins/chosen.jquery.min.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
<script type="text/javascript" src="js/custom/forms.js"></script>
<script type="text/javascript" src="js/plugins/colorpicker.js"></script>
<script type="text/javascript" src="js/plugins/jquery.jgrowl.js"></script>
<script type="text/javascript" src="js/plugins/jquery.alerts.js"></script>
<script type="text/javascript" src="js/custom/elements.js"></script>

<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="css/style.ie9.css"/>
<![endif]-->
<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="css/style.ie8.css"/>
<![endif]-->
<!--[if lt IE 9]>
	<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
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
					<img src="/StudentManager/images/thumbs/avatar.png" alt="" /> <span><c:out
							value="${identity }"></c:out></span>
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
							class="icon icon-flatscreen"></span>学生</a></li>
				</c:if>
				<c:if test="${identity=='teacher' }">
					<li><a href="teacher.jsp"><span class="icon icon-pencil"></span>教师</a></li>
				</c:if>
				<c:if test="${identity=='admin' }">
					<li><a href="admin.jsp"><span class="icon icon-pencil"></span>管理员</a></li>
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
				<c:if test="${identity=='student' }">
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
				</c:if>
				<c:if test="${identity=='teacher' }">
					<li><a href="#error" class="error">教师信息</a> <span
						class="arrow"></span>
						<ul id="error">
							<li><a
								href="/StudentManager/TeacherBasicinfoServlet?page=first">教师基本信息</a></li>
							<li><a href="/StudentManager/TeacherCourseServlet">任课信息</a></li>
							<li><a href="/StudentManager/TeacherStudentServlet">学生基本信息</a></li>
							<li><a
								href="/StudentManager/ShowStudentScoreServlet?page=first">成绩信息</a></li>
							<li><a href="/StudentManager/addCourse.jsp">添加课程</a></li>
						</ul></li>
				</c:if>
				<c:if test="${identity=='admin' }">
					<li><a href="#formsub" class="editor">学生管理</a> <span
						class="arrow"></span>
						<ul id="formsub">
							<li><a
								href="/StudentManager/StudentBasicinfoServlet?page=first">学生基本信息</a></li>
							<li><a href="/StudentManager/register.jsp">添加学生</a></li>
						</ul></li>

					<li><a href="#error" class="error">教师管理</a> <span
						class="arrow"></span>
						<ul id="error">
							<li><a
								href="/StudentManager/TeacherBasicinfoServlet?page=first">教师基本信息</a></li>
							<li><a
								href="/StudentManager/StudentChooseCourseServlet?page=first">删除课程</a></li>
						</ul></li>

				</c:if>

			</ul>

			<a class="togglemenu"></a> <br /> <br />
		</div>
		<!--leftmenu-->

		<div class="centercontent">

			<div class="pageheader">
				<h1 class="pagetitle">注册</h1>
				<span class="pagedesc">注册信息</span>
			</div>
			<!--pageheader-->

			<div id="contentwrapper" class="contentwrapper">


				<div id="validation" class="subcontent">



					<c:if test="${! empty myself }">
						<form id="form1" class="stdform" method="post"
							action="/StudentManager/UpdateMyselfServlet">

							<p>
								<label>学号</label> <span class="field"><input type="text"
									id="no" name="no" value="${myself.no }" class="longinput"
									readonly /></span>
							</p>

							<p>
								<label>姓名</label> <span class="field"><input type="text"
									id="name" name="name" value="${myself.name }" class="longinput" /></span>
							</p>

							<p>
								<label>性别</label> <span class="field"> <input
									type="radio" name="gender" id="gender" checked="checked"
									class="longinput" value="男"
									checked="${myself.gender == '男'?'checked':null}" />男 <input
									type="radio" name="gender" id="gender" class="longinput"
									value="女" checked="${myself.gender == '女' }" />女
								</span>
							</p>

							<p>
								<label>Email</label> <span class="field"><input
									type="text" id="email" name="email" value="${myself.email }"
									class="longinput" /></span>
							</p>

							<p>
								<label>生日</label> <span class="field"> <input
									id="birthday" name="birthday" value="${myself.birthday }"
									type="date" class="width100" />
								</span>
							</p>
							<p>
								<label>院系</label> <span class="field"> <select
									name="dept" id="dept" value=" ${myself.dept }">
										<option value="">请选择:</option>
										<option value="123">外语学院</option>
										<option value="243">信息工程学院</option>
										<option value="343">医学院</option>
										<option value="423">历史学院</option>
								</select>
								</span>
							</p>

							<br />
							<div align="center">
								<a href="/StudentManager/MyselfServlet"><button
										class="stdbtn btn_yellow">返回上一级</button></a>
								<button type="submit" class="stdbtn btn_yellow">修改</button>
							</div>
						</form>
					</c:if>


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
