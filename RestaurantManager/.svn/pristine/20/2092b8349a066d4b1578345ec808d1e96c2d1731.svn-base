<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.zzu.minjie.bean.*,com.zzu.minjie.dao.*,com.zzu.minjie.servlet.*"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="css/all.css" />
		<link rel="stylesheet" type="text/css" href="css/context.css" />
		<title></title>
		
		
		
		
		
	</head>
<body>
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
					<p>订单信息</p>
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
				<table align="center" border="1" cellspacing="0" cellpadding="0">
					<tr class="head">
						<td colspan="12">销售订单查询结果信息列表</td>
					</tr>
			
							<tr>
								<td class="it-table-title">订单ID：</td>
								<td class="it-table-title">用户ID</td>
								<td class="it-table-title">真实姓名</td>
								<td class="it-table-title">联系方式</td>
								<td class="it-table-title">家庭住址</td>
								<td class="it-table-title">订购时间</td>
								<td class="it-table-title">订单状态</td>
								<td class="it-table-title">订单详情</td>
								
								<td class="it-table-title">按    钮</td>

							</tr>

							<c:forEach items="${list }" var="list">
								<tr class="tn-table-grid-row">

									<td class="tn-border-rb">${list.orderNo }</td>
									<td class="tn-border-rb">${list.userId }</td>
								
									<td class="tn-border-rb">${list.userName }</td>
									
									<td class="tn-border-rb">${list.phone }</td>
									<td class="tn-border-rb">${list.address }</td>
								
									<td class="tn-border-rb">${list.time }</td>
					
								
									<td class="tn-border-rb">${list.status }</td>
									<td class="tn-border-rb">ok</td>
								
					
								
									<td class="tn-border-rb"><a href="#">确认</a><a href="#">取消</a></td>

								</tr>
							</c:forEach>
							
							
						<!-- <tr class="head">
						<td colspan="12">共${pageorder.pageSum }页
							<a href="../manage/listOrder?pageNumber=1">[首页]</a>
							<c:forEach var="pageNum" begin="1" end="${pageorder.pageSum }">
								<a href="../manage/listOrder?pageNumber=${pageSum }">${pageSum }</a>
							</c:forEach>
							<a href="../manage/listOrder?pageNumber=${pageorder.pageSum }">[尾页]</a>
						</td>
						</tr>
 -->
						</table>
						<div class="he"></div>

						<div class="he"></div>
					</div>
					<div class="clear"></div>
				</div>


			</div>
			<!-- 右侧公共部分：简历完善度 -->

			<div style="clear: both"></div>
		</div>
	</div>
</body>
</html>