<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>ZZU学生管理系统</title>
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
<!-- <script type="text/javascript">
$(function(){
	if(! ${success}.eq""){
		alert(${success});
	}
});


</script> -->
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

		<div class="centercontent tables">

			<div class="pageheader notab">
				<h1 class="pagetitle">课程信息</h1>
			</div>
			<!--pageheader-->
			<div id="contentwrapper" class="contentwrapper">
				<form action="/School/SearchServlet?location=course" method="post">
					<input style="width: 30%;" type="text" name="keyword" id="keyword"/>
					<button type="submit">搜索</button>
				</form>
				<div class="contenttitle2">
					<h3>课程信息</h3>
				</div>
				<!--contenttitle-->
				<table cellpadding="0" cellspacing="0" border="0" class="stdtable"
					id="dyntable">
					<colgroup>
						<col class="con0" />
						<col class="con0" />
						<col class="con0" />
						<col class="con0" />
						<col class="con0" />
						<col class="con0" />
						<col class="con0" />
						<col class="con0" />
					</colgroup>
					<thead>
						<tr>
							<th class="head0">课程编号</th>
							<th class="head0">课程名称</th>
							<th class="head0">类型</th>
							<th class="head0">学分</th>
							<th class="head0">教师</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th class="head0">课程编号</th>
							<th class="head0">课程名称</th>
							<th class="head0">类型</th>
							<th class="head0">学分</th>
							<th class="head0">教师</th>
						</tr>
					</tfoot>
					<tbody>
						<c:choose>

							<c:when test="${! empty cbList }">
								<c:forEach items="${cbList }" var="cb">
									<tr class="gradeX">
										<td class="center"><c:out value="${cb.course_no }"></c:out></td>
										<td class="center"><c:out value="${cb.course_name  }"></c:out></td>
										<td class="center"><c:out value="${cb.type }"></c:out></td>
										<td class="center"><c:out value="${cb.credit }"></c:out></td>
										<td class="center"><c:out value="${cb.teacher_name }"></c:out></td>
									</tr>

								</c:forEach>
							</c:when>
						</c:choose>

					</tbody>
				</table>
				<br /> <br />
			</div>
			<!--contentwrapper-->

		</div>
		<!-- centercontent -->


	</div>
	<!--bodywrapper-->

</body>
</html>
