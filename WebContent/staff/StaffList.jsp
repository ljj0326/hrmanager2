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
	<base href="<%=basepath %>">
		<title>员工数据</title>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=gbk">
	</head>
	<body>
		<table border="0" width="950" height="350" bgcolor="#ffffff"
			align="center">
			<tr>
				<td align="center" valign="top">
					<table width="98%" border="0" cellpadding="5" cellspacing="1"
						bgcolor="#CCCCCC">
						<tr>
							<td width="7%" height="24" bgcolor="#FFCC00">
								员工编号
							</td>
							<td width="11%" height="24" bgcolor="#FFCC00">
								员工姓名
							</td>
							<td width="16%" height="24" bgcolor="#FFCC00">
								邮箱
							</td>
							<td width="16%" height="24" bgcolor="#FFCC00">
								电话
							</td>
							<td width="12%" height="24" bgcolor="#FFCC00">
								入职时间
							</td>
							<td width="9%" height="24" bgcolor="#FFCC00">
								职务
							</td>
							<td width="9%" height="24" bgcolor="#FFCC00">
								工资
							</td>
							<td width="7%" height="24" bgcolor="#FFCC00">
								部门
							</td>
							<td width="13%" height="24" bgcolor="#FFCC00">
								操作
							</td>
						</tr>
						<c:forEach items="${requestScope.elist }" var="staff">
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									${staff.getE_id()}
								</td>
								<td height="24" bgcolor="#FFFFFF">
									${staff.getE_name()}
								</td>
								<td height="24" bgcolor="#FFFFFF">
									${staff.getE_mail()}
								</td>
								<td height="24" bgcolor="#FFFFFF">
									${staff.getE_tel()}
								</td>
								<td height="24" bgcolor="#FFFFFF">
									${staff.getE_starttime()}
								</td>
								<td height="24" bgcolor="#FFFFFF">
									${staff.getE_titleid()}
								</td>
								<td height="24" bgcolor="#FFFFFF">
									${staff.getE_salary()}
								</td>
								<td height="24" bgcolor="#FFFFFF">
									${staff.getE_deptid()}
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<a href="staff/staff!selByIdStaffFun?staff.e_id=${staff.getE_id()}">修改</a>
									<a href="staff/staff!deleteStaffFun?staff.e_id=${staff.getE_id()}">删除</a>
								</td>
							</tr>
							</c:forEach>
					</table>
					<p>
						<a href="staff/staff!addPage">增加新员工</a>					</p>
				</td>
			</tr>
		</table>
	</body>
</html>