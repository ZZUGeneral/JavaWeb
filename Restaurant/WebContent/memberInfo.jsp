<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page
	import="zzu.minjie.bean.Notice,zzu.minjie.bean.DishesRank,zzu.minjie.dao.DishesRankDao,zzu.minjie.bean.Food,zzu.minjie.dao.NoticeDao,zzu.minjie.dao.FoodDao,java.util.List,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<title>首页</title>
	<!--fonts-->
		<link href='http://fonts.useso.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>
		<link href='http://fonts.useso.com/css?family=Slabo+27px' rel='stylesheet' type='text/css'>
		<link href='http://fonts.useso.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
		
	<!--//fonts-->
			<link href="css/bootstrap.css" rel="stylesheet">
			<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<!-- js -->
		<script type="text/javascript" src="js/jquery.min.js"></script>
	<!-- js -->
	<!-- cart -->
		<script src="js/simpleCart.min.js"> </script>
	<!-- cart -->
	<!-- start-smoth-scrolling -->
		<script type="text/javascript" src="js/move-top.js"></script>
		<script type="text/javascript" src="js/easing.js"></script>
		<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();//防止链接打开url(.scroll)
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);//js被chrome和Firefox都支持
				});
			});
		</script>
	<!-- start-smoth-scrolling -->

</head>
<body>
<!-- header -->
<div class="header">
	<div class="container">
		<div class="top-header">
				<div class="header-left">
					<p>新会员下单立享8折优惠！</p>
				</div>
				<div class="login-section">
					<ul>
						<li><a href="login.jsp">登录</a>  </li>
						<li><a href="register.html">注册</a> </li>
					</ul>
				</div>
				<!-- start search-->
				    <div class="search-box">
					    <div id="sb-search" class="sb-search">
							<form>
								<input class="sb-search-input" placeholder="请输入内容" type="search" name="search" id="search">
								<input class="sb-search-submit" type="submit" value="">
								<span class="sb-icon-search"> </span>
							</form>
						</div>
				    </div>
					<!-- search-scripts -->
					<script src="js/classie.js"></script>
					<script src="js/uisearch.js"></script>
						<script>
							new UISearch( document.getElementById( 'sb-search' ) );
						</script>
				<!-- //search-scripts -->
				<div class="header-right">
						<div class="cart box_1">
							<a href="checkout.html">
								<h3> <span class="simpleCart_total"> $0.00 </span> (<span id="simpleCart_quantity" class="simpleCart_quantity"> 0 </span> 条)<img src="images/bag.png" alt=""></h3>
							</a>	
							<p><a href="javascript:;" class="simpleCart_empty">购物车</a></p>
							<div class="clearfix"> </div>
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
									$(function () {
									 // Slideshow 4
									$("#slider3").responsiveSlides({
										auto: true,
										pager: false,
										nav: false,
										speed: 500,
										namespace: "callbacks",
										before: function () {
									$('.events').append("<li>before event fired.</li>");
									},
									after: function () {
										$('.events').append("<li>after event fired.</li>");
										}
										});
										});
								</script>
		
		<div  id="top" class="callbacks_container">
			<ul class="rslides" id="slider3">
				<li>
					<div class="banner one">
						<div class="container">
							<div class="navigation text-center">
								<span class="menu"><img src="images/menu.png" alt=""/></span>
									<ul class="nav1">
										<li><a class="active" href="#">首页</a></li>
										<li><a href="#">关于我们</a></li>
										<li><a href="#">菜单</a></li>
										<li><a href="#">订单</a></li>
										<li><a href="#">今日特色</a>
										<li><a href="#">会员中心</a>
										<li><a href="#">联系我们</a></li>
										<div class="clearfix"></div>
									</ul>
								

							</div>
													
						</div>
					</div>
				</li>				
			</ul>
		</div>
	</div>
	<div class="clearfix"></div>
	<!-- banner-bottom -->
		
	<!-- //banner-bottom -->
</div>
<!-- //banner -->


<div class="ofNav">
	<div class="content">
		<div class="left"><a href='/member_16.html' class='cur'>会员信息</a><a href='/membersearch_17.html'>会员权益</a><a href='/memberitem_18.html'>外卖信息</a></div>

	</div>
</div>





<!-- footer-top -->
<div class="footer-top">
	<div class="container">
		<div class="col-md-3 footer-grid">
			<h3><a href="#">FAVORITES</a></h3>
		</div>
		<div class="col-md-3 footer-grid">
			<h4>店内</h4>
			<p>周一 - -周日<span>7 : 00 - 21 : 00</span></p>
		</div>
		<div class="col-md-3 footer-grid">
			<h4>外卖</h4>
			<p>周一 - -周日<span>7 : 00 - 21 : 00</span></p>
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
		$().UItoTop({ easingType: 'easeOutQuart' });
		});
	</script>
	<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!-- //smooth scrolling -->


</body>
</html>
