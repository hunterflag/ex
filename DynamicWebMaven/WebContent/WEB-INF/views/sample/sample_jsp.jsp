<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*" %>
   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	Map map = new HashMap<String, Object>();
	map.put("userName", "hunter");
	map.put("password", "1234");
	request.setAttribute("login", map);
%>
	<table>
		${login.userName}<br/>
		<tr>
			<th>變數名稱</th>
			<th>意義</th>
			<th>類別</th>
			<th>寫法</th>
			<th>值</th>
		</tr>
		<tr>
			<td>page</td>
			<td>本物件</td>
			<td>this</td>
			<td>${page}</td>
			<td>${page}</td>
		</tr>
		<tr>
			<td>response</td>
			<td></td>
			<td>this</td>
			<td>${page}</td>
			<td>${page}</td>
		</tr>
		<tr>
			<td>request</td>
			<td></td>
			<td>this</td>
			<td>${page}</td>
			<td>${page}</td>
		</tr>
		<tr>
			<td>application</td>
			<td></td>
			<td>HttpServletRequest</td>
			<td>${request.getParameter("name")}</td>
			<td>${request}</td>
		</tr>
		<tr>
			<td>session</td>
			<td></td>
			<td>HttpServletRequest</td>
			<td>${request.getParameter("name")}</td>
			<td>${request}</td>
		</tr>
		
	</table>
	<hr/>
	${pageContext.request.contextPath}
	resuest: ${request}
	config: ${config}
	${out }
</body>
</html>