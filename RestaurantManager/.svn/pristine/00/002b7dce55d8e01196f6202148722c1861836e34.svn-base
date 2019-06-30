<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page
	import="com.zzu.minjie.dao.DishStyleDao,com.zzu.minjie.bean.DishStyle,java.util.List,java.util.ArrayList"%>
    <%
	String ctx = request.getContextPath();
	pageContext.setAttribute("ctx", ctx);
	%>  
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="css/all.css" />
		<link rel="stylesheet" type="text/css" href="css/context.css" />
		<link href="css/bootstrap.min.css" rel="stylesheet">	
		<script type="text/javascript" src="js/jquery.min.js"></script>
		
	</head>

	<body onLoad="goPage(1,5);">
	<script type="text/html" id="barDemo">
            <a class="layui-btn layui-btn-xs" lay-event="edit" data-toggle="modal" data-target="#myModal">编辑</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" >删除</a>
    </script>
		<div id="body">
			<div id="top">
				<div>
					<img src="img/left-top-right.gif" />
				</div>
				<div id="title">
					<p>类别信息</p>
				</div>
				<div id="top_body">
					<img src="img/content-bg.gif" height="31px" />
				</div>
				<div>
					<img src="img/nav-right-bg.gif" />
				</div>
			</div>
			 <form action="TypeServlet?type=edit" method="post" id="xfrom"
				onsubmit="return validate();">
			<div id="middle">
				<br/>
				<br/>
				
				<div class="row" align="center">       
                                           请输入类别名称：<input type="text"  id="uid" name="uid"/>
                <button id="searchtheme" name="searchtheme" class="layui-btn" onclick="search()">搜索</button>
                
                <button onclick="flash()">所有类别</button>
                
		        </div>
		        
				<table align="center" border="1" cellspacing="0" cellpadding="0">
					<tr class="head">
						<td colspan="11">类别信息列表</td>
					</tr>
				
				 
		     
		     <table align="center" width="700" border ="1">
		     
            <thead>
            <tr class="head">
                        <td  >编号</td>
                        <td width="300">类别名称</td>
						<td width="500">菜系描述</td>
						<td width="100">菜系选择</td>
						<td width="100">菜系图片</td>
						<td colspan="2"></td>
           </tr> 
           </thead>
           <tbody id="idData">
           <%
           String flag=(String)request.getAttribute("flag");
         //取出flag判断是所有列表还是搜索的
           List <DishStyle> list;
           if(flag.equals("search")){//搜索
             list=(List)request.getAttribute("dishstyle1");
           }
           else{//所有菜系
        	 list=(List)request.getAttribute("dishstyle");
           }
           for(DishStyle no:list)
            {%>
           <tr>   
               <td width="100" align="center"><%=no.getDishId() %></td>
               <td width="300" align="center"><%=no.getDishName() %></td>
               <td width="600" align="center" ><%=no.getDishExplain() %></td>
               <td width="100" align="center"><%=no.getOpt() %></td>
               <td ><img src="images/<%=no.getImage() %>"  width="30px" height="30px"/></td>
               <td width="50" align="center"> <a href="${ctx }/TypeServlet?type=edit&dishid=<%=no.getDishId() %>">修改</a></td>
               <td width="50" align="center"> <input type="button" value="删除" onclick="del(<%=no.getDishId()%>);"></td>
           </tr>
             <%}
        %>
           </tbody>
           </table> 
                
		<table width="60%" align="right">
        <tr><td><div id="barcon" name="barcon"></div></td></tr>
        </table>
            </table>
				<br/>
				<br/>
	
           
			</div>
			</form>
	
         </div>
		</div>
	
		<script>
		
		 //删除菜系
		function del(id){  	
			var msg = "您真的确定要删除吗？\n\n请确认！";
			if (confirm(msg)==true){
			
			var info={
					"type":"delete",
			        "TypeId":id
			};
			 $.ajax({
				 type: "POST",
                 url: "TypeServlet",
                 data:info,
                 dataType: "json",
		         success:function(data){

		        	 alert("删除成功！"); 
		        	 window.location.href="TypeServlet?type=list";
		         },
		         error:function(data){
		        	 
		        	 alert("删除失败！"); 
		        	 window.location.href="TypeServlet?type=list";
		         }
		     });
			}else{
				return false;
				}  
	           
		}
     
     //搜索菜系
		function search(){
			
			document.forms.xfrom.action="TypeServlet?type=search";
			document.forms.xfrom.submit();
		}
     //刷新所有菜系
        function flash(){
			
			document.forms.xfrom.action="TypeServlet?type=list";
			document.forms.xfrom.submit();
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