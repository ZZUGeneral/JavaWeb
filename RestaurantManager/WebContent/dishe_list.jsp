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
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<title></title>
	</head>

	<body onLoad="goPage(1,5);">
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
			
			<div id="middle">
				<br/>
				<br/>
				<table align="center" border="1" cellspacing="0" cellpadding="0">
					<tr class="head">
						<td colspan="11">菜单信息列表</td>
					</tr>
					<tr class="head">
						<td>菜单名称</td>
						<td>展示图片</td>
						<td>原料</td>
						<td>类型</td>
						<td>说明</td>
						<td>市场价格</td>
						<td>市场价销售数量</td>
						<td>会员单价</td>
						<td>会员价销售数量</td>
						<td colspan="2"></td>
					</tr>
						<tbody id="idData">								
					<c:forEach items="${allFood }" var="food" varStatus="status">  <!--status for循环脚标-->
					
						<tr>
							<td>${food.name}</td>
							<td><img src="picture/${food.image}" width="30px" height="30px" /></td>
							<td>${food.material}</td>
							<td>${food.type}</td>
							<td>${food.foodExplain}</td>
							<td>${food.price}</td>
							<td>${food.type}</td>
							<td>${food.memberPrice}</td>
							<td>${food.type}</td>
						<td width="50" align="center"> <a href="${ctx }/DishesManageServlet?TYPES=dishesUpdate&foodId=${food.foodId}">修改</a></td>
                        <td width="50" align="center"> <input type="button" value="删除" onclick="del(${food.foodId});"></td>
						</tr>
						
					</c:forEach>
					</tbody>
					<table width="60%" align="right">
        <tr><td><div id="barcon" name="barcon"></div></td></tr>
        </table>
				</table>
				<br/>
				<br/>
			</div>
		</div>
		<script>
		function del(id){  	
			var msg = "您真的确定要删除吗？\n\n请确认！";
			if (confirm(msg)==true){
			
			var info={
					"TYPES":"dishesDel",
			        "foodid":id
			};
			 $.ajax({
				 type: "POST",
                 url: "DishesManageServlet",
                 data:info,
                 dataType: "json",
		         success:function(data){

		        	 alert("删除成功！"); 
		        	 window.location.href="DishesManageServlet?TYPES=dishesList";
		         },
		         error:function(data){
		        	 
		        	 alert("删除失败！"); 
		        	 window.location.href="DishesManageServlet?TYPES=dishesList";
		         }
		     });
			}else{
				return false;
				}  
	           
		}
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