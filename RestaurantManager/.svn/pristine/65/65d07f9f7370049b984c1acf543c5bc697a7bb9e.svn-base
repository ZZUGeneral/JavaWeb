<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    
<%
	String ctx = request.getContextPath();
	pageContext.setAttribute("ctx", ctx);
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="css/all.css" />
		<link rel="stylesheet" type="text/css" href="css/context.css" />
		<title></title>
	</head>

	<body id="background">
		<div id="body">
			<!--
            	作者：luchao7285@163.com
            	时间：2017-03-11
            	描述：设置页头
            -->
			<div id="top">
				<div>
					<img src="img/left-top-right.gif" />
				</div>
				<div id="title">
					<p>菜品信息</p>
				</div>
				<div id="top_body">
					<img src="img/content-bg.gif" height="31px" />
				</div>
				<div>
					<img src="img/nav-right-bg.gif" />
				</div>
			</div>
			<!--
            	作者：luchao7285@163.com
            	时间：2017-03-11
            	描述：设置页中
            -->
			<div id="middle">
				<br/>
				<br/>
				<form action="${ctx }/DishesManageServlet?TYPES=dishesUpdateNext" method="post" >
					<table align="center" border="1" cellspacing="0" cellpadding="0">
					
						
						<tr>
							<td class="left">图片： </td>							
							<td class="right"><img src="picture/${food.image}" width="60px" height="60px" /></td>
						</tr>            			
            			
						<tr>
							<td class="left">菜品名称：</td>
							<td class="right">${food.name}</td>
						</tr>
						<tr>
							<td class="left">原 料：</td>
							<td class="right">${food.material}</td>
						</tr>
						<tr>
							<td class="left">市场价格：</td>
							<td class="right">${food.price}</td>
						</tr>
						<tr>
							<td class="left">会员价格：</td>
							<td class="right">${food.memberPrice}</td>
						</tr>
						<tr>
							<td class="left">说 明：</td>
							<td class="right">${food.foodExplain}</td>
						</tr>
						<tr>
							<td class="left">菜品类别：</td>
							<td class="right">${food.type}</td>
						</tr>	
						
					</table>
				</form>
				<br/>
				<br/>
			</div>
		</div>
	</body>

</html>