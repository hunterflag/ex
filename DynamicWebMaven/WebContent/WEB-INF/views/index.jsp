<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="author" content="Hunter">
<base href="http://localhost:8080/" target="_self">
<link rel="manifest" href="/manifest.json" />
<link rel="stylesheet" type="text/css" href="../../css/common.css" >
<script type="text/javascript" src="../../js/common.js" >
<script type="text/javascript">showMessageWithSerialNoMessatge("Head tag");</script>
<title>舊首頁index.jsp</title>
</head>
<body onload="init()">
	<table>
		<caption>CSS Sample</caption>
		<tr><td><a href="./sample/sample_css_size" target="_blank">大小單位</a>
		    <td><a href="./sample/sample_css_transition" target="_self">轉場</a>
		</tr>
	</table>
	
	<table>
		<caption>Sample</caption>
		<tr><td><a href="./sample/sample_jsp" target="_blank">jsp</a>
		<tr><td><a href="./sample/sample_js" target="_blank">js</a>
		</tr>
	</table>
	
	<div>
		<table>
		index.jsp in Context root ("/")
		<tr><td><a href="./user/sign_up">使用者註冊</a>
		<tr><td><a href="./sample/sample_css">CSS展示範例</a>
		<tr><td><A href="home/home">新網址</A></td>
		<tr><td><A href="./home/home">相對新網址</A>
		<tr><td><A href="/home/home">絕對新網址</A>
		index.jsp in Context root ("/")
		</table>
	</div>
	