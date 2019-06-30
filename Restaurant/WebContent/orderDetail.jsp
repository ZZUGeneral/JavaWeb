<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Check Out</title>
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
<script type="application/x-javascript">
	
	
	
	
	
	
	
	
	
	
			addEventListener("load", function() {
				setTimeout(hideURLbar, 0);
			}, false);

			function hideURLbar() {
				window.scrollTo(0, 1);
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
	<!-- checkout -->
	<div class="cart-items">
		<div class="container">
			<h1>订单详情</h1>
			<div class="strip-line"></div>
			<div class="cart-gd">
				<c:choose>
					<c:when test="${! empty FoodList}">
						<c:forEach items="${FoodList}" var="list">
							<div class="cart-header">
								<div class="cart-sec simpleCart_shelfItem">
									<div class="cart-item cyc">
										<img src="images/k3.jpg" class="img-responsive" alt="">
									</div>
									<div class="cart-item-info">
										<h3>
											<a href="#">${list.name } </a>
										</h3>
										<ul class="qty">
											<li>
												<p>${list.explain }</p>
											</li>
										</ul>
										<div class="delivery">
											<p>单价 : ￥ ${list.price }</p>
											<div align="center">
												数量 : <input type="text"
													style="width: 50px; height: auto; text-align: center;"
													value="${list.number }" disabled="disabled"
													background-color="#000" />
											</div>
											<div align="right">计价 : ￥${list.number*list.price }</div>
										</div>
									</div>
									<div class="clearfix"></div>

								</div>
							</div>
						</c:forEach>
					</c:when>
				</c:choose>
				<div align="right">
					<font size="6">总价 : ￥ ${sum }</font>
				</div>
			</div>
		</div>
	</div>

	<!-- //checkout -->
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
