<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./../../css/common.css" />
<title>使用者註冊</title>
</head>
<body>
	<form action="/user/sign_up">
	<table>
		<tr><th><th>
		<tr><td><label for="userName" class="field_name">姓名</label>
			<td><input type="text" class="field_value" id="userName" name="user" title="1.可用英數字&#013;2.首字限英文&#013;3.不分大小寫" />		
		<tr><td><td>		
		<tr><td><td>		
	</table>
		<input type="hidden" name="action" value="sign_up">
		<input type="submit"  value="註冊">
		<input type="reset" value="清除"/>
	</form>
</body>
</html>