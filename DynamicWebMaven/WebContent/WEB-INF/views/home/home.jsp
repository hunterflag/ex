<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css" />
<style type="text/css">
	body{
		margin:100px;
	}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<title>新首頁home.jsp</title>
</head>
<body>
	/WEB-INF/views/index.jsp <br/>
	${pageContext.request.contextPath}<br/>
	<table>
		<tr><td><A href="./login/form">登入</A></td>
		</tr>
		<tr><td><A href="./sendDataToBackEndForm">使用者輸入表單</A></td>
		</tr>
	</table>
</body>
</html>