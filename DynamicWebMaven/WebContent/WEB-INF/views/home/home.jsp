<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home/home.css" />

<style type="text/css">
	body{
		margin:100px;
	}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<title>新首頁home.jsp</title>
</head>
<body>
	<%@include file="./head_bar.jsp" %>
	aa&lt;&u0030; ${request} &#064;&gt;zz<br/>
	
	<table>
		<caption>User</caption>
		<tr><td><A href="../user/sign_in">登入</A></td>
			<td><A href="../user/sign_up">註冊</A></td>
			<td><A href="../user/modify">修改</A></td>
		</tr>
	</table>
<div>
	<iframe id="headBar" height=50% width=50% name=headBar" src="./head_bar"/>
</div>
qqqq
</body>
</html>