<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<!--fonts-->
<link
	href='http://fonts.useso.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Slabo+27px'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.useso.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!--//fonts-->
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Favorites Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
		Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	
	
	 addEventListener("load", function() {
		 setTimeout(hideURLbar, 0); }, false);
	 function hideURLbar(){
		 window.scrollTo(0,1); 
		 } 






</script>
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
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<script type="text/javascript">
	function changeVerificationCode() {
		document.getElementById("validateCode").src = "ValidateCodeServlet?rand="
				+ Math.random();
	}
</script>

<!-- start-smoth-scrolling -->

</head>
<body>
	<div class="header">
		<div class="container">
			<div class="top-header">
				<div class="header-left">
					<p>新会员下单立享8折优惠！</p>
				</div>
				<div class="login-section">
					<ul>
						<li><a href="login.jsp">登录</a></li>
						<li><a href="register.jsp">注册</a></li>
					</ul>
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
						<a href="checkout.html">
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

	<!-- banner -->
	<div class="banner-slider">
		<div class="banner-pos">
			<script src="js/responsiveslides.min.js"></script>
			<script>
				// You can also use "$(window).load(function() {"
				$(function() {
					// Slideshow 4
					$("#slider3").responsiveSlides(
							{
								auto : true,
								pager : false,
								nav : false,
								speed : 500,
								namespace : "callbacks",
								before : function() {
									$('.events').append(
											"<li>before event fired.</li>");
								},
								after : function() {
									$('.events').append(
											"<li>after event fired.</li>");
								}
							});
				});
			</script>

			<div id="top" class="callbacks_container">
				<ul class="rslides" id="slider3">
					<li>
						<div class="banner one">
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

								<div class="banner-info text-center">
									<p>美味常在!!</p>
									<div class="order">
										<a href="#">立即下单</a>
									</div>
								</div>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
		<div class="clearfix"></div>
		<!-- banner-bottom -->
		<!-- login-page -->
		<div class="login">
			<div class="container">
				<div class="login-grids">
					<div class="col-md-6 log">
						<h3>登陆</h3>
						<div class="strip"></div>
						<p>欢迎来到，请按提示操作。</p>
						<p>
							您已经在本网站登陆过，<a href="#">点击</a>
						</p>
						<form action="LoginServlet" method="post">
							<h5>账号:</h5>
							<input type="text" name="username" value="">
							<h5>密码:</h5>
							<input type="password" name="password" value="">
							<h5>验证码:</h5>
							<input type="text" name="verificationcode"> <img
								src="ValidateCodeServlet" id="verificationcode" title="点击换一换"
								onclick="changeVerificationCode()"> <a
								href="javascript:changeVerificationCode();">看不清？</a> <input
								type="submit" value="登陆" >

						</form>

						<button class="btn btn-primary" data-toggle="modal"
							data-target="#myModal">找回密码</button>
						<!-- 模态框（Modal） -->
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">&times;</button>
										<h4 class="modal-title" id="myModalLabel">找回密码</h4>
									</div>

									<div class="modal-footer" aling="left">
										<form action="FindPwdServler" method="post"
											onsubmit="return changepwd()">
											<div align="left">
												账号：<input id="userID" name="userID" type="text"
													placeholder="输入账号"></input><br>
											</div>
											<div align="left">
												手机号：<input id="phone" name="phone" type="text"
													placeholder="输入手机号"></input> <br>
											</div>
											<div align="left">
												新密码：<input id="newpwd" name="newpwd" type="password"
													placeholder="输入新密码"></input> <br>
											</div>
											<div align="left">
												确认新密码：<input id="confirmpwd" name="confirmpwd"
													type="password" placeholder="确认新密码"></input> <br>
											</div>

											<button type="button" class="btn btn-default"
												data-dismiss="modal" algin="left">关闭</button>
											<button type="submit" class="btn btn-primary" align="right">找回密码</button>
										</form>
									</div>
								</div>
								<!-- /.modal-content -->
							</div>
							<!-- /.modal -->
						</div>
					</div>
					<div class="col-md-6 login-right">
						<h3>注册指引</h3>
						<div class="strip"></div>
						<p>在本网站创建一个账号，你可以享受更多的优惠。</p>
						<a href="register.jsp" class="hvr-shutter-in-horizontal button">注册账号</a>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<!-- //login-page -->
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
