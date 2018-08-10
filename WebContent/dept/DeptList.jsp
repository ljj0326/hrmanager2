<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basepath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>部门数据</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
	<!-- 页面内容 -->
	<table border="0" width="950" height="350" bgcolor="#ffffff"
		align="center">
		<tr>
			<td align="center" valign="top">
				<table width="90%" border="0" cellpadding="5" cellspacing="1"
					bgcolor="#CCCCCC">
					<tr>
						<th width="17%" bgcolor="#FFCC00">部门编号</th>
						<th width="25%" bgcolor="#FFCC00">部门名称</th>
						<th width="37%" bgcolor="#FFCC00">部门地址</th>
						<th width="21%" bgcolor="#FFCC00">操作</th>
					</tr>

					<!-- 循环输出部门记录 -->
                 <c:forEach items="${requestScope.dlist}" var="dept">
					<tr>
						<td bgcolor="#FFFFFF">${dept.getD_id()}</td>
						<td bgcolor="#FFFFFF">${dept.getD_name()}</td>
						<td bgcolor="#FFFFFF">${dept.getD_addr()}</td>
						<td bgcolor="#FFFFFF">
						   <a href="dept/dept!selOneDeptById?dept.d_id=${dept.getD_id()}">修改</a>
						   <a href="dept/dept!deleteDeptById?dept.d_id=${dept.getD_id()}">删除</a></td>
					</tr>
					</c:forEach>
				</table>
				<p>
					<a href="dept/DeptAdd.jsp">增加新部门</a>
				</p>
			</td>
		</tr>
	</table>

</body>
</html>