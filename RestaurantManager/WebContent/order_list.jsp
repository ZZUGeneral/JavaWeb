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

	<body onLoad="goPage(1,8);">
		<div id="body">
			
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
								

							</tr>
                            <tbody id="idData">	
							<c:forEach items="${list }" var="list">
								<tr class="tn-table-grid-row">
									<td class="tn-border-rb">${list.orderNo }</td>
									<td class="tn-border-rb">${list.userId }</td>
									<td class="tn-border-rb">${list.userName }</td>
									<td class="tn-border-rb">${list.phone }</td>
									<td class="tn-border-rb">${list.address }</td>
									<td class="tn-border-rb">${list.time }</td>
									<td class="tn-border-rb">${list.status }</td>
								</tr>
							</c:forEach>
							</tbody>
							<table width="60%" align="right">
                                <tr><td><div id="barcon" name="barcon"></div></td></tr>
                           </table>
						</table>
					</div>
				</div>
	<script>
	//分页函数
    function goPage(pno,psize){
        var itable = document.getElementById("idData");
        var num = itable.rows.length;//表格所有行数(所有记录数)
        console.log(num);
        var totalPage = 0;//总页数
        var pageSize = psize;//每页显示行数
        //总共分几页 
        if((num/pageSize)>parseInt(num/pageSize)){   
                totalPage=parseInt(num/pageSize)+1;   
           }else{   
               totalPage=parseInt(num/pageSize);   
           }   
        var currentPage = pno;//当前页数
        var startRow = (currentPage - 1) * pageSize+1;//开始显示的行  31 
           var endRow = currentPage * pageSize;//结束显示的行   40
           endRow = (endRow > num)? num : endRow;    //40
           console.log(endRow);
           //遍历显示数据实现分页
        for(var i=1;i<(num+1);i++){    
            var irow = itable.rows[i-1];
            if(i>=startRow && i<=endRow){
                irow.style.display = "";    
            }else{
                irow.style.display = "none";
            }
        }
       
        var tempStr = "共"+num+"条记录 分"+totalPage+"页 当前第"+currentPage+"页";
        if(currentPage>1){
            tempStr += "<a href=\"#\" onClick=\"goPage("+(1)+","+psize+")\">首页</a>";
            tempStr += "<a href=\"#\" onClick=\"goPage("+(currentPage-1)+","+psize+")\"><上一页</a>"
        }else{
            tempStr += "首页";
            tempStr += "<上一页";    
        }
     
        if(currentPage<totalPage){
            tempStr += "<a href=\"#\" onClick=\"goPage("+(currentPage+1)+","+psize+")\">下一页></a>";
            tempStr += "<a href=\"#\" onClick=\"goPage("+(totalPage)+","+psize+")\">尾页</a>";
        }else{
            tempStr += "下一页>";
            tempStr += "尾页";    
        }
     
        document.getElementById("barcon").innerHTML = tempStr;
        
    }
	</script>
</body>
</html>