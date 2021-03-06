<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 获得请求的绝对地址 
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<base href="<%=basePath%>">
<!-- layui -->
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<!--fonts-->
<link
	href='http://fonts.useso.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Slabo+27px'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.useso.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

<!--//fonts-->
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Favorites Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
		Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<!-- //for-mobile-apps -->
<!-- js -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- js -->
<!-- cart -->
<script src="js/simpleCart.min.js">
	
</script>
<!-- cart -->
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<!-- start-smoth-scrolling -->
</head>
<body>
	<!-- 从request对象中获取一个JavaBean对象 -->
	<jsp:useBean id="user" class="zzu.minjie.bean.User" scope="request"></jsp:useBean>
	<!-- header -->
	<div class="header">
		<div class="container">
			<div class="top-header">
				<div class="header-left">
					<p>新会员下单立享8折优惠！</p>
				</div>
				<div class="login-section">
					<div class="head_user">
						<%
							if (session.getAttribute("SESSION_NICK") == null) {
						%>
						<a href="login.jsp" target="_parent"><span class="type1">登录</span></a>
						<a href="register.jsp" target="_parent"><span class="type2">注册</span></a>
						<%
							} else if (session.getAttribute("SESSION_NICK") != null) {
						%>
						<a href="UserInfoServlet?type=select">${sessionScope.SESSION_NICK}<%
							//=sessionStudent.getStudentNum()
						%></a>&nbsp;&nbsp; <a href="LogoutServlet">退出</a>
						<%
							}
						%>
					</div>
				</div>
				<!-- start search-->
				<div class="search-box">
					<div id="sb-search" class="sb-search">
						<form>
							<input class="sb-search-input" placeholder="请输入内容" type="search"
								name="search" id="search"> <input
								class="sb-search-submit" type="submit" value=""> <span
								class="sb-icon-search"> </span>
						</form>
					</div>
				</div>
				<!-- search-scripts -->
				<script src="js/classie.js"></script>
				<script src="js/uisearch.js"></script>
				<script>
					new UISearch(document.getElementById('sb-search'));
				</script>
				<!-- //search-scripts -->
				<div class="header-right">
					<div class="cart box_1">
						<a href="shopcart.jsp">
							<h3>
								<img src="images/bag.png" alt="">
							</h3>
						</a>
						<p>
							<a href="shopcart.jsp" class="simpleCart_empty">购物车</a>
						</p>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>

	<!-- //header -->
	<!-- banner -->
	<div class="banner-slider">
		<div class="banner-pos">
			<div class="banner one page-head">
				<div class="container">
					<div class="navigation text-center">
						<span class="menu"><img src="images/menu.png" alt="" /></span>
						<ul class="nav1">
										<li><a class="active" href="index.jsp">首页</a></li>
										<li><a href="member.jsp">会员中心</a></li>
										<li><a href="menu.jsp">菜单</a></li>
										<li><a href="HistoryOrderServlet">订单</a></li>
										<li><a href="#">今日特色</a>
										<li><a href="contact.jsp">联系我们</a></li>
										<div class="clearfix"></div>
									</ul>
						<!-- script for menu -->
						<script>
							$("span.menu").click(function() {
								$("ul.nav1").slideToggle(300, function() {
									// Animation complete.
								});
							});
						</script>
						<!-- //script for menu -->

					</div>
					<!-- point burst circle -->
					<div class="logo">
						<a href="index.html">
							<div class="burst-36 ">
								<div>
									<div>
										<span><img src="images/logo.png" alt="" /></span>
									</div>
								</div>
							</div>
							<h1>FAVORITES</h1>
						</a>
					</div>
					<!-- //point burst circle -->


				</div>
			</div>
		</div>
	</div>
	<!-- //banner -->
	<!-- registration-form -->
	<div class="registration-form">
		<div class="container">
			<h3>个人信息</h3>
			<div class="strip"></div>
			<div class="registration-grids">
				<div class="reg-form">
					<div class="reg">
						<ul>
							<li class="text-info">账号:</li>
							<li>${user.userId }</li>
							<li><label style="color: red" id="idValidate"></label></li>
						</ul>
						<ul>
							<li class="text-info">昵称:</li>
							<li>${user.nick }</li>
							<li><label style="color: red" id="nickValidate"></label></li>
						</ul>
						<ul>
							<li class="text-info">真实姓名:</li>
							<li>${user.name }</li>
						</ul>
						<ul>
							<li class="text-info">地址:</li>
							<li>${user.address }</li>
						</ul>
						<ul>
							<li class="text-info">电话:</li>
							<li>${user.phone }</li>
							<li><label style="color: red" id="phoneValidate"></label></li>
						</ul>
						<ul>
							<li class="text-info">性别:</li>
							<li>${user.gender }</li>
						</ul>
						<ul>
							<li class="text-info">生日:</li>
							<li>${user.birthday }</li>
						</ul>
						<p>
							<a href="UserInfoServlet?type=updateSelect">
								<h2>
									<span class="label label-warning">修改个人信息</span>
								</h2>
							</a>
						</p>
					</div>
				</div>

				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- registration-form -->


	<!-- footer-top -->
	<div class="footer-top">
		<div class="container">
			<div class="col-md-3 footer-grid">
				<h3>
					<a href="#">FAVORITES</a>
				</h3>
			</div>
			<div class="col-md-3 footer-grid">
				<h4>店内</h4>
				<p>
					周一 - -周日<span>7 : 00 - 21 : 00</span>
				</p>
			</div>
			<div class="col-md-3 footer-grid">
				<h4>外卖</h4>
				<p>
					周一 - -周日<span>7 : 00 - 21 : 00</span>
				</p>
			</div>
			<div class="col-md-3 footer-grid">
				<h4>地址</h4>
				<ul>
					<li class="list-one">郑州大学科学大道100号</li>
					<li class="list-two"><a href="http://www.zzu.edu.cn/">zzu.zhuoyue.com</a></li>
					<li class="list-three">+8 800 555 555 55</li>
				</ul>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- smooth scrolling -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			 */
			$().UItoTop({
				easingType : 'easeOutQuart'
			});
		});
	</script>
	<a href="#" id="toTop" style="display: block;"> <span
		id="toTopHover" style="opacity: 1;"> </span></a>
	<!-- //smooth scrolling -->

</body>
</html>