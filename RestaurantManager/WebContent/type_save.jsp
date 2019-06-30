<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="css/all.css" />
		<link rel="stylesheet" type="text/css" href="css/context.css" />
		<title></title>
		<script type="text/javascript">
	     function validate() {
		var theme = document.getElementById("theme");
		var notice = document.getElementById("notice");
		
		
		if (theme.value == ""){
			alert("您还没有输入公告标题！");
			theme.focus();
			return false;
		}
		if (notice.value == ""){
			alert("您还没有输入公告内容！");
			notice.focus();
			return false;
		}
		return true;
	}
</script>
	</head>

	<body id="background">
		<div id="body">
		
			<div id="top">
				<div>
					<img src="img/left-top-right.gif" />
				</div>
				<div id="title">
					<p>添加类别</p>
				</div>
				<div id="top_body">
					<img src="img/content-bg.gif" height="31px" />
				</div>
				<div>
					<img src="img/nav-right-bg.gif" />
				</div>
			</div>
			<div id="middle">
				<br /> <br />
					<form action="TypeServlet?type=add" method="post" onsubmit="return validate();">
						<table align="center" border="1" cellspacing="0" cellpadding="0">
							<tr>
								<td class="left">菜系名称：</td>
								<td class="right"><input type="text" name="dishName" id="dishName"/></td>
							</tr>
							<tr>
								<td class="left">菜系描述：</td>
								<td class="right"><textarea name="dishExplain" rows="10" cols="30" id="dishExplain"></textarea></td>
							</tr>
							<tr>
								<td class="left">菜系选择：</td>
								<td class="right"><input type="text" name="option" id="option"/></td>
							</tr>
							<tr>
							<td class="left">上传图片：</td>
							<td class="right"><input type="file" name="image" id="image" required="ture" /></td>
						</tr>
							
							<tr>
								<td colspan="2" align="center"><input type="submit" /></td>
							</tr>
						</table>
					</form>
				<br /> <br />
			</div>
		</div>
	</body>

</html>