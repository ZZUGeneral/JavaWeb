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
					<p>添加菜品</p>
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
					
						
                		<input type="hidden" id="foodId" name="foodId" value="${foodId }" >
            			
            			
						<tr>
							<td class="left">菜品名称：</td>
							<td class="right"><input type="text" id="name" name="name" value="${food.name}"  required="ture"  />
							</td>
						</tr>
						<tr>
							<td class="left">原 料：</td>
							<td class="right"><input type="text" name="recipe" value="${food.material}" required="ture" /></td>
						</tr>
						<tr>
							<td class="left">市场价格：</td>
							<td class="right"><input type="text" name="price" value="${food.price}" required="ture" /></td>
						</tr>
						<tr>
							<td class="left">会员价格：</td>
							<td class="right"><input type="text" name="memberPrice" value="${food.memberPrice}" required="ture" /></td>
						</tr>
						<tr>
							<td class="left">说 明：</td>
							<td class="right"><textarea name="brief" rows="10" cols="30" required="ture" >${food.foodExplain}</textarea></td>
						</tr>
						<tr>
							<td class="left">菜品类别：</td>
							<td class="right">
								<select name="type">	
									<c:forEach items="${dishStyleList }" var="dishStyle" varStatus="status">  <!--status for循环脚标-->
										<option value="${dishStyle.dishName }">${dishStyle.dishName }</option>
									</c:forEach>			
								</select>
							</td>
						</tr>
						
						<tr>
							<td class="left">图片： <img src="picture/${food.image}" width="30px" height="30px" id="image"/></td>
														
							<td class="right"><input type="file" name="imgpath" value="${food.image}" required="ture" onchange="document.getElementById('image').src=this.value" /></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="submit" /></td>
						</tr>
					</table>
				</form>
				<br/>
				<br/>
			</div>
		</div>
	</body>

</html>


