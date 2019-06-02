<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ page import="com.zzu.minjie.bean.*,com.zzu.minjie.dao.*" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="css/all.css" />
		<link rel="stylesheet" type="text/css" href="css/context.css" />
		<title></title>
		
		<script type="text/javascript">
	function validate() {
		var OID = document.getElementById("OID");
		var UID = document.getElementById("UID");
		
		if (OID.value == "") {
			alert("订单ID不能为空！");
			OID.focus();
			return false;
		} 
		if (UID.value == "") {
			alert("用户ID不能为空！");
			UID.focus();
			return false;
		}
		return true;
	}	
</script>
		
		
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
            
           
            
            
            <form action="OrderSearchServlet" method="post"
			onsubmit="return validate();">
					<table align="center" border="1" cellspacing="0" cellpadding="0">
						
						
						<tr>
							<td class="left">按订单ID查询</td>
							<td class="right"><input type="date" name="OID" id="OID"/>
								<!-- H5时间标签 --><input type="submit" /></td>
						</tr>
					</table>
				</form>
				<br/>
				<br/>
            
            	<table align="center" border="1" cellspacing="0" cellpadding="0">
            				
            			
            			<c:choose>
							<c:when test="${ not empty order }">
							
							<tr>
								<td class="it-table-title">订单ID </td>
								<td class="it-table-title">用户ID </td>
								<td class="it-table-title">真实姓名 </td>
								<td class="it-table-title">联系方式  </td>
								<td class="it-table-title">家庭住址 </td>
								<td class="it-table-title">订购时间 </td>
								<td class="it-table-title">订单状态 </td>
								<td class="it-table-title"> </td>

							</tr>
							
							<c:forEach items="${order }" var="order">		
							<tr class="tn-table-grid-row">
								<td class="tn-border-rb"> ${order.orderNo }</td>
							
								<td class="tn-border-rb"> ${order.userId }</td>
								
								<td class="tn-border-rb"> ${order.userName }</td>
								
								<td class="tn-border-rb"> ${order.phone }</td>
								<td class="tn-border-rb"> ${ order.address }</td>
								
								<td class="tn-border-rb"> ${order.time }</td>
								
								<td class="tn-border-rb"> ${order.status }</td>
								<td class="tn-border-rb"><a href="Order2Servlet?action=${order.orderNo }">确认</a>
								<a href="Order2Servlet?action=no & order=${order.orderNo }">取消</a></td>
							</tr>
							</c:forEach>
							
							</c:when>
							
							<c:otherwise>
								<tr><td class="tn-border-rb"> 您所查找的订单不存在！</td>	</tr>
							</c:otherwise>
								
							</c:choose>
							
							
							
				</table>			
							
				</div>
				
</body>
</html>