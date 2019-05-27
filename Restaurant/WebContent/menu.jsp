<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>菜单</title>
	<!--fonts-->
		<link href='http://fonts.useso.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>
		<link href='http://fonts.useso.com/css?family=Slabo+27px' rel='stylesheet' type='text/css'>
		<link href='http://fonts.useso.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
		
	<!--//fonts-->
			<link href="css/bootstrap.css" rel="stylesheet">
			<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<!-- for-mobile-apps -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="Favorites Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
		Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- //for-mobile-apps -->	
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
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
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
								<span class="menu"><img src="images/menu.png" alt=""/></span>
									<ul class="nav1">
										<li><a href="index.jsp">首页</a></li>
										<li><a href="member.jsp">会员中心</a></li>
										<li><a class="active" href="menu.jsp">菜单</a></li>
										<li><a href="HistoryOrderServlet">订单</a></li>
										<li><a href="#">今日特色</a>
										<li><a href="contact.jsp">联系我们</a></li>
										<div class="clearfix"></div>
									</ul>
									<!-- script for menu -->
										<script> 
											$( "span.menu" ).click(function() {
											$( "ul.nav1" ).slideToggle( 300, function() {
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
											<div><span><img src="images/logo.png" alt=""/></span></div>
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
<!-- menu-page -->
<!-- <div class="menu">
	<div class="container">
		<div class="menu-info">
			<h3>六大菜系展览</h3>
			<div class="strip-line"></div>
		</div>
		<div class="our-menu-grids">
			<div class="order-top">
				<li class="im-g"><a href="#"><img src="images/pic10.png" class="img-responsive" alt=""></a></li>
				<li class="data">
					<h3>川菜</h3>
					<h4>四川菜系</h4>
					<p>川菜取材广泛，调味多变，菜式多样，口味清鲜醇浓并重，以善用麻辣调味著称，并以其别具一格的烹调方法和浓郁的地方风味，融会了东南西北各方的特点，博采众家之长，善于吸收，善于创新，享誉中外。</p>
				</li>
				<li class="bt-nn">
					<a class="hvr-shutter-in-horizontal button" href="MenuServlet?dish=select1">去点菜</a>
				</li>
				<div class="clearfix"></div>
			</div>
			<div class="order-top">
				<li class="im-g"><a href="#"><img src="images/pic11.png" class="img-responsive" alt=""></a></li>
				<li class="data">
					<h3>浙菜</h3>
					<h4>浙江菜系</h4>
					<p>浙菜由杭州菜、宁波菜、绍兴菜、瓯菜组成。菜式小巧玲珑，清 俊逸秀，菜品鲜美滑嫩，脆软清爽。运用香糟调味。常用烹调技法有30多种，注重煨、焖、烩、炖等。 </p>
				</li>
				<li class="bt-nn">
					<a class="hvr-shutter-in-horizontal button" href="MenuServlet?dish=select2">去点菜</a>
				</li>
				<div class="clearfix"></div>
			</div>
			<div class="order-top">
				<li class="im-g"><a href="#"><img src="images/pic12.png" class="img-responsive" alt=""></a></li>
				<li class="data">
					<h3>徽菜</h3>
					<h4>古徽商之家乡菜</h4>
					<p>徽菜的烹调方法上一是就地取材，以鲜制胜。二是善用火候，火功独到。三是娴于烧炖，浓淡相宜。四是注重天然，以食养身。徽菜擅长烧、炖、蒸，而爆、炒菜少，重油、重色，重火功。徽菜继承了祖国医食同源的传统，讲究食补，这是徽菜的一大特色。 </p>
				</li>
				<li class="bt-nn">
					<a class="hvr-shutter-in-horizontal button" href="MenuServlet?dish=select3">去点菜</a>
				</li>
				<div class="clearfix"></div>
			</div>
				
			<div class="order-top">
				<li class="im-g"><a href="#"><img src="images/pic13.png" class="img-responsive" alt=""></a></li>
				<li class="data">
					<h3>闽菜</h3>
					<h4>闽菜风韵</h4>
					<p>闽菜以烹制山珍海味而著称，在色香味形俱佳的基础上，尤以“香”、“味”见长，其清鲜、和醇、荤香、不腻的风格特色，以及汤路广泛的特点，在烹坛园地中独具一席。</p>
				</li>
				<li class="bt-nn">
					<a class="hvr-shutter-in-horizontal button" href="MenuServlet?dish=select4">去点菜</a>
				</li>
				<div class="clearfix"></div>
			</div>
			<div class="order-top">
				<li class="im-g"><a href="#"><img src="images/pic14.png" class="img-responsive" alt=""></a></li>
				<li class="data">
					<h3>苏菜</h3>
					<h4>江苏菜</h4>
					<p>苏菜内部分为四大派系：金陵菜，来于南京，制作精细，口味平和。善用蔬菜，以“金陵三草”和“早春四野”驰名。 淮扬菜，“淮”即淮菜，以淮安一带为代表的淮河流域，“扬”即扬菜，以扬州一带为代表的长江流域。讲究选料和刀工，擅长制汤。
					苏锡菜，来于苏州，无锡和常熟，常用酒糟调味，擅长各类水产。 徐海菜，来于徐州和连云港，擅长海产和蔬菜。</p>
				</li>
				<li class="bt-nn">
					<a class="hvr-shutter-in-horizontal button" href="MenuServlet?dish=select5">去点菜</a>
				</li>
				<div class="clearfix"></div>
			</div>
			<div class="order-top">
				<li class="im-g"><a href="#"><img src="images/pic15.png" class="img-responsive" alt=""></a></li>
				<li class="data">
					<h3>湘菜</h3>
					<h4>湖南菜</h4>
					<p>湘菜历来重视原料互相搭配，滋味互相渗透。湘菜调味尤重香辣。因地理位置的关系，湖南气候温和湿润，故人们多喜食辣椒，用以提神去湿。同时，爆炒也是湖南人做菜的拿手好戏。</p>
				</li>
				<li class="bt-nn">
					<a class="hvr-shutter-in-horizontal button" href="MenuServlet?dish=select6">去点菜</a>
				</li>
				<div class="clearfix"></div>
			</div>
				
		</div>
	</div>
</div>
 -->
<div class="menu">
	<div class="container">
		<div class="menu-info">
			<h3>六大菜系展览</h3>
			<div class="strip-line"></div>
		</div>
		<div class="our-menu-grids">
		<div class="order-top">
		<c:forEach items="${requestScope.dishStyle }" var="dishstyle">			
				<li class="im-g"><a href="#"><img src="images/${dishstyle.image}" class="img-responsive" alt=""></a></li>
				<li class="data">
					<h3>${dishstyle.dishName}</h3>
					<p>${dishstyle.dishExplain}</p>
				</li>
				<li class="bt-nn">
					<a class="hvr-shutter-in-horizontal button" href="MenuServlet?dish=${dishstyle.option}">去点菜</a>
				</li>
				<div class="clearfix"></div>
				</c:forEach>
			</div>
			
		</div>
	</div>
</div>
<!-- //menu-page -->
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
<!-- //footer-top -->
<!-- footer -->

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
		$().UItoTop({ easingType: 'easeOutQuart' });
		});
	</script>
	<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!-- //smooth scrolling -->

</body>
</html>
