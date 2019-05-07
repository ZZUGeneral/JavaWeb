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
							<p><a href="shopcart.jsp" class="simpleCart_empty">购物车</a></p>
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
		<div class="left"><a href='/member_16.html' class='cur'>会员权益</a><a href='memberInfo.jsp'>会员信息</a><a href='/memberitem_18.html'>外卖信息</a></div>

	</div>
</div>



<div class="mymargin">
<p class="MsoNormal" style="text-align:left;">
	<span style="font-size:24px;line-height:1.5;"><strong>会员简介：</strong></span><span></span> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<span style="font-size:18px;"><strong><br />
</strong></span> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<span style="font-size:18px;line-height:1.5;">本餐厅会员体系可为您提供会员价、积分换礼等多种权益，同时具有储值功能。本餐厅会员可在全国范围内的XX餐饮管理有限公司旗下各品牌门店使用。您在使用中如有任何建议或意见，请拨打全国客服热线</span><span style="font-size:18px;line-height:1.5;">4006-365-517</span><span style="font-size:18px;line-height:1.5;">，我们将竭诚为您提供更优质的服务！</span><span></span> 
</p>
<p class="MsoNormal">
	<span></span> 
</p>
<p class="MsoNormal">
	<span></span> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<b><span style="font-size:18px;"><br />
</span></b> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<b><span style="font-size:24px;line-height:1.5;">一、入会</span></b> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<span style="font-size:18px;"><br />
</span> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<span style="font-size:18px;line-height:1.5;">注册为本店用户，并完善姓名、性别、出生日期、手机号等信息，即可免费成为会员。</span> 
</p>
<p class="MsoNormal">
	<span></span> 
</p>
<p class="MsoNormal">
	<span></span> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<br />
</p>
<p class="MsoNormal" style="text-align:left;">
	<b><span style="font-size:18px;"><br />
