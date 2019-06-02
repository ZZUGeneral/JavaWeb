<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	function validate() {
		var OID = document.getElementById("OID");
		
		if (OID.value == "") {
			alert("订单号不能为空！");
			OID.focus();
			return false;
		} 
		return true;
	}	
</script>
	
</head>
<body>

		<form action="OrderSearchServlet" method="post"
			onsubmit="return validate();">
		根据订单号查询息信：<input type="text" name="OID" id="OID"/><br> <input
			type="submit" value="查询" />
		</form>
		
		
</body>
</html>