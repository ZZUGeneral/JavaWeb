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
					<p>Place your order and get 20% off on each price</p>
				</div>
				<div class="login-section">
					<ul>
						<li><a href="login.html">Login</a></li> |
						<li><a href="register.html">Register</a></li>
					</ul>
				</div>
				<!-- start search-->
				<div class="search-box">
					<div id="sb-search" class="sb-search">
						<form>
							<input class="sb-search-input"
								placeholder="Enter your search item..." type="search"
								name="search" id="search"> <input
								class="sb-search-submit" type="submit" value=""> <span
								class="sb-icon-search"> </span>
						</form>
					</div>
					<!-- search-scripts -->
					<script src="js/classie.js"></script>
					<script src="js/uisearch.js"></script>
					<script>
						new UISearch(document.getElementById('sb-search'));
					</script>
					<!-- //search-scripts -->
				</div>

				<div class="header-right">
					<div class="cart box_1">
						<a href="shopcart.html">
							<h3>
								<span class="simpleCart_total"> $0.00 </span> (<span
									id="simpleCart_quantity" class="simpleCart_quantity"> 0
								</span> items)<img src="images/bag.png" alt="">
							</h3>
						</a>
						<p>
							<a href="javascript:;" class="simpleCart_empty">Empty cart</a>
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
							<li><a href="index.html">HOME</a></li>
							<li><a href="about.html">ABOUT</a></li>
							<li><a href="menu.html">OUR MENU</a></li>
							<li><a href="gallery.html">GALLERY</a></li>
							<li><a href="typography.html">TODAY'S SPECIAL</a>
							<li><a href="contact.html">CONTACT</a></li>
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
				<h4>BUFFET</h4>
				<p>
					MONDAY - THURSDAY<span>7 : 00 - 21 : 00</span>
				</p>
			</div>
			<div class="col-md-3 footer-grid">
				<h4>ORDERS</h4>
				<p>
					MONDAY - SUNDAY<span>7 : 00 - 21 : 00</span>
				</p>
			</div>
			<div class="col-md-3 footer-grid">
				<h4>ADDRESS</h4>
				<ul>
					<li class="list-one">Lorem ipsy street, Newyork</li>
					<li class="list-two"><a href="mailto:info@example.com">favorites@example.com</a></li>
					<li class="list-three">+8 800 555 555 55</li>
				</ul>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- //footer-top -->
	<!-- footer -->
	<div class="footer">
		<div class="container">
			<div class="footer-left">
				<p>
					Copyright &copy; 2015.Company name All rights reserved.More
					Templates <a href="http://www.cssmoban.com/" target="_blank"
						title="模板之家">模板之家</a> - Collect from <a
						href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
				</p>
			</div>
			<div class="footer-right">
				<ul>
					<li><a href="#" class="twitter"> </a></li>
					<li><a href="#" class="facebook"> </a></li>
					<li><a href="#" class="chrome"> </a></li>
					<li><a href="#" class="pinterest"> </a></li>
					<li><a href="#" class="linkedin"> </a></li>
					<li><a href="#" class="dribbble"> </a></li>
				</ul>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- //footer -->
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
