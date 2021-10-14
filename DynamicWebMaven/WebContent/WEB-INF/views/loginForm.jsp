<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入</title>
</head>
<body>
	<form action="login" >
		<input type="hidden" name="hiddenAtribute" value="999" />
		<table>
			<thead>測試用輸入資料</thead>
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