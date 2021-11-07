<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入</title>
</head>
<body>
/login/form.jsp
	<form action="/login/verify" >
		<input type="hidden" name="pageName" value="./login/form.jsp" />
		<table>
			<thead style="bordercolor:#red;"></thead>
			<tbody>
				<tr><th>輸入項目</th>
					<th>輸入值</th>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" name="name" title="請輸入名字" default="隨便取"/></td>
				</tr>
				<tr>
					<td>年齡</td>
					<td><input type="text" name="age" title="請輸入年齡" default=""/></td>
				</tr>
			</tbody>
			<tfoot> 
				<input type="reset"  name="btn" value="清除" />
			</tfoot>
		</table>
				<input type="submit" name="btn" value="送出" />
				<input type="submit" name="btn" value="取消" />
	</form>
	
</body>
</html>