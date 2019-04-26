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
<script type="application/x-javascript">
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 




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
<!-- 日期控件js -->
<script src="layui/layui.js" charset="utf-8"></script>
<script>
	layui.use('laydate', function() {
		var laydate = layui.laydate;

		//常规用法
		laydate.render({
			elem : '#birthday'
		});
	});
</script>

<script type="text/javascript">
	var xhr = false;
	function createXHR() {
		try {
			xhr = new XMLHttpRequest();
		} catch (e) {
			try {
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e1) {
				xhr = false;
			}
		}
		if (!xhr)
			alert("初始化XMLHttpRequest对象失败！");
	}
	function idAjaxValidate(idObj) {
		createXHR();
		var url = "UserServlet";
		var content = "id_type=idAjaxValidate&id=" + idObj.value;
		xhr.open("POST", url, true);
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				document.getElementById("idValidate").innerHTML = xhr.responseText;
			}
		};
		xhr.setRequestHeader("Content-Length", content.length);
		xhr.setRequestHeader("CONTENT-TYPE",
				"application/x-www-form-urlencoded");
		xhr.send(content);
	}
	function phoneAjaxValidate(phoneObj) {
		createXHR();
		var url = "UserServlet";
		var content = "phone_type=phoneAjaxValidate&phone=" + phoneObj.value;
		xhr.open("POST", url, true);
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				document.getElementById("phoneValidate").innerHTML = xhr.responseText;
			}
		};
		xhr.setRequestHeader("Content-Length", content.length);
		xhr.setRequestHeader("CONTENT-TYPE",
				"application/x-www-form-urlencoded");
		xhr.send(content);
	}
	function nickAjaxValidate(nickObj) {
		createXHR();
		var url = "UserServlet";
		var content = "nick_type=nickAjaxValidate&nick=" + nickObj.value;
		xhr.open("POST", url, true);
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				document.getElementById("nickValidate").innerHTML = xhr.responseText;
			}
		};
		xhr.setRequestHeader("Content-Length", content.length);
		xhr.setRequestHeader("CONTENT-TYPE",
				"application/x-www-form-urlencoded");
		xhr.send(content);
	}

	//数据合理性

	function validate() {
		var userId = document.getElementById("userId");
		var name = document.getElementById("name");
		var address = document.getElementById("address");
		var phone = document.getElementById("phone");
		var birthday = document.getElementById("birthday");
		var password = document.getElementById("password");
		var repassword = document.getElementById("repassword");

		//正则表达式（不能包含中文）
		var idPattern = /^[\x01-\x7f]*$/;
		// 手机号格式正则表达式
		var phonePattern = /^1(3|4|5|7|8)\d{9}$/;
		if (userId.value == "") {
			alert("用户账号不能为空！");
			userId.focus();
			return false;
		} else if (!idPattern.test(userId.value)) {
			alert("用户账号不可包含中文！");
			userId.focus();
			return false;
		}
		if (name.value == "") {
			alert("姓名不能为空！");
			name.focus();
			return false;
		}
		if (address.value == "") {
			alert("地址不能为空！");
			address.focus();
			return false;
		}
		if (phone.value == "") {
			alert("手机号码不能为空！");
			phone.focus();
			return false;
		} else if (!phonePattern.test(phone.value)) {
			alert("手机号码格式不正确！");
			phone.focus();
			return false;
		}

		if (password.value == "") {
			alert("密码不能为空！");
			password.focus();
			return false;
		}
		if (password.value.length<6||password.value.length>12) {
			alert("密码长度不符合要求，请输入6-12位密码!");
			password.focus();
			return false;
		}
		if (repassword.value != password.value) {
			alert("两次密码输入不一致！请重新输入");
			repassword.focus();
			return false;
		}

		return true;
	}

	//验证码的更换
	function changeValidateCode() {
		document.getElementById("validateCode").src = "ValidateCodeServlet?rand="
				+ Math.random();
	}
</script>
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
						<li><a href="login.html">登录</a></li> |
						<li><a href="register.html">注册</a></li>
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
								<span class="simpleCart_total"> $0.00 </span> (<span
									id="simpleCart_quantity" class="simpleCart_quantity"> 0
								</span> items)<img src="images/bag.png" alt="">
							</h3>
						</a>
						<p>
							<a href="javascript:;" class="simpleCart_empty">购物车</a>
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
							<li><a class="active" href="#">首页</a></li>
							<li><a href="#">关于我们</a></li>
							<li><a href="#">菜单</a></li>
							<li><a href="#">订单</a></li>
							<li><a href="#">今日特色</a>
							<li><a href="#">联系我们</a></li>
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
			<h3>注册</h3>
			<div class="strip"></div>
			<div class="registration-grids">
				<div class="reg-form">
					<div class="reg">

						<p>
							已有账号？ <a href="#">请点这里</a>
						</p>
						<form action="UserServlet" method="post"
							onsubmit="return validate();">
							<ul>
								<li class="text-info">账号:</li>
								<li><input id="userId" name="userId" type="text"
									onblur="idAjaxValidate(this)"></li>
								<li><label style="color: red" id="idValidate"></label></li>
							</ul>
							<ul>
								<li class="text-info">昵称:</li>
								<li><input id="nick" name="nick" type="text"
									onblur="nickAjaxValidate(this)"></li>
								<li><label style="color: red" id="nickValidate"></label></li>
							</ul>
							<ul>
								<li class="text-info">真实姓名:</li>
								<li><input id="name" name="name" type="text"></li>
							</ul>
							<ul>
								<li class="text-info">地址:</li>
								<li><input id="address" name="address" type="text"></li>
							</ul>
							<ul>
								<li class="text-info">电话:</li>
								<li><input id="phone" name="phone" type="text"
									onblur="phoneAjaxValidate(this)"></li>
								<li><label style="color: red" id="phoneValidate"></label></li>
							</ul>
							<ul>
								<li class="text-info">性别:</li>
								<li><input type="radio" id="gender" name="gender"
									checked="checked" value="男">男&nbsp;&nbsp; <input
									type="radio" id="gender" name="gender" value="女">女</li>
							</ul>
							<ul>
								<li class="text-info">生日:</li>
								<li><input type="text" class="layui-input" id="birthday"
									name="birthday" onclick="laydate"></li>
							</ul>
							<ul>
								<li class="text-info">密码:</li>
								<li><input id="password" name="password" type="password"></li>
							</ul>
							<ul>
								<li class="text-info">再次输入密码:</li>
								<li><input id="repassword" name="repassword"
									type="password" onblur="repasswordAjaxValidate(this)"></li>
							</ul>
							<ul>
								<li class="text-info">验证码:</li>
								<li><img src="ValidateCodeServlet" id="validateCode"
									title="点击换一换" onclick="changeValidateCode()"> <a
									href="javascript:changeValidateCode();">看不清？</a> <input
									type="text" name="verifyCode"></li>
							</ul>
							<input type="submit" value="注册">

						</form>
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