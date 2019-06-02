<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page
	import="com.zzu.minjie.dao.NoticeDao,com.zzu.minjie.bean.Notice,java.util.List,java.util.ArrayList"%>
    
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
					<p>公告信息</p>
				</div>
				<div id="top_body">
					<img src="img/content-bg.gif" height="31px" />
				</div>
				<div>
					<img src="img/nav-right-bg.gif" />
				</div>
			</div>
			 <form action="#" method="post" id="xfrom"
				onsubmit="return validate();">
			<div id="middle">
				<br/>
				<br/>
				
				<div class="row" align="center">       
                                           请输入公告标题：<input type="text"  id="uid" name="uid"/>
                <button id="searchtheme" name="searchtheme" class="layui-btn" onclick="search()">搜索</button>
                
                <button onclick="flash()">所有公告</button>
                
		        </div>
		        
				<table align="center" border="1" cellspacing="0" cellpadding="0">
					<tr class="head">
						<td colspan="11">公告信息列表</td>
					</tr>
				
				 
		     
		     <table align="center" width="700" border ="1">
		     
            <thead>
            <tr class="head">
                        <td  >编号</td>
                        <td width="300">标题</td>
						<td width="500">内容</td>
						<td width="100">发布时间</td>
						<td colspan="2"></td>
           </tr> 
           </thead>
           <tbody id="idData">
           <%
           String flag=(String)request.getAttribute("flag");
          
           List <Notice> list;
           if(flag.equals("search")){
        	  
             list=(List)request.getAttribute("noticelist1");
           }
           else{
        	 list=(List)request.getAttribute("noticelist");
           }
           
           for(Notice no:list)
            {%>
           <tr>   
               <td width="100" align="center"><%=no.getNoticeId() %></td>
               <td width="300" align="center"><%=no.getTheme() %></td>
               <td width="600" align="center" ><%=no.getNotice() %></td>
               <td width="100" align="center"><%=no.getTime() %></td>
               <td align="center"> <input type="button" data-toggle="modal" data-target="#myModal" value="编辑" onclick="edit(this)"></td>
               <td align="center"> <input type="button" value="删除" onclick="del(<%=no.getNoticeId()%>);"></td>
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
	<!-- 修改模态框 --> 
           <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	       <div class="modal-dialog">
		    <div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					请进行修改操作
				</h4>
			</div>
		
			<div class="modal-footer">
			 <form action="#">
                    <div class="form-group">
                        <lable for="addid">编号:</lable>
                        <input type="text" id="addid" class="form-control" placeholder="请输入要修改的编号"/>
                    </div>
                    <div class="form-group">
                        <lable for="addtheme">标题:</lable>
                        <input type="text" id="addtheme" class="form-control" placeholder="请输入要修改的公告标题"/>
                    </div>
                    <div class="form-group">
                        <lable for="addnotice">内容：</lable>
                        <input type="text" id="addnotice" class="form-control" placeholder="请输入要修改的公告内容"/>
                    </div>
                    <div class="modal-footer">
                      <a href="NoticeServlet?type=list">
                      <button type="button" class="layui-btn" data-dismiss="modal">关闭</button>
                      </a>
                      <button type="button" class="layui-btn" id="add_btn" name="add_btn" onclick="update()">提交</button>
                      
                  </div>
                </form>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
         </div>
		</div>
		<script src="js/bootstrap.min.js"></script>	
		<script>
		 function edit(obj){
				var $td = $(obj).parents('tr').children('td');
				var id = $td.eq(0).text();
				var the= $td.eq(1).text();
				var not= $td.eq(2).text();
				
				//向模态框传值
				$('#addid').val(id);
				$('#addtheme').val(the);
				$('#addnotice').val(not);
				$('#myModal').modal('show');
				
			}
		 
		function del(id){  	
			var msg = "您真的确定要删除吗？\n\n请确认！";
			if (confirm(msg)==true){
			
			var info={
					"type":"delete",
			        "NoticeId":id
			};
			 $.ajax({
				 type: "POST",
                 url: "NoticeServlet",
                 data:info,
                 dataType: "json",
		         success:function(data){
		        	       	
		         },
		         error:function(data){
		        	 
		        	 alert("删除成功！"); 
		        	 window.location.href="NoticeServlet?type=list";
		         }
		     });
			}else{
				return false;
				}  
	           
		}
     
		function update(){
			var id=document.getElementById("addid").value;
			var theme=document.getElementById("addtheme").value;
			var notice=document.getElementById("addnotice").value;
			var info={
					"type":"edit",
			        "NoticeId":id,
			        "Theme":theme,
			        "Notice":notice
			        
			}
			
			$.ajax({
			   type: "POST",
               url: "NoticeServlet",
               data:info,
               dataType: "json",
		         success:function(data){
		        	         	
		         },
		         error:function(data){
		        	 alert("修改成功！"); 
		        	 window.location.href="NoticeServlet?type=list";
		         }
		         
		     });
		}
		function search(){
			
			document.forms.xfrom.action="NoticeServlet?type=search";
			document.forms.xfrom.submit();
		}
        function flash(){
			
			document.forms.xfrom.action="NoticeServlet?type=list";
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