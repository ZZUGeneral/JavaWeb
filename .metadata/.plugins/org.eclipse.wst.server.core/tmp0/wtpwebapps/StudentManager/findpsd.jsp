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
<script type="text/javascript">
	//验证码的更换
	function changeValidateCode() {
		document.getElementById("validateCode").src = "ValidateCodeServlet?rand="
				+ Math.random();
	}
</script>

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
				<c:if test="${identity!='teacher' }">
					<li class="current"><a href="student.jsp"><span
							class="icon icon-flatscreen"></span>学生</a></li>
				</c:if>
				<c:if test="${identity!='student' }">
					<li><a href="teacher.html"><span class="icon icon-pencil"></span>教师</a></li>
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
		<div class="centercontent">

			<div class="pageheader">
				<h1 class="pagetitle">修改密码</h1>
				<span class="pagedesc">密码</span>
			</div>
			<!--pageheader-->

			<div id="contentwrapper" class="contentwrapper">
				<div id="validation" class="subcontent">
					<div id="contentwrapper" class="contentwrapper">
						<div class="contenttitle2">
							<h3>修改密码</h3>
						</div>
						<form id="form1" class="stdform" method="post"
							action="/StudentManager/FindPasswordServlet">

							<p>
								<label>学号</label> <span class="field"><input type="text"
									id="no" name="no" class="longinput" /></span>
							</p>

							<p>
								<label>姓名</label> <span class="field"><input type="text"
									id="name" name="name" class="longinput" /></span>
							</p>

							<p>
								<label>性别</label> <span class="field"> <input
									type="radio" name="gender" id="gender" checked="checked"
									value="男" checked="checked" />男 &nbsp;&nbsp;&nbsp;<input
									type="radio" name="gender" id="gender" value="女" />女
								</span>
							</p>

							<p>
								<label>Email</label> <span class="field"><input
									type="text" id="email" name="email" class="longinput" /></span>
							</p>

							<p>
								<label>生日</label> <span class="field"> <input
									id="birthday" name="birthday" type="date" class="width100" />
								</span>
							</p>
							<p>
								<label>院系</label> <span class="field"> <select
									name="dept" id="dept">
										<option value="">请选择:</option>
										<option value="123">外语学院</option>
										<option value="243">信息工程学院</option>
										<option value="343">医学院</option>
										<option value="423">历史学院</option>
								</select>
								</span>
							</p>
							<p>
								<label>新密码</label> <span class="field"> <input
									id="password" name="password" type="password" class="width100"
									class="longinput" />
								</span>
							</p>

							<br />
							<div align="center">
								<a href="/StudentManager/MyselfServlet"><button
										class="stdbtn btn_yellow">返回上一级</button></a>
								<button type="submit" class="stdbtn btn_yellow">修改</button>
							</div>
						</form>
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
