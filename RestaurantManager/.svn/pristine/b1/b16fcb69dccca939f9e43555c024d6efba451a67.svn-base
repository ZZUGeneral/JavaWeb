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
			<div id="top">
				<div>
					<img src="img/left-top-right.gif" />
				</div>
				<div id="title">
					<p>修改类别</p>
				</div>
				<div id="top_body">
					<img src="img/content-bg.gif" height="31px" />
				</div>
				<div>
					<img src="img/nav-right-bg.gif" />
				</div>
			</div>
			<div id="middle">
				<br/>
				<br/>
				<form action="${ctx }/TypeServlet?type=editnext" method="post" >
					<table align="center" border="1" cellspacing="0" cellpadding="0">
					
						
                		<input type="hidden" id="dishid" name="dishid" value="${dishid }" >
            			
            			
						<tr>
							<td class="left">菜品名称：</td>
							<td class="right"><input type="text" id="dishname" name="dishname" value="${dishstyle.dishName}"  required="ture"  />
							</td>
						</tr>
						<tr>
							<td class="left">菜系描述：</td>
							<td class="right"><input type="text" name="dishexplain" value="${dishstyle.dishExplain}" required="ture" /></td>
						</tr>
						<tr>
							<td class="left">菜系选择：</td>
							<td class="right"><input type="text" name="opt" value="${dishstyle.opt}" required="ture" /></td>
						</tr>
						<tr>
							<td class="left">图片： <img src="images/${dishstyle.image}" width="30px" height="30px" id="image"/></td>
														
							<td class="right"><input type="file" name="imgpath" value="${dishstyle.image}" required="ture" onchange="document.getElementById('image').src=this.value" /></td>
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


