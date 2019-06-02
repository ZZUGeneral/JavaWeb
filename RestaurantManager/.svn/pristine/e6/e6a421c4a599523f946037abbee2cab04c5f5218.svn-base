$(function(){ 
	alert("aaa");
	
     $.ajax({
         type:"get",
         url:"NoticeServlet?type=list",
         dataType:"json",	    
         success:function(data){
             var con="";   
             $.each(data,function(i,item){         	
                 con+="<tr><td>"+item.Theme+"</td><td>"+item.Notice+"</td><td>"+item.Time+"</td><td>"+$("#barDemo").html()+"</td></tr>";
             });
             
             $("table_search").append(con);
         },
         error:function(){
             alert("没有用户");
         }
     })
     
});