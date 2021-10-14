<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../../css/common.css" />
<style type="text/css">
	div {
		background-color:#BBBBBB;
		border-width: 3px;
	}
	div table {
		border-color : #FF0000;
	}
</style>
<script type="text/javascript"></script>
<title>舊首頁index.jsp</title>
</head>
<body>
	<div>
	<table border="3px">
	index.jsp in Context root ("/")
	<td><A href="home">新網址</A></td>
	<td><A href="./home">相對新網址</A>
	<td><A href="/home">絕對新網址</A>
	index.jsp in Context root ("/")
	</table>
	</div>
	<br/>
	<div>
	<thead>
	index.jsp in Context root ("/")
	</thead>
	<tbody>
	<table>0
	<td><A href="home">新網址</A></td>
	<td><A href="./home">相對新網址</A>
	<td><A href="/home">絕對新網址</A>
	</table>
	</tbody>
	<tfoot>
	index.jsp in Context root ("/")
	</tfoot>
	</div>
</body>
</html>