</span></b> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<b><span style="font-size:24px;line-height:1.5;">二、会员</span></b> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<b><span style="font-size:18px;"><br />
</span></b> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<b><span style="font-size:18px;line-height:1.5;">1</span></b><b><span style="font-size:18px;line-height:1.5;">、会员等级：</span></b> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<span style="font-size:18px;line-height:1.5;">会员分为“会员”、“</span><span style="font-size:18px;line-height:1.5;">VIP</span><span style="font-size:18px;line-height:1.5;">”、“</span><span style="font-size:18px;line-height:1.5;">VVIP</span><span style="font-size:18px;line-height:1.5;">”三档。</span><span></span> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<span style="font-size:18px;line-height:1.5;">注册即可成为会员；</span><span></span> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<span style="font-size:18px;line-height:1.5;">消费累计</span><span style="font-size:18px;line-height:1.5;">500</span><span style="font-size:18px;line-height:1.5;">元即可升级为</span><span style="font-size:18px;line-height:1.5;">VIP</span><span style="font-size:18px;line-height:1.5;">；</span><span></span> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<span style="font-size:18px;line-height:1.5;">消费累计</span><span style="font-size:18px;line-height:1.5;">2500</span><span style="font-size:18px;line-height:1.5;">元即可升级为</span><span style="font-size:18px;line-height:1.5;">VVIP</span><span style="font-size:18px;line-height:1.5;">。</span><span></span> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<span style="font-size:18px;line-height:1.5;">会员升级后，每</span><span style="font-size:18px;line-height:1.5;">6</span><span style="font-size:18px;line-height:1.5;">个月消费不足</span><span style="font-size:18px;line-height:1.5;">500</span><span style="font-size:18px;line-height:1.5;">元，自动降低</span><span style="font-size:18px;line-height:1.5;">1档</span><span style="font-size:18px;line-height:1.5;">。</span><span></span> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<br />
</p>
<p class="MsoNormal" style="text-align:left;">
	<b><span style="font-size:18px;line-height:1.5;">2</span></b><b><span style="font-size:18px;line-height:1.5;">、会员权益：</span><span></span></b> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<span style="font-size:18px;line-height:1.5;">会员开卡赠送一张</span><span style="font-size:18px;line-height:1.5;">20</span><span style="font-size:18px;line-height:1.5;">元新人代金券，并可享受(1) 、(2)&nbsp;</span><span style="font-size:18px;line-height:1.5;">两项会员权益；</span><span></span> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<span style="font-size:18px;line-height:1.5;">升级到</span><span style="font-size:18px;line-height:1.5;">VIP</span><span style="font-size:18px;line-height:1.5;">赠送一张</span><span style="font-size:18px;line-height:1.5;">30</span><span style="font-size:18px;line-height:1.5;">元</span><span style="font-size:18px;line-height:1.5;">VIP</span><span style="font-size:18px;line-height:1.5;">代金券，并可享受</span><span style="line-height:115%;"><span></span><span style="font-size:18px;line-height:1.5;"><span style="font-size:18px;white-space:normal;line-height:1.5;">(1) 、(2)&nbsp;</span></span></span><span style="font-size:18px;"></span><span style="line-height:115%;"><span></span></span><span style="font-size:18px;line-height:1.5;">、</span><span style="line-height:1.5;"><span style="font-size:18px;line-height:1.5;">(</span></span><span style="font-size:18px;line-height:1.5;">3)&nbsp;</span><span style="line-height:115%;"><span></span></span><span style="font-size:18px;line-height:1.5;">三项会员权益；</span><span></span> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<span style="font-size:18px;line-height:1.5;">升级到</span><span style="font-size:18px;line-height:1.5;">VVIP</span><span style="font-size:18px;line-height:1.5;">赠送一张</span><span style="font-size:18px;line-height:1.5;">50</span><span style="font-size:18px;line-height:1.5;">元</span><span style="font-size:18px;line-height:1.5;">VVIP</span><span style="font-size:18px;line-height:1.5;">代金券，并可享受</span><span style="line-height:115%;"><span></span><span style="font-size:18px;"><span style="white-space:normal;line-height:1.5;"><span style="font-size:18px;line-height:1.5;">(1) 、(2)&nbsp;</span></span><span style="white-space:normal;font-size:18px;"></span><span style="white-space:normal;line-height:13.8px;"></span><span style="white-space:normal;font-size:18px;line-height:1.5;">、</span><span style="white-space:normal;line-height:1.5;"><span style="font-size:18px;line-height:1.5;">(</span></span><span style="white-space:normal;font-size:18px;line-height:1.5;">3) 、(</span></span></span><span style="font-size:18px;line-height:1.5;">4)&nbsp;</span><span style="line-height:115%;"><span></span></span><span style="font-size:18px;line-height:1.5;">四项会员权益。</span><span></span> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<span style="line-height:1.5;"><span style="font-size:18px;line-height:1.5;">(</span></span><span style="font-size:18px;line-height:1.5;">1</span><span style="font-size:18px;line-height:1.5;">)&nbsp;</span><span style="font-size:18px;line-height:1.5;">会员价：部分菜品具有会员价，开卡当餐即可享受；</span><span></span> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<span style="line-height:1.5;"><span style="font-size:18px;line-height:1.5;">(</span></span><span style="font-size:18px;line-height:1.5;">2</span><span style="font-size:18px;line-height:1.5;">)&nbsp;</span><span style="font-size:18px;line-height:1.5;">积分换礼：消费</span><span style="font-size:18px;line-height:1.5;">20</span><span style="font-size:18px;line-height:1.5;">元</span><span style="font-size:18px;line-height:1.5;">=1</span><span style="font-size:18px;line-height:1.5;">积分，每年</span><span style="font-size:18px;line-height:1.5;">12</span><span style="font-size:18px;line-height:1.5;">月</span><span style="font-size:18px;line-height:1.5;">31</span><span style="font-size:18px;line-height:1.5;">号积分清零，积分可在积分商城兑换多种优惠；</span><span></span> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<span style="line-height:1.5;"><span style="font-size:18px;line-height:1.5;">(</span></span><span style="font-size:18px;line-height:1.5;">3</span><span style="font-size:18px;line-height:1.5;">)&nbsp;</span><span style="font-size:18px;line-height:1.5;">生日权益：赠寿面、果盘</span><span style="font-size:18px;line-height:1.5;">+</span><span style="font-size:18px;line-height:1.5;">赠</span><span style="font-size:18px;line-height:1.5;">50</span><span style="font-size:18px;line-height:1.5;">元生日券</span><span style="font-size:18px;line-height:1.5;">+</span><span style="font-size:18px;line-height:1.5;">提前预约生日场地布置</span><span style="font-size:18px;line-height:1.5;">+</span><span style="font-size:18px;line-height:1.5;">生日音乐</span><span style="font-size:18px;line-height:1.5;">+</span><span style="font-size:18px;line-height:1.5;">预约代购蛋糕服务（个别门店如有差异，以门店信息为准）；</span><span></span> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<span style="line-height:1.5;"><span style="font-size:18px;line-height:1.5;">(</span></span><span style="font-size:18px;line-height:1.5;">4</span><span style="font-size:18px;line-height:1.5;">)&nbsp;</span><span style="font-size:18px;line-height:1.5;">新品体验官：新品上市将为您免费提供一款指定新品，以供品鉴。</span><span></span> 
