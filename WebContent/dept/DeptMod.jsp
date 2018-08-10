<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basepath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>增加新部门</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
	<table border="0" width="950" height="350" bgcolor="#ffffff"
		align="center">
		<tr>
			<td align="center" valign="top">
				<form name="form1" method="post" action="dept/dept!updateDeptFun">
					<table width="500" border="0" cellpadding="5" cellspacing="1"
						bgcolor="#CCCCCC">
						<tr>
							<td height="24" colspan="2" align="center" bgcolor="#FFCC00">
								请填写新部门信息</td>
						</tr>
						<tr>
							<td width="120" height="24" bgcolor="#FFFFFF">部门编号</td>
							<td width="357" height="24" bgcolor="#FFFFFF"><input
								name="dept.d_id" type="text"  id="department_id" readonly="readonly" value="${requestScope.dept.getD_id() }"> *</td>
						</tr>
						<tr>
							<td height="24" bgcolor="#FFFFFF">部门名称</td>
							<td height="24" bgcolor="#FFFFFF"><input
								name="dept.d_name" type="text" id="department_name" value="${requestScope.dept.getD_name() }">
								*</td>
						</tr>
						<tr>
							<td height="24" bgcolor="#FFFFFF">部门地址</td>
							<td height="24" bgcolor="#FFFFFF"><input
								name="dept.d_addr" type="text" id="location_name" value="${requestScope.dept.getD_addr() }"> *</td>
						</tr>
						<tr>
							<td height="24" colspan="2" align="center" bgcolor="#FFFFFF">
								<input type="submit" name="Submit1" value="提交">
								<input type="button" name="Submit2" value="取消"
								onClick="history.back();">
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>