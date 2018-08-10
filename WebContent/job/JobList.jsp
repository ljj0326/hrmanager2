<%@ page import="java.util.*,com.mzmy.HRManager.model.vo.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path=request.getContextPath();
String basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<base href="<%=basepath %>">
		<title>职务数据</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=gbk">

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
							<th width="16%" height="24" align="center" bgcolor="#FFCC00">
								职务编号
							</th>
							<th width="21%" height="24" align="center" bgcolor="#FFCC00">
								职务名称
							</th>
							<th width="23%" height="24" align="center" bgcolor="#FFCC00">
								最低工资
							</th>
							<th width="24%" height="24" align="center" bgcolor="#FFCC00">
								最高工资
							</th>
							<th width="16%" height="24" align="center" bgcolor="#FFCC00">
								操作
							</th>
						</tr>

						<!-- 显示职务数据 -->
						 <c:forEach items="${requestScope.tlist}" var="tv">
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									${tv.getT_id()}
								</td>
								<td height="24" bgcolor="#FFFFFF">
									${tv.getT_name()}
								</td>
								<td height="24" bgcolor="#FFFFFF">
									${tv.getT_minsalary()}
								</td>
								<td height="24" bgcolor="#FFFFFF">
									${tv.getT_maxsalary()}
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<a href="title/title!selByIdTitleFun?title.t_id=${tv.getT_id()}">修改</a>
									<a href="title/title!deleteTitleFun?title.t_id=${tv.getT_id()}">删除</a>								</td>
							</tr>
							</c:forEach>
					</table>
					<p>
						<a href="job/JobAdd.jsp">增加新职务种类</a>					</p>
				</td>
			</tr>
		</table>


	</body>
</html>