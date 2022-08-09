<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入</title>
</head>
<body>
	<form method="post" action="loginServlet" name="loginForm">
		<table>
			<tr><td>帳號
				<td><input type="text" name="account" placeholder="電話號碼" title="英文、數字、6~20字">
				<td>英文、數字、6~20字
			<tr><td>密碼
				<td><input type="password" name="password" placeholder="輸入的密碼將不會顯示" title="英文、數字、符號6~20字">
				<td>英文、數字、符號6~20字
			<tr><td><input type="button" name="forgetBtn" value="忘記密碼">
				<td><input type="reset" name="resetBtn" value="清除">
				<td><input type="submit" name="submitBtn" value="送出">
		</table>
	</form>
</body>
</html>