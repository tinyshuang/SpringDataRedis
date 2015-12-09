<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		$(function() {
			var data = {
    			"name" : "tinys",
    			 "age"   : 25,
    			 "sex"   : "男"
            };
			$.ajax({
			   type: "POST",
			   url: "/SpringDataRedis/addUser.do",
			   data: data,
			   success: function(msg){
                    console.info(msg);
			   }
			});
		});
	</script>
</body>
</html>