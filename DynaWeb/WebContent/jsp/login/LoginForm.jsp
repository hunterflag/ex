<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
</head>
<body>
	<form action="./Login">
		<table>
			<tr><th>欄位</th>
				<th>值</th>
				<th>說明</th></tr>
			<tr><td>帳號:</td>
				<td><input type="text" name="username" id="username" placeholder="輸入帳號" title="格式: [0-9]+" pattern="[0-9]+" required="required" /></td>
			<tr><td>密碼:</td>
				<td><input type="password" name="password" id="password" placeholder="輸入密碼" title="輸入密碼" required/></td>
				<td></td>
			<tr><td>fff帳號:</td>
				<td></td>
				<td>密碼:</td>
		</table>
	</form>
</body>
</html>