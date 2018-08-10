<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path=request.getContextPath();
String basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<base href="<%=basepath %>">
		<title>职务数据</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=gbk">

	</head>

	<body class="bgImg" >
		<!-- 页面头部 -->
		<table width="950" border="0" align="center" cellpadding="0"
	cellspacing="0">
          <tr>
            <td height="80" bgcolor="#FFFFFF"><img src="img/bannal.jpg" width="950"
				height="80"> </td>
          </tr>
          <tr>
            <td height="24" align="right" bgcolor="#FFFFFF">
                <a href="Main.html" target="main">首页</a> 
                <a href="dept/dept!selAllDeptFun" target="main">部门查询</a>
                <a href="title/title!selectAllTitleFun" target="main">职务查询</a>
                <a href="staff/staff!selectAllStaffeFun" target="main">员工查询</a>
                <a href="Logout.html" target="_top">退出登陆</a> 
             </td>
          </tr>
          <tr>
            <td height="24" align="right" bgcolor="#0099CC"> 当前用户：admin 身份：管理员 </td>
          </tr>
        </table>
        
		<!-- 页面内容 -->
        <table border="0" width="950" height="350" bgcolor="#ffffff" align="center"><tr><td>
            <iframe name="main" src="Main.html" width="100%" height="100%" bgcolor="#ffffff" scrolling="no" frameborder="0">
            </iframe>
        </td></tr></table>
		
		<!-- 页面底部 -->
		
        <table width="950" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
          <tr>
            <td><hr width="100%" size="1" align="center"/></td>
          </tr>
          <tr>
            <td align="center">&copy;版权所有</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
          </tr>
        </table>
	</body>
</html>