</p>
<p class="MsoNormal">
	<span></span> 
</p>
<p class="MsoNormal">
	<b><span></span></b> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<b><span style="font-size:18px;"><br />
</span></b> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<b><span style="font-size:18px;"><br />
</span></b> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<b><span style="font-size:24px;line-height:1.5;">三、储值</span><span></span></b> 
</p>
<p class="MsoNormal">
	<span></span> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<b><span style="font-size:18px;"><br />
</span></b> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<b><span style="font-size:18px;line-height:1.5;">储值另享有如下优惠：</span><span></span></b> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<span style="font-size:18px;line-height:1.5;">500</span><span style="font-size:18px;line-height:1.5;">元返现</span><span style="font-size:18px;line-height:1.5;">60</span><span style="font-size:18px;line-height:1.5;">元，共</span><span style="font-size:18px;line-height:1.5;">560</span><span style="font-size:18px;line-height:1.5;">元；</span><span></span> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<span style="font-size:18px;line-height:1.5;">1000</span><span style="font-size:18px;line-height:1.5;">元返现</span><span style="font-size:18px;line-height:1.5;">150</span><span style="font-size:18px;line-height:1.5;">元，共</span><span style="font-size:18px;line-height:1.5;">1150</span><span style="font-size:18px;line-height:1.5;">元；</span><span></span> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<span style="font-size:18px;line-height:1.5;">4999</span><span style="font-size:18px;line-height:1.5;">元返现</span><span style="font-size:18px;line-height:1.5;">1000</span><span style="font-size:18px;line-height:1.5;">元，共</span><span style="font-size:18px;line-height:1.5;">5999</span><span style="font-size:18px;line-height:1.5;">元。</span><span></span> 
</p>
<p class="MsoNormal">
	<span></span> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<b><span style="font-size:18px;"><br />
</span></b> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<b><span style="font-size:18px;line-height:1.5;">储值使用规则：</span><span></span></b> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<span style="font-size:18px;line-height:1.5;">1</span><span style="font-size:18px;line-height:1.5;">、储值顾客请在结账时提供开卡手机号，并告知密码（密码请妥善保管）； </span><span></span> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<span style="font-size:18px;line-height:1.5;">2</span><span style="font-size:18px;line-height:1.5;">、不与部分优惠活动同时使用，详见店内明示；</span><span></span> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<span style="font-size:18px;line-height:1.5;">3</span><span style="font-size:18px;line-height:1.5;">、溢价部分按规则使用，不可兑换现金、不开发票、不可找零；</span><span></span> 
</p>
<p class="MsoNormal" style="text-align:left;">
	<span style="font-size:18px;line-height:1.5;">4</span><span style="font-size:18px;line-height:1.5;">、享受会员升级体系，拥有会员权益。</span> 
</p>

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
