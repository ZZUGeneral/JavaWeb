<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="zzu.minjie.bean.Notice,zzu.minjie.bean.DishesRank,zzu.minjie.dao.DishesRankDao,zzu.minjie.bean.Food,zzu.minjie.dao.NoticeDao,zzu.minjie.dao.FoodDao,java.util.List,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<title>首页</title>
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
			event.preventDefault();//防止链接打开url(.scroll)
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);//js被chrome和Firefox都支持
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
										<li><a href="MenuManageServlet?type=select">菜单</a></li>
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
										<a href="shopcart.jsp">立即下单</a>
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
		<div class="banner-bottom">
			<div class="container">
				<div class="bottom-grids">
					<div class="col-md-4 bottom-grid text-center">
						<div class="btm-clr">
							<figure class="icon">
								<img src="images/k1.png" alt="" />
							</figure>
							<!-- 直接调用Dao里面的函数，显示公告列表 -->
							<h3>公告</h3>
							<p>
								<%
									NoticeDao dao = new NoticeDao();
									List<Notice> list = dao.readNotice();
									for (Notice no : list) {
								%>
								<tr>

									<td align="center">主题：<%=no.getTheme()%></td>
									<td align="center">时间：<%=no.getTime()%></td>
									<marquee>
										<td align="center">内容：<%=no.getNotice()%></td>
									</marquee>
									</br>

								</tr>
								<%
									}
								%>

							</p>
						</div>
					</div>
					<div class="col-md-4 bottom-grid btm-gre text-center">
						<div class="btm-clr">
							<figure class="icon">
								<img src="images/k2.png" alt="" />
							</figure>
							<h3></h3>
							<p></p>
						</div>
					</div>
					<div class="col-md-4 bottom-grid text-center">
						<div class="btm-clr">
							<figure class="icon">
								<img src="images/k3.png" alt="" />
							</figure>
							<h3>排行榜</h3>
							<p>
								<%
									DishesRankDao rankdao = new DishesRankDao();
									List<DishesRank> ranklist = rankdao.readDishesRank();
									int i = 1;
									for (DishesRank no : ranklist) {
								%>
								<tr>

									<td align="left"><font color="00ff00"><%=i++%><%=no.getFoodName()%></font></td>
									<td align="left"><font color="#00ff00">销量:<%=no.getCountnumber()%></font></td>

									</br>

								</tr>
								<%
									}
								%>
							</p>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<!-- //banner-bottom -->
	</div>
	<!-- //banner -->
	<!-- welcome -->
	<div class="welcome">
		<div class="container">
			<div class="wel-info">
				<h3>欢迎光临</h3>
				<div class="strip-line"></div>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本店提供川菜、浙菜、徽菜、闽菜、苏菜、湘菜六大主菜系，同时提供各种凉菜、甜点、饮料。原材料全部由农家直接提供，绿色、无公害、无污染，放心使用。本店会以美味的食物，周到的服务给您和您的家人带来愉悦的用餐心情，祝您用餐愉快！</p>
			</div>
			<div class="welcome-grids">
				<div class="col-md-4 welcome-grid-img">
					<img src="images/pic10.png" alt="" />
					<div class="wel-pos">
						<h4>
							<a href="MenuServlet?type=select1">川菜</a>
						</h4>
					</div>
				</div>
				<div class="col-md-4 welcome-grid-img">
					<img src="images/pic11.png" alt="" />
					<div class="wel-pos">
						<h4>
							<a href="MenuServlet?type=select2">浙菜</a>
						</h4>
					</div>
				</div>
				<div class="col-md-4 welcome-grid-img">
					<img src="images/pic12.png" alt="" />
					<div class="wel-pos">
						<h4>
							<a href="MenuServlet?type=select3">徽菜</a>
						</h4>
					</div>
				</div>
				<div class="col-md-4 welcome-grid-img">
					<img src="images/pic13.png" alt="" />
					<div class="wel-pos">
						<h4>
							<a href="MenuServlet?type=select4">闽菜</a>
						</h4>
					</div>
				</div>
				<div class="col-md-4 welcome-grid-img">
					<img src="images/pic14.png" alt="" />
					<div class="wel-pos">
						<h4>
							<a href="MenuServlet?type=select5">苏菜</a>
						</h4>
					</div>
				</div>
				<div class="col-md-4 welcome-grid-img">
					<img src="images/pic15.png" alt="" />
					<div class="wel-pos">
						<h4>
							<a href="MenuServlet?type=select6">湘菜</a>
						</h4>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- //welcome -->
	<!-- good -->
	<div class="good">
		<div class="container">
			<div class="good-info">
			
			<!-- 将招牌菜从数据库筛选出来 -->
				<h3>招牌菜</h3>
				<div class="strip-line"></div>
			</div>
			<%
				FoodDao dao2 = new FoodDao();
				List<Food> list2 = dao2.readSpecialty();
				for (Food s : list2) {
			%>
			<div class="good-grids">
				<div class="col-md-5 good-right">
					<img src="images/<%=s.getImage()%>" alt="" />
					<div class="desc">
						<p><%=s.getName()%></p>
					</div>
				</div>
				<div class="col-md-7 good-left">
					<h3>美味的食物让你快乐</h3>
					<div class="strip"></div>
					<p><%=s.getMaterial()%></p>
					<p><%=s.getFoodExplain()%></p>
				</div>
				<%
					}
				%>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- //good -->
	<!-- delicious -->
	<div class="delicious">
		<div class="container">
			<div class="delicious-info">
			
			<!-- 展示推荐的菜品 -->
			
				<h3>各种口味的佳肴</h3>
				<div class="strip-line"></div>
			</div>
			<div class="delicious-grids">
				<%
					FoodDao dao1 = new FoodDao();
					List<Food> list1 = dao1.readFood();
					for (Food fo : list1) {
				%>
				<div class="col-md-3 delicious-grid">
					<h3><%=fo.getName()%></h3>
					<img src="images/<%=fo.getImage()%>" alt="" />
					<p><%=fo.getMaterial()%></p>
					<a href="#">MORE</a>
				</div>
				<%
					}
				%>

			</div>
			<div class="clearfix"></div>
		</div>
	</div>

	<!-- //delicious -->


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
