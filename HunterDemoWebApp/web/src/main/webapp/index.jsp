<%@ page 	language="java" 
			contentType="text/html; charset=UTF-8"
    		pageEncoding="UTF-8"
 			import="java.text.SimpleDateFormat"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gate.入口</title>
</head>
<body>
	<% 
		String now = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(System.currentTimeMillis());
		System.out.println(now + request.getLocalPort()+ System.currentTimeMillis()); 
		out.append(now + request.getPathInfo() + System.currentTimeMillis());
	%>
	歡迎光臨
</body>
</